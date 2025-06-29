package day1;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 given()
    content type, set cookies, add auth, add param, set headers info etc....

 when()
    get, post, put, delete

 then()
    validate status code, extract response, extract headers cookies & response body....

 */

public class HTTPRequests {

    int id;

    @Test(priority = 1)
    void createUser() {
        HashMap data = new HashMap();
        data.put("name", "nhu");
        data.put("job", "tester");

        id=given()
                //.contentType("application/json")
                .contentType(ContentType.JSON)
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

//        .then()
//                .statusCode(201)
//                .log().all();
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void getUser() {
        given()

        .when()
                .get("https://reqres.in/api/users?page=" + id)

        .then()
                .statusCode(200)
                .body("page", equalTo(id))
                .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser() {
        HashMap data = new HashMap();
        data.put("name", "rua");
        data.put("job", "auto");

        given()
                .contentType(ContentType.JSON)
                .body(data)

        .when()
                .put("https://reqres.in/api/users/" + id)

        .then()
                .statusCode(200)
                .body("name", equalTo("rua"))
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = {"createUser"})
    void deleteUser() {
        given()

        .when()
                .delete("https://reqres.in/api/users/" + id)

        .then()
                .statusCode(204)
                .log().all();
    }

}
