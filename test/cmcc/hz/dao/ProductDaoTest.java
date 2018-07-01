package cmcc.hz.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cmcc.hz.model.Product;

public class ProductDaoTest {

	private static ProductDao productDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("junit开始前环境准备……");
		productDao = new ProductDao();
		
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
		
/*		String str1="abc";
		sys
		
		StringBuffer stringBuffer1=new StringBuffer("abc");
		stringBuffer1=stringBuffer1.append("bcd");
		*/
		
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
		fail("Not yet implemented");
	}

}
