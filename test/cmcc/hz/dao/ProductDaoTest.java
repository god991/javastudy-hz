package cmcc.hz.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cmcc.hz.model.Product;
import cmcc.hz.service.ProductService;

public class ProductDaoTest {

	private static ProductService productService;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("junit开始前环境准备……");
//		productDao = new ProductDao();
		
		context = new ClassPathXmlApplicationContext("spring-bean.xml");
		productService = context.getBean("ps", ProductService.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("junit结束后资源释放……");
	}

	
	@Test
	public void testSave() {
		Product p=new Product();
		p.setName("华为手机");
		p.setPrice(3600.00);
		//p.setId(2);
		p.setRemark("华为新款手机");
		productService.save(p);
		//fail("Not yet implemented");
	}
	
	

}
