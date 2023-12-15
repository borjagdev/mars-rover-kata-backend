package es.leanmind.marsroverkatabackend.domain.repositories

import es.leanmind.marsroverkatabackend.domain.model.MarsRover

interface MarsRoverRepository {
    fun getBy(id: Int): MarsRover
}
