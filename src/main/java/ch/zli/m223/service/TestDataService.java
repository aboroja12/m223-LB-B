package ch.zli.m223.service;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Workspace;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class TestDataService {

    @Inject
    private UserService userService;

    @Inject
    private BookingService bookingService;

    @Inject
    private WorkspaceService workspaceService;


    @Transactional
    public void generateTestData(@Observes StartupEvent event) {
        AppUser user1 = new AppUser();
        user1.setFirstName("Alfred");
        user1.setLastName("Müller");
        user1.setEmail("Alfred.Mueller@example.com");
        user1.setIsAdmin(false);
        user1.setPassword("1234");
        userService.createUser(user1);

        AppUser user2 = new AppUser();
        user2.setFirstName("Mara");
        user2.setLastName("Meier");
        user2.setEmail("Mara.Meier@example.com");
        user2.setIsAdmin(true);
        user2.setPassword("1234");
        userService.createUser(user2);

        Booking booking1 = new Booking();
        booking1.setDate(new Date());
        booking1.setBookingPeriod("half day");
        booking1.setIsCancelled(false);
        booking1.setIsAccepted(true);
        bookingService.createBooking(booking1);

        Booking booking2 = new Booking();
        booking2.setDate(new Date());
        booking2.setBookingPeriod("whole day");
        booking2.setIsCancelled(false);
        booking2.setIsAccepted(true);
        bookingService.createBooking(booking2);

    
        Workspace workspace1 = new Workspace();
        workspace1.setType("conference room");
        workspace1.setLocation("Zuerich");
        workspace1.setAvailability(true);
        workspace1.setFavorite(false);
        workspaceService.createWorkspace(workspace1);

        Workspace workspace2 = new Workspace();
        workspace2.setType("desk table");
        workspace2.setLocation("Bern");
        workspace2.setAvailability(true);
        workspace2.setFavorite(true);
        workspaceService.createWorkspace(workspace2);
        

    }





    }


    
    

