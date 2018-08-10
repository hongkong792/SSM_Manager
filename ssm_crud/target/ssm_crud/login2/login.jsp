<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="author" content="Kodinger">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>My Login Page &mdash; Bootstrap 4 Login Page Snippet</title>
	<%
	  pageContext.setAttribute("APP_PATH", request.getContextPath());
	  System.out.println("路径："+request.getContextPath());
	%>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/my-login.css">
</head>
<body class="my-login-page">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="img/logo.jpg">
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">Login</h4>
							<div method="POST">
							 
								<div class="form-group">
									<label for="account">E-Mail Address</label>

									<input id="account" type="account" class="form-control" name="account" value="" required autofocus>
								</div>

								<div class="form-group">
									<label for="password">Password
										<a href="forgot.html" class="float-right">
											Forgot Password?
										</a>
									</label>
									<input id="password" type="password" class="form-control" name="password" required data-eye>
								</div>

								<div class="form-group">
									<label>
										<input type="checkbox" name="remember"> Remember Me
									</label>
								</div>

								<div class="form-group no-margin">
									<button onclick="myFunction()" type="submit" class="btn btn-primary btn-block">
										Login
									</button>
								</div>
								<div class="margin-top20 text-center">
									Don't have an account? <a href="register.html">Create One</a>
								</div>
							</div>
						</div>
					</div>
					<div class="footer">
						Copyright &copy; 2017 &mdash; Your Company 
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/my-login.js"></script>



	<script type="text/javascript">

    function myFunction() {

        // 获取搜素框中的值，校验，提交
        var name = $("input[id='account']").val();
        var passwd = $("input[id='password']").val();


alert(name)
        $.ajax({
            url: "${APP_PATH}/login",
            data: "name="+name+"&"+"pass="+passwd,
            type: "POST",
            success:function(result){

                var empData = result.extend.resultStr;

                alert('666')
                alert(empData);


            }
        });



    }


    $("#").click(function(){


        // 获取搜素框中的值，校验，提交
        var name = $("input[id='name']").val();
        var passwd = $("input[id='pass']").val();



        $.ajax({
            url: "${APP_PATH}/login",
            data: "name="+name+"&"+"pass="+passwd,
            type: "POST",
            success: function (result) {

                var empData = result.extend.resultStr;

                alert('666')
                alert(empData);
                if (empData == 'loginSuccess'){

                    window.location.href = "${APP_PATH}/index.jsp";
                }



            }
        });

    });



	</script>


</body>
</html>