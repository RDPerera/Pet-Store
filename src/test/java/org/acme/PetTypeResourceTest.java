package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PetTypeResourceTest {
    //Get Test
    @Test
    public void GetById() {
        given()
                .when().get("http://localhost:8080/v1/pettype/1")
                .then()
                .statusCode(200);
    }
    //Creation Test
    @Test
    public void Create() {

        given().contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("type","Snake")
                .when().post("http://localhost:8080/v1/pettype/create")
                .then()
                .statusCode(200);
    }

    //Update Test
    @Test
    public void Update() {
        given().contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("pet_type","Dog")
                .formParam("pet_type_id",1)
                .when().put("http://localhost:8080/v1/pettype/update")
                .then()
                .statusCode(200);
    }
    //DELETE Test
    @Test
    public void Delete() {
        given()
                .when().delete("http://localhost:8080/v1/pettype/1")
                .then()
                .statusCode(200);
    }
}