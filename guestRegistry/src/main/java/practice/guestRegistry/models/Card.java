package practice.guestRegistry.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "card")
public class Card {

    @Id
    ObjectId id;
    String serialNumber;

    @DBRef(db = "test", lazy = false)
    Location location;
    LocalDateTime manufactured;
    LocalDateTime validUntil;
//    @JsonProperty("ctype")
    CardType ctype;


    public Card(ObjectId id, String serialNumber, Location location, LocalDateTime manufactured, LocalDateTime validUntil, CardType ctype) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.location = location;
        this.manufactured = manufactured;
        this.validUntil = validUntil;
        this.ctype = ctype;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
//                ", location=" + location.toString() +
                ", location=" + location +
                ", manufactured=" + manufactured +
                ", validUntil=" + validUntil +
                ", ctype=" + ctype +
                '}';
    }

    @NonNull
    public ObjectId getId() {
        return id;
    }

    public void setId(@NonNull ObjectId id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getManufactured() {
        return manufactured;
    }

    public void setManufactured(LocalDateTime manufactured) {
        this.manufactured = manufactured;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public CardType getCtype() {
        return ctype;
    }

    public void setCtype(CardType ctype) {
        this.ctype = ctype;
    }
}
