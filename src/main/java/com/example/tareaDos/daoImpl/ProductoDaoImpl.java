package com.example.tareaDos.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.tareaDos.dao.Operaciones;
import com.example.tareaDos.entity.Producto;

@Component
public class ProductoDaoImpl implements Operaciones<Producto>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO producto(nombre, precio, stock) VALUES(?,?,?)";
		return jdbcTemplate.update(sql, 
				t.getNombre(),
				t.getPrecio(),
				t.getPrecio(),
				t.getStock());
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		String sql = "UPDATE producto SET(nombre=?, precio=?, stock=?) WHERE(idproducto=?)";
		return jdbcTemplate.update(sql,
				t.getNombre(),
				t.getPrecio(),
				t.getPrecio(),
				t.getStock(),
				t.getIdProducto());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM producto WHERE idproducto=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM producto WHERE idproducto=?";
		return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Producto>(Producto.class), id);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM producto";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Producto>(Producto.class));
	}

}
