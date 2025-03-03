package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {

    @Test(priority = 1)
    void testHeaders() {
        given()

        .when()
                .get("https://www.google.com/")

        .then()
                .header("Cache-Control", "private, max-age=0")
                .and()
                .header("Content-Type",  "text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .log().headers();
    }

    @Test(priority = 2)
    void getHeaders() {

        Response response = given()
                                .when()
                                        .get("https://www.google.com/");

        // get single header info
        String headerValue = response.getHeader("Content-Type");
        System.out.println("The value of Content-type header is: " + headerValue);

        // get all headers info
        Headers headerValues = response.getHeaders();
        System.out.println(headerValues);
        for (Header header : headerValues) {
            System.out.println(header.getName() + "         " + header.getValue());
        }
    }

}
