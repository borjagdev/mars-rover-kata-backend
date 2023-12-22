package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.domain.model.Command
import es.leanmind.marsroverkatabackend.domain.model.East
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.model.Position
import es.leanmind.marsroverkatabackend.infrastructure.repositories.FakeMarsRoverRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class MoveMarsRoverUseCaseShould {
    @Test
    fun `order the specified Rover to move according to given command`() {
        val marsRoverRepository = FakeMarsRoverRepository()
        val moveMarsRoverUseCase = MoveMarsRoverUseCase(marsRoverRepository)
        val expectedMarsRover = MarsRover(Position(2, 1), East)

        val resultingMarsRover = moveMarsRoverUseCase.execute(UUID.randomUUID(), Command.from("FFRF"))

        assertEquals(expectedMarsRover, resultingMarsRover)
    }
}