package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.application.PlanetRepository
import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.*

@Injectable
class InMemoryPlanetRepository : PlanetRepository {
    private val defaultPlanet = Planet(
            Size(10, 10),
            listOf(MarsRover(Position(0, 0), "N")),
            listOf(Obstacle(Position(4, 4)), Obstacle(Position(2, 2)))
    )

    override fun create(): Planet {
        return defaultPlanet
    }

    override fun getCurrent(): Planet {
        return defaultPlanet
    }
}