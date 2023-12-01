package es.leanmind.marsroverkatabackend.application

import es.leanmind.marsroverkatabackend.domain.Planet

interface PlanetRepository {
    fun create(): Planet
}
