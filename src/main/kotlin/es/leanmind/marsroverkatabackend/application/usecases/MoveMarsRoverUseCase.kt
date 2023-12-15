package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.Command
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.repositories.MarsRoverRepository

@Injectable
class MoveMarsRoverUseCase(
        private val marsRoverRepository: MarsRoverRepository
) {
    fun execute(marsRoverId: Int, command: Command): MarsRover {
        return marsRoverRepository.getBy(marsRoverId).process(command)
    }
}
