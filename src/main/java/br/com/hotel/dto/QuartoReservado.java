package br.com.hotel.dto;

import org.springframework.http.HttpStatus;

public record QuartoReservado(
		HttpStatus status,
		
		String mensagem) {

}
