package online.raman_boora.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.ArrayList;
import java.util.List;

@Data
//@Document
@Document(collection = "userDetails123")
public class userDetails {

    @Id
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull

    private String email;
    @DBRef
    private List<venuesDetails> userVenues = new ArrayList<>();


}
