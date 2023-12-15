package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.domain.*

data class MarsRoverResponse(val position: PositionResponse, val direction: String) {
    companion object {
        fun from(marsRover: MarsRover): MarsRoverResponse {
            return MarsRoverResponse(
                    position = PositionResponse(marsRover.position.latitude, marsRover.position.longitude),
                    direction = directionFrom(marsRover.direction)
            )
        }

        private fun directionFrom(direction: Direction): String {
            return when (direction) {
                North -> "N"
                East -> "E"
                South -> "S"
                West -> "W"
            }
        }
    }
}