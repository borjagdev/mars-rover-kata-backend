package es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.responses

import es.leanmind.marsroverkatabackend.domain.model.*

class PlanetResponse(
        val size: SizeResponse,
        val marsRovers: List<MarsRoverResponse>,
        val obstacles: List<ObstacleResponse>
) {
    companion object {
        fun from(planet: Planet): PlanetResponse {
            return PlanetResponse(
                    size = SizeResponse(planet.size.height, planet.size.width),
                    marsRovers = planet.marsRovers.map { MarsRoverResponse.from(it) },
                    obstacles = planet.obstacles.map { ObstacleResponse.from(it) }
            )
        }
    }
}

data class SizeResponse(val height: Int, val width: Int)

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

class ObstacleResponse(val position: PositionResponse) {
    companion object {
        fun from(obstacle: Obstacle): ObstacleResponse {
            return ObstacleResponse(
                    position = PositionResponse(obstacle.position.latitude, obstacle.position.longitude)
            )
        }
    }
}

data class PositionResponse(val latitude: Int, val longitude: Int) {}