package cmcc.hz.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Proc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cmcc.hz.model.Product;

public class ProductDao{
	
	private JdbcTemplate jdbcTemplate = null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public int delete(Integer id) {

		String sql="delete from product where id = ?";
		//return super.executeUpdate(sql, new Object[] {id});
		return jdbcTemplate.update(sql, new Object[] {id});
	}

	
	// 编写一个方法,完成数据的插入操作
	public int update(Product product) {
		// ?称为占位符
		String sql="update product set name=?,price=?,remark=? where id = ?";		
		return jdbcTemplate.update(sql, new Object[] {product.getName(),product.getPrice(),
				product.getRemark(),product.getId()});
	}

	// 编写一个方法,完成数据的插入操作
	public int save(Product product) {
		// ?称为占位符
		String sql="insert into product (name,price,remark) values (?,?,?)";

		return jdbcTemplate.update(sql, new Object[] {product.getName(),product.getPrice(),
				product.getRemark()});
	}
	
	public Product getById(int id) {
		String sql="select * from product where id=?";		
		return jdbcTemplate.queryForObject(sql,new Object[] {id},
				new BeanPropertyRowMapper<>(Product.class));
	}
	
	public List<Product> getByName(String name) {
		String sql="select * from product where name like ?";		
		return jdbcTemplate.query(sql,new Object[] {"%"+name+"%"},
				new BeanPropertyRowMapper<>(Product.class));

		
	}

}
