package database.project.entites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "Staff")
@NoArgsConstructor // lombak argümansız constructor oluşturur
@AllArgsConstructor // lombak tüm argümanları kullanarak constructor oluşturur
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","diseases","hobbies","vaccines","workingTime","covid"})
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'nin nasıl arttırıldığını gösterir
    @Column(name = "staffId")
    private int id;

    @Column(name = "tcno")
    private String tcNo;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String lastName;

    @Column(name = "bloodgroup")
    private String bloodGroup;

    @Column(name = "city")
    private String city;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private int salary;

    @Column(name = "educationstatus")
    private String educationStatus;

    @OneToMany(mappedBy = "staff")
    private List<Disease> diseases;

    @OneToMany(mappedBy = "staffHobbies")
    private List<Hobbies> hobbies;

    @OneToMany(mappedBy = "staffVaccines")
    private List<Vaccine> vaccines;

    @OneToMany(mappedBy = "staffWorkingTime")
    private List<WorkingTime> workingTime;

    @OneToMany(mappedBy = "staffCovid")
    private List<Covid> covid;

}
