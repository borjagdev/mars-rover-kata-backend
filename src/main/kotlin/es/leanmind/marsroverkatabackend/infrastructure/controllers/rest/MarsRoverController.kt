package es.leanmind.marsroverkatabackend.infrastructure.controllers.rest

import es.leanmind.marsroverkatabackend.application.usecases.CreatePlanetUseCase
import es.leanmind.marsroverkatabackend.application.usecases.GetCurrentPlanetUseCase
import es.leanmind.marsroverkatabackend.application.usecases.LandMarsRoverUseCase
import es.leanmind.marsroverkatabackend.application.usecases.MoveMarsRoverUseCase
import es.leanmind.marsroverkatabackend.domain.model.Command
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request.MarsRoverCommandRequest
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request.MarsRoverLandingRequest
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.responses.MarsRoverResponse
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.responses.PlanetResponse
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class MarsRoverController(
        private val getCurrentPlanetUseCase: GetCurrentPlanetUseCase,
        private val createPlanetUseCase: CreatePlanetUseCase,
        private val landMarsRoverUseCase: LandMarsRoverUseCase,
        private val moveMarsRoverUseCase: MoveMarsRoverUseCase
) {
    @GetMapping("/planet")
    fun getCurrentPlanet(): ResponseEntity<PlanetResponse> {
        val planet = getCurrentPlanetUseCase.execute()
        return ResponseEntity.ok(PlanetResponse.from(planet))
    }

    @PostMapping("/planet")
    fun createPlanet(): ResponseEntity<PlanetResponse> {
        val planet = createPlanetUseCase.execute()
        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .body(PlanetResponse.from(planet))
    }

    @PostMapping("/planet/mars-rover")
    fun landMarsRover(@RequestBody marsRoverLandingRequest: MarsRoverLandingRequest): ResponseEntity<Any> {
        val marsRoverId = landMarsRoverUseCase.execute(marsRoverLandingRequest.position(), marsRoverLandingRequest.direction())
        return ResponseEntity.ok("{\"marsRoverId\": \"$marsRoverId\"}") // TODO: Would make more sense treating MarsRover as an entity and adding the id to MarsRoverResponse (?)
    }

    @PutMapping("/planet/mars-rover/{marsRoverId}")
    fun moveMarsRover(
            @PathVariable marsRoverId: UUID,
            @RequestBody marsRoverCommandRequest: MarsRoverCommandRequest
    ): ResponseEntity<Any> {
        val marsRoverAfterProcessedCommand = moveMarsRoverUseCase.execute(marsRoverCommandRequest.marsRoverId, Command.from(marsRoverCommandRequest.command))
        return ResponseEntity.ok(MarsRoverResponse.from(marsRoverAfterProcessedCommand))
    }
}