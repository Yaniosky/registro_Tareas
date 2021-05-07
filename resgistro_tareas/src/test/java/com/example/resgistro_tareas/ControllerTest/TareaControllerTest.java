package com.example.resgistro_tareas.ControllerTest;

import com.example.resgistro_tareas.controller.TareaController;
import com.example.resgistro_tareas.entity.AgregarTareaRequest;
import com.example.resgistro_tareas.entity.TareaEntity;
import com.example.resgistro_tareas.repository.TareaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TareaControllerTest {

    @MockBean
    TareaRepository tareaRepository;

    @MockBean
    TareaController tareaController;

    List<TareaEntity> listadoTarea(){
        List<TareaEntity> list = new ArrayList<>();
        list.add(dataTarea1());
        list.add(dataTarea2());
        return list;
    }

    TareaEntity dataTarea1(){
        TareaEntity tarea = new TareaEntity();
        tarea.setIdentificador(1);
        tarea.setDescripcion("Tarea1");
        tarea.setFechaCreacion(new Date());
        tarea.setVigente(true);
        return tarea;
    }

    TareaEntity dataTarea2(){
        TareaEntity tarea = new TareaEntity();
        tarea.setIdentificador(1);
        tarea.setDescripcion("Tarea2");
        tarea.setFechaCreacion(new Date());
        tarea.setVigente(true);
        return tarea;
    }

    AgregarTareaRequest dataTareaRequest(){
        AgregarTareaRequest tarea = new AgregarTareaRequest();
        tarea.setIdentificador(1);
        tarea.setDescripcion("Tarea1");
        tarea.setVigente(true);
        return tarea;
    }

    @Test
    public void testListarTareas() {
        Mockito.when(tareaRepository.findAll()).thenReturn(listadoTarea());
        List<TareaEntity> tareas = tareaController.listarTareas();
        assertEquals(0,tareas.size());
    }

    @Test
    void testAgregarTarea() throws IOException {
        Mockito.when(tareaRepository.save(dataTarea1()))
                .thenReturn(dataTarea1());
        tareaController.agregarTarea(dataTareaRequest());
        Assertions.assertEquals("Tarea1",dataTarea1().getDescripcion());
    }

    @Test
    void testEliminarTarea() {
        boolean del = tareaRepository.existsById(2L);
        assertEquals(del, tareaController.eliminarTarea(2L));
    }
}
