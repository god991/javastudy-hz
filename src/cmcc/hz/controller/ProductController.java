package cmcc.hz.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cmcc.hz.model.Product;
import cmcc.hz.service.ProductService;

@Component(value="pc")  //此类交给spring管理
@RequestMapping("/product")  //web前端访问地址
public class ProductController {

	// MVC支持把request session application自动注入到Controller中
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpSession session;
	
	//如果采用注解方式，则不需要写set方法
	@Resource(name="ps")
	private ProductService productService;
	
	//jsp->controller->service->productDao->jdbcTemplate->dataSource->db
	
	//mvc支持自动赋值，前端文本框的name属性与product属性匹配
	@RequestMapping("/save")
	public String save(Product product) {
		productService.save(product);
		//3.返回结果页面（此处跳转到查询页面，当前controller与query.jsp没有数据交互，需要用重定向）
		return "redirect:/query.jsp";
	}
	
	@RequestMapping("/query")
	public String queryByName(String keyword) {
		// 调用业务逻辑
		ArrayList<Product> proList =(ArrayList<Product>) productService.getByName(keyword);
		request.setAttribute("proList", proList);
		session.setAttribute("keyword", keyword);
		return "forward:/query.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		productService.delete(id);
		//3.返回结果页面（此处跳转到查询页面，当前controller与query.jsp没有数据交互，需要用重定向）
		return "redirect:/query.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		//3.返回结果页面（此处跳转到查询页面，当前controller与query.jsp没有数据交互，需要用重定向）
		return "redirect:/query.jsp";
	}
	
	@RequestMapping("/getById")
	public String getById(int id) {
		request.setAttribute("product",productService.getById(id));
		//3.返回结果页面（此处跳转到查询页面，当前controller与query.jsp没有数据交互，需要用重定向）
		return "forward:/update.jsp";
	}
	
}
