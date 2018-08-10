package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(String name, String pass,HttpServletRequest request,HttpServletResponse response) throws Exception {

        try{
            User user = new User();
            user.setName(name);
            user.setPass(pass);
            User userRe = userService.selectByUser(user);

            System.out.println("user:" + userRe);
            String resultStr = "loginError";



            if (userRe != null) {
//                request.getRequestDispatcher("/index.jsp").forward(request,response);
//                response.sendRedirect(request.getContextPath() + "/index.jsp");
//                   return "index";
//                return new ModelAndView("redirect:/index.jsp");
                resultStr = "loginSuccess";
                request.getSession().setAttribute("user",user);
            }


//              return resultStr;
            return Msg.success().add("resultStr", resultStr);

        }catch (Exception e){

            System.out.println(e);
        }

        return null;

    }


}
