package es.leanmind.marsroverkatabackend.domain

data class Planet(val size: Size, val marsRovers: List<MarsRover>, val obstacles: List<Obstacle>) {}
