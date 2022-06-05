package com.guild.backend.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.guild.backend.entity.User;
import com.guild.backend.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserService {
    private final UserRepo userRepo;

    public User create(User user){
        log.info("Creating new user: {}", user.getSurname());
        return userRepo.save(user);
    }

    public Collection<User> list(int limit){
        log.info("Featching all users with limit: {}", limit);
        return userRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    public User get(Long id){
        log.info("Featching user with id: {}", id);
        return userRepo.findById(id).get();
    }

    public User update(User user){
        log.info("Updating user id: {}", user.getId());
        User exUser = userRepo.findById(user.getId()).get();
        if (user.getAge() > 0) exUser.setAge(user.getAge());
        if (user.getSurname() != null) exUser.setSurname(user.getSurname());
        if (user.getFirstname() != null) exUser.setFirstname(user.getFirstname());
        if (user.getLogin() != null) exUser.setLogin(user.getLogin());
        if (user.getPassword() != null) exUser.setPassword(user.getPassword());
        if (user.getSex() != null) exUser.setSex(user.getSex());
        if (user.isAdventurer()) exUser.setAdventurer(user.isAdventurer());
        return userRepo.save(exUser);
    }

    public boolean delete(Long id){
        log.info("Deleting user by id:{}", id);
        userRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
