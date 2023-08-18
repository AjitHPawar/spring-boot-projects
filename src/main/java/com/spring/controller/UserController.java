package com.spring.controller;

import com.spring.dto.UserDto;
import com.spring.entity.User;
import com.spring.exception.RecordNotDeleteException;
import com.spring.exception.RecordNotFoundException;
import com.spring.exception.RecordNotSavedException;
import com.spring.exception.RecordNotUpdatedException;
import com.spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto dto) throws RecordNotSavedException {
        User user = service.saveUser(dto);
        if (user != null)
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        else throw new RecordNotSavedException("Record Not Saved Successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody @Valid UserDto dto) throws RecordNotUpdatedException {
        User user = service.update(dto);
        if (user != null)
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        else throw new RecordNotUpdatedException("Record Not Updated Successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Integer id) throws RecordNotDeleteException {
        boolean isDeleted = service.deleteUser(id);
        if (isDeleted) return new ResponseEntity<String>("Record Deleted successfully ", HttpStatus.OK);
        else throw new RecordNotDeleteException("Record Not deleted for Id : " + id);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUsers() throws RecordNotFoundException {
        List<User> users = service.getAllUser();
        if (!users.isEmpty())
            return new ResponseEntity<>(users, HttpStatus.FOUND);
        else throw new RecordNotFoundException("Records Not Found ");
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) throws RecordNotFoundException {
        Optional<User> user = service.getUser(id);
        if (user.isPresent())
            return new ResponseEntity<User>(user.get(), HttpStatus.FOUND);
        else throw new RecordNotFoundException("Record Not Found For Id :" + id);
    }


    @GetMapping("/getByContact/{contact}")
    public ResponseEntity<List<User>> findDistinctByContact(@PathVariable String contact) throws RecordNotFoundException {
        List<User> users = service.findDistinctByContact(contact);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Contacts : " + contact);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @GetMapping("/getByNameAndNationality/{name}/{nationality}")
    public ResponseEntity<List<User>> findByNameAndNationality(@PathVariable String name, @PathVariable String nationality) throws RecordNotFoundException {
        List<User> users = service.findByNameAndNationality(name, nationality);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Name : " + name + "and Nationality :" + nationality);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }


    @GetMapping("/getByIdOrAge/{id}/{age}")
    public ResponseEntity<List<User>> findByIdOrAge(@PathVariable int id, @PathVariable int age) throws RecordNotFoundException {
        List<User> users = service.findByIdOrAge(id, age);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Id : " + id + "and Age :" + age);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/findByAgeLessThan/{age}")
    public ResponseEntity<List<User>> findByAgeLessThan(@PathVariable int age) throws RecordNotFoundException {
        List<User> users = service.findByAgeLessThan(age);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Age : " + age);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @GetMapping("/findByNameLike/{nameLike}")
    public ResponseEntity<List<User>> findByNameLike(@PathVariable String nameLike) throws RecordNotFoundException {
        List<User> users = service.findByNameLike(nameLike);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Name Like : " + nameLike);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @GetMapping("/findByEmailContaining")
    public ResponseEntity<List<User>> findByEmailContaining(@RequestParam String email) throws RecordNotFoundException {
        List<User> users = service.findByEmailContaining(email);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Email : " + email);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @GetMapping("/findByEmailStartingWith/{email}")
    public ResponseEntity<List<User>> findByEmailStartingWith(@PathVariable String email) throws RecordNotFoundException {
        List<User> users = service.findByEmailStartingWith(email);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Email : " + email);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @GetMapping("/findByAllAgeOrderByAsc")
    public ResponseEntity<List<User>> findAllByOrderByAgeAsc() throws RecordNotFoundException {
        List<User> users = service.findAllByOrderByAgeAsc();
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found ");
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @GetMapping("/getUserNationalityAndActiveStatus")
    public ResponseEntity<List<User>> getUserNationalityAndActiveStatus(@RequestParam String nationality, @RequestParam boolean active) throws RecordNotFoundException {
        List<User> users = service.getUserNationalityAndActiveStatus(nationality, active);
        if (users.isEmpty())
            throw new RecordNotFoundException("Record Not found For the Nationality : " + nationality + " and active :" + active);
        else return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/getByFilterWithPaginationAndSorting")
    public ResponseEntity<Page<User>> findByNameOrEmailOrAgeOrNationalityOrContactOrActive(@RequestParam(required = false) String name, @RequestParam(required = false) String email, @RequestParam(required = false, defaultValue = "0") int age, @RequestParam(required = false) String nationality
            , @RequestParam(required = false) String contact, @RequestParam(required = false) boolean active, @RequestParam(required = false) int pageNo, @RequestParam(required = false) int pageSize, @RequestParam(required = false) String sortBy, @RequestParam(required = false) String sortDir) throws RecordNotFoundException {
        Page<User> page = service.findByNameOrEmailOrAgeOrNationalityOrContactOrActive(name, email, age, nationality
                , contact, active, pageNo, pageSize, sortBy, sortDir);
        if (page.isEmpty())
            throw new RecordNotFoundException("Record Not found For the page ");
        else return new ResponseEntity<Page<User>>(page, HttpStatus.OK);
    }

}
