package ru.gav19770210.javapro.task04;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class UserService {
    @Autowired
    UserDAO userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userDao.create(user);
    }

    public User updateUser(User user) {
        return userDao.update(user);
    }

    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
