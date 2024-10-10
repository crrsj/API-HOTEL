package br.com.hotel.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hotel.enums.Pagamento;
import br.com.hotel.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {
	private Long id;	
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
}
