package it.texo.desafio.helpers;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {
    
    protected String baseUri;
    protected Map<String, String> headers;
    protected RequestSpecBuilder spec;

    public BaseService() {
        this.headers = new HashMap<String, String>();
    }
    
    protected void definirBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }
    
    protected BaseService spec(RequestSpecBuilder spec) {
        spec.setBaseUri(baseUri);
        this.spec = spec;
        return this;
    }

    public BaseService adicionarHeader(String chave, String valor) {
        headers.put(chave, valor);
        return this;
    }
    
    protected Map<String, String> obterHeaders() {
        return headers;
    }

    public Response get() {
        spec.addHeaders(obterHeaders());
        RequestSpecification rs = spec.build();
        return RestAssured.given()
            .spec(rs)
            .log().all()
            .get();
    }
    
    public Response post() {
        spec.addHeaders(obterHeaders());
        RequestSpecification rs = spec.build();
        return RestAssured.given()
            .spec(rs)
            .log().all()
            .post();
    }

    public Response put() {
        spec.addHeaders(obterHeaders());
        RequestSpecification rs = spec.build();        
        return RestAssured.given()
            .spec(rs)
            .log().all()
            .put();
    }
    
}

