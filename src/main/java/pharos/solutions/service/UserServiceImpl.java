package pharos.solutions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pharos.solutions.model.entity.User;
import pharos.solutions.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserDetails(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        if (!user.isPresent()) {
            throw new RuntimeException("not valid user ");
        }
        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user  = getUserDetails(s);
        return new org.springframework.security.core.userdetails.User(user.getId().toString(),
                user.getPassword(), getGrantAuthority());
    }
    private List getGrantAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
