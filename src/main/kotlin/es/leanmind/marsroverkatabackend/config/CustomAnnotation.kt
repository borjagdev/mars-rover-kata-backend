package es.leanmind.marsroverkatabackend.config

import java.lang.annotation.Inherited

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Inherited
annotation class Injectable
