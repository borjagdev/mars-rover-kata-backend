package es.leanmind.marsroverkatabackend.domain.model

sealed interface Direction {
    fun atLeft(): Direction
    fun atRight(): Direction
}

data object North : Direction {
    override fun atLeft(): Direction {
        return West
    }

    override fun atRight(): Direction {
        return East
    }
}

data object South : Direction {
    override fun atLeft(): Direction {
        return East
    }

    override fun atRight(): Direction {
        return West
    }
}

data object East : Direction {
    override fun atLeft(): Direction {
        return North
    }

    override fun atRight(): Direction {
        return South
    }
}

data object West : Direction {
    override fun atLeft(): Direction {
        return South
    }

    override fun atRight(): Direction {
        return North
    }
}