package practice.guestregistry.data.api.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class PersonDTO {
    @NotEmpty
    private String id;

    @NotEmpty
    private String firstName;
    private String middleName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @Pattern(regexp = "[0-9]*")
    private String phoneNumber;
    //URL url;
}
