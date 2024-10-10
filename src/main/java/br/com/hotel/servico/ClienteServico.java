package br.com.hotel.servico;

import org.springframework.stereotype.Service;

import br.com.hotel.dto.ClienteDTO;
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
		criar.setStatus(Status.RESERVADO);
		return clienteRepositorio.save(criar) 
	}
}
