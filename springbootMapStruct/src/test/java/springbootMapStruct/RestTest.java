package springbootMapStruct;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import springbootMapStruct.REST.InternTeam2Controller;
import springbootMapStruct.domain.dto.InternTeam2DTO;
import springbootMapStruct.domain.entities.InternTeam2;
import springbootMapStruct.facadeapi.InternTeam2Mapper;
import springbootMapStruct.facadeapi.InternTeam2Service;
import springbootMapStruct.facadeimpl.InternTeam2MapperImpl;



@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=Library.class)
@WebMvcTest(InternTeam2Controller.class)
public class RestTest {

    @TestConfiguration
    public static class TestConfig{


        @Bean
        public InternTeam2Mapper internTeam2Mapper(){
            return new InternTeam2MapperImpl();
        }
    }

    @Autowired
   private ObjectMapper objm;

//    public static String asJsonString(final Object obj) {
//        try {
//
//            //final ObjectMapper objm = new ObjectMapper();
//            //objm.registerModule(new JavaTimeModule());
//            return objm.writeValueAsString(obj);
//        } catch (final Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    @Autowired
    private MockMvc mock;

    @MockBean
    private InternTeam2Service service;


    @MockBean
    private InternTeam2Mapper mapper;

    @Before
    public void setUp()
    {
        final InternTeam2DTO dto= new InternTeam2DTO(new Long(-1),"test",Instant.now());
        Mockito.when(mapper.destinationToSource(dto)).thenReturn(new InternTeam2(dto.getId(),dto.getName(),dto.getDate()));
    }


    @Test
    public void test() throws Exception {
        final InternTeam2DTO dto= new InternTeam2DTO(new Long(-1),"test",Instant.now());
        mock.perform(MockMvcRequestBuilders.post("/").
        content(objm.writeValueAsString(dto)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//        .andExpect(status().isNotFound());
        .andExpect(status().isCreated());



    }

}
