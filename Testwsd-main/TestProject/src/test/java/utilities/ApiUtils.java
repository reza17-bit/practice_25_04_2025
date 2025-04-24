package utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response getRequest(String endpoint) {
        return given().get(endpoint);
    }

    public static Response postRequest(String endpoint, Object body) {
        return given().body(body).post(endpoint);
    }
}