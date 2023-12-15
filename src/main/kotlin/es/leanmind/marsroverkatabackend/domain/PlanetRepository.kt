package es.leanmind.marsroverkatabackend.domain

interface PlanetRepository {
    fun create(): Planet
    fun getCurrent(): Planet
}
