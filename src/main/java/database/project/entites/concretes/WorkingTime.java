package database.project.entites.concretes;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WorkingTime")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","diseases","hobbies","vaccines","workingTime","covid"})
public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workingTimeId")
    private int id;

    @Column(name = "day")
    private String day;


    @Column(name = "enterTime")
    private Date enterTime;


    @Column(name = "exitTime")
    private Date exitTime;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staffWorkingTime;

}
