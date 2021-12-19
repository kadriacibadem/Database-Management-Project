package database.project.entites.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccineId")
    private int id;


    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staffVaccines;

    @Column(name = "vaccineName")
    private String vaccineName;

}
