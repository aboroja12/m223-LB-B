package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.AppUser;

@ApplicationScoped
public class UserService {
    @Inject
    EntityManager entityManager;
    


    public List<AppUser> findAll() {
        var query = entityManager.createQuery("FROM AppUser", AppUser.class);
        return query.getResultList();
    }

    @Transactional
    public AppUser createUser(AppUser user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        var entity = entityManager.find(AppUser.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public AppUser updateUser(Long id, AppUser user) {
        user.setId(id);
        return entityManager.merge(user);
    }

}