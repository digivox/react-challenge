package br.com.digivox.reactchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digivox.reactchallenge.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
