package es.leanmind.marsroverkatabackend.infrastructure.repositories

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.model.North
import es.leanmind.marsroverkatabackend.domain.model.Position
import es.leanmind.marsroverkatabackend.domain.repositories.MarsRoverRepository

@Injectable
class InMemoryMarsRoverRepository : MarsRoverRepository {
    private val defaultMarsRover = MarsRover(Position(0, 0), North)

    override fun getBy(id: Int): MarsRover {
        return defaultMarsRover
    }
}