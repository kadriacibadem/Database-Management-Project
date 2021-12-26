package database.project.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CovidSymptom")
public class CovidSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'nin nasıl arttırıldığını gösterir
    @Column(name = "covidSymptomId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "covidId")
    private Covid covidSymptom;

    @Column(name = "symptom")
    private String symptom;


}
