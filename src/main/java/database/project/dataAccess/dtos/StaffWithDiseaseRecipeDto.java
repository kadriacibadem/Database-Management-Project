package database.project.dataAccess.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffWithDiseaseRecipeDto {

    private int staffId;
    private int diseaseId;
    private int recipeId;


}
