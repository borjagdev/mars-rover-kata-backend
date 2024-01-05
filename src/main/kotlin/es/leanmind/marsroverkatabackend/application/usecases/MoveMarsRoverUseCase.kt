package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.Command
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.repositories.MarsRoverRepository
import java.util.*

@Injectable
class MoveMarsRoverUseCase(
        private val marsRoverRepository: MarsRoverRepository
) {
    fun execute(marsRoverId: UUID, command: Command): MarsRover {
        val updatedMarsRover = marsRoverRepository.getBy(marsRoverId).process(command)
        marsRoverRepository.save(marsRoverId, updatedMarsRover)
        return updatedMarsRover
    }
}
