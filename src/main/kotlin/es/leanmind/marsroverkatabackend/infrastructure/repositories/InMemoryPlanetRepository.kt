package es.leanmind.marsroverkatabackend.infrastructure.repositories

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.*
import es.leanmind.marsroverkatabackend.domain.repositories.PlanetRepository

@Injectable
class InMemoryPlanetRepository : PlanetRepository {
    private var defaultPlanet = Planet(
            Size(10, 10),
            listOf(MarsRover(Position(0, 0), North)),
            listOf(Obstacle(Position(4, 4)), Obstacle(Position(2, 2)))
    )

    override fun create(): Planet {
        return defaultPlanet
    }

    override fun getCurrent(): Planet {
        return defaultPlanet
    }
}