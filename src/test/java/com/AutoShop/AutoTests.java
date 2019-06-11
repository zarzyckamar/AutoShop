package com.AutoShop;

import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AutoTests {
    private static final String ENDPOINT_URL = "http://localhost:8081";

    @Test
    public void connectWithDatabase() {
        //given
        final String DATABASE_URL = "jdbc:postgresql://localhost:5432/database?user=admin&password=admin";
        //when
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connection Established Successful with DataBase: "
                    + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }

    @Test
    public void pingTest() {
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
    public void shouldRemoveUser() throws IOException {
        // given
        URL obj = new URL(UriComponentsBuilder
                .fromHttpUrl(ENDPOINT_URL)
                .path("/deleteClient/2")
                .build().toString());
        // when
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("DELETE");
        // then
        assertThat(String.valueOf(connection.getResponseCode())).isEqualTo("200");

    }

    @Test
    public void shouldNotRemoveUser() throws IOException {
        // given
        URL obj = new URL(UriComponentsBuilder.fromHttpUrl(ENDPOINT_URL).path("/deleteClient/10").build().toString());
        // when
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("DELETE");
        // then
        assertThat(String.valueOf(connection.getResponseCode())).isEqualTo("500");

    }

}
