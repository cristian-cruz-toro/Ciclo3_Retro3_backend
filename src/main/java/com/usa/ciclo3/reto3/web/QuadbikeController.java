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
/**
 * controllador CRUD proyecto Cuatrimotos quadbike
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class QuadbikeController {
	  /**
     * importar servicio Quadbike
     */
    @Autowired
    private QuadbikeService quadbikeService;
    
	  /**
     * contolador para listar todos los clientes inscritos en la base de datos Quadbike
     */
    @GetMapping("/all")
    public List<Quadbike> getQuadbikes(){
        return quadbikeService.getAll();
    }
    
	   /**
  * contolador para obtener un cliente  relacionado por el id Quadbike
  */
    @GetMapping("/obtener/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int id){
        return quadbikeService.getQuadbike(id);
    }
    
    /**
     * contolador para guardar 1 nuevo cliente en la base de datos Quadbike
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike q){
        return quadbikeService.save(q);
    }
    
    /**
     * contolador para eliminar un elemento de  la base de datos Quadbike
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
    	quadbikeService.deleteId(id);
    }
    
	  /**
     *contolador para actualizar un elementos ya creado en la base de datos Quadbike
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike q) {
    	 return quadbikeService.update(q);
    }
}
