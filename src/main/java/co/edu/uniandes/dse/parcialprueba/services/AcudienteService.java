package co.edu.uniandes.dse.parcialprueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;

import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;

public class AcudienteService {
    
    @Autowired
    PacienteRepository acudiente;

    @Autowired
    PacienteRepository paciente;

    /**

     */
    @Transactional
    public PacienteEntity createHistoria(Long pacienteId, Long acudienteiId) throws EntityNotFoundException, IllegalOperationException {
        Optional<PacienteEntity> Paciente = paciente.findById(pacienteId);
        Optional<PacienteEntity> Acudiente = paciente.findById(pacienteId);
        PacienteEntity acu=Acudiente.get().getAcudiente();
        if (acu != null){
            throw new IllegalOperationException("acudiente is not valid");
        }
        if (Paciente.get().getAcudiente() != null){
            throw new IllegalOperationException("paciente is not valid");
        }
        Paciente.get().getAcudiente().add(Acudiente.get());
        
        return Acudiente.get();

    }
}
