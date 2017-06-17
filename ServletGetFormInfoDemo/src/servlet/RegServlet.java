package servlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by localhost on 17-6-14.
 */

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        Users u = new Users();
        String username,mypassword,gender,email,introduce,isAccept;
        Date birthday;
        String[] favorites;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        try {
            username = request.getParameter("username");
            mypassword = request.getParameter("mypassword");
            gender = request.getParameter("gender");
            email = request.getParameter("email");
            introduce = request.getParameter("introduce");
            birthday = sdf.parse(request.getParameter("birthday"));
            //用来获得多个复选按钮的值
            favorites = request.getParameterValues("favorite");
            if (request.getParameter("isAccept")!=null) {
                isAccept = request.getParameter("isAccept");
            }
            else {
                isAccept = "false";
            }
            u.setUsername(username);
            u.setMypassword(mypassword);
            u.setGender(gender);
            u.setEmail(email);
            u.setIntroduce(introduce);
            u.setBirthday(birthday);
            u.setFavorites(favorites);
            if(isAccept.equals("true")){
                u.setFlag(true);
            }
            else {
                u.setFlag(false);
            }

            //把注册成功的用户保存在session当中
            request.getSession().setAttribute("regUser",u);

            //跳转到注册成功页面
            request.getRequestDispatcher("../userinfo.jsp").forward(request,response);



        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
