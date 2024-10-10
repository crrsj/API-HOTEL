package br.com.hotel.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hotel.dto.ClienteDTO;
import br.com.hotel.dto.ClientesDTO;
import br.com.hotel.enums.Status;
import br.com.hotel.modelo.Cliente;
import br.com.hotel.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServico {

	private ClienteRepositorio clienteRepositorio;
	
	public Cliente criarCliente(ClienteDTO clienteDTO) {
		var criar = new Cliente(clienteDTO);
	    if(criar.getStatus() == Status.RESERVADO) {
	    	System.out.println("ja reservado");
	    }
		return clienteRepositorio.save(criar);
	}
	
	public List<ClientesDTO> listarClientes() {
	  var listar = clienteRepositorio.findAll().stream().map(ClientesDTO::new).toList();
	  if(listar.isEmpty()) {
		  System.out.println("not found");
	  }
	  return listar;
	}
}
