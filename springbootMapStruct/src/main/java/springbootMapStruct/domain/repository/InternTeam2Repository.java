package springbootMapStruct.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootMapStruct.domain.entities.InternTeam2;


public interface InternTeam2Repository extends JpaRepository<InternTeam2,Long> {

    InternTeam2 findOneByName(String string);

}
