package es.leanmind.marsroverkatabackend.infrastructure

import es.leanmind.marsroverkatabackend.domain.Obstacle

class ObstacleResponse(val position: PositionResponse) {
    companion object {
        fun from(obstacle: Obstacle): ObstacleResponse {
            return ObstacleResponse(
                    position = PositionResponse(obstacle.position.latitude, obstacle.position.longitude)
            )
        }
    }
}