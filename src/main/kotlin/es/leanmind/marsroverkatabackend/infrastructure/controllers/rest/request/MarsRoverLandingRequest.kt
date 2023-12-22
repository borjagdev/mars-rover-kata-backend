package es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request

import es.leanmind.marsroverkatabackend.domain.model.*

class MarsRoverLandingRequest(val position: PositionRequest, val direction: String) {
    fun position(): Position {
        return Position(position.latitude, position.longitude)
    }

    fun direction(): Direction {
        return when(direction) {
            "N" -> North
            "S" -> South
            "W" -> West
            "E" -> East
            else -> throw RuntimeException()
        }
    }
}

data class PositionRequest(val latitude: Int, val longitude: Int)