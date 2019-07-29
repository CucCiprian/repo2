package springbootMapStruct.domain.dto;

import java.io.Serializable;
import java.time.Instant;

public class InternTeam2DTO implements Serializable{
    public InternTeam2DTO() {
    }
    private Long id;
    private String name;

//    @Convert(converter = Jsr310JpaConverters.InstantConverter.class)
    private Instant date;


    public InternTeam2DTO(final Long id, final String name,  final Instant date) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString()
    {
        return ""+id+", named: "+name+"@ "+date;
    }


}


