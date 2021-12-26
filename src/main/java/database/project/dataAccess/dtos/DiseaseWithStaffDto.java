package database.project.dataAccess.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseWithStaffDto {
    private int diseaseId;
    private int staffId;
}
