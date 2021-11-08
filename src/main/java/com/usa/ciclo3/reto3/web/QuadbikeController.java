package com.usa.ciclo3.reto3.web;

import com.usa.ciclo3.reto3.model.Quadbike;
import com.usa.ciclo3.reto3.service.QuadbikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class QuadbikeController {
    @Autowired
    private QuadbikeService quadbikeService;
    
    @GetMapping("/all")
    public List<Quadbike> getQuadbikes(){
        return quadbikeService.getAll();
    }
    
    @GetMapping("/obtener/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int id){
        return quadbikeService.getQuadbike(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike q){
        return quadbikeService.save(q);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id){
    	quadbikeService.deleteId(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Quadbike update(@RequestBody Quadbike q) {
    	return quadbikeService.update(q);
    }
}
