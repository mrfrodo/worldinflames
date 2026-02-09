package com.frodo.worldinflames.infrastructure.in.web;

import com.frodo.worldinflames.application.WorldinflamesStartGameUseCase;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorldinflamesController {

    private final WorldinflamesStartGameUseCase startGame;

    public WorldinflamesController(WorldinflamesStartGameUseCase startGame) {
        this.startGame = startGame;
    }

    @GetMapping("/worldinflames")
    public String board(Model model) {
        model.addAttribute("tiles", startGame.start());
        return "board";
    }

    @PostConstruct
    public void init() {
        System.out.println("WorldinflamesController loaded");
    }
}
