package cmcc.hz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmcc.hz.model.Product;
import cmcc.hz.service.ProductService;

/**
 * Servlet implementation class ProduceServlet
 */
@WebServlet("/ProduceServlet")
public class ProduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 前端返回所有数据都封装到request中。
		Product product=new Product();
		product.setName(request.getParameter("name"));
		product.setRemark(request.getParameter("remark"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		
		ProductService pService=new ProductService();
		pService.productSave(product);
		
		//doGet(request, response);
	}

}
