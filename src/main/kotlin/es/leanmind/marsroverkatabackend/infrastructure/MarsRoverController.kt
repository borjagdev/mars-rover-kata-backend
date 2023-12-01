package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.application.CreatePlanetUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MarsRoverController(
        private val createPlanetUseCase: CreatePlanetUseCase
) {
    @PostMapping("/planet")
    fun createPlanet() : ResponseEntity<Any> {
        val planet = createPlanetUseCase.execute()
        return ResponseEntity.ok(planet)
    }
}