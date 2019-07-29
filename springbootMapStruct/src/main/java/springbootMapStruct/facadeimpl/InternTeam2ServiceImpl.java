package springbootMapStruct.facadeimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootMapStruct.domain.dto.InternTeam2DTO;
import springbootMapStruct.domain.entities.InternTeam2;
import springbootMapStruct.domain.repository.InternTeam2Repository;
import springbootMapStruct.facadeapi.InternTeam2Mapper;
import springbootMapStruct.facadeapi.InternTeam2Service;

@Service
public class InternTeam2ServiceImpl implements InternTeam2Service {

    @Autowired
    private InternTeam2Repository repo;

    @Autowired
    private InternTeam2Mapper mapper;

    @Override
    public List<InternTeam2DTO> findAll() {
        return mapper.sourcesToDestinations(repo.findAll());
    }

    @Override
    public void save(final InternTeam2 team) {
       repo.save(team);

    }

    @Override
    public void remove(final Long id) {
        repo.deleteById(id);

    }

}
