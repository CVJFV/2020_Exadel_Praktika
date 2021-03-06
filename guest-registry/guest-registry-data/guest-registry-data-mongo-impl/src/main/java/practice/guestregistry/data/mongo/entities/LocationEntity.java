package practice.guestregistry.data.mongo.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
//@Document(collection = "location")
@Document
public class LocationEntity {
    @Id
    private ObjectId id;
    private String name;
    private String country;
    private String city;
    private String address;
    private LocationType locationType;
    private String phoneNumber;
    //Worker manager;
}
