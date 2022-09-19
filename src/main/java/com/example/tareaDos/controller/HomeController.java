package com.example.tareaDos.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tareaDos.entity.Venta;
import com.example.tareaDos.service.DetalleService;
import com.example.tareaDos.service.VentaService;

@RestController
public class HomeController {

	@Autowired
	private DetalleService detalleService;
	
	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/listDetails")
	public List<Map<String,Object>> readDetail(){
		return detalleService.readAll();
	}
	
	@PostMapping("/addDetailssales")
	public int addDetailsandSales(
			@RequestBody Venta venta
	) {
		return ventaService.create(venta);
	}
	
	@DeleteMapping("/eliminar-venta/{idVenta}")
	public String eliminarVenta(
			@PathVariable
			Integer idVenta
	) {
		int deleteSales = ventaService.delete(idVenta);
		return "Eliminado correctamente! -> " + deleteSales;
	}
}
