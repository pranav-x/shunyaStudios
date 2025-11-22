package com.shunya.studios.middleware.controller;

import com.shunya.studios.middleware.models.VoterRoll;
import com.shunya.studios.middleware.repo.VoterRollRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voters")
public class VoterRollController {

    private final VoterRollRepository repo;

    public VoterRollController(VoterRollRepository repo) {
        this.repo = repo;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public List<VoterRoll> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{serialNo}")
    public VoterRoll getById(@PathVariable Integer serialNo) {
        return repo.findById(serialNo).orElse(null);
    }

     @GetMapping("/ping")
    public String ping() { return "pong"; }
}
