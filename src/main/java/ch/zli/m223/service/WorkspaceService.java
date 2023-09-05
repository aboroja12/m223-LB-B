package ch.zli.m223.service;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import javax.persistence.EntityManager;
import ch.zli.m223.model.Workspace;

@ApplicationScoped
public class WorkspaceService {

    @Inject
    EntityManager entityManager;

    public List<Workspace> workspace(){
        var query = entityManager.createQuery("FROM Workspace WHERE availability = true", Workspace.class);
        return query.getResultList();
    }
    
    public List<Workspace> favoriteWorkspace(){
        var query = entityManager.createQuery("FROM Workspace WHERE favorite = true", Workspace.class);
        return query.getResultList();
    }
    


}
