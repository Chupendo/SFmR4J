package com.example.springsecurity.servicies.roles;

import java.util.List;
import java.util.stream.Collectors;

import com.example.springsecurity.entities.AuditDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.repositories.IRoleRepository;

@Service
public class RoleServicie implements IRoleService{

	@Autowired
	IRoleRepository repo;

	@Autowired
	private KafkaTemplate<Integer,String> kafkaTemplate;

	private ObjectMapper mapper = new ObjectMapper();
	@Override
	public List<Role> getAllRole(String contain) {
		List<Role> result = repo.findAll();
		if(result.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("No data in the systema load"));
		if(contain==null)
			return result;
		else
			return result.stream().filter(r->r.getName().contains(contain)).collect(Collectors.toList());
	}

	@Override
	public Role getRolleByName(String name) {
		
		return repo.findRoleByName(name)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("%s not found", name)));
	}

	@Override
	public Role getRolleById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role createRole(Role role) {
		
		return null;
	}

	@Override
	public Role updateRoleById(long id, Role roleNew) {
		//id of releNew is ignorated
		Role roleToUpdate = repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("id %s not found", id)));
		roleToUpdate.setName(roleNew.getName());
		repo.save(roleToUpdate);
		
		return roleToUpdate;
	}

	@Override
	public Role updateRoleByName(String nameOld, Role roleNew) {
		//id of releNew is ignorated
		Role roleToUpdate = repo.findRoleByName(nameOld).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("name %s not found", nameOld)));
		roleToUpdate.setName(roleNew.getName());
		repo.save(roleToUpdate);
		
		return roleToUpdate;
	}

	@Override
	public boolean deleteRoleById(long id) {
		repo.deleteById(id);
		return repo.existsById(id);
	}

	@Override
	public boolean deleteRoleByName(String name) {
		Role roleToDelete = repo.findRoleByName(name).get();
		System.out.println(roleToDelete.toString()+".");
		
		repo.deleteById(roleToDelete.getId());
		
		return repo.existsById(roleToDelete.getId());
	}


	//Mehtod used with Kafka
	public Role createRoleKafka(Role rle){
		Role roleCRole = repo.save(rle);


		AuditDetails detials = new AuditDetails(
				SecurityContextHolder.getContext().getAuthentication().getName(),
				roleCRole.getName()
		);

		try {
			//Se envia como JSON el detials
			kafkaTemplate.send("devs4j-topic", mapper.writeValueAsString(detials));
		} catch (JsonProcessingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error parsing the message");
		}
		return roleCRole;
	}
}
