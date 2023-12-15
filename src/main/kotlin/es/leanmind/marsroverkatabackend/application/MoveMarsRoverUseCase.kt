package es.leanmind.marsroverkatabackend.application

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.*

@Injectable
class MoveMarsRoverUseCase(
        private val marsRoverRepository: MarsRoverRepository
) {
    fun execute(marsRoverId: Int, command: Command): MarsRover {
        return marsRoverRepository.getBy(marsRoverId).process(command)
    }
}
