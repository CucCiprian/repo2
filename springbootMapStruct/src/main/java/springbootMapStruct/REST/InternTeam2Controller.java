package springbootMapStruct.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootMapStruct.domain.dto.InternTeam2DTO;
import springbootMapStruct.facadeapi.InternTeam2Mapper;
import springbootMapStruct.facadeapi.InternTeam2Service;

@RestController
public class InternTeam2Controller {

    @Autowired
    private InternTeam2Service service;


    @Autowired
    private InternTeam2Mapper mapper;

    @GetMapping(value = "/")
    public List<InternTeam2DTO> getAll()
    {
        return service.findAll();
    }

    @PostMapping(value="/")
    public ResponseEntity<HttpStatus> addTeam(@RequestBody final InternTeam2DTO dto)
    {
        System.out.print(mapper.destinationToSource(dto));
            service.save(mapper.destinationToSource(dto));

            return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable final Long id)
    {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}
