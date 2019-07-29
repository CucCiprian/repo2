package springbootMapStruct;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import springbootMapStruct.domain.dto.InternTeam2DTO;
import springbootMapStruct.domain.entities.InternTeam2;
import springbootMapStruct.domain.repository.InternTeam2Repository;
import springbootMapStruct.facadeapi.InternTeam2Mapper;
import springbootMapStruct.facadeapi.InternTeam2Service;
import springbootMapStruct.facadeimpl.InternTeam2MapperImpl;
import springbootMapStruct.facadeimpl.InternTeam2ServiceImpl;

@RunWith(MockitoJUnitRunner.class)
//@DataJpaTest
//@TestPropertySource(locations = "classpath:test.properties")
public class InternTeam2MockitoTest {


    @TestConfiguration
    static class ServiceTestContextConfiguration {

        @Bean
        public InternTeam2Service internTeam2Service() {
            return new InternTeam2ServiceImpl();
        }

        @Bean InternTeam2Mapper internTeam2Mapper(){
            return new InternTeam2MapperImpl();
        }

    }

    @Mock
    private InternTeam2Mapper mapper;

    @Mock
    private InternTeam2Repository repo;

    @InjectMocks
    private InternTeam2ServiceImpl service;


    @Before
    public void setup(){
//        final InternTeam2 team = new InternTeam2();
//        team.setName("Serg");
//        team.setDate(LocalDateTime.now().atZone(ZoneId.of("Europe/Bucharest")).toInstant());
       // service.save(team);
    }

    @Test
    public void test() {
        final List<InternTeam2> list = new ArrayList<>();
        list.add(new InternTeam2());
        Mockito.when(repo.findAll()).thenReturn(list);

        final List<InternTeam2DTO> listDTO = new ArrayList<>();
        listDTO.add(new InternTeam2DTO());

        Mockito.when(mapper.sourcesToDestinations(list)).thenReturn(listDTO);
        final int nr=service.findAll().size();
        assertEquals(1, nr);
    }

}