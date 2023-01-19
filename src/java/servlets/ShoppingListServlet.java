/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ericr
 */
public class ShoppingListServlet extends HttpServlet {


    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if(session != null){
        String username = (String)session.getAttribute("username");
        
        request.setAttribute("username", username);
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp" )
            .forward(request, response); 
        }
   
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp" )
                .forward(request, response);



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = (String)request.getAttribute("action");
        
        switch (action){
            case "register":
                HttpSession session = request.getSession();
                String username = request.getParameter("username");
                session.setAttribute("username", username);
                response.sendRedirect("/Week6Lab_ShoppingList/ShoppingList");
                break;
            case "add":
                
                break;                
            case "delete":
                break;                    
        }

        
        
    }



}
