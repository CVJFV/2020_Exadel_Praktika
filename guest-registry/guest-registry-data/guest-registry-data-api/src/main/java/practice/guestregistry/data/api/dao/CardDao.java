package practice.guestregistry.data.api.dao;


import org.bson.types.ObjectId;
import practice.guestregistry.data.api.domain.Card;

import java.util.List;
import java.util.Optional;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface CardDao {
    void deleteAll ();
    Optional<Card> findById (String id);
    List<Card> findAll ();
    Card save (Card card);
    Card update (Card card);
    void deleteById (String id);
    boolean existById (String id);
    boolean exist (Card card);
}



