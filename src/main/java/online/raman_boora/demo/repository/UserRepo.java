package online.raman_boora.demo.repository;

import online.raman_boora.demo.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserDetails,Object> {

}
