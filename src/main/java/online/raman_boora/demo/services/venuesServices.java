package online.raman_boora.demo.services;

import online.raman_boora.demo.entity.userDetails;
import online.raman_boora.demo.entity.venuesDetails;
import online.raman_boora.demo.repository.userDataRepository;
import online.raman_boora.demo.repository.venuesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class venuesServices {

    @Autowired
    private venuesDataRepository venuesDataRepository;

    @Autowired
    private signupService signupService;

    public Object getAllVenues() {

        return venuesDataRepository.findAll();

    }

    public Object saveVenues(venuesDetails venues) {

        return venuesDataRepository.save(venues);

    }

    public Object getVenuesById(String venueId) {
        return venuesDataRepository.findByvenueId(venueId);
    }

//    @Transactional
    public void saveUserVenues(venuesDetails venue, String username) {
        Optional<userDetails> userOptional = signupService.getUseedetailsByUsername(username);
        System.out.println(userOptional.isEmpty());
        if (userOptional.isEmpty()) {
            return;
        }

        userDetails user = userOptional.get();

        venuesDetails savedVenue = venuesDataRepository.save(venue);

        user.getUserVenues().add(savedVenue);

        signupService.saveUserDetails(user);

    }

//    @Transactional
    public void deleteVenuesById(String Id, String username) {

        Optional<userDetails> userOptional = signupService.getUseedetailsByUsername(username);

        userDetails user = userOptional.get();

        user.getUserVenues().removeIf( x -> x.getVenueId().equals(Id));

        signupService.saveUserDetails(user);
        venuesDataRepository.deleteByvenueId(Id);
    }

}
