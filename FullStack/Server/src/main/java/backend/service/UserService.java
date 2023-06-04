package backend.service;

import backend.model.User;
import backend.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRep userRep;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = getByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean add(User value) {
        User userFromDB = getByLogin(value.getUsername());
        if (userFromDB != null) {
            return false;
        }
        value.setPassword(bCryptPasswordEncoder.encode(value.getPassword()));
        userRep.save(value);
        return true;
    }

    public void remove(User value) {
        this.userRep.delete(value);
    }

    public List<User> getAll() {
        return this.userRep.findAll();
    }

    public User getById(Long id) {
        return userRep.getById(id);
    }

    public User getByLogin(String login) {
        for (User value : getAll()) {
            if (value.getLogin().equals(login)) {
                return value;
            }
        }
        return null;
    }

    public List<User> getByUserName(String name) {
        List<User> list = new LinkedList<>();
        for (User value : getAll()) {
            if (value.getUserName().equals(name)) {
                list.add(value);
            }
        }
        return list;
    }

    public List<User> getByUserStatus(Boolean status) {
        List<User> list = new LinkedList<>();
        for (User value : getAll()) {
            if (value.getUserStatus().equals(status)) {
                list.add(value);
            }
        }
        return list;
    }
}
