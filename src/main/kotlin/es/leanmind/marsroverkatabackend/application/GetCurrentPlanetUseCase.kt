package es.leanmind.marsroverkatabackend.application

import es.leanmind.marsroverkatabackend.config.Injectable
import es.leanmind.marsroverkatabackend.domain.Planet

@Injectable
class GetCurrentPlanetUseCase(
        private val planetRepository : PlanetRepository
) {
    fun execute(): Planet {
        return planetRepository.getCurrent()
    }
}