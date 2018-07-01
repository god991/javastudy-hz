package cmcc.hz.service;

import cmcc.hz.dao.ProductDao;
import cmcc.hz.model.Product;

public class ProductService {

	public void productSave(Product product) {
		ProductDao productDao=new ProductDao();
		productDao.save(product);
	}
	
}
