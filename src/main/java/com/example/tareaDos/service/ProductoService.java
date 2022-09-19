package com.example.tareaDos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tareaDos.dao.Operaciones;
import com.example.tareaDos.daoImpl.ProductoDaoImpl;
import com.example.tareaDos.entity.Producto;

@Service
public class ProductoService implements Operaciones<Producto> {
	
	@Autowired
	private ProductoDaoImpl daoImpl;

	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		return daoImpl.create(t);
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		return daoImpl.update(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return daoImpl.delete(id);
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return daoImpl.read(id);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return daoImpl.readAll();
	}
	
}
