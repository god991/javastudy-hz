<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ProduceServlet" method="post">
	商品名：<input type="text" name="name"/></br>
	价格：<input type="text" name="price"/></br>
	备注：<input type="text" name="remark"/></br>
	<input type="submit" value="提交" />
</form>

</body>
</html>