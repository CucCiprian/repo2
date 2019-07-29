package springbootMapStruct.facadeapi;

import java.util.List;

import springbootMapStruct.domain.dto.InternTeam2DTO;
import springbootMapStruct.domain.entities.InternTeam2;

public interface InternTeam2Service {


    List<InternTeam2DTO> findAll();

    void save(InternTeam2 team);
    void remove(Long id);
}
