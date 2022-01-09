package br.com.likwi.photoapp.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

public class GetUserHandler implements RequestHandler {
    @Override
    public Object handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        return null;
    }
}
