package backend.joffre.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.joffre.dto.CreateAppUserDto;
import backend.joffre.dto.MessageDto;
import backend.joffre.entity.Role;
import backend.joffre.enums.RoleName;
import backend.joffre.repository.RoleRepository;
import backend.joffre.service.AppUserService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private final AppUserService appUserService;

	// private final ClientService clientService;

	@Autowired
	RoleRepository repository;

	@PostConstruct
	public void creatRole() {
		Role adminRole = Role.builder().role(RoleName.ROLE_ADMIN).build();
		Role userRole = Role.builder().role(RoleName.ROLE_USER).build();
		// Role oidcRole = Role.builder().role(RoleName.OIDC_USER).build();
		repository.save(adminRole);
		repository.save(userRole);
		// repository.save(oidcRole);
		List<String> roleuser = new ArrayList<>();
		roleuser.add("ROLE_USER");

		List<String> roleadmin = new ArrayList<>();
		roleadmin.add("ROLE_ADMIN");
		roleadmin.add("ROLE_USER");

		CreateAppUserDto dtouser = new CreateAppUserDto("user", "user", roleuser);
		CreateAppUserDto dtoadmin = new CreateAppUserDto("admin", "admin", roleadmin);

		LOGGER.info("user agregado: " + dtouser);
		LOGGER.info("admin agregado: " + dtoadmin);
		// appUserService.createUser(dtouser);

		/*
		 * List<Usuario> usuarios = new ArrayList<>(); Timestamp timestamp = new
		 * Timestamp(System.currentTimeMillis());
		 * 
		 * for (int i = 3; i < 15; i++) { Usuario usuario = new Usuario();
		 * usuario.setId(i); usuario.setName("usuarioID: +" + i);
		 * usuario.setPais("Pais a disponer"); usuario.setCreatAt(timestamp);
		 * usuarios.add(usuario); } usuarioservice.saveAllUsuarios(usuarios);
		 */
	}

	@PostMapping("/create")
	public ResponseEntity<MessageDto> createUser(@RequestBody CreateAppUserDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
	}
}