package es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request

data class MarsRoverCommandRequest(val marsRoverId: Int, val command: String) {}
