package es.leanmind.marsroverkatabackend.domain.repositories

import es.leanmind.marsroverkatabackend.domain.model.Direction
import es.leanmind.marsroverkatabackend.domain.model.MarsRover
import es.leanmind.marsroverkatabackend.domain.model.Position
import java.util.*

interface MarsRoverRepository {
    fun getBy(id: Int): MarsRover
    fun createFrom(position: Position, direction: Direction): UUID
}
