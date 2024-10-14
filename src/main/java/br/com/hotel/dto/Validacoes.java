package br.com.hotel.dto;

import org.springframework.validation.FieldError;

public record Validacoes(String campo,String mensagem) {

	public Validacoes(FieldError erro) {
		this(erro.getField(),erro.getDefaultMessage());
	}
}
