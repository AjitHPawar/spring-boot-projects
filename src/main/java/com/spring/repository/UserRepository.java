package com.spring.repository;

import com.spring.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findDistinctByContact(String contact);

    List<User> findByNameAndNationality(String name, String nationality);

    List<User> findByIdOrAge(int id, int age);

    List<User> findByAgeLessThan(int age);

    List<User> findByNameLike(String name);

    List<User> findByEmailContaining(String email);

    List<User> findByEmailStartingWith(String email);

    List<User> findAllByOrderByAgeAsc();

    @Query("select u from User u where nationality = ?1 and active = ?2")
    public List<User> getUserNationalityAndActiveStatus(String nationality, boolean active);

    Page<User> findByNameOrEmailOrAgeOrNationalityOrContactOrActive(String name, String email, int age,
                                                                    String nationality, String contact,
                                                                    boolean active, Pageable page);

    Optional<User> findByEmail(String email);
}
