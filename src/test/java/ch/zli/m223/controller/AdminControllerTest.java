package ch.zli.m223.controller;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.given;


public class AdminControllerTest {

    @Test
    @Order(1)
    public void testShowUser() {
        given()
        .when().get("/users")
        .then()
        .statusCode(200);
        
    }

	@Test
	void testCreate() {

	}

	@Test
	void testCreate2() {

	}

	@Test
	void testDeleteBooking() {

	}

	@Test
	void testDeleteUser() {

	}

	@Test
	void testUpdate() {

	}

	@Test
	void testUpdate2() {

	}
}
