package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.ArtistaDAO;
import edu.co.sergio.mundo.vo.Artista;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        ArtistaDAO dao = new ArtistaDAO();
        
        Artista artista = new Artista();
        artista.setId(Integer.parseInt(id));
        artista.setNombre(nombre);
        dao.insert(artista);
        
        //Listando la informacion  
        List<Artista> a =  dao.findAll();
        request.setAttribute("artista", artista);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        }
}
