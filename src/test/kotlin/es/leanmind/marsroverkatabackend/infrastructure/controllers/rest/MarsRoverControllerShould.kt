package es.leanmind.marsroverkatabackend.infrastructure.controllers.rest

import com.fasterxml.jackson.databind.ObjectMapper
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request.MarsRoverCommandRequest
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request.MarsRoverLandingRequest
import es.leanmind.marsroverkatabackend.infrastructure.controllers.rest.request.PositionRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@WebMvcTest
class MarsRoverControllerShould {
    @Autowired
    lateinit var mvc: MockMvc

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
        ).andExpect(MockMvcResultMatchers.status().isCreated)
        .andExpect(MockMvcResultMatchers.content().json(expectedPlanetResponse))
    }

    @Test
    fun `make a Mars Rover land on the specified position and direction`() {
        val requestBody = ObjectMapper().writeValueAsString(
                MarsRoverLandingRequest(
                        PositionRequest(0, 0), "N"
                )
        )
        val expectedResponse = """
        {
            "marsRoverId": "52325ef1-9ef4-4349-9259-815bc4c9e409"
        }
        """

        mvc.perform(MockMvcRequestBuilders.post("/planet/mars-rover")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestBody)
        ).andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().json(expectedResponse))
    }

    @Test
    fun `move the specified Mars Rover according to received command`() {
        val requestBody = ObjectMapper().writeValueAsString(MarsRoverCommandRequest(1, "RFF"))
        val expectedResponse = """
        {
            "position": {
                "latitude": 0,
                "longitude": 2
            },
            "direction": "E"
        }
        """

        mvc.perform(MockMvcRequestBuilders.put("/planet/mars-rover/{marsRoverId}", "${UUID.randomUUID()}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestBody)
        ).andExpect(MockMvcResultMatchers.status().isOk)
        .andExpect(MockMvcResultMatchers.content().json(expectedResponse))
    }

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
}
