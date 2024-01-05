package es.leanmind.marsroverkatabackend.infrastructure.repositories

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import java.util.*

@SpringBootTest
@Sql("classpath:db/init.sql")
class MysqlMarsRoverRepositoryShould {
    @Autowired
    lateinit var mysqlMarsRoverRepository: MysqlMarsRoverRepository

    @Test
    @Sql("classpath:db/insert-mars-rover.sql")
    fun `retrieve a mars rover by id`() {
        mysqlMarsRoverRepository.getBy(UUID.fromString("ab15cb61-6c0d-4972-8750-a3c2343ab9f4"))
    }
}