package co.edu.uniandes.dse.parcialprueba.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinicaEntity, Long> {
	Optional<HistoriaClinicaEntity> findById(Long id);

}
