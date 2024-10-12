package br.com.hotel.servico;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hotel.dto.AtualizarClientesDTO;
import br.com.hotel.dto.ClienteDTO;
import br.com.hotel.dto.ClientesDTO;
import br.com.hotel.modelo.Cliente;
import br.com.hotel.repositorio.ClienteRepositorio;
import jakarta.transaction.Transactional;


@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public Cliente criarCliente(ClienteDTO clienteDTO) {
		var criar = new Cliente(clienteDTO);
		criar.setTotal(criar.getDias() * criar.getValorDiaria());
	 	return clienteRepositorio.save(criar);
	}
	
	public List<ClientesDTO> listarClientes() {
	  var listar = clienteRepositorio.findAll().stream().map(ClientesDTO::new).toList();
	  if(listar.isEmpty()) { 
		  throw new NoSuchElementException();
	  }
	  return listar;
	}
	public Cliente buscarPorId(Long id) {
		Optional<Cliente>buscar = clienteRepositorio.findById(id);
		return buscar.orElseThrow(NoSuchElementException::new);
	}
	
	@Transactional
	public Cliente AtualizarCliente(AtualizarClientesDTO clientesDTO) {
		var atualizar = clienteRepositorio.getReferenceById(clientesDTO.getId());
		atualizar.atualizando(clientesDTO);
		return clienteRepositorio.save(atualizar);
	}
	
	public void excluir(Long id) {
		clienteRepositorio.deleteById(id);
		
	}
	
	
	public List<Cliente> buscarCliente(String nome) {		
		var cliente = clienteRepositorio.findAllByNome(nome.trim().toUpperCase());
		if(cliente.isEmpty()) {
			 throw new NoSuchElementException();
		}
		return cliente;
	}
}
