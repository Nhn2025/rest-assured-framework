package day2;

import org.json.JSONTokener;
import org.testng.annotations.Test;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

//Topics Covered:
//How many ways we can create request body
//1) using HashMap
//2) using Org.json
//3) using POJO (Plain Old Java Object)
//4) using external json file

public class DiffWaysToCreatePostRequestBody {

    //1) Post request body using HashMap

    @Test(priority = 1)
    void testPostUsingHashMap() {
        HashMap data = new HashMap();

        data.put("name", "Nhu");
        data.put("location", "France");
        data.put("phone", "123456");

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);

        given()
                .contentType("application/json")
                .body(data)

        .when()
                .post("http://localhost:3000/students")

        .then()
                .statusCode(201)
                .body("name", equalTo("Nhu"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C+"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test(priority = 2)
    void deleteUserUsingHashMap() {
        given()
        .when()

                .delete("http://localhost:3000/students/4")

        .then()
                .statusCode(200);
    }

    //2) Post request body using Json Library

    @Test(priority = 1)
    void testPostUsingJsonLibrary() {
        JSONObject data = new JSONObject();
        data.put("name", "nhu");
        data.put("location", "France");
        data.put("phone", "123456");

        String coursesArr[] = {"C", "C++"};

        data.put("courses", coursesArr[0]);
        data.put("courses", coursesArr[1]);

        given()
                .contentType("application/json")
                // Cần chuyển dữ liệu Json về dạng chuỗi trước
                .body(data.toString())

        .when()
                .post("http://localhost:3000/students")

        .then()
                .statusCode(201)
                .body("name", equalTo("Nhu"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C+"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test(priority = 2)
    void deleteUserUsingJsonLibrary() {
        given()

        .when()

                .delete("http://localhost:3000/students/4")

        .then()
                .statusCode(200);
    }

    //3) Post request body using POJO Class

    @Test(priority = 1)
    void testPostUsingPojoClass() {
        Pojo_ClassRequest data = new Pojo_ClassRequest();
        data.setName("nhu");
        data.setLocation("France");
        data.setPhone("123456");
        String courseArr[] = {"C", "C++"};
        data.setCourses(courseArr);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Nhu"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C+"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test(priority = 2)
    void deleteUserUsingPojoClass() {
        given()

                .when()

                .delete("http://localhost:3000/students/4")

                .then()
                .statusCode(200);
    }

    //4) Post request body using External Json File

    @Test(priority = 1)
    void testPostUsingExternalJsonFile() throws FileNotFoundException {
        File f = new File(".\\body.json");

        FileReader fr = new FileReader(f);

        JSONTokener jt = new JSONTokener(fr);

        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                // Cần chuyển dữ liệu Json về dạng chuỗi trước
                .body(data.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Nhu"))
                .body("location", equalTo("France"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C+"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test(priority = 2)
    void deleteUserUsingExternalJsonFile() {
        given()

                .when()

                .delete("http://localhost:3000/students/4")

                .then()
                .statusCode(200);
    }

}
