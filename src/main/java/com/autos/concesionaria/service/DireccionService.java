package com.autos.concesionaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autos.concesionaria.entity.Direccion;
import com.autos.concesionaria.repository.DireccionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DireccionService {

    // Repository injected by constructor
    @Autowired
    private final DireccionRepository direccionRepository;

    /**
     * Create a new direccion
     *
     * @param direccion
     * @return Direccion created
     */
    public Direccion crearDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    /**
     * Get all the direccions
     *
     * @return List<Direccion> List of direccions
     */
    public List<Direccion> buscarDireccions() {
        return direccionRepository.findAll();
    }

    /**
     * Get a direccion by id
     *
     * @param id
     * @return Direccion found or null
     */
    public Direccion buscarDireccionPorId(Long id) {
        return direccionRepository.findById(id).get();
    }

    /**
     * Update a direccion
     *
     * @param id       Direccion id
     * @param direccion Direccion data to update
     * @return Direccion updated
     */
    public Direccion actualizarDireccionPorId(Long id, Direccion direccion) {
        Direccion direccionActual = direccionRepository.findById(id).get();
        direccionActual.setCalle(direccion.getCalle());
        direccionActual.setNumero(direccion.getNumero());
        direccionActual.setPiso(direccion.getPiso());
        direccionActual.setDepartamento(direccion.getDepartamento());
        return direccionRepository.save(direccionActual);
    }

    /**
     * Delete a direccion
     *
     * @param id Direccion id
     */
    public void eliminarDireccionPorId(Long id) {
        direccionRepository.deleteById(id);
    }

}
