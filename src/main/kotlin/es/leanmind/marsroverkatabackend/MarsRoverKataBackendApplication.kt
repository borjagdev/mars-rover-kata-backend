package es.leanmind.marsroverkatabackend

import es.leanmind.marsroverkatabackend.config.UseCase
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@SpringBootApplication
@ComponentScan(includeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [UseCase::class])])
class MarsRoverKataBackendApplication {
	fun main(args: Array<String>) {
		runApplication<MarsRoverKataBackendApplication>(*args)
	}
}
