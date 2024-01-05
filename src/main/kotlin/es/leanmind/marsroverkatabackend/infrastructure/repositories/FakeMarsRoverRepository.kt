package es.leanmind.marsroverkatabackend.infrastructure.repositories

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.Direction
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.model.North
import es.leanmind.marsroverkatabackend.domain.model.Position
import es.leanmind.marsroverkatabackend.domain.repositories.MarsRoverRepository
import java.util.*

@Injectable
class FakeMarsRoverRepository : MarsRoverRepository {
    private var defaultMarsRoverId: UUID = UUID.fromString("52325ef1-9ef4-4349-9259-815bc4c9e409")
    private var defaultMarsRover = MarsRover(Position(0, 0), North)

    override fun getBy(id: UUID): MarsRover {
        return defaultMarsRover
    }

    override fun createFrom(position: Position, direction: Direction): UUID {
        return defaultMarsRoverId
    }

    override fun save(marsRoverId: UUID, updatedMarsRover: MarsRover) {
        defaultMarsRover = updatedMarsRover
    }

    fun defaultId(): UUID {
        return defaultMarsRoverId
    }
}