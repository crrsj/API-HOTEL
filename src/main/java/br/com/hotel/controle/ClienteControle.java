package br.com.hotel.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hotel.dto.ClienteDTO;
import br.com.hotel.servico.ClienteServico;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("hotel")
public class ClienteControle {

	private ClienteServico clienteServico;
	
	@PostMapping
	public ResponseEntity<ClienteDTO>criarCliente(@RequestBody ClienteDTO clienteDTO){
		var cadastrarCliente = clienteServico.criarCliente(clienteDTO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(cadastrarCliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(cadastrarCliente));
	}
}
