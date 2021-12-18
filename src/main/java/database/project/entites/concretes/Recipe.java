package database.project.entites.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Recipe")
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
