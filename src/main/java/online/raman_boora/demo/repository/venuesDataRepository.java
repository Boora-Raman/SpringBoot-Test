package online.raman_boora.demo.repository;

import online.raman_boora.demo.entity.venuesDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface venuesDataRepository extends MongoRepository<venuesDetails,String> {

    Optional findByvenueId(String venueId);

    Optional deleteByvenueId(String venueId);

}
