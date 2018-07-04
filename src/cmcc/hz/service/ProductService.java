package cmcc.hz.service;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import cmcc.hz.dao.ProductDao;
import cmcc.hz.dao.ProductDaoInterface;
import cmcc.hz.model.Product;

public class ProductService {
	
	private ProductDaoInterface productDao=null;
	
	public void setProductDao(ProductDaoInterface productDao) {
		this.productDao = productDao;
	}

	public void save(Product product) {
		productDao.save(product);
		
		//Integer.parseInt("adfadf");
	}
	
	public List<Product> getByName(String name) {
		return productDao.getByName("%"+name+"%");
		
	}
	
	public Product getById(int id) {
		return productDao.getById(id);
		
	}
	
	public void delete(int id) {
		productDao.delete(id);
		
		//Integer.parseInt("adfadf");
	}
	
	public void update(Product product) {
		productDao.update(product);
		
		//Integer.parseInt("adfadf");
	}
}
