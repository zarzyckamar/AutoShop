package com.AutoShop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
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


}
