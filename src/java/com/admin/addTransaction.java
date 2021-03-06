/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.db.DataBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ashik
 */
@WebServlet(name = "addTransaction", urlPatterns = {"/addTransaction"})
public class addTransaction extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataBase db = new DataBase();
        String dist_id = request.getParameter("distributorId");
        StringTokenizer st = new StringTokenizer(dist_id);
        String distributor_id = st.nextToken();
        String book_id = request.getParameter("bookId");
        st = new StringTokenizer(book_id);
        String bkId = st.nextToken();
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        int i = db.addTransaction(distributor_id, bkId, quantity, price);
        if(i==1){
            response.sendRedirect("adminSuccess.jsp");
        }
        else{
            response.sendRedirect("adminFail.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
