package day1;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequestsVersion2 {

    private static final String BASE_URL = "https://reqres.in/api/users";  // Tách URL tránh hardcode
    private int userId;

    @BeforeClass
    public void setup() {
        baseURI = BASE_URL;
    }

    @Test(priority = 1)
    public void createUser() {
        Map<String, String> data = Map.of(
                "name", "nhu",
                "job", "tester"
        );

        Response response = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("name", equalTo("nhu"))
                .body("job", equalTo("tester"))
                .log().all()
                .extract().response();

        // Kiểm tra id hợp lệ
        userId = response.jsonPath().getInt("id");
        Assert.assertTrue(userId > 0, "User ID is not valid!");
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    public void getUser() {
        given()
                .when()
                .get("?page=" + userId)  // Sửa lại đúng URL
                .then()
                .statusCode(200)
                .body("page", equalTo(userId))
                .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    public void updateUser() {
        Map<String, String> data = Map.of(
                "name", "rua",
                "job", "auto"
        );

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("/" + userId)
                .then()
                .statusCode(200)
                .body("name", equalTo("rua"))
                .body("job", equalTo("auto"))
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = {"createUser"})
    public void deleteUser() {
        given()
                .when()
                .delete("/" + userId)
                .then()
                .statusCode(204)
                .log().all();
    }
}