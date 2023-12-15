package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.domain.model.Command
import es.leanmind.marsroverkatabackend.domain.model.East
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.model.Position
import es.leanmind.marsroverkatabackend.infrastructure.repositories.InMemoryMarsRoverRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MoveMarsRoverUseCaseShould {
    @Test
    fun `order the specified Rover to move according to given command`() {
        val marsRoverRepository = InMemoryMarsRoverRepository()
        val moveMarsRoverUseCase = MoveMarsRoverUseCase(marsRoverRepository)
        val expectedMarsRover = MarsRover(Position(2, 1), East)

        val resultingMarsRover = moveMarsRoverUseCase.execute(1, Command.from("FFRF"))

        assertEquals(expectedMarsRover, resultingMarsRover)
    }
}