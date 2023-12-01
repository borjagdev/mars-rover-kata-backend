package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.application.CreatePlanetUseCase
import es.leanmind.marsroverkatabackend.application.GetCurrentPlanetUseCase
import es.leanmind.marsroverkatabackend.application.MoveMarsRoverUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MarsRoverController(
        private val getCurrentPlanetUseCase: GetCurrentPlanetUseCase,
        private val createPlanetUseCase: CreatePlanetUseCase,
        private val moveMarsRoverUseCase: MoveMarsRoverUseCase
) {
    @GetMapping("/planet")
    fun getCurrentPlanet() : ResponseEntity<Any> {
        val planet = getCurrentPlanetUseCase.execute()
        return ResponseEntity.ok(planet)
    }

    @PostMapping("/planet")
    fun createPlanet() : ResponseEntity<Any> {
        val planet = createPlanetUseCase.execute()
        return ResponseEntity.ok(planet)
    }

    @PostMapping("/mars-rover") // TODO: Should we use PUT since we are updating a Mars Rover state?
    fun moveMarsRover(@RequestBody marsRoverCommandDTO: MarsRoverCommandDTO) : ResponseEntity<Any> {
        val marsRoverAfterProcessedCommand = moveMarsRoverUseCase.execute()
        return ResponseEntity.ok(marsRoverAfterProcessedCommand)
    }
}