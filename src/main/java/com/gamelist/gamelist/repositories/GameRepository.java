 package com.gamelist.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamelist.gamelist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	//realiza consultas no banco H2
}
