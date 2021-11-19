package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PetResourceTest {
    //Get Test
    @Test
    public void Get() {
        given()
                .when().get("http://localhost:8080/v1/pets/1")
                .then()
                .statusCode(200);
    }
    // Pet Creation Test
    @Test
    public void Create() {
        given().contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("pet_type","Snake")
                .formParam("pet_age",8)
                .formParam("pet_name","Viper")
                .when().post("http://localhost:8080/v1/pets/create")
                .then()
                .statusCode(200);
        given().contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("pet_type","Snake")
                .formParam("pet_age",6)
                .formParam("pet_name","Mira")
                .when().post("http://localhost:8080/v1/pets/create")
                .then()
                .statusCode(200);
    }
    //Update Test
    @Test
    public void Update() {
        given().contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("pet_type","Snake")
                .formParam("pet_age",3)
                .formParam("pet_name","Aluth")
                .formParam("pet_id","1")
                .when().put("http://localhost:8080/v1/pets/update")
                .then()
                .statusCode(200);
    }
    //DELETE Test
    @Test
    public void Delete() {
        given()
                .when().delete("http://localhost:8080/v1/pets/1")
                .then()
                .statusCode(200);
    }
    //Get By Name Test
    @Test
    public void GetByName() {
        given()
                .when().get("http://localhost:8080/v1/pets/name/Kalu")
                .then()
                .statusCode(200);
    }
    //Get By Age Test
    @Test
    public void GetByAge() {
        given()
                .when().get("http://localhost:8080/v1/pets/age/3")
                .then()
                .statusCode(200);
    }
    //Get By Type Test
    @Test
    public void GetByType() {
        given()
                .when().get("http://localhost:8080/v1/pets/type/Dog")
                .then()
                .statusCode(200);
    }

}