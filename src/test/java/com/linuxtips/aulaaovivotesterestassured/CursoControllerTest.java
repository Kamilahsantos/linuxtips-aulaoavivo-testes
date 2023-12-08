package com.linuxtips.aulaaovivotesterestassured;

import com.linuxtips.aulaaovivotesterestassured.model.Curso;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CursoControllerTest {

    static {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    private static String requestBody = "{\n" +
            "  \"nome\": \"descomplicando java e spring\",\n" +
            "  \"valor\": \"799.0\",\n" +
            "  \"pessoaInstrutora\": \"kamila santos\" \n}";


    private Response criaCursos(Curso curso)  {
        RequestSpecification request
                = given()
                .contentType("application/json")
                .body(curso);

        return request.post("/cursos");
    }
    @Test
    @DisplayName("Deve criar um curso com sucesso")
    public void deveCriarUmCursoComSucesso() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/cursos")
                .then()
                .extract().response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("799.0", response.jsonPath().getString("valor"));

    }

    @Test
    @DisplayName("Deve buscar um curso pelo id  com sucesso")
    public void deveBuscarCursoPeloIdComSucesso() {
        criaCursos(new Curso("123","java e aws", 123.0, "kamila"));
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .basePath("/cursos")
                .get("/123")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @DisplayName("Deve atualizar um curso pelo id  com sucesso")
    public void deveAtualizarUmCursoComSucesso() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .basePath("/cursos")
                .get("/123")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());

    }


    @Test
    @DisplayName("Deve excluir um curso pelo id  com sucesso")
    public void deleteRequest() {
        criaCursos(new Curso("12345","java", 123.0,"kamila"));
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/cursos/12345")
                .then()
                .extract().response();

        Assertions.assertEquals(204, response.statusCode());
    }

}
