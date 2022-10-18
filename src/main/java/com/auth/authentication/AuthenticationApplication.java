package com.auth.authentication;

import com.auth.authentication.domain.Role;
import com.auth.authentication.domain.User;
import com.auth.authentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Raul Seixas", "raul", "1234", new ArrayList()));
			userService.saveUser(new User(null, "Paulão Velhas Virgens", "paulao", "1234", new ArrayList()));
			userService.saveUser(new User(null, "Renato Russo", "renato", "1234", new ArrayList()));
			userService.saveUser(new User(null, "Marcelo Nova", "marcelo", "1234", new ArrayList()));

			userService.addRoleToUser("raul","ROLE_USER");
			userService.addRoleToUser("raul","ROLE_ADMIN");
			userService.addRoleToUser("paulao","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("renato","ROLE_MANAGER");
			userService.addRoleToUser("marcelo","ROLE_USER");

		};
	}


}
