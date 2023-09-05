package ch.zli.m223.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class BookingControllerTest {

    @Test
    @Order(1)
    public void testShowBookings() {
        given()
        .when().get("/bookings")
        .then()
        .statusCode(200);
        
    }
	@Test
	void testCreate() {

	}

	@Test
	void testCreateSerialBooking() {

	}

	@Test
	void testDelete() {

	}

	@Test
	void testIndex() {

	}

	@Test
	void testUpdate() {

	}
}
