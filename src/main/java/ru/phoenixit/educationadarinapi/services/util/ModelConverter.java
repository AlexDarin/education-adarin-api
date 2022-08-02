package ru.phoenixit.educationadarinapi.services.util;

import org.springframework.stereotype.Component;
import ru.phoenixit.educationadarinapi.models.Model;
import ru.phoenixit.educationadarinapi.models.ModelRequest;
import ru.phoenixit.educationadarinapi.models.ModelResponse;

@Component
public class ModelConverter {

    public void toModel(final ModelRequest modelRequest, final Model model) {
        model.setId(modelRequest.getId());
        model.setName(modelRequest.getName());
        model.setComment(modelRequest.getComment());
    }

    public void toModelResponse(final Model model, final ModelResponse modelResponse) {
        modelResponse.setId(model.getId());
        modelResponse.setName(model.getName());
        modelResponse.setComment(model.getComment());
        modelResponse.setCreateAt(model.getCreateAt());
        modelResponse.setCreator(model.getCreator());
        modelResponse.setUpdateAt(model.getUpdateAt());
        modelResponse.setUpdater(model.getUpdater());
    }
}
