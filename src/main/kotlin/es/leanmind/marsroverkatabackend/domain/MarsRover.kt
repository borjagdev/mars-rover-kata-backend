package es.leanmind.marsroverkatabackend.domain

data class MarsRover(val position: Position, val direction: Direction) {
    fun process(command: Command): MarsRover {
        var resultingPosition = position
        var resultingDirection = direction
        command.instructions.forEach {
            when (it) {
                'L' -> resultingDirection = resultingDirection.atLeft()
                'R' -> resultingDirection = resultingDirection.atRight()
                'F' -> resultingPosition = resultingPosition.moveForwardFrom(resultingDirection)
                else -> throw RuntimeException()
            }
        }
        return MarsRover(resultingPosition, resultingDirection)
    }
}
