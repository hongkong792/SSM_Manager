<!DOCTYPE HTML>
<html>
<head>
    <title>Purple_loginform Website Template | Home :: w3layouts</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript"
            src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- -->
    <script>var __links = document.querySelectorAll('a');

    function __linkClick(e) {
        parent.window.postMessage(this.href, '*');
    };
    for (var i = 0, l = __links.length; i < l; i++) {
        if (__links[i].getAttribute('data-t') == '_blank') {
            __links[i].addEventListener('click', __linkClick, false);
        }
    }</script>
    <script src="js/jquery.min.js"></script>
    <script>$(document).ready(function (c) {
        $('.alert-close').on('click', function (c) {
            $('.message').fadeOut('slow', function (c) {
                $('.message').remove();
            });
        });
    });

    function myFunction() {

     // 获取搜素框中的值，校验，提交
            var name = $("input[id='name']").val();
            var passwd = $("input[id='pass']").val();



            $.ajax({
                url: "${APP_PATH}/login",
                data: "name="+name+"&"+"pass="+passwd,
                type: "POST",
                success:function(result){

                    var empData = result.extend.resultStr;


                    if (empData == 'loginSuccess'){

                        window.location.href = "${APP_PATH}/sdkList.jsp";
                    }else{
                        alert(empData);
                    }



                    // window.location.href = "http://www.baidu.com";
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


            }
        });

    });



    </script>
</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>Login Form</h1>
            <div class="alert-close"></div>
        </div>
        <div class="loginForm">
            <li>
                <input type="text" class="text" id="name" value="Username" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'Username';}"><a href="#" class=" icon user"></a>
            </li>
            <div class="clear"></div>
            <li>
                <input type="password" id="pass" value="Password" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class="icon lock"></a>
            </li>
            <div class="clear"></div>
            <div class="submit">
                <input type="submit"  id="login" onclick="myFunction()" value="Sign in">
                <h4><a href="#">Lost your Password ?</a></h4>
                <div class="clear"></div>
            </div>

        </div>
    </div>
</div>
</div>
<div class="clear"></div>
<!--- footer --->
<div class="footer">
    <p>Copyright &copy; 2014.</p>
</div>


</body>
</html>