package co.edu.uniandes.dse.parcialprueba.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HistoriaClinicaService {
    

    
    @Autowired
    HistoriaClinicaRepository Historia;

    @Autowired
    PacienteRepository paciente;

    /**

     */
    @Transactional
    public HistoriaClinicaEntity createHistoria(Long pacienteId, Long historaiId) throws EntityNotFoundException, IllegalOperationException {
        Optional<HistoriaClinicaEntity> HistoriaEntity = Historia.findById(historaiId);

		if (HistoriaEntity.isEmpty())
			throw new EntityNotFoundException("ErrorMessage.PACIENTE_NOT_FOUND");
        Optional<PacienteEntity> Paciente = paciente.findById(pacienteId);
		Paciente.get().getHistoriasClinicas().add(HistoriaEntity.get());
		return HistoriaEntity.get();

    }

}
