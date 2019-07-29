package springbootMapStruct.facadeapi;

import java.util.List;

import org.mapstruct.Mapper;

import springbootMapStruct.domain.dto.InternTeam2DTO;
import springbootMapStruct.domain.entities.InternTeam2;

@Mapper(implementationPackage = "springbootMapStruct.facadeimpl",componentModel = "spring")
public interface InternTeam2Mapper {
    InternTeam2DTO sourceToDestination(InternTeam2 internteam2);
    InternTeam2 destinationToSource(InternTeam2DTO dto);
    List<InternTeam2> destinationsToSources(List<InternTeam2DTO> dtos);
    List<InternTeam2DTO> sourcesToDestinations(List<InternTeam2> internteam2copies);
}
