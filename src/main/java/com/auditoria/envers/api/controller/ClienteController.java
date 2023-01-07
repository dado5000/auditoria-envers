package com.auditoria.envers.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auditoria.envers.domain.ClienteService;
import com.auditoria.envers.domain.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping("/novo")
	public ResponseEntity<Cliente> novo(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(service.salvar(cliente));
	}
	
	@GetMapping("{idCliente}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long idCliente) {
		return ResponseEntity.ok(service.buscarOuFalhar(idCliente));
	}
	
	@PutMapping("{idCliente}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long idCliente, @RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(service.atualizar(idCliente, cliente));
	}
	
	@DeleteMapping("{idCliente}")
	public ResponseEntity<Object> excluir(@PathVariable Long idCliente) {
		service.excluir(idCliente);
		return ResponseEntity.noContent().build();
		
	}

}
