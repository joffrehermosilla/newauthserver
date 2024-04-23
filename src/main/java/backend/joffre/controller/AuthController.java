package backend.joffre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.joffre.dtio.CreateAppUserDto;
import backend.joffre.dtio.MessageDto;
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

	private final AppUserService appUserService;
	
	
	@Autowired
	RoleRepository repository;
	
	
	@PostConstruct
	public void creatRole() {
		Role adminRole = Role.builder().role(RoleName.ROLE_ADMIN).build();
		Role userRole = Role.builder().role(RoleName.ROLE_USER).build();
		repository.save(adminRole);
		repository.save(userRole);
		
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