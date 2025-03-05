package co.edu.uniandes.dse.parcialprueba.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {


    
        @Autowired
        PacienteRepository pacienterepo;

        /**
         * Guardar un nuevo libro
         *
         * @param bookEntity La entidad de tipo libro del nuevo libro a persistir.
         * @return La entidad luego de persistirla
         * @throws IllegalOperationException Si el ISBN es inválido o ya existe en la
         *                                   persistencia o si la editorial es inválida
         */
        @Transactional
        public PacienteEntity createPaciente(PacienteEntity paciente) throws EntityNotFoundException, IllegalOperationException {
            log.info("Inicia proceso de creación del libro");
            
            if (paciente.getId() == null)
                throw new IllegalOperationException("id is not valid");
            if (paciente.getTelefono()<11)
                throw new IllegalOperationException("telefono no valido");
    
            log.info("Termina proceso de creación de paciente");
            return pacienterepo.save(paciente);
        }
    
}
