package com.example.resgistro_tareas.ServiciosTest;

import com.example.resgistro_tareas.controller.TareaController;
import com.example.resgistro_tareas.entity.TareaEntity;
import com.example.resgistro_tareas.repository.TareaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Date;

@RunWith(SpringRunner.class)
@WebMvcTest(TareaController.class)
public class TareaServiciosTest {

    @Autowired
    private MockMvc mvc;

    private MockMvcRequestBuilders mockMvcRequestBuilders;

    @MockBean
    TareaRepository tareaRepository;

    @MockBean
    TareaController tareaController;

    TareaEntity dataTarea(){
        TareaEntity tarea = new TareaEntity();
        tarea.setIdentificador(1);
        tarea.setDescripcion("Tarea1");
        tarea.setFechaCreacion(new Date());
        tarea.setVigente(true);
        return tarea;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testListarTareas() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testAgregarTarea() throws Exception
    {
        mvc.perform( mockMvcRequestBuilders
                .put("/agregarTarea")
                .content(asJsonString(dataTarea()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void editarTarea() throws Exception
    {
        mvc.perform( mockMvcRequestBuilders
                .post("/editarTarea")
                .content(asJsonString(dataTarea()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testEliminarTarea() throws Exception
    {
        mvc.perform( mockMvcRequestBuilders
                .delete("/eliminarTarea/{id}", dataTarea().getIdentificador()) )
                .andExpect(status().isOk());
    }


}
