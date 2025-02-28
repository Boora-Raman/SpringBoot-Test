package online.raman_boora.demo.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "VenueDetails")
public class venuesDetails {

    @NonNull
    @Id
    private String venueId;

    private String venueName;

    private String venueAddress;

    private List<String> venueServices = new ArrayList<>();

}
