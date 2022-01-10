package br.com.likwi.photoapp.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Map;
import java.util.UUID;


public class GetUserHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static Logger logger = LoggerFactory.getLogger(GetUserHandler.class);

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        final Map<String, String> pathParameters = input.getPathParameters();
        final String userId = pathParameters.get("userId");
        logger.info(MessageFormat.format("new customer registration {0}", userId));

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("firstName","Ronaldo");
        jsonObject.addProperty("lastName","Nazário");
        jsonObject.addProperty("id", userId.concat("___").concat(UUID.randomUUID().toString()));

        final APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).withBody(jsonObject.toString());

        return response;
    }
}
