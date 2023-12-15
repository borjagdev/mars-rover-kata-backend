package es.leanmind.marsroverkatabackend.application

import es.leanmind.marsroverkatabackend.domain.*
import es.leanmind.marsroverkatabackend.infrastructure.InMemoryPlanetRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GetCurrentPlanetUseCaseShould {
    @Test
    fun `get the current state of a planet`() {
        val planetRepository = InMemoryPlanetRepository()
        val getCurrentPlanetUseCase = GetCurrentPlanetUseCase(planetRepository)
        val expectedPlanet = Planet(
                Size(10, 10),
                listOf(MarsRover(Position(0, 0), North)),
                listOf(Obstacle(Position(4, 4)), Obstacle(Position(2, 2)))
        )

        val planet = getCurrentPlanetUseCase.execute()

        assertEquals(expectedPlanet, planet)
    }
}