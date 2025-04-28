package com.tomin.chess.chess_backend.controller;

import com.tomin.chess.chess_backend.model.ChessMove;
import com.tomin.chess.chess_backend.repository.ChessMoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/moves")
@RequiredArgsConstructor
public class ChessMoveController {

    @Autowired
    private ChessMoveRepository repository;

    @PostMapping
    public Mono<ChessMove> saveMove(@RequestBody ChessMove move){
        move.setTimestamp(LocalDateTime.now());
        return repository.save(move);
    }

    @GetMapping
    public Flux<ChessMove> getAllMoves(){
        return repository.findAll();
    }


    @GetMapping("/{gameId}")
    public Flux<ChessMove> getMoves(@PathVariable String gameId){
        return repository.findByGameId(gameId);
    }

    @DeleteMapping("/{gameId}")
    public Mono<Void> deleteMove(@PathVariable String gameId){
        return repository.deleteById(gameId);
    }
}
