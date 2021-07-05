
package com.vms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.assertj.core.api.Assertions;

import com.vms.Controllers.UserController;
import com.vms.Entity.Candidate;
import com.vms.Entity.Election;
import com.vms.Entity.User;
import com.vms.Repository.UserRepository;
import com.vms.Service.UserServiceOperation;

@SpringBootTest
public class UserControllerTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServiceOperation userservice;
	
	@Autowired
	UserController userController;
	
	@Test
	public void userTest() throws Exception {
		assertThat(userController).isNotNull();
	}
	@Test
	public void serviceTest() throws Exception {
		assertThat(userservice).isNotNull();
	}

	
	@Test
	public void testViewUser() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/listAllVoters";
			userRepository.findAllUser();
			User[] us =restTemplate.getForObject(url, User[].class);
			User u=userRepository.finduserByid(1L);
			Assertions.assertThat(us).extracting(User :: getUsername).contains("monako");				
	}
	
//	@Test
//	public void testViewUser() {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/listAllVoters";
//        User user= new User(10L,"nilam","thapa",19,"7977008753","female","223456789012","avc road","567897","abc@g.com","nilu","nilam",null,null,null,null);
//		userRepository.save(user);
//		userRepository.findAllUser();
//		User[] us =restTemplate.getForObject(url, User[].class);
//		User u=userRepository.finduserByid(10L);
//		Assertions.assertThat(us).extracting(User :: getUsername).contains("monako");				
//	}
	
	
	
	
	
}
