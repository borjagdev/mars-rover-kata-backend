package es.leanmind.marsroverkatabackend.domain

interface MarsRoverRepository {
    fun getBy(id: Int): MarsRover
}
