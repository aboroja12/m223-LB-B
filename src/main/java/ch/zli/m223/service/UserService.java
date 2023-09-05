package ch.zli.m223.service;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.AppUser;
import io.smallrye.jwt.build.Jwt;

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

    public String loginAppUser(String email, String password){
        var query = entityManager.createQuery("FROM AppUser WHERE email = :email", AppUser.class);
        query.setParameter("email", email);
        AppUser user = query.getSingleResult();
        if (user.getPassword().equals(password)){
            Set<String>groups= new HashSet<>();
            if (user.isAdmin()){
                groups.add("admin");
            }
            else{
                groups.add("mitglied");
            }
            return Jwt.upn(email).groups(groups).claim("user_id", user.getId()).expiresIn(Duration.ofHours(24)).sign();
        }
        return null;

    }

}
