package backend.joffre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import backend.joffre.entity.Role;
import backend.joffre.enums.RoleName;
import backend.joffre.repository.RoleRepository;

@SpringBootApplication
public class DemoApplication /* implements CommandLineRunner */ {

	/*
	 * @Autowired RoleRepository repository;
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*
	 * @Override public void run(String... args) throws Exception { Role adminRole =
	 * Role.builder().role(RoleName.ROLE_ADMIN).build(); Role userRole =
	 * Role.builder().role(RoleName.ROLE_USER).build(); repository.save(adminRole);
	 * repository.save(userRole); }
	 */
}
