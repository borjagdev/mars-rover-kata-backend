package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.domain.Planet

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