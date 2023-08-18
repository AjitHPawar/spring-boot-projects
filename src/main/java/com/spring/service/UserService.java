package com.spring.service;

import com.spring.dto.UserDto;
import com.spring.entity.User;
import com.spring.exception.RecordNotDeleteException;
import com.spring.repository.UserRepository;
import com.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private Pagination pagination;

    @Autowired
    private PasswordEncoder encoder;

    public User saveUser(UserDto dto) {
        User user = User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .age(dto.getAge())
                .contact(dto.getContact())
                .nationality(dto.getNationality())
                .active(dto.isActive()).role(dto.getRole())
                .build();

        return repo.save(user);
    }

    public User update(UserDto dto) {
        User user = User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .age(dto.getAge())
                .contact(dto.getContact())
                .nationality(dto.getNationality()).active(dto.isActive()).role(dto.getRole())
                .build();
        return repo.save(user);
    }

    public boolean deleteUser(Integer id) throws RecordNotDeleteException {
        boolean isExist = repo.existsById(id);
        if (isExist) {
            repo.deleteById(id);
            return isExist;
        } else return isExist;
    }

    public List<User> getAllUser() {
        return repo.findAll();
    }

    public Optional<User> getUser(int id) {
        return repo.findById(id);
    }


    public List<User> findDistinctByContact(String contact) {
        return repo.findDistinctByContact(contact);
    }


    public List<User> findByNameAndNationality(String name, String nationality) {
        return repo.findByNameAndNationality(name, nationality);
    }


    public List<User> findByIdOrAge(int id, int age) {
        return repo.findByIdOrAge(id, age);
    }


    public List<User> findByAgeLessThan(int age) {
        return repo.findByAgeLessThan(age);
    }


    public List<User> findByNameLike(String name) {
        return repo.findByNameLike(name);
    }


    public List<User> findByEmailContaining(String email) {
        return repo.findByEmailContaining(email);
    }


    public List<User> findByEmailStartingWith(String email) {
        return repo.findByEmailStartingWith(email);
    }


    public List<User> findAllByOrderByAgeAsc() {
        return repo.findAllByOrderByAgeAsc();
    }


    public List<User> getUserNationalityAndActiveStatus(String nationality, boolean active) {
        return repo.getUserNationalityAndActiveStatus(nationality, active);
    }


    public Page<User> findByNameOrEmailOrAgeOrNationalityOrContactOrActive(String name, String email, int age, String nationality
            , String contact, boolean active, int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable page = pagination.getPagination(pageNo, pageSize, sortBy, sortDir);
        return repo.findByNameOrEmailOrAgeOrNationalityOrContactOrActive(
                name, email, age, nationality, contact, active, page);
    }


}
