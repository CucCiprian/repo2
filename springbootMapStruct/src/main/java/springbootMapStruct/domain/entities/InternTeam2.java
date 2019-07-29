package springbootMapStruct.domain.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "internteam2")
public class InternTeam2 implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name  = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "changedate")
//    @Convert(converter = Jsr310JpaConverters.InstantConverter.class)
    private Instant date;

    public InternTeam2() {
    }

    public InternTeam2(final Long id, final String name, final Instant date) {
        this.id = id;
        this.name = name;
       // date = date.atZone(ZoneId.of("Europe/Bucharest")).toInstant();
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(final Instant date) {
        this.date = date;
    }




}
