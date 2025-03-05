package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class PacienteEntity extends BaseEntity{
    private String name;
    private String correo;
    private int telefono;
    private Long id;

    @PodamExclude
	@OneToMany(mappedBy = "paciente")
	private List<HistoriaClinicaEntity> HistoriasClinicas = new ArrayList<>();

    @PodamExclude
    @OneToOne
    private PacienteEntity acudiente;


}
