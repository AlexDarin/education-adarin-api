package ru.phoenixit.educationadarinapi.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcError;
import com.googlecode.jsonrpc4j.JsonRpcErrors;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import org.springframework.stereotype.Component;
import ru.phoenixit.educationadarinapi.models.ModelRequest;
import ru.phoenixit.educationadarinapi.models.ModelResponse;

import javax.persistence.EntityNotFoundException;

@JsonRpcService("rpc/model")
@Component
public interface ModelRpc {

    ModelResponse create(@JsonRpcParam("model") final ModelRequest modelRequest);

    @JsonRpcErrors({
            @JsonRpcError(exception = EntityNotFoundException.class, code = 404)
    })
    ModelResponse get(@JsonRpcParam("id") final String modelId);

    @JsonRpcErrors({
            @JsonRpcError(exception = EntityNotFoundException.class, code = 404),
            @JsonRpcError(exception = IllegalArgumentException.class, code = 500)
    })
    ModelResponse update(@JsonRpcParam("model") final ModelRequest modelRequest);

    @JsonRpcErrors({
            @JsonRpcError(exception = EntityNotFoundException.class, code = 404)
    })
    void delete(@JsonRpcParam("id") final String modelId);
}
