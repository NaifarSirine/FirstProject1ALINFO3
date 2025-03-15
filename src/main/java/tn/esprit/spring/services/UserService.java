package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service // ou @Component
//@AllArgsConstructor
public class UserService implements IUserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> addAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User edit(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> editAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteAll(List<User> users) {
        userRepository.deleteAll(users);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
       //return userRepository.findById(id).get();
       return userRepository.findById(id).orElse(User.builder().id(0L)
                .firstName("Foulen")
                .lastName("Ben Foulen").birthday(LocalDate.parse("1900-5-5"))
                .build()
            );
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Long count() {
        return userRepository.count();
    }
}
