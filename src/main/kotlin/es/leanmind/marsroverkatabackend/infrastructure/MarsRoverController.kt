package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.application.CreatePlanetUseCase
import es.leanmind.marsroverkatabackend.application.GetCurrentPlanetUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MarsRoverController(
        private val getCurrentPlanetUseCase: GetCurrentPlanetUseCase,
        private val createPlanetUseCase: CreatePlanetUseCase
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
}