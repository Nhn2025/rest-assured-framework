package day4;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {

    @Test(priority = 1)
    void testJsonResponseBodyData() {
        // Approach1

        given()
                .contentType("ContentType.JSON")
        .when()
                .get("http://localhost:300/store")
        .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("book[3].title", equalTo("The Lord of the Rings"));

        // Approach2

        Response response = (Response) given()
                .contentType("ContentType.JSON")

        .when()
                .get("http://localhost:300/store");

        Assert.assertEquals(response.getStatusCode(), 200); //Validation 1
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        String bookName = response.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(bookName, "The Lord of the Rings");
    }

    @Test(priority = 2)
    void testJsonResponseBody() {
        // Approach1

        given()
                .contentType("ContentType.JSON")
                .when()
                .get("http://localhost:300/store")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("book[3].title", equalTo("The Lord of the Rings"));

        // Approach2

        Response response = (Response) given()
                .contentType("ContentType.JSON")

         .when()
                .get("http://localhost:300/store");

        Assert.assertEquals(response.getStatusCode(), 200); //Validation 1
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        String bookName = response.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(bookName, "The Lord of the Rings");
    }


}
