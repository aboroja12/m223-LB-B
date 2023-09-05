package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.BookingService;
import ch.zli.m223.model.Booking;
import ch.zli.m223.service.UserService;
import ch.zli.m223.model.AppUser;

@Path("/admin")
@Tag(name = "admin", description = "Handlings for admin")
public class AdminController {

    @Inject
    BookingService bookingService;
    UserService userService;

    @Path("bookings")
    @POST
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates new booking", 
        description = "Creates a new booking and returns the newly added booking."
    )
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }

    @Path("/bookings/{id}")
    @DELETE
    @RolesAllowed({"admin"})
    @Operation(
        summary = "Deletes a booking.",
        description = "Deleting a booking by id."
    )
    public void deleteBooking(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @Path("/bookings/{id}")
    @PUT
    @RolesAllowed({"admin"})
    @Operation(
        summary = "Updates a booking.",
        description = "Is updating a booking by id."
    )
    public Booking update(@PathParam("id") Long id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }


    @Path("/members")
    @POST
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
      summary = "admin creates an new user", 
      description = "admin creates a new user and returns the newly added user."
  )
    @PermitAll
    public AppUser create(AppUser user) {
        return userService.createUser(user);
  }

    @Path("/members/{id}")
    @DELETE
    @RolesAllowed({"admin"})
    @Operation(
      summary = "Deletes an user.",
      description = "Deleting users by id"
  )
    public void deleteUser(@PathParam("id") Long id) {
      userService.deleteUser(id);
  }

  @Path("/{id}")
  @PUT
  @RolesAllowed({"admin"})
  @Operation(
      summary = "Updates an user.",
      description = "Updating user by id."
  )
  public AppUser update(@PathParam("id") Long id, AppUser user) {
      return userService.updateUser(id, user);
  }





}
