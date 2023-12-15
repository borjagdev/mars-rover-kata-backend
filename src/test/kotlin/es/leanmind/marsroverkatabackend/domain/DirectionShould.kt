package es.leanmind.marsroverkatabackend.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DirectionShould {
    @ParameterizedTest
    @MethodSource("atLeftTestInput")
    fun `recognize the cardinal direction at left`(candidate: Direction, expected: Direction) {
        assertEquals(expected, candidate.atLeft())
    }

    @ParameterizedTest
    @MethodSource("atRightTestInput")
    fun `recognize the cardinal direction at right`(candidate: Direction, expected: Direction) {
        assertEquals(expected, candidate.atRight())
    }

    companion object{
        @JvmStatic
        private fun atLeftTestInput(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(North, West),
                    Arguments.of(West, South),
                    Arguments.of(South, East),
                    Arguments.of(East, North)
            )
        }

        @JvmStatic
        private fun atRightTestInput(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(North, East),
                    Arguments.of(East, South),
                    Arguments.of(South, West),
                    Arguments.of(West, North)
            )
        }
    }
}
