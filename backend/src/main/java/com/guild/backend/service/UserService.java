package com.guild.backend.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        if (user.getBirthDate() != null) exUser.setBirthDate(user.getBirthDate());
        if (user.getSurname() != null) exUser.setSurname(user.getSurname());
        if (user.getFirstname() != null) exUser.setFirstname(user.getFirstname());
        if (user.getPatronymic() != null) exUser.setPatronymic(user.getPatronymic());
        if (user.getLogin() != null) exUser.setLogin(user.getLogin());
        if (user.getPassword() != null) exUser.setPassword(user.getPassword());
        if (user.getSex() != null) exUser.setSex(user.getSex());
        if (user.getRank() != null) exUser.setRank(user.getRank());
        if (user.isAdventurer()) exUser.setAdventurer(user.isAdventurer());
        if (user.getPhone_number() != null) exUser.setPhone_number(user.getPhone_number());
        if (user.getEmail() != null) exUser.setEmail(user.getEmail());
        return userRepo.save(exUser);
    }

    public boolean delete(Long id){
        log.info("Deleting user by id:{}", id);
        userRepo.deleteById(id);
        return Boolean.TRUE;
    }

}
