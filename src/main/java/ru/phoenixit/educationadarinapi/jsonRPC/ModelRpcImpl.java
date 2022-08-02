package ru.phoenixit.educationadarinapi.jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.phoenixit.educationadarinapi.models.ModelRequest;
import ru.phoenixit.educationadarinapi.models.ModelResponse;
import ru.phoenixit.educationadarinapi.services.ModelService;

@AutoJsonRpcServiceImpl
@Component
@RequiredArgsConstructor
public class ModelRpcImpl implements ModelRpc {

    private final ModelService modelService;

    @Override
    public ModelResponse create(final ModelRequest modelRequest) {
        return modelService.createModel(modelRequest);
    }

    @Override
    public ModelResponse get(final String modelId) {
        return modelService.getModel(modelId);
    }

    @Override
    public ModelResponse update(final ModelRequest modelRequest) {
        return modelService.updateModel(modelRequest);
    }

    @Override
    public void delete(final String modelId) {
        modelService.deleteModel(modelId);
    }
}
