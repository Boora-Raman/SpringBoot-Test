package online.raman_boora.demo.services;

import online.raman_boora.demo.entity.UserDetails;
import online.raman_boora.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SignupService {

    @Autowired
    private UserRepo userRepo;

    public UserDetails signup(UserDetails Details)
    {
        return  userRepo.save(Details);
//    return Details;
    }

    public List<UserDetails> getsignup()
    {
     return userRepo.findAll();
    }


    public UserDetails findById(Object username)
    {
        Optional<UserDetails> details = userRepo.findById(username);
        if(!details.isEmpty())
        {
            return userRepo.findById(username).get();
        }
        else
        {
            return null;
        }
    }

    }


