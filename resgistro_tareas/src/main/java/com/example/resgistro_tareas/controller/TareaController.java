package com.example.resgistro_tareas.controller;

import com.example.resgistro_tareas.entity.AgregarTareaRequest;
import com.example.resgistro_tareas.entity.TareaEntity;
import com.example.resgistro_tareas.repository.TareaRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class TareaController {

    private TareaRepository tareaRepository;

    @Autowired
    public TareaController(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @GetMapping("/")
    @ApiOperation(value = "--Listar Tareas--", notes = "Servicio para listar las tareas")
    public List<TareaEntity> listarTareas(){
        return tareaRepository.findAll();
    }

    @PutMapping("/agregarTarea")
    @ApiOperation(value = "--Agregar Tarea--", notes = "Servicio para adicionar una tarea")
    public void agregarTarea(@RequestBody AgregarTareaRequest agregarTareaRequest ) throws IOException {
        if (agregarTareaRequest.getIdentificador()>0){
            TareaEntity tareaEntity = new TareaEntity();
            if (agregarTareaRequest.getIdentificador() > 0 && agregarTareaRequest.getDescripcion()!=null && agregarTareaRequest.getDescripcion()!="") {
                tareaEntity.setIdentificador(agregarTareaRequest.getIdentificador());
                tareaEntity.setDescripcion(agregarTareaRequest.getDescripcion());
                tareaEntity.setFechaCreacion(new Date());
                tareaEntity.setVigente(agregarTareaRequest.isVigente());
                tareaRepository.save(tareaEntity);
            }else {
                throw new IOException("La descripcion de la tarea es requerida");
            }
        }else {
            throw new IOException("Identificador no valido");
        }
    }

    @PostMapping("/editarTarea")
    @ApiOperation(value = "--Editar Tarea--", notes = "Servicio para editar una tarea")
    public void editarTarea(@RequestBody AgregarTareaRequest agregarTareaRequest) throws IOException {
        if (agregarTareaRequest.getIdentificador()>0){
            Long id = agregarTareaRequest.getIdentificador();
            if (!tareaRepository.findById(agregarTareaRequest.getIdentificador()).isEmpty()) {
                String _descripcion = tareaRepository.findById(id).get().getDescripcion();
                Date _fechaCreacion = tareaRepository.findById(id).get().getFechaCreacion();

                TareaEntity tareaEntity = new TareaEntity();
                tareaEntity.setIdentificador(id);
                tareaEntity.setDescripcion(agregarTareaRequest.getDescripcion() != null && agregarTareaRequest.getDescripcion() != ""?agregarTareaRequest.getDescripcion():_descripcion);
                tareaEntity.setFechaCreacion(_fechaCreacion);
                tareaEntity.setVigente(agregarTareaRequest.isVigente());

                tareaRepository.deleteById(id);
                tareaRepository.save(tareaEntity);
            }else {
            throw new IOException("No se encontro la tarea");
         }
        }else {
            throw new IOException("Identificador no valido");
        }
    }

    @DeleteMapping("/eliminarTarea/{id}")
    @ApiOperation(value = "--Eliminar Tarea--", notes = "Servicio para eliminar una tarea")
    public boolean eliminarTarea(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
