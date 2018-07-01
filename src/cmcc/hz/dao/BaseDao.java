package cmcc.hz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeMBeanException;

import cmcc.hz.model.Product;
import cmcc.hz.utils.JdbcUtils;

public class BaseDao {

	public void executeUpdate(String sql, Object[] parm) {
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {

			PreparedStatement pre = conn.prepareStatement(sql);

			for (int i = 0; i < parm.length; i++) {
				pre.setObject(i + 1, parm[i]);
			}

			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
		// 5: 关闭Connection释放资源
	}

	public List<Product> querySQL(String sql, Object[] parm){
		//这里代码基本与executeUpdate一样。 
		
		return null;
	}
	
	public Product getOne(int id) {
		Product product = null;
		String sql = "select * from product where id=?";
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection conn = jdbcUtils.getConnection();
		PreparedStatement pre = null;

		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rSet = pre.executeQuery();
			if (rSet.next()) {
				product = new Product();
				product.setId(rSet.getInt("id"));
				product.setName(rSet.getString("name"));
				product.setPrice(rSet.getDouble("Price"));
				product.setRemark(rSet.getString("Remark"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}
	
	

}
