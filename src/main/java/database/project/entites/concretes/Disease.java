package database.project.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Disease")
public class Disease {

    @Id
    @Column(name = "diseaseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "diseaseName")
    private String diseaseName;

    @Column(name = "diseaseDate")
    private Date diseaseDate;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;

    @OneToMany(mappedBy = "disease")
    private List<Recipe> recipes;

}
