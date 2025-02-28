package online.raman_boora.demo.controller;

import online.raman_boora.demo.entity.venuesDetails;
import online.raman_boora.demo.services.venuesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class venuesController {

    @Autowired
    private venuesServices venuesServices;


    @PostMapping("/venues/{username}")
    public ResponseEntity<?> saveUserVenues(@RequestBody venuesDetails venue , @PathVariable String username)
    {
        try
        {
        venuesServices.saveUserVenues(venue,username);
        return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping("/venues")
    public ResponseEntity<?> getAllVenues()
    {
        return new ResponseEntity<>( venuesServices.getAllVenues(), HttpStatus.OK);
    }



    @GetMapping("/venues/{venue-id}")
    public ResponseEntity<?> getVenuesById(@PathVariable("venue-id") String venueId)
    {
        return new ResponseEntity<>(venuesServices.getVenuesById(venueId),HttpStatus.OK);
    }


    @DeleteMapping("/venues/{username}/{venue-id}")
    public ResponseEntity<?> deleteVenuesById(@PathVariable("venue-id") String Id, @PathVariable String username)
    {
        venuesServices.deleteVenuesById(Id,username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
