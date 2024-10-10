package br.com.hotel.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hotel.enums.Pagamento;
import br.com.hotel.enums.Status;
import br.com.hotel.modelo.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {
	private Long id;
	private String dataEntrada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;	
	private String fone;
	private int quarto;
	private Double valorDiaria;
	private int dias;
	private Double total;
	private Pagamento pagamento;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;
	private Status status;
	
	public ClientesDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.fone = cliente.getFone();
		this.quarto = cliente.getQuarto();
		this.valorDiaria = cliente.getValorDiaria();
		this.dias = cliente.getDias();
		this.total = cliente.getTotal();
		this.pagamento = cliente.getPagamento();
		this.dataSaida = cliente.getDataSaida();
		this.status = cliente.getStatus();
	}
}
