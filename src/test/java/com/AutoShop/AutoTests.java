package com.AutoShop;

import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AutoTests {
    private static final String ENDPOINT_URL = "http://localhost:8081";



    @Test
    public void connectWithDatabase() throws ClassNotFoundException, SQLException, SQLException {

        final String DATABASE_URL = "jdbc:postgresql://localhost:5432/database?user=admin&password=admin";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        System.out.println("Connection Established Successful with DataBase: "
                + connection.getMetaData().getDatabaseProductName());
    }

    @Test
    public void shouldReturnAllProducts() {
        given()
                .when()
                .get(UriComponentsBuilder
                        .fromHttpUrl(ENDPOINT_URL)
                        .path("/allProducts")
                        .build()
                        .toString())
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyClientName() {
        given()
                .when()
                .get(UriComponentsBuilder
                        .fromHttpUrl(ENDPOINT_URL)
                        .path("/clients/1")
                        .build()
                        .toString())
                .then()
                .statusCode(200)
                .body("lastName", equalTo("Grubinski"));
    }

    @Test
    public void shouldRemoveUser() {
        given()
                .when()
                .delete(UriComponentsBuilder
                        .fromHttpUrl(ENDPOINT_URL)
                        .path("/deleteClient/2")
                        .build().toString())
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldNotRemoveUser() {
        given()
                .when()
                .delete(UriComponentsBuilder
                        .fromHttpUrl(ENDPOINT_URL)
                        .path("/deleteClient/100")
                        .build().toString())
                .then()
                .statusCode(500);
    }

    @Test
    public void shouldAddClient() {
        given()
                .when()
                .post(UriComponentsBuilder
                        .fromHttpUrl(ENDPOINT_URL)
                        .path("/addClient")
                        .queryParam("firstName", "testName")
                        .queryParam("lastName", "testSurname")
                        .queryParam("address", "testAddress")
                        .build().toString())
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldReturnAllClients() {
        given()
                .when()
                .get(UriComponentsBuilder
                        .fromHttpUrl(ENDPOINT_URL)
                        .path("/allClients")
                        .build().toString())
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldReturnAllOrders() {
        given()
                .when()
                .get(UriComponentsBuilder
                        .fromHttpUrl(ENDPOINT_URL)
                        .path("/allOrders")
                        .build().toString())
                .then()
                .statusCode(200);
    }
}
