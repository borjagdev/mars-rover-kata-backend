package es.leanmind.marsroverkatabackend.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PositionShould {
    @ParameterizedTest
    @MethodSource("moveForwardInput")
    fun `move forward according to specified direction`(specifiedDirection: Direction, expectedPosition: Position) {
        assertEquals(expectedPosition, Position(0,0).moveForwardFrom(specifiedDirection))
    }

    companion object{
        @JvmStatic
        private fun moveForwardInput(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(North, Position(1, 0)),
                    Arguments.of(West, Position(0, -1)),
                    Arguments.of(South, Position(-1, 0)),
                    Arguments.of(East, Position(0, 1))
            )
        }
    }
}