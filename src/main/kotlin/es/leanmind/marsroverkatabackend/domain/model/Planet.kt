package es.leanmind.marsroverkatabackend.domain.model

data class Planet(val size: Size, val marsRovers: List<MarsRover>, val obstacles: List<Obstacle>) {}
