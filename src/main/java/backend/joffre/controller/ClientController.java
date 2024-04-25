package backend.joffre.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.joffre.dto.CreateAppUserDto;
import backend.joffre.dto.CreateClientDto;
import backend.joffre.dto.MessageDto;
import backend.joffre.entity.Role;
import backend.joffre.enums.RoleName;
import backend.joffre.service.AppUserService;
import backend.joffre.service.ClientService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

	private final ClientService clientService;
	

	@PostMapping("/create")
	public ResponseEntity<MessageDto> create(@RequestBody CreateClientDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(dto));
	}
}
