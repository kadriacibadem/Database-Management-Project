package database.project.dataAccess.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffWithVaccineCovidDisease {

    private int staffId;
    private int covidId;
    private int vaccineId;
    private int diseaseId;

}
