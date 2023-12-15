package es.leanmind.marsroverkatabackend.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MarsRoverShould {
    @Test
    fun `rotate to the left`() {
        val marsRover = MarsRover(Position(0, 0), North).process(Command.from("L"))

        assertEquals(MarsRover(Position(0, 0), West), marsRover)
    }

    @Test
    fun `rotate to the right`() {
        val marsRover = MarsRover(Position(0, 0), North).process(Command.from("R"))

        assertEquals(MarsRover(Position(0, 0), East), marsRover)
    }

    @Test
    fun `move forward`() {
        val marsRover = MarsRover(Position(0, 0), North).process(Command.from("F"))

        assertEquals(MarsRover(Position(1, 0), North), marsRover)
    }

    @Test
    fun `process multiple commands`() {
        val marsRover = MarsRover(Position(0, 0), North).process(Command.from("FFRFF"))

        assertEquals(MarsRover(Position(2, 2), East), marsRover)
    }
}