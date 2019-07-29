package springbootMapStruct.facadeimpl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import springbootMapStruct.domain.dto.InternTeam2DTO;
import springbootMapStruct.domain.entities.InternTeam2;
import springbootMapStruct.facadeapi.InternTeam2Mapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-07-29T12:28:47+0300",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 1.2.100.v20160418-1457, environment: Java 1.8.0_91 (Oracle Corporation)"
)
@Component
public class InternTeam2MapperImpl implements InternTeam2Mapper {

    @Override
    public InternTeam2DTO sourceToDestination(InternTeam2 internteam2) {
        if ( internteam2 == null ) {
            return null;
        }

        InternTeam2DTO internTeam2DTO = new InternTeam2DTO();

        internTeam2DTO.setId( internteam2.getId() );
        internTeam2DTO.setName( internteam2.getName() );
        internTeam2DTO.setDate( internteam2.getDate() );

        return internTeam2DTO;
    }

    @Override
    public InternTeam2 destinationToSource(InternTeam2DTO dto) {
        if ( dto == null ) {
            return null;
        }

        InternTeam2 internTeam2 = new InternTeam2();

        internTeam2.setId( dto.getId() );
        internTeam2.setName( dto.getName() );
        internTeam2.setDate( dto.getDate() );

        return internTeam2;
    }

    @Override
    public List<InternTeam2> destinationsToSources(List<InternTeam2DTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<InternTeam2> list = new ArrayList<InternTeam2>( dtos.size() );
        for ( InternTeam2DTO internTeam2DTO : dtos ) {
            list.add( destinationToSource( internTeam2DTO ) );
        }

        return list;
    }

    @Override
    public List<InternTeam2DTO> sourcesToDestinations(List<InternTeam2> internteam2copies) {
        if ( internteam2copies == null ) {
            return null;
        }

        List<InternTeam2DTO> list = new ArrayList<InternTeam2DTO>( internteam2copies.size() );
        for ( InternTeam2 internTeam2 : internteam2copies ) {
            list.add( sourceToDestination( internTeam2 ) );
        }

        return list;
    }
}
