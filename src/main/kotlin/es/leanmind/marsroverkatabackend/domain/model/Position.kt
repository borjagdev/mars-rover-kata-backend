package es.leanmind.marsroverkatabackend.domain.model

data class Position(val latitude: Int, val longitude: Int) {
    fun moveForwardFrom(direction: Direction): Position {
        return when (direction) {
            North -> Position(latitude + 1, longitude)
            South -> Position(latitude - 1, longitude)
            East -> Position(latitude, longitude + 1)
            West -> Position(latitude, longitude - 1)
        }
    }
}
