package springbootMapStruct;


import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import springbootMapStruct.domain.entities.InternTeam2;
import springbootMapStruct.domain.repository.InternTeam2Repository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InternTeam2Test {


    @MockBean
    private InternTeam2Repository repo;

    @Before
    public void setUp()
    {
        final List<InternTeam2> dtos = new ArrayList<>();
        dtos.add(new InternTeam2(new Long(1),"unu",LocalDateTime.now().atZone(ZoneId.of("Europe/Bucharest")).toInstant()));
        dtos.add(new InternTeam2(new Long(2),"doi",LocalDateTime.now().atZone(ZoneId.of("Europe/Budapest")).toInstant()));
            Mockito.when(repo.findAll()).thenReturn(dtos);
    }

    @Test
    public void test1() {
            final List<InternTeam2> list = repo.findAll();
            assertEquals(list.size(),2);

    }

}
