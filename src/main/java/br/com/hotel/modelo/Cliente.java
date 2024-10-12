package br.com.hotel.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hotel.dto.AtualizarClientesDTO;
import br.com.hotel.dto.ClienteDTO;
import br.com.hotel.dto.ClientesDTO;
import br.com.hotel.enums.Pagamento;
import br.com.hotel.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataEntrada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;
	private String cpf;
	private String fone;
	@Column(unique = true)
	private int quarto;
	private Double valorDiaria;
	private int dias;
	private Double total;
	@Enumerated(EnumType.STRING)
	private Pagamento pagamento;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;
    @Enumerated(EnumType.STRING)
	private Status status;
	
	public Cliente(ClienteDTO clienteDTO) {
	
		this.dataEntrada = clienteDTO.getDataEntrada();
		this.nome = clienteDTO.getNome();
		this.cpf = clienteDTO.getCpf();
		this.fone = clienteDTO.getFone();
		this.quarto = clienteDTO.getQuarto();
		this.valorDiaria = clienteDTO.getValorDiaria();
		this.dias = clienteDTO.getDias();
		this.total = clienteDTO.getTotal();
		this.pagamento = clienteDTO.getPagamento();
		this.dataSaida = clienteDTO.getDataSaida();
		this.status = clienteDTO.getStatus();
		
	}

	public Cliente(ClientesDTO clientesDTO) {
	   this.dataEntrada = clientesDTO.getDataEntrada();
	   this.nome = clientesDTO.getNome();
	   this.fone = clientesDTO.getFone();
	   this.quarto = clientesDTO.getQuarto();
	   this.valorDiaria = clientesDTO.getValorDiaria();
	   this.dias = clientesDTO.getDias();
	   this.total = clientesDTO.getTotal();
	   this.pagamento = clientesDTO.getPagamento();
	   this.dataSaida  =clientesDTO.getDataSaida();
	   this.status = clientesDTO.getStatus();
	}

	public void atualizando(AtualizarClientesDTO clientesDTO) {
		if(clientesDTO.getPagamento() != null) {
			this.pagamento = clientesDTO.getPagamento();
		}
		if(clientesDTO.getFone() != null) {
			this.fone = clientesDTO.getFone();
		}
	}

	
}
