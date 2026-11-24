package com.example.grupoJovenU4P3.service;

import com.example.grupoJovenU4P3.dto.ActividadForm;
import com.example.grupoJovenU4P3.model.Actividad;
import com.example.grupoJovenU4P3.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Aquí se gestionan las operaciones de las actividades.
@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    // Se recibe el repositorio por constructor para poder utilizarlo en el servicio.
    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> listarActividades() {
        return actividadRepository.findAll();
    }

    public Optional<Actividad> buscarPorId(Long id) {
        return actividadRepository.findById(id);
    }

    public Actividad guardarActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public Actividad guardarActividad(ActividadForm formulario) {
        // Se pasan los datos del formulario a una nueva entidad antes de guardarla.
        Actividad actividad = new Actividad();

        actividad.setNombre(formulario.getNombre());
        actividad.setDescripcion(formulario.getDescripcion());
        actividad.setTipo(formulario.getTipo());
        actividad.setFecha(formulario.getFecha());
        actividad.setHora(formulario.getHora());
        actividad.setDuracionMinutos(formulario.getDuracionMinutos());
        actividad.setAsistencia(formulario.getAsistencia());
        actividad.setCoste(formulario.getCoste());
        actividad.setRequiereInscripcion(formulario.getRequiereInscripcion());
        actividad.setLugar(formulario.getLugar());

        return actividadRepository.save(actividad);
    }

    public void eliminarActividad(Long id) {
        actividadRepository.deleteById(id);
    }
}