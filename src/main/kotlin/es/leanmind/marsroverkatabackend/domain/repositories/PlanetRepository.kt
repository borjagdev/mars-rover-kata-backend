package es.leanmind.marsroverkatabackend.domain.repositories

import es.leanmind.marsroverkatabackend.domain.model.Planet

interface PlanetRepository {
    fun create(): Planet
    fun getCurrent(): Planet
}
