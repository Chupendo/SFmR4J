package com.example.springsecurity.servicies.users;

import com.example.springsecurity.entities.User;
import com.example.springsecurity.repositories.IUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    IUserRepository uRepo;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);


    public List<User> getUsers(String startWith){
        List<User> lUsers = uRepo.findAll();
        if(lUsers ==null|| lUsers.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There aren't users load in the system");

        if(startWith==null) {
            return lUsers;
        }

        return lUsers.stream().filter(u->u.getUserName().startsWith(startWith)).toList();

    }

    public Page<User> getUsersPage(Integer page, Integer size, String startWith){
        Page<User> allUserSortedByNameAndId = uRepo.findAll(PageRequest.of(page, size, Sort.by("name").and(Sort.by("id"))));
        if(startWith==null) {
            return allUserSortedByNameAndId;
        }

        /*
         * convert to List<User> to page<User>
         *  List<User> users = userService.findAllByProgramId(programId);
         *  Page<User> pages = new PageImpl<User>(users, pageable, users.size());
         */
        return new PageImpl<>(
                allUserSortedByNameAndId.stream()
                        .filter(u->u.getUserName().startsWith(startWith))
                        .collect(Collectors.toList()));

    }

    @Cacheable(value= "users", key="#name", unless = "#result == null")//Guarda el resultado en el mapa user con la key "name"
    public User getUserByName(String name) {
        log.info("Getting user by name {}",name);
        return uRepo
                .findByUserName(name)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Name user %s not found",name)
                ));
    }

    public User createUser(User user) {
        if(user.getId()!=0 && idIsBeingUsed(user.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Name user %s not found", user.getId()));

        if(user.getUserName()==null || user.getUserName().isEmpty() || nameIsBeingUsed(user.getUserName()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Name user %s not found", user.getId()));

        uRepo.save(user);
        return user;

    }

    @CachePut(value = "users",key = "#name")
    public User updateUser(String name, User user) {
        if(!nameIsBeingUsed(name))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("The user %s not found" , name));

        if(!nameIsBeingUsed(user.getUserName()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("The user %s is being used" , name));

        User userToBeUpdate = uRepo.findByUserName(name).orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("The user %s not found" , name)));
        userToBeUpdate.setUserName(user.getUserName());
        //userToBeUpdate.setId(user.getId());
        userToBeUpdate.setUserNick(user.getUserNick());
        userToBeUpdate.setPassword(user.getPassword());

        uRepo.save(userToBeUpdate);

        return userToBeUpdate;

    }
    private boolean idIsBeingUsed(Long id) {
        return uRepo.existsById(id);
    }

    private boolean nameIsBeingUsed(String name) {
        return uRepo.existsByUserName(name);
    }

    public User authenticateUser(User user) {
        User userToAuth = uRepo.findByUserName(user.getUserName()).get();
        if(userToAuth ==null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("The user %s not found" , user.getUserName()));
        }

        if(userToAuth.getUserName().equals(user.getUserName())
                && userToAuth.getPassword().equals(user.getPassword())) {
            return user;
        }

        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, String.format("The user or pwd is error"));

    }

    @CacheEvict(value = "users",key="#name")
    public void deleteUserByName(String name) {
        if(!nameIsBeingUsed(name))
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    String.format("The user %s not found" , name));

        uRepo.deleteById(getUserByName(name).getId());
    }

    public List<String> getAllUserNames(){
        return uRepo.findAllUserName();
    }

    public Page<String> getAllUserNamesPage(Integer page,Integer size){
        return uRepo.findAllUserNamePage(PageRequest.of(page, size));
    }
}