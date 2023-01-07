package com.devs4j.jpa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.jpa.entites.User;
import com.devs4j.jpa.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	
	
	public List<User> getUsers(String startWith){
		List<User> luser = (List<User>)repository.findAll();
		if(startWith==null) {
			return luser;
		}
		
		return luser.stream().filter(u->u.getUserName().startsWith(startWith)).collect(Collectors.toList());
	}
	
	public User getUserByName(String userName){
		return repository.findUserByUserName(userName)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, 
				String.format("User %s not found", userName)));
	}
	
	public User createUser(User user){
		if(repository.findUserByUserName(user.getUserName()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					String.format("The %s is in used", user.getUserName()));
		}
		
		repository.save(user);
		return user;
	}
	
	public void updatedUser(String username,User user) {
		User userToBeUpdated = getUserByName(username);
		if(!username.equals(user.getUserName()))
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, 
					String.format("The %s don't equal to %s",username,user.getUserName()));
		
		userToBeUpdated.setUserName(user.getUserName());
		userToBeUpdated.setRole(user.getRole());
		userToBeUpdated.setPassword(user.getPassword());
	}
	
	public void deleteUserByName(String userName) {
		User userToBeDeleted = getUserByName(userName);
		
		repository.delete(userToBeDeleted);
	}
	
	public User authenticateUser(User user) {
		return repository.findUserByUserNameAndPassword(user.getUserName(), user.getPassword()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, 
					String.format("The %s cannot be authentication",user.getUserName())));
	}
	
	public Page<User> paginableUser(Integer page, Integer size, String startWith){
		Page<User> luser = repository.findAll(PageRequest.of(page, size));
		if(startWith==null) {
			return luser;
		}
		
		/*
		 * convert to List<User> to page<User>
		 *  List<User> users = userService.findAllByProgramId(programId);
    	 *  Page<User> pages = new PageImpl<User>(users, pageable, users.size());
		 */
		
		return new PageImpl<User>( 
				luser.stream()
					.filter(
							u->u.getUserName()
								.startsWith(startWith))
								.collect(Collectors.toList()));
	}
	
	public List<String> getAllUserNames(){
		return repository.findAllUserNames();
	}
	
	public Page<String> getAllUserNamesPage(Integer page,Integer size){
		return repository.findAllUserNamesPage(PageRequest.of(page, size));
	}

}
