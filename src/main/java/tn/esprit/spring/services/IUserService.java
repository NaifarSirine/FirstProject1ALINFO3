package tn.esprit.spring.services;

import tn.esprit.spring.entities.User;

import java.util.List;

public interface IUserService {
    User add(User user);
    List<User> addAll(List<User> users);
    User edit(User user);
    List<User> editAll(List<User> users);
    void delete(User user);
    void deleteById(Long id);
    void deleteAll();
    void deleteAll(List<User> users);
    List<User> getAll();
    User getById(Long id);
    boolean existsById(Long id);
    Long count();
}
