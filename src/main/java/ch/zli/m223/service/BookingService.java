package ch.zli.m223.service;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.BookingWeekday;
import ch.zli.m223.model.Weekday;

@ApplicationScoped
public class BookingService {
    @Inject
    EntityManager entityManager;


    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    @Transactional
    public void deleteBooking(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return entityManager.merge(booking);
    }

    @Transactional
    public BookingWeekday createSerialBooking(BookingWeekday bookingWeekday) {
        Booking booking = createBooking(bookingWeekday.getBooking());
        Weekday weekday = entityManager.find(Weekday.class, bookingWeekday.getWeekday().getId());
        bookingWeekday.setBooking(booking);
        bookingWeekday.setWeekday(weekday);
        return bookingWeekday;
        
    }
}
