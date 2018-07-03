package cmcc.hz.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cmcc.hz.model.Product;

public class ProductDaoTest {

	private static ProductDao productDao;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("junit开始前环境准备……");
//		productDao = new ProductDao();
		
		context = new ClassPathXmlApplicationContext("spring-bean.xml");
		productDao = context.getBean("productDao", ProductDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("junit结束后资源释放……");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		
		String str1=new String("abc");
		String str2=new String("bcd");
		System.out.println(str1);
		System.out.println(str1+str2);
		
		StringBuffer stringBuffer1=new StringBuffer("abc");
		System.out.println(stringBuffer1);
		stringBuffer1=stringBuffer1.append("bcd");
		System.out.println(stringBuffer1);
		
		
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Product p=new Product();
		p.setName("华为手机");
		p.setPrice(3600.00);
		//p.setId(2);
		p.setRemark("华为新款手机");
		productDao.save(p);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGetOne() {
		//Product p=new Product();
		//Product p=productDao.getOne(1);
		//System.out.println(p);
		
	}

}
