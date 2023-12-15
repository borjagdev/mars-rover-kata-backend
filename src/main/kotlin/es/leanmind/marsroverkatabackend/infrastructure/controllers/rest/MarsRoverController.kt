package es.leanmind.marsroverkatabackend.infrastructure.controllers.rest

import es.leanmind.marsroverkatabackend.application.usecases.CreatePlanetUseCase
import es.leanmind.marsroverkatabackend.application.usecases.GetCurrentPlanetUseCase
import es.leanmind.marsroverkatabackend.application.usecases.MoveMarsRoverUseCase
import es.leanmind.marsroverkatabackend.domain.model.Command
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request.MarsRoverCommandRequest
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.responses.GetPlanetResponse
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
        return ResponseEntity.ok(GetPlanetResponse.from(planet))
    }

    @PostMapping("/planet")
    fun createPlanet() : ResponseEntity<Any> {
        val planet = createPlanetUseCase.execute()
        return ResponseEntity.ok(planet)
    }

    @PostMapping("/mars-rover") // TODO: Should we use PUT since we are updating a Mars Rover state?
    fun moveMarsRover(@RequestBody marsRoverCommandRequest: MarsRoverCommandRequest) : ResponseEntity<Any> {
        val marsRoverAfterProcessedCommand = moveMarsRoverUseCase.execute(marsRoverCommandRequest.marsRoverId, Command.from(marsRoverCommandRequest.command))
        return ResponseEntity.ok(marsRoverAfterProcessedCommand)
    }
}