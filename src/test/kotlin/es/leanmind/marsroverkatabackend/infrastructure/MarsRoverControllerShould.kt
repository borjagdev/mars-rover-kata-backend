package es.leanmind.marsroverkatabackend.infrastructure

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class MarsRoverControllerShould {
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `create a planet`() {
        val expectedResponse = """
            {
                "size": {
                  "width": 10,
                  "length": 10
                },
                "marsRover": [
                  {
                    "position": {
                      "latitude": 0,
                      "longitude": 0
                    },
                    "direction": "N"
                  }
                ],
                "obstacle": [
                  {
                    "position": {
                      "latitude": 4,
                      "longitude": 4
                    }
                  },
                  {
                    "position": {
                      "latitude": 2,
                      "longitude": 2
                    }
                  }
                ]
            }
        """

        mvc.perform(MockMvcRequestBuilders.post("/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().json(expectedResponse))
    }
}