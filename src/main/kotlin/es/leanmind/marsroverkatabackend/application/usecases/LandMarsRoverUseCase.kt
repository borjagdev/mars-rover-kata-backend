package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.Direction
import es.leanmind.marsroverkatabackend.domain.model.Position
import es.leanmind.marsroverkatabackend.domain.repositories.MarsRoverRepository
import java.util.*

@Injectable
class LandMarsRoverUseCase(
        private val marsRoverRepository: MarsRoverRepository
) {
    fun execute(position: Position, direction: Direction): UUID {
        return marsRoverRepository.createFrom(position, direction)
    }
}
