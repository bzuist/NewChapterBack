package dev.vorstu.Controllers;

import dev.vorstu.dto.Fanfic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import dev.vorstu.repositories.FanficRepository;

import java.awt.*;
import java.util.Date;


@RestController
@RequestMapping("api/base")
@RequiredArgsConstructor

public class BaseController {
    @Autowired
    private FanficRepository fanficrepository;

    @PutMapping(value = "fanfic", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Fanfic changeFanfic(@RequestBody Fanfic changingFanfic){
        return updateFanfic(changingFanfic);
}
private Fanfic updateFanfic(Fanfic fanfic){
        if(fanfic.getId()==null){
            throw new RuntimeException("id of changing student cannot be null");
        }
        fanficrepository.save(fanfic);
        return fanfic;
}

@DeleteMapping(value = "fanfic/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Long deleteFanfic(@PathVariable("id") Long id){
        return removeFanfic(id);
}
private Long removeFanfic(Long id){
    fanficrepository.deleteById(id);
    return id;
}
    @GetMapping("fanfics")
    @Query("")
    public Iterable<Fanfic> getAllFanfics(){
        return fanficrepository.findAll();
    }


    @GetMapping("check")
    public String greetJava(){
        return "Hello, world" + new Date();
    }

}
