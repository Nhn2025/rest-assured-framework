package day3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CookiesDemo {

    @Test(priority = 1)
    void testCookies() {
        given()

        .when()
                .get("https://www.google.com/")

        .then()
                .cookie("AEC")  // Kiểm tra cookie "AEC" có tồn tại, không quan tâm giá trị
                .log().all();
    }

    @Test(priority = 2)
    void getCookiesInfo() {

        Response response = given()

        .when()
                .get("https://www.google.com/");

        // get single cookie info
        String cookies_value = response.getCookie("AEC");
        System.out.println("Value of cookie is ===>" + cookies_value);

        // get all cookies info
        Map<String, String> cookies_values = response.getCookies();
        System.out.println(cookies_values);

        for (String k : cookies_values.keySet()) {
            String cookie_value = response.getCookie(k);
            System.out.println(k + "             " + cookie_value);
        }
    }

}
