package com.example.tareaDos.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.tareaDos.dao.Todo;
import com.example.tareaDos.entity.Detalle;

@Component
public class DetalleDaoImpl implements Todo<Detalle>{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Detalle t) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO detalle (id_venta, id_producto, precio, cantidad) values(?,?,?,?)";
		return jdbcTemplate.update(sql,
				t.getIdVenta(),
				t.getIdProducto(),
				t.getPrecioTotal(),
				t.getCantidad());
	}

	@Override
	public int update(Detalle t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM detalle WHERE id_venta=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT P.NOMBRE,  D.CANTIDAD, D.PRECIO, V.FECHA FROM DETALLE AS D INNER JOIN PRODUCTO AS P ON D.ID_PRODUCTO=P.IDPRODUCTO INNER JOIN VENTA AS V ON D.ID_VENTA = V.IDVENTA";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Detalle>(Detalle.class));
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT P.NOMBRE,  D.CANTIDAD, D.PRECIO, V.FECHA FROM DETALLE AS D INNER JOIN PRODUCTO AS P ON D.ID_PRODUCTO=P.IDPRODUCTO INNER JOIN VENTA AS V ON D.ID_VENTA = V.IDVENTA";
		return jdbcTemplate.queryForList(sql);
	}
}
