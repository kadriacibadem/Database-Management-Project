package database.project.entites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@Entity
@Table(name = "Contact")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","diseases","hobbies","vaccines","workingTime","contactStaff","covidContact"})
public class Contact {

    @EmbeddedId
    private ContactId id;

    @ManyToOne
    @JoinColumn(name = "covidId",insertable = false,updatable = false)
    private Covid covidContact;


    @ManyToOne
    @JoinColumn(name = "staffId",insertable = false,updatable = false)
    private Staff staffContact;


}
