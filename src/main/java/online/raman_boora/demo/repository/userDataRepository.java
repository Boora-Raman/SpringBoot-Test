package online.raman_boora.demo.repository;

import online.raman_boora.demo.entity.userDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;
import java.util.Optional;

public interface userDataRepository extends MongoRepository<userDetails,String> {

//    public  getUseeDetailsByUsername(String username);
//    public Optional<userDetails> userDataRepository.findByUsername(String Username);

    Optional getUseeDetailsByUsername(String username);

}


