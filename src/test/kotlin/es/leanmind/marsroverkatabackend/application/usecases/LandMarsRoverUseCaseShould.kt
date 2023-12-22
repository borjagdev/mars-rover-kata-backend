package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.domain.model.North
import es.leanmind.marsroverkatabackend.domain.model.Position
import es.leanmind.marsroverkatabackend.infrastructure.repositories.FakeMarsRoverRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LandMarsRoverUseCaseShould {
    @Test
    fun `make a Mars Rover land on the specified position and direction`() {
        val marsRoverRepository = FakeMarsRoverRepository()
        val landMarsRoverUseCase = LandMarsRoverUseCase(marsRoverRepository)

        val resultingMarsRoverId = landMarsRoverUseCase.execute(Position(0, 0), North)

        assertEquals(FakeMarsRoverRepository().defaultId(), resultingMarsRoverId)
    }
}