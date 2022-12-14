package com.example.tareaDos.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tareaDos.dao.Todo;
import com.example.tareaDos.daoImpl.DetalleDaoImpl;
import com.example.tareaDos.daoImpl.VentaDaoImpl;
import com.example.tareaDos.entity.Venta;

@Service
public class VentaService implements Todo<Venta>{
	
	@Autowired
	private VentaDaoImpl daoImpl;
	@Autowired
	private DetalleDaoImpl detailsDaoImpl;
	
	@Override
	public int create(Venta t) {
		// TODO Auto-generated method stub
		return daoImpl.create(t);
	}

	@Override
	public int update(Venta t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int delete(int id) {
		// TODO Auto-generated method stub
		detailsDaoImpl.delete(id);
		return daoImpl.delete(id);
	}

	@Override
	public Venta read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
