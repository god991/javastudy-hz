package cmcc.hz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cmcc.hz.utils.JdbcUtils;

public class BaseDao {

	public void executeUpdate(String sql,Object[] parm) {
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			//pre.setInt(1,id);
			// 4: 执行SQL语句,返回int如果返回为1则代表插入1条数据
			
			for (int i = 0; i < parm.length; i++) {
				pre.setObject(i+1,parm[i]);
			}
			
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}
		// 5: 关闭Connection释放资源
	}
	
}
