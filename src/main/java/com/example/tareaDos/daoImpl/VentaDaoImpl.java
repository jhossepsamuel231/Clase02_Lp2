package com.example.tareaDos.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.tareaDos.dao.Todo;
import com.example.tareaDos.entity.Venta;
import com.fasterxml.jackson.databind.util.Named;

@Component
public class VentaDaoImpl implements Todo<Venta>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DetalleDaoImpl detalleDao;
	//Ayuda a permitir datos
	@Autowired
	private DataSource dataSource;
	
	@Override
	@Transactional
	public int create(Venta t) {
		// Permite la accio de obtener el id generado(tiene el metodo especial)
		NamedParameterJdbcTemplate ejecutar = new NamedParameterJdbcTemplate(dataSource);
		
		GeneratedKeyHolder generar = new GeneratedKeyHolder();
		String sql = "INSERT INTO venta (fecha) values(:fecha)";
		Map<String, Object> valores=new HashMap<>();
		valores.put("fecha", t.getFechaVenta());
		ejecutar.update(sql, new MapSqlParameterSource(valores), generar);
		int idGenerado = generar.getKey().intValue();
		t.getListaDetails().forEach(x->{
			x.setIdVenta(idGenerado);
			detalleDao.create(x);
		});
		return idGenerado;
	}

	@Override
	public int update(Venta t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
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
