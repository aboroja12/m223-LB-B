package ch.zli.m223.controller;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.service.UserService;
import ch.zli.m223.model.AppUser;

@Path("/users")
@Tag(name = "Users", description = "Handling of users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all users.", 
        description = "Returns a list of all users"
  )
  public List<AppUser> index() {
      return userService.findAll();
  }

    @Path("/register")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
      summary = "Creates a new user and registering as mitglied", 
      description = "Creates a new user and returns the newly added user."
  )
    @PermitAll
    public AppUser create(AppUser user) {
        return userService.createUser(user);
  }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
      summary = "logs user mitglied and admin in", 
      description = "is logging user and admin in"
  )
    @PermitAll
    public String login(AppUser user) {
      return userService.loginAppUser(user.getEmail(), user.getPassword());
    }




  




}