package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.MarsRover
import es.leanmind.marsroverkatabackend.domain.MarsRoverRepository
import es.leanmind.marsroverkatabackend.domain.North
import es.leanmind.marsroverkatabackend.domain.Position

@Injectable
class InMemoryMarsRoverRepository : MarsRoverRepository {
    private val defaultMarsRover = MarsRover(Position(0, 0), North)

    override fun getBy(id: Int): MarsRover {
        return defaultMarsRover
    }
}