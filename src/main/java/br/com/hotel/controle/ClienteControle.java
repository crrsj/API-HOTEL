package br.com.hotel.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hotel.dto.AtualizarClientesDTO;
import br.com.hotel.dto.ClienteDTO;
import br.com.hotel.dto.ClientesDTO;
import br.com.hotel.servico.ClienteServico;
import jakarta.validation.Valid;


@RestController
@RequestMapping("hotel")
public class ClienteControle {

	@Autowired 
	private ClienteServico clienteServico; 
	
	@PostMapping
	public ResponseEntity<ClienteDTO>criarCliente(@RequestBody @Valid  ClienteDTO clienteDTO){
		var cadastrarCliente = clienteServico.criarCliente(clienteDTO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(cadastrarCliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(cadastrarCliente));
	}
	
	
	@GetMapping
	public ResponseEntity<List<ClientesDTO>>listarClientes(){
		var listar = clienteServico.listarClientes();
		return ResponseEntity.ok(listar);
	}
	
	@PatchMapping
	public ResponseEntity<AtualizarClientesDTO>atualizarClientes(@RequestBody AtualizarClientesDTO clientes){
		var atualizar = clienteServico.AtualizarCliente(clientes);
		return ResponseEntity.ok().body(new AtualizarClientesDTO(atualizar));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClientesDTO>buscarPorId(@PathVariable Long id){
		var busca = clienteServico.buscarPorId(id);
		return ResponseEntity.ok().body(new ClientesDTO(busca));
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		clienteServico.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("buscarNome")
	public ResponseEntity<List<ClientesDTO>>buscarCliente(@RequestParam("nome")String nome){
		var buscarNome = clienteServico.buscarCliente(nome).stream().map(ClientesDTO::new).toList();
		return ResponseEntity.ok(buscarNome);
	}
}
