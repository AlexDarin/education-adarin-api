package ru.phoenixit.educationadarinapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.phoenixit.educationadarinapi.models.Model;
import ru.phoenixit.educationadarinapi.models.ModelRequest;
import ru.phoenixit.educationadarinapi.models.ModelResponse;
import ru.phoenixit.educationadarinapi.repositories.ModelRepository;
import ru.phoenixit.educationadarinapi.services.util.ModelConverter;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    private final ModelConverter modelConverter;

    @Override
    @Transactional
    public ModelResponse createModel(final ModelRequest modelRequest) {
        final Model model = new Model();
        modelConverter.toModel(modelRequest, model);
        final ModelResponse modelResponse = new ModelResponse();
        modelConverter.toModelResponse(modelRepository.save(model), modelResponse);
        return modelResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public ModelResponse getModel(final String modelId) {
        return modelRepository.findById(modelId)
                .map(model -> {
                    final ModelResponse modelResponse = new ModelResponse();
                    modelConverter.toModelResponse(model, modelResponse);
                    return modelResponse;
                })
                .orElseThrow(() -> new EntityNotFoundException("No model with id = " + modelId + " found"));
    }

    @Override
    @Transactional
    public ModelResponse updateModel(final ModelRequest modelRequest) {
        final Model model = modelRepository.findById(modelRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("No model with id = " + modelRequest.getId() + " found"));

        modelConverter.toModel(modelRequest, model);
        final ModelResponse modelResponse = new ModelResponse();
        modelConverter.toModelResponse(modelRepository.save(model), modelResponse);
        return modelResponse;
    }

    @Override
    @Transactional
    public void deleteModel(final String modelId) {
        modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("No model with id = " + modelId + " found"));

        modelRepository.deleteById(modelId);
    }
}
