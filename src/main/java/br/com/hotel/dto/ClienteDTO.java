package br.com.hotel.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hotel.enums.Pagamento;
import br.com.hotel.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
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
	@Enumerated(EnumType.STRING)
	private Pagamento pagamento;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataSaida;
	@Enumerated(EnumType.STRING)
	private Status status;
	
}
