package com.auditoria.envers.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.auditoria.envers.domain.model.Cliente;
import com.auditoria.envers.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente atualizar(Long idCliente, Cliente cliente) {
		cliente.setId(idCliente);
		return repository.save(cliente);
	}
	
	public void excluir(Long idCliente) {
		var cliente = buscarOuFalhar(idCliente);
		repository.deleteById(cliente.getId());
	}
	
	public Cliente buscarOuFalhar(Long idCliente) {
		return repository.findById(idCliente).orElseThrow(
				() -> new DataIntegrityViolationException("Registro de cliente não localizado"));
	}

}
