package br.com.hotel.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hotel.enums.Pagamento;
import br.com.hotel.enums.Status;
import br.com.hotel.modelo.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
	
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
	
	public ClienteDTO(Cliente cadastrarCliente) {
		this.dataEntrada = cadastrarCliente.getDataEntrada();
		this.nome = cadastrarCliente.getNome();
		this.cpf = cadastrarCliente.getCpf();
		this.fone = cadastrarCliente.getFone();
		this.quarto = cadastrarCliente.getQuarto();
		this.valorDiaria = cadastrarCliente.getValorDiaria();
		this.dias = cadastrarCliente.getDias();
		this.total = cadastrarCliente.getTotal();
		this.pagamento = cadastrarCliente.getPagamento();
		this.dataSaida = cadastrarCliente.getDataSaida();
		this.status = cadastrarCliente.getStatus();
	}
}
