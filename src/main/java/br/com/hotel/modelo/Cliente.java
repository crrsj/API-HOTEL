package br.com.hotel.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hotel.dto.ClienteDTO;
import br.com.hotel.enums.Pagamento;
import br.com.hotel.enums.Status;
import jakarta.persistence.Entity;
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
	private int quarto;
	private Double valorDiaria;
	private int dias;
	private Double total;
	private Pagamento pagamento;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;
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
}
