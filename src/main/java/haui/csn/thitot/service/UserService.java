package haui.csn.thitot.service;

import haui.csn.thitot.entity.User;
import haui.csn.thitot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
    public void save(User user) {
        userRepository.save(user);
    }
}
