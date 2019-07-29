package springbootMapStruct;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import springbootMapStruct.domain.entities.InternTeam2;
import springbootMapStruct.domain.repository.InternTeam2Repository;
import springbootMapStruct.facadeapi.InternTeam2Mapper;
import springbootMapStruct.facadeapi.InternTeam2Service;
import springbootMapStruct.facadeimpl.InternTeam2MapperImpl;
import springbootMapStruct.facadeimpl.InternTeam2ServiceImpl;


@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class ServiceTest {


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
    @Autowired
    private InternTeam2Repository repo;

    @Autowired
    private InternTeam2Service service;


    @Before
    public void setup(){
        final InternTeam2 team = new InternTeam2();
        team.setName("Serg");
        team.setDate(LocalDateTime.now().atZone(ZoneId.of("Europe/Bucharest")).toInstant());
        service.save(team);
    }

    @Test
    public void test() {
        final int nr=service.findAll().size();
        assertEquals(1, nr);
    }

    @Test
    public void test2(){
        final InternTeam2 team = new InternTeam2();
        team.setName("map");
        team.setDate(LocalDateTime.now().atZone(ZoneId.of("Europe/Budapest")).toInstant());
        service.save(team);
        final Long id = repo.findOneByName("map").getId();
        service.remove(id);
        assertEquals(1,service.findAll().size());
    }

}
