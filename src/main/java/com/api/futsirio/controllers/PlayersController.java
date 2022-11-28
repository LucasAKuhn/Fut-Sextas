package com.api.futsirio.controllers;

import com.api.futsirio.entities.Players;
import com.api.futsirio.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/players")
public class PlayersController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Players> findAll() {
        List<Players> result = playerRepository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Players findById(@PathVariable Long id) {
        Players result = playerRepository.findById(id).get();
        return result;
    }

    @PostMapping
    public Players insert(@RequestBody Players players) {
        Players result = playerRepository.save(players);
        return result;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePlayers(@PathVariable(value = "id") Long id,
                                                @RequestBody Players players ) {
        Optional<Players> playersOptional = playerRepository.findById(id);
        if(!playersOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player não encontrado");
        }
        var player = playersOptional.get();

        player.setIdade(players.getIdade());
        player.setNome(players.getNome());
        player.setQualidade(players.getQualidade());

        return ResponseEntity.status(HttpStatus.OK).body(playerRepository.save(player));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePlayer(@PathVariable(value = "id") Long id) {
        Optional<Players> playersOptional = playerRepository.findById(id);
        if(!playersOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player não encontrado");
        }
        playerRepository.delete(playersOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Player deletado com sucesso");
    }

}








