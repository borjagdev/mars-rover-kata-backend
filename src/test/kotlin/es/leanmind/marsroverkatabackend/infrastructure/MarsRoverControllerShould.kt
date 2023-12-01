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

    private val expectedPlanetResponse = """
            {
                "size": {
                  "height": 10,
                  "width": 10
                },
                "marsRovers": [
                  {
                    "position": {
                      "latitude": 0,
                      "longitude": 0
                    },
                    "direction": "N"
                  }
                ],
                "obstacles": [
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

    @Test
    fun `get the current state of a planet`() {
        mvc.perform(MockMvcRequestBuilders.get("/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().json(expectedPlanetResponse))
    }

    @Test
    fun `create a planet`() {
        mvc.perform(MockMvcRequestBuilders.post("/planet")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().json(expectedPlanetResponse))
    }
}