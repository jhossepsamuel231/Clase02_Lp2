package com.example.tareaDos.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tareaDos.dao.Todo;
import com.example.tareaDos.daoImpl.DetalleDaoImpl;
import com.example.tareaDos.entity.Detalle;

@Service
public class DetalleService implements Todo<Detalle>{

	@Autowired
	private DetalleDaoImpl daoImpl;
	
	@Override
	public int create(Detalle t) {
		// TODO Auto-generated method stub
		return daoImpl.create(t);
	}

	@Override
	public int update(Detalle t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return daoImpl.readAll();
	}

}
