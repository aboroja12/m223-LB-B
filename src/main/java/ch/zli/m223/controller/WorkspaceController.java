package ch.zli.m223.controller;
import java.util.List;
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

import ch.zli.m223.service.WorkspaceService;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Workspace;

@Path("/workspaces")
@Tag(name = "Workspaces", description = "Handling of workspaces")
public class WorkspaceController {

    @Inject
    WorkspaceService workspaceService;

    @Path("/availability")
    @GET
    @RolesAllowed({"admin", "mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
      summary = "Index all available workspaces", 
      description = "Returns a list of all bookings"
  )
  public List<Workspace> index() {
      return workspaceService.workspace();
  }

    @Path("/favorites")
    @GET
    @RolesAllowed({"admin", "mitglied"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
      summary = "Index all favorite workspaces.", 
      description = "Returns a list of all favorite workspaces"
  )
  public List<Workspace> favoriteList() {
      return workspaceService.favoriteWorkspace();
  }

  

    
}
