package com.AutoShop;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class AutoTests {

    @Test
    public void connectWithDatabase() {
        String Url = "jdbc:postgresql://localhost:5432/database?user=admin&password=admin";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Url);
            System.out.println("Connection Established Successfull with DataBase: "
                    + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }

    @Test
    public void pingTest() {
        given().when().request("GET", "http://localhost:8081/allProducts").then().statusCode(200);
    }

    @Test
    public void verifyClientName() {
        given()
                .when()
                .get("http://localhost:8081/clients/2")
                .then()
                .statusCode(200)
                .body("lastName", equalTo("Stefanczyk"));
    }


    @Test
    public void shouldRemoveUser() throws IOException {
        // given
        URL obj = new URL(UriComponentsBuilder.fromHttpUrl(URL).path("/deleteClient/2").build().toString());
        // when
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("DELETE");
        // then
        assertThat(String.valueOf(connection.getResponseCode())).isEqualTo("200");

    }
    @Test
    public void shouldNotRemoveUser() throws IOException {
        // given
        URL obj = new URL(UriComponentsBuilder.fromHttpUrl(URL).path("/deleteClient/10").build().toString());
        // when
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("DELETE");
        // then
        assertThat(String.valueOf(connection.getResponseCode())).isEqualTo("500");

    }

}
