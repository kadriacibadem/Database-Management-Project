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
@Table(name = "Recipe")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","diseases","hobbies","vaccines","workingTime","covid"})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'nin nasıl arttırıldığını gösterir
    @Column(name = "recipeId")
    private int recipeId;

    @ManyToOne
    @JoinColumn(name = "diseaseId")
    private Disease disease;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "dosage")
    private int dosage;
}
