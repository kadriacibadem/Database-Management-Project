package database.project.entites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Covid")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","diseases","hobbies","vaccines","workingTime","staff"})
public class Covid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "covidId")
    private int covidId;


    @Column(name = "covidPositiveDate")
    private Date covidPositiveDate;


    @Column(name = "covidNegativeDate")
    private Date covidNegativeDate;

    @OneToMany(mappedBy = "covidSymptom")
    private List<CovidSymptom> covidSymptoms;

    @OneToMany(mappedBy = "covidDisease")
    private List<ChronicDisease> chronicDiseases;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staffCovid;

}
