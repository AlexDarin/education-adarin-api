package ru.phoenixit.educationadarinapi.services;

import ru.phoenixit.educationadarinapi.models.ModelRequest;
import ru.phoenixit.educationadarinapi.models.ModelResponse;

public interface ModelService {

    ModelResponse createModel(ModelRequest modelRequest);

    ModelResponse getModel(String modelId);

    ModelResponse updateModel(ModelRequest modelRequest);

    void deleteModel(String modelId);

}
