package database.project.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Covid")
public class Covid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "covidId")
    private int covidId;


    @Column(name = "covidPositiveDate")
    private Date covidPositiveDate;


    @Column(name = "covidNegativeDate")
    private Date covidNegativeDate;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staffCovid;

}
