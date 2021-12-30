package database.project.dataAccess.abstracts;


import database.project.dataAccess.dtos.*;
import database.project.entites.concretes.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface StaffDao extends JpaRepository<Staff,Integer> {


    @Query("Select new database.project.dataAccess.dtos.CovidWithStaffDto"
            + "(c.covidId,c.staffCovid.id)"
            + "from Staff s inner join s.covid c where s.educationStatus=:education")
    List<CovidWithStaffDto> getCovidWithStaffEducationDetails(String education);


    @Query("Select new database.project.dataAccess.dtos.CovidWithStaffDto"
            + "(c.covidId,c.staffCovid.id)"
            + "from Staff s inner join s.covid c where s.educationStatus='Yüksek Lisans'")
    List<CovidWithStaffDto> getCovidWithStaffDetailsYuksekLisans();

    @Query("Select new database.project.dataAccess.dtos.CovidWithStaffDto"
            + "(c.covidId,c.staffCovid.id)"
            + "from Staff s inner join s.covid c where s.educationStatus='Doktora'")
    List<CovidWithStaffDto> getCovidWithStaffDetailsDoktora();



    @Query("SELECT new database.project.dataAccess.dtos.StaffWithDiseaseCovidRecipeDto"
            + "(s.id,d.id,c.covidId,r.recipeId)"
            + "from Staff s inner join s.diseases d inner join s.covid c inner join d.recipes r where s.id = d.staff.id and d.id = r.disease.id and s.id = c.staffCovid.id and r.medicine=:medicine"


    )
    List<StaffWithDiseaseCovidRecipeDto> getStaffWithDiseaseCovidRecipeDetails(String medicine);


    @Query("SELECT new database.project.dataAccess.dtos.StaffWithDiseaseRecipeDto"
            + "(s.id,d.id,r.recipeId)"
            + "From Staff s,Disease d,Recipe r where r.medicine=:medicine and s.id = d.staff.id and d.id = r.disease.id and d.staff.id NOT IN(Select d.staff.id From Covid c, Disease d Where c.staffCovid.id = d.staff.id)"


    )
    List<StaffWithDiseaseRecipeDto> getStaffWithDiseaseNoCovidRecipeDetails(String medicine);




    @Query("select new database.project.dataAccess.dtos.StaffWithVaccineCovidDisease"
            +"(s.id,c.covidId,v.id,d.id)"
            + "from Staff s inner join s.covid c inner join s.vaccines v inner join s.diseases d where s.id = d.staff.id and v.staffVaccines.id = s.id and s.id = c.staffCovid.id and v.vaccineName = 'Biontech' and d.diseaseName=:disease"

    )
    List<StaffWithVaccineCovidDisease> getStaffWithVaccineCovidDisease(String disease);


    @Query(nativeQuery = true,value = "Select distinct s.* From Recipe r, Disease d, Staff s Where r.diseaseId = d.diseaseId AND d.staffID = s.staffID AND medicine IN(Select TOP 3 medicine From Recipe group by medicine order by Count(*) desc) AND s.staffId IN(Select s.staffId From covid c, staff s Where c.staffId = s.staffId) Order By staffId")
    List<Staff> getMost3MedicineCovidStatus();

    @Query(nativeQuery = true,value = "Select distinct s.* From Recipe r, Disease d, Staff s Where r.diseaseId = d.diseaseId AND d.staffID = s.staffID AND medicine IN(Select TOP 3 medicine From Recipe group by medicine order by Count(*) desc) AND s.staffId NOT IN(Select s.staffId From covid c, staff s Where c.staffId = s.staffId) Order By staffId")
    List<Staff> getMost3MedicineNoCovidStatus();

    @Query(nativeQuery = true,value = "select count(*) * 100.0 / (select count(*) from Covid) AS 'Covid Olup Ası Olanlar' from Vaccine v, Covid c Where v.staffId = c.staffId")
    Float covidRateByVaccineStatus();

    @Query(nativeQuery = true,value = "select count(*) * 100.0/ (select count(*) from Covid) AS 'Covid olup Ası Olmayanlar' from covid c Where NOT EXISTS(Select * from vaccine v Where v.staffId = c.staffId)")
    Float covidRateByNoVaccineStatus();



    @Query(nativeQuery = true,value = "Select * From Staff Where staffId IN(Select TOP 10 s.staffId From disease d, staff s Where d.StaffId = s.staffId AND DATEDIFF(month, DiseaseDate, getdate()) BETWEEN 0 AND 2 AND s.staffId IN(Select s.staffId From Covid c, staff s Where c.staffId = s.staffId)Group BY s.staffId Order BY COUNT(s.staffId) DESC)")
    List<Staff> getMostDiseaseStaff();


    @Query(nativeQuery = true,value = "Select * From Staff Where staffId IN(Select TOP 10 s.staffId From disease d, staff s Where d.StaffId = s.staffId AND DATEDIFF(month, DiseaseDate, getdate()) BETWEEN 0 AND 2 AND s.staffId NOT IN(Select s.staffId From Covid c, staff s Where c.staffId = s.staffId)Group BY s.staffId Order BY COUNT(s.staffId) DESC)")
    List<Staff> getMostDiseaseStaffNoCovid();




}
