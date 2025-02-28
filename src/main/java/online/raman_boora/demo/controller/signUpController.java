package online.raman_boora.demo.controller;

import online.raman_boora.demo.entity.userDetails;
import online.raman_boora.demo.services.signupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class signUpController {

    @Autowired
    private signupService signupService;

    // Get all user details
    @GetMapping("")
    public List<userDetails> getUseedetails() {
        return signupService.getUseedetails();
    }

    // Get user details by username
    @GetMapping("/details/{Username}")
    public ResponseEntity<?> getUseedetailsByUsername(@PathVariable String Username) {
        Optional<userDetails> user = signupService.getUseedetailsByUsername(Username);
        if(user.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get() ,HttpStatus.FOUND);
    }


    @DeleteMapping("/{Username}")
    public ResponseEntity<?> deleteUseedetailsByUsername(@PathVariable("Username") String Username) {
        boolean deleted = signupService.deleteUseedetailsByUsername(Username);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Save user details
    @PostMapping("")
    public ResponseEntity<String> saveUserDetails(@RequestBody userDetails details) {
//        userDetails details = new userDetails(username,email,password);
        signupService.saveUserDetails(details);
        return ResponseEntity.ok("User saved successfully.");
    }
}
