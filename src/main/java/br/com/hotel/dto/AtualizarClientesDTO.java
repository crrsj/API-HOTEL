package br.com.hotel.dto;

import br.com.hotel.enums.Pagamento;
import br.com.hotel.modelo.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtualizarClientesDTO {


	private Long id;
	private String fone;	
	private Pagamento pagamento;
	
	
	public AtualizarClientesDTO(Cliente atualizar) {
		// TODO Auto-generated constructor stub
		this.id = atualizar.getId();
		this.fone = atualizar.getFone();
		this.pagamento = atualizar.getPagamento();
	}
}
