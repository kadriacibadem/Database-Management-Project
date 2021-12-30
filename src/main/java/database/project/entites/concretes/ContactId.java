package database.project.entites.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactId implements Serializable {

    @Column(name = "covidId",insertable = false,updatable = false)
    private int covidId;

    @Column(name = "staffId",insertable = false,updatable = false)
    private int staffId;

}
