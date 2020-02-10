package webservices1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "fields")
public class Field {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Account account;

    @Column
    private String name;

    @Column
    private String lat;

    @Column
    private String lon;
}
