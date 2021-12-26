package database.project.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChronicDisease")
public class ChronicDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'nin nasıl arttırıldığını gösterir
    @Column(name = "chronicDiseaseId")
    private int chronicDiseaseId;

    @Column(name = "chronicDisease")
    private String chronicDiseases;

    @ManyToOne
    @JoinColumn(name = "covidId")
    private Covid covidDisease;


}
