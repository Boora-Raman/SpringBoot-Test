package online.raman_boora.demo.services;

import online.raman_boora.demo.entity.userDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class signupService {

    @Autowired
    private online.raman_boora.demo.repository.userDataRepository userDataRepository;

//    @Transactional
    public void saveUserDetails(userDetails Details) {
        userDataRepository.save(Details);
    }

    public List<userDetails> getUseedetails() {
        return userDataRepository.findAll();
    }

    public Optional<userDetails> getUseedetailsByUsername(String Username) {
        return  userDataRepository.getUseeDetailsByUsername(Username);
    }
//    @Transactional
    public boolean deleteUseedetailsByUsername(String Username) {
        Optional<userDetails> details = (Optional<userDetails>) userDataRepository.getUseeDetailsByUsername(Username);
        if (details.isPresent()) {
            userDataRepository.deleteById(details.get().getUsername());
            return true; // Indicates successful deletion
        }
        return false; // Indicates user not found
    }
}
