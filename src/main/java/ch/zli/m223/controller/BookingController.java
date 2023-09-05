package ch.zli.m223.controller;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
import ch.zli.m223.model.BookingWeekday;

@Path("/bookings")
@Tag(name = "Bookings", description = "Handling of bookings")
public class BookingController {
    

    @Inject
    BookingService bookingService;

    @GET
    @RolesAllowed({"admin", "mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
      summary = "list of all bookings", 
      description = "Returns a list of all bookings"
  )
  public List<Booking> index() {
      return bookingService.findAll();
  }

    @POST
    @RolesAllowed({"mitlgied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates new booking", 
        description = "Creates a new booking and returns the newly added booking."
    )
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }

    @Path("/{id}")
    @DELETE
    @RolesAllowed({"mitglied"})
    @Operation(
        summary = "Cancel a booking",
        description = "Deleting a booking by id, so the booking is cancelled"
    )
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }


    @Path("/{id}")
    @PUT
    @RolesAllowed({"mitglied"})
    @Operation(
        summary = "Updates a booking",
        description = "Is updating a booking by id"
    )
    public Booking update(@PathParam("id") Long id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @Path("series")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "makes a serial booking",
        description = "is making a serial booking so you yan boook more rooms at ones"
    )

        public BookingWeekday createSerialBooking(BookingWeekday bookingWeekday){
            return bookingService.createSerialBooking(bookingWeekday);

        }

}
