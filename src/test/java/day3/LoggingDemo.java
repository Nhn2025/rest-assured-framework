package day3;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoggingDemo {

    @Test(priority = 1)
    void testLogs() {
        given()

        .when()
                .get("https://www.google.com/")

        .then()
                //.log().all()
                //.log().body()
                //.log().cookies()
                //.log().headers()
                .log().all();
    }

}
