package com.usa.ciclo3.reto3.web;

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

import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.service.CategoryService;

/**
 * controllador CRUD proyecto Cuatrimotos category
 * 
 * @author: Cristian Felipe Cruz
 * @version: 08/11/2021 version2
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class CategoryController {
	/**
	 * importar servicio categoria
	 */
	@Autowired
	private CategoryService categoryService;

	/**
	 * contolador para listar todos los clientes inscritos en la base de datos
	 * category
	 */
	@GetMapping("/all")
	public List<Category> getCategorys() {
		return categoryService.getAll();
	}

	/**
	 * contolador para obtener un cliente relacionado por el id category
	 */
	@GetMapping("/obtener/{id}")
	public Optional<Category> getCategory(@PathVariable("id") int id) {
		return categoryService.getCategory(id);
	}

	/**
	 * contolador para guardar 1 nuevo cliente en la base de datos category
	 */
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@RequestBody Category c) {
		return categoryService.save(c);
	}

	/**
	 * contolador para eliminar un elemento de la base de datos category
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		categoryService.deleteId(id);
	}

	/**
	 * contolador para actualizar un elementos ya creado en la base de datos
	 * category
	 */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Category update(@RequestBody Category c) {
		return categoryService.update(c);
	}
}
