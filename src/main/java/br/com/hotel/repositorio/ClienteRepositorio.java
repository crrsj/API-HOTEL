package br.com.hotel.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotel.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente , Long> {

}
