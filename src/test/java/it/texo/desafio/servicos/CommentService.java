package it.texo.desafio.servicos;

import it.texo.desafio.helpers.JsonPlaceholderService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;

public class CommentService extends JsonPlaceholderService {

    public ValidatableResponse listar(Object comment) {
        RequestSpecBuilder spec = new RequestSpecBuilder()
                .setBasePath("/comments")
                .addQueryParam("name", "alias odio sit");

        ValidatableResponse response = spec(spec).get().then().log().all();
        return response;
    }

}
