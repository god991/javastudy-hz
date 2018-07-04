package cmcc.hz.dao;

import java.util.List;

import cmcc.hz.model.Product;

public interface ProductDaoInterface {

	public int save(Product product);
	
	
	public int delete(Integer id) ;

	
	// 编写一个方法,完成数据的插入操作
	public int update(Product product);

	
	public Product getById(int id) ;
	
	public List<Product> getByName(String name) ;
	
}
