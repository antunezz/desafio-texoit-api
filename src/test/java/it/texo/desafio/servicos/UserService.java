package it.texo.desafio.servicos;

import it.texo.desafio.helpers.JsonPlaceholderService;
import it.texo.desafio.modelo.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;

public class UserService extends JsonPlaceholderService {

    public ValidatableResponse criar(User user) {
        RequestSpecBuilder spec = new RequestSpecBuilder()
                .setBasePath("/users")
                .setContentType("application/json")
                .setBody(user.toJson());

        ValidatableResponse response = spec(spec).post().then().log().all();
        return response;
    }

    public ValidatableResponse editar(int id, User user) {
        RequestSpecBuilder spec = new RequestSpecBuilder()
                .setBasePath("/users/" + id)
                .setContentType("application/json")
                .setBody(user.toJson());

        ValidatableResponse response = spec(spec).put().then().log().all();
        return response;
    }

}
