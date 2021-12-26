package database.project.dataAccess.abstracts;


import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.dataAccess.dtos.DiseaseWithStaffDto;
import database.project.dataAccess.dtos.StaffWithDiseaseCovidRecipeDto;
import database.project.dataAccess.dtos.StaffWithVaccineCovidDisease;
import database.project.entites.concretes.Covid;
import database.project.entites.concretes.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface StaffDao extends JpaRepository<Staff,Integer> {

    // Soru 1 {

    @Query("Select new database.project.dataAccess.dtos.CovidWithStaffDto"
            + "(c.covidId,c.staffCovid.id)"
            + "from Staff s inner join s.covid c where s.educationStatus='Lisans'")
    List<CovidWithStaffDto> getCovidWithStaffDetailsLisans();


    @Query("Select new database.project.dataAccess.dtos.CovidWithStaffDto"
            + "(c.covidId,c.staffCovid.id)"
            + "from Staff s inner join s.covid c where s.educationStatus='Yüksek Lisans'")
    List<CovidWithStaffDto> getCovidWithStaffDetailsYuksekLisans();

    @Query("Select new database.project.dataAccess.dtos.CovidWithStaffDto"
            + "(c.covidId,c.staffCovid.id)"
            + "from Staff s inner join s.covid c where s.educationStatus='Doktora'")
    List<CovidWithStaffDto> getCovidWithStaffDetailsDoktora();
    // }

    // Soru 9 {

    @Query("SELECT new database.project.dataAccess.dtos.StaffWithDiseaseCovidRecipeDto"
            + "(s.id,d.id,c.covidId,r.recipeId)"
            + "from Staff s inner join s.diseases d inner join s.covid c inner join d.recipes r where s.id = d.staff.id and d.id = r.disease.id and s.id = c.staffCovid.id and r.medicine=:medicine"


    )
    List<StaffWithDiseaseCovidRecipeDto> getStaffWithDiseaseCovidRecipeDetails(String medicine);
    // }


    // Soru 10 {

    @Query("select new database.project.dataAccess.dtos.StaffWithVaccineCovidDisease"
            +"(s.id,c.covidId,v.id,d.id)"
            + "from Staff s inner join s.covid c inner join s.vaccines v inner join s.diseases d where s.id = d.staff.id and v.staffVaccines.id = s.id and s.id = c.staffCovid.id and v.vaccineName = 'Biontech' and d.diseaseName=:disease"

    )
    List<StaffWithVaccineCovidDisease> getStaffWithVaccineCovidDisease(String disease);

    // Soru 8 bakılacak
    @Query(nativeQuery = true,value = "Select s.*,(case when d.staffId IN(Select d.staffId From covid c, disease d Where c.staffId = d.staffId) Then 1.0 Else 0.0 End) AS 'Covid Durumu' From Recipe r, Disease d, Staff s Where r.diseaseId = d.diseaseId AND medicine IN(Select TOP 3 medicine From Recipe group by medicine order by Count(*) desc) Order By medicine")
    List<Staff> getMost3MedicineCovidStatus();


    @Query(nativeQuery = true,value = "select count(*) * 100.0 / (select count(*) from Covid) AS 'Covid Olup Ası Olanlar' from Vaccine v, Covid c Where v.staffId = c.staffId")
    Float covidRateByVaccineStatus();

    @Query(nativeQuery = true,value = "select count(*) * 100.0/ (select count(*) from Covid) AS 'Covid olup Ası Olmayanlar' from covid c Where NOT EXISTS(Select * from vaccine v Where v.staffId = c.staffId)")
    Float covidRateByNoVaccineStatus();



}
