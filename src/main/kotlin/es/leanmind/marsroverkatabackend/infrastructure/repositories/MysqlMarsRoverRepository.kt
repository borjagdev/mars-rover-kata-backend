package es.leanmind.marsroverkatabackend.infrastructure.repositories

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.Direction
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.model.Position
import es.leanmind.marsroverkatabackend.domain.repositories.MarsRoverRepository
import org.springframework.context.annotation.Primary
import java.util.*

@Injectable
@Primary
class MysqlMarsRoverRepository : MarsRoverRepository {
    override fun getBy(id: UUID): MarsRover {
        TODO("Not yet implemented")
    }

    override fun createFrom(position: Position, direction: Direction): UUID {
        TODO("Not yet implemented")
    }

    override fun save(marsRoverId: UUID, updatedMarsRover: MarsRover) {
        TODO("Not yet implemented")
    }
}