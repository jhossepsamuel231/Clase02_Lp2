package com.example.tareaDos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tareaDos.entity.Producto;
import com.example.tareaDos.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listProduct")
	public List<Producto> ListProduct(){
		return productoService.readAll();
	}
	
	@GetMapping("/search/{id}")
	public Producto ListProduct(@PathVariable int id){
		return productoService.read(id);
	}
	
	@DeleteMapping("/deleteProduc/{porductoId}")
	public int deleteProducto(@PathVariable int porductoId) {
		return productoService.delete(porductoId);
	}
	
	@PostMapping("/createProduc")
	public int createProduct(Producto products) {
		return productoService.create(products);
	}
	
	@PutMapping("/updateProducts")
	public int updateById(@RequestBody Producto id) {
		return productoService.update(id);
	}
	
}
