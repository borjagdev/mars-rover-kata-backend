package es.leanmind.marsroverkatabackend.application.usecases

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.model.Planet
import es.leanmind.marsroverkatabackend.domain.repositories.PlanetRepository

@Injectable
class CreatePlanetUseCase(
        private val planetRepository : PlanetRepository
) {
    fun execute(): Planet {
        return planetRepository.create()
    }
}
