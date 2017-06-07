package io.crowdcode.spring.restsoap.controller;

import io.crowdcode.spring.restsoap.repository.RahmenvertragRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static io.crowdcode.spring.restsoap.fixture.RahmenvertragFixture.buildDefaultRV;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by idueppe on 06.06.17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StammdatenServiceController.class)
public class StammdatenServiceControllerTest {

    @MockBean
    private RahmenvertragRepository repositoryMock;

    @Autowired
    private MockMvc mvc;


    @Test
    public void testGetStammdatenNotFound() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v1/api/stammdaten")
                .param("name", "JUNIT")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void testGetStammdaten_Found() throws Exception {
        when(repositoryMock.findByName("JUNIT-RV")).thenReturn(buildDefaultRV("JUNIT-RV"));
        mvc.perform(MockMvcRequestBuilders.get("/v1/api/stammdaten")
                .param("name", "JUNIT-RV")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{}"))
                .andDo(print());

    }

    @Test
    public void testPostBetriebsstaette() throws Exception {
        when(repositoryMock.findByName("JUNIT-RV")).thenReturn(buildDefaultRV("JUNIT-RV"));
        mvc.perform(MockMvcRequestBuilders.post("/v1/api/stammdaten/JUNIT-RV")
                .content("{  \"gueltigBis\": \"2017-06-06T18:25:51.178Z\", \"kennung\":\"ABCDED\",\"uniqueKey\":\"537e084ec0444f23\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }




}