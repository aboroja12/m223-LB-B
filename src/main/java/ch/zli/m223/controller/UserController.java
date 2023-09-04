package ch.zli.m223.controller;

import java.util.List;
import javax.annotation.security.PermitAll;
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

}