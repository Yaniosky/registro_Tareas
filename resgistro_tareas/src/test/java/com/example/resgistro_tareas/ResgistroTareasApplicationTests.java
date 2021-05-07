package com.example.resgistro_tareas;

import com.example.resgistro_tareas.controller.TareaController;
import com.example.resgistro_tareas.entity.AgregarTareaRequest;
import com.example.resgistro_tareas.entity.TareaEntity;
import com.example.resgistro_tareas.repository.TareaRepository;
import javassist.expr.Cast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.test.StepVerifier;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ResgistroTareasApplicationTests {

    @Test
    void contextLoads() {
    }
}
