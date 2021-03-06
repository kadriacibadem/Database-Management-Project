package database.project.entites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hobbies")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","hobbies","vaccines","workingTime","covid","recipes"})
public class Hobbies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobbiesId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staffHobbies;

    @Column(name = "hobby")
    private String hobby;

}
