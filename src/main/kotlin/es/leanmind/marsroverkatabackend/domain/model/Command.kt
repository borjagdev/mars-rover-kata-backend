package es.leanmind.marsroverkatabackend.domain.model

data class Command private constructor(val instructions: String) {
    companion object {
        fun from(command: String): Command {
            return Command(command)
        }
    }
}