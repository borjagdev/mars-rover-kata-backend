package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.domain.model.*
import es.leanmind.marsroverkatabackend.infrastructure.repositories.FakePlanetRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetCurrentPlanetUseCaseShould {
    @Test
    fun `get the current state of a planet`() {
        val planetRepository = FakePlanetRepository()
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