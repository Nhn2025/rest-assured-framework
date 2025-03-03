package day3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {

    @Test
    void testQueryAndPathParameters() {
        given()
                .pathParam("mypath", "user")
                .queryParam("page", 2)
                .queryParam("id", 5)

        .when()
                .get("https://reqres.in/api/{mypath}")

        .then()
                .statusCode(200)
                .log().all();
    }

}
