package it.texo.desafio.testes;

import it.texo.desafio.modelo.Address;
import it.texo.desafio.modelo.Company;
import it.texo.desafio.modelo.Geo;
import it.texo.desafio.modelo.User;
import it.texo.desafio.servicos.CommentService;
import it.texo.desafio.servicos.UserService;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class MainTest {
    
    private static CommentService commentService;
    private static UserService userService;

    @BeforeAll
    public static void setup() throws Exception {
        commentService = new CommentService();
        userService = new UserService();
    }
    
    @Test
    @DisplayName("1 - Realizar uma requisição do tipo GET")
    public void realizarRequisicaoTipoGet() throws Exception {

        ValidatableResponse response = commentService.listar(null);

        response
                .statusCode(200)
                .body("[0].email", equalTo("Lew@alysha.tv"));

    }

    @Test
    @DisplayName("2 – Realizar uma requisição do tipo POST")
    public void realizarRequisicaoTipoPost() throws Exception {

        User user = new User();
        user.setName("João da Silva");
        user.setUsername("jsilva");
        user.setEmail("joao.silva@gmail.com");
        user.setPhone("(11) 99999-7878");
        user.setWebsite("https://www.joaosilva.com.br");
        Geo geo = new Geo();
        geo.setLat(-25.44164f);
        geo.setLng(-45.48379f);
        Address address = new Address();
        address.setStreet("Rua Dois");
        address.setSuite("Ap 101");
        address.setCity("São Paulo");
        address.setZipcode("01114-040");
        address.setGeo(geo);
        user.setAddress(address);
        Company company = new Company();
        company.setName("Empresa A");
        company.setCatchphrase("Multi-layered client-server neural-net");
        company.setBs("harness real-time e-markets");
        user.setCompany(company);

        ValidatableResponse response = userService.criar(user);

        response
                .statusCode(201)
                .body("id", greaterThanOrEqualTo(0));

    }

    @Test
    @DisplayName("3 - Realizar uma requisição do tipo PUT")
    public void realizarRequisicaoTipoPut() throws Exception {

        int id = 5;
        float lat = -23.44164f;
        float lng = -44.48379f;

        User user = new User();
        Geo geo = new Geo();
        geo.setLat(lat);
        geo.setLng(lng);
        Address address = new Address();
        address.setGeo(geo);
        user.setAddress(address);

        ValidatableResponse response = userService.editar(id, user);

        response
                .statusCode(200)
                .body("id", equalTo(id))
                .body("address.geo.lat", equalTo(lat))
                .body("address.geo.lng", equalTo(lng));
    }

}
