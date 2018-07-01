package cmcc.hz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cmcc.hz.model.Product;
import cmcc.hz.utils.JdbcUtils;


public class ProductDao extends BaseDao{

	public int delete(Integer id) {

		String sql="delete from product where id = ?";
		return super.executeUpdate(sql, new Object[] {id});
		
	}

	
	// 编写一个方法,完成数据的插入操作
	public int update(Product product) {
		// ?称为占位符
		String sql="update product set name=?,price=?,remark=? where id = ?";
		
		return super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),
				product.getRemark(),product.getId()});
	}

	// 编写一个方法,完成数据的插入操作
	public int save(Product product) {
		// ?称为占位符
		String sql="insert into product (name,price,remark) values (?,?,?)";

		return super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),
				product.getRemark()});
	}

}
