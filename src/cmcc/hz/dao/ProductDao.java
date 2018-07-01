package cmcc.hz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cmcc.hz.model.Product;
import cmcc.hz.utils.JdbcUtils;


public class ProductDao extends BaseDao{

	// alt+/
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product p=new Product();
		p.setName("华为手机");
		p.setPrice(3600.00);
		p.setId(2);
		p.setRemark("华为新款手机");
//		dao.save(p);
//		dao.update(p);
		dao.delete(2);
	}
	
	public void delete(Integer id) {
		// ?称为占位符
		String sql="delete from product where id = ?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			// 4: 执行SQL语句,返回int如果返回为1则代表插入1条数据
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}
		// 5: 关闭Connection释放资源
	}

	
	// 编写一个方法,完成数据的插入操作
	public void update(Product product) {
		// ?称为占位符
		String sql="update product set name=?,price=?,remark=? where id = ?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: 对占位符进行赋值操作
			pre.setString(1, product.getName()); // 把getName的值赋给第1个?问号
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			pre.setInt(4, product.getId());
			// 4: 执行SQL语句,返回int如果返回为1则代表插入1条数据
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}
		// 5: 关闭Connection释放资源
	}

	// 编写一个方法,完成数据的插入操作
	public void save(Product product) {
		// ?称为占位符
		String sql="insert into product (name,price,remark) values (?,?,?)";
		// 1: 连接数据库
		//JdbcUtils utils = new JdbcUtils();
		//Connection conn = utils.getConnection();
/*		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: 对占位符进行赋值操作
			pre.setString(1, product.getName()); // 把getName的值赋给第1个?问号
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			// 4: 执行SQL语句,返回int如果返回为1则代表插入1条数据
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}*/
		// 5: 关闭Connection释放资源
		
		
	}

}
