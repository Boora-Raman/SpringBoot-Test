package online.raman_boora.demo.controller;

import online.raman_boora.demo.entity.UserDetails;
import online.raman_boora.demo.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class signup {
    @Autowired
    private SignupService signupService;

    @GetMapping("signup/")
    public List<UserDetails> getUseedetails()
    {
        return signupService.getsignup();
    }

    @GetMapping("signup/{username}")
    public UserDetails getUseedetailsByUsername(@PathVariable("username") Object username)
    {
        return signupService.findById(username);
    }
    @PostMapping("signup/")
    public UserDetails SignupDetails( @RequestBody UserDetails details )
    {
       return signupService.signup(details);
    }


}
