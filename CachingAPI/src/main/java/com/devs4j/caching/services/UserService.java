package com.devs4j.caching.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.caching.entitites.User;
import com.devs4j.caching.reports.IUserRepository;

@Service
public class UserService {

	@Autowired
	IUserRepository uRepo;
	
	
	public List<User> getUsers(String startWith){
		List<User> lUser = uRepo.findAll();
		if(lUser==null||lUser.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There aren't users load in the system");
			
		if(startWith==null) {
			return lUser;
		}
		
		return lUser.stream().filter(u->u.getName().startsWith(startWith)).toList();
		
	}
	
	public Page<User> getUsersPage(Integer page,Integer size, String startWith){
		Page<User> allUserSortedByNameAndId = uRepo.findAll(PageRequest.of(page, size,Sort.by("name").and(Sort.by("id"))));
		if(startWith==null) {
			return allUserSortedByNameAndId;
		}
		
		/*
		 * convert to List<User> to page<User>
		 *  List<User> users = userService.findAllByProgramId(programId);
    	 *  Page<User> pages = new PageImpl<User>(users, pageable, users.size());
		 */
		return new PageImpl<User>(
				allUserSortedByNameAndId.stream()
					.filter(u->u.getName().startsWith(startWith))
					.collect(Collectors.toList())); 
		
	}
	
	public User getUserByName(String name) {
		return uRepo.findByName(name).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Name user %s not found",name)));
	}
	
	public User createUser(User user) {
		if(user.getId()!=0 && idIsBeingUsed(user.getId()))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Name user %s not found",user.getId()));
		
		if(user.getName()==null || user.getName().isEmpty() || nameIsBeingUsed(user.getName()))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Name user %s not found",user.getId()));
		
		uRepo.save(user);
		return user;
		
	}
	public void updateUser(String name, User user) {
		if(!nameIsBeingUsed(user.getName()))
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("The user %s not found" , name));
		
		User userToBeUpdate = uRepo.findByName(name).orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("The user %s not found" , name)));
		userToBeUpdate.setName(user.getName());
		userToBeUpdate.setId(user.getId());
		userToBeUpdate.setNick(user.getNick());
		userToBeUpdate.setPassword(user.getPassword());
		
		uRepo.save(userToBeUpdate);
		
	}
	private boolean idIsBeingUsed(Integer id) {
		return uRepo.existsById(id);
	}
	
	private boolean nameIsBeingUsed(String name) {
		return uRepo.existsByName(name);
	}
	
	public User authenticateUser(User user) {
		User userToAuth = uRepo.findByName(user.getName()).get();
		if(userToAuth==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("The user %s not found" , user.getName()));
		}
		
		if(userToAuth.getName().equals(user.getName())
				&& userToAuth.getPassword().equals(user.getPassword())) {
			return user;
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, String.format("The user or pwd is error"));
		
	}
	
	public void deleteUserByName(String name) {
		if(!nameIsBeingUsed(name))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("The user %s not found" , name));
		
		uRepo.deleteById(getUserByName(name).getId());
	}
	
	public List<String> getAllUserNames(){
		return uRepo.findAllUserName();
	}
	
	public Page<String> getAllUserNamesPage(Integer page,Integer size){
		return uRepo.findAllUserNamePage(PageRequest.of(page, size));
	}
	
}
