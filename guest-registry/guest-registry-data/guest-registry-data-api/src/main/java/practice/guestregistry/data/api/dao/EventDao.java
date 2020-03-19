package practice.guestregistry.data.api.dao;

import practice.guestregistry.data.api.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventDao {
    Optional<Event> findById (String id);
    List<Event> findAll ();
    void add (Event event);
    Event update (Event event);
    void deleteById (String id);
    void deleteAll ();
}