package day4;

import io.restassured.http.ContentType;
import org.json.JSONObject;
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
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:300/store")
        .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("book[3].title", equalTo("The Lord of the Rings"));

        // Approach2

        Response response = (Response) given()
                .contentType(ContentType.JSON)

        .when()
                .get("http://localhost:300/store");

        Assert.assertEquals(response.getStatusCode(), 200); //Validation 1
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        String bookName = response.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(bookName, "The Lord of the Rings");
    }

    @Test(priority = 2)
    void testJsonResponseBody() {
        Response response = given()
                .contentType(ContentType.JSON)

        .when()
                .get("http://localhost:300/store");

        //JSONObject class
        JSONObject  jo = new JSONObject(response.asString()); // converting response to json object type

        // Print all title of books
//        for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
//            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
//            System.out.println(bookTitle);
//        }

        // Search for title of the book in Json -  validation 1
        boolean status = false;

        for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();

            if (bookTitle.equals("The Lord of the Rings")) {
                status = true;
                break;
            }
        }

        Assert.assertEquals(status, true);

        // Validation total price of books - validation 2

        double totalPrice = 0;

        for (int i = 0; i <= jo.getJSONArray("boook").length(); i++) {
            String price = jo.getJSONArray("boook").getJSONObject(i).get("price").toString();

            totalPrice = Double.parseDouble(totalPrice + price);
        }

        System.out.println("Total price of books is: " + totalPrice);
        Assert.assertEquals(totalPrice, 53.92);
    }

}
