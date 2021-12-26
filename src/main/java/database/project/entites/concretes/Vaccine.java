package database.project.entites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Vaccine")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","diseases","hobbies","vaccines","workingTime","covid"})
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
