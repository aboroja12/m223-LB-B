package ch.zli.m223.service;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    EntityManager entityManager;
    


    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }
}
