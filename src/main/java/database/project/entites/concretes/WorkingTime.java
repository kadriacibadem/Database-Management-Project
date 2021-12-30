package database.project.entites.concretes;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;


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
    @JsonFormat(timezone="GMT+03:00")
    private LocalDateTime enterTime;


    @Column(name = "exitTime")
    @JsonFormat(timezone="GMT+03:00")
    private LocalDateTime exitTime;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staffWorkingTime;

}
