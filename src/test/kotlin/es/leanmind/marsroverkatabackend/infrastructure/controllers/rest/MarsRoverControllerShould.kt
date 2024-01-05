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
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put
import java.util.*

@WebMvcTest
class MarsRoverControllerShould {
    @Autowired
    lateinit var objectMapper: ObjectMapper
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `get the current state of a planet`() {
        mvc.get("/planet") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { json(expectedPlanetResponse) }
        }
    }

    @Test
    fun `create a planet`() {
        mvc.post("/planet") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isCreated() }
            content { json(expectedPlanetResponse) }
        }
    }

    @Test
    fun `make a Mars Rover land on the specified position and direction`() {
        val requestBody = objectMapper.writeValueAsString(
                MarsRoverLandingRequest(
                        PositionRequest(0, 0), "N"
                )
        )
        val expectedResponse = """
        {
            "marsRoverId": "52325ef1-9ef4-4349-9259-815bc4c9e409"
        }
        """

        mvc.post("/planet/mars-rover") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = requestBody
        }.andExpect {
            status { isOk() }
            content { json(expectedResponse) }
        }
    }

    @Test
    fun `move the specified Mars Rover according to received command`() {
        val requestBody = objectMapper.writeValueAsString(MarsRoverCommandRequest("RFF"))
        val expectedResponse = """
        {
            "position": {
                "latitude": 0,
                "longitude": 2
            },
            "direction": "E"
        }
        """

        mvc.put("/planet/mars-rover/${UUID.randomUUID()}") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = requestBody
        }.andExpect {
            status { isOk() }
            content { json(expectedResponse) }
        }
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
