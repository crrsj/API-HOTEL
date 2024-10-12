package br.com.hotel.infra;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.hotel.dto.QuartoReservado;

@RestControllerAdvice
public class TratamentoDeExcessao {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<QuartoReservado>erroQuartoReservado(){
		var tratarErros = new QuartoReservado(HttpStatus.BAD_REQUEST, "Este quarto já está reservado !");
		return new ResponseEntity<>(tratarErros,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<QuartoReservado>clientesNaoEncontrados(){		
		var naoEncontrado = new QuartoReservado(HttpStatus.NOT_FOUND, "Cliente(s) não Encontrado(s)");
		return new ResponseEntity<>(naoEncontrado,HttpStatus.NOT_FOUND);
	}
	
	
}
