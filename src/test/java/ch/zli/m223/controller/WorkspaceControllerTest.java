package ch.zli.m223.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class WorkspaceControllerTest {

    @Test
    @Order(1)
    public void testShowBookings() {
        given()
        .when().get("/workspaces/availability")
        .then()
        .statusCode(200);
        
    }
	@Test
	void testFavoriteList() {

	}

	@Test
	void testIndex() {

	}
}
