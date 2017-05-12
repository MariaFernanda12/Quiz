package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Artista;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2
 * Clase que permite la gestion de la tabla Depto en la base de datos.
 * 
 * CREATE TABLE Depto(
 *     id_depto integer,
 *     nom_depto varchar(40),
 *     PRIMARY KEY(id_depto)
 * );
 */
 

public class ArtistaDAO implements IBaseDatos<Artista> {

	/**
	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
	 * @return List<Departamento> Retorna la lista de Departamentos existentes en la base de datos
	 */
	public List<Artista> findAll() {
		List<Artista> artista= null;
	    String query = "SELECT * FROM artista";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int id =0;
	    String nombre = null;
	
	    while (rs.next()){
	    	if(artista == null){
	    		artista= new ArrayList<Artista>();
	    	}
	      
	        Artista registro= new Artista();
	        id = rs.getInt("artista_id");
	        registro.setId(id);
	        
	        nombre = rs.getString("artista_nombre");
	        registro.setNombre(nombre) ;
	        
	        artista.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Departamentos");
			e.printStackTrace();
		}
	    
	    return artista;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(Artista t) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into Artista (artista_id,artista_usuario,artista_nombre,artista_apellido,artista_origen,artista_curriculum,artista_distincion,artista_domicialiado)"  + " values (?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, t.getId());
                        preparedStmt.setString (2, t.getUsuario());
                        preparedStmt.setString (3, t.getNombre());
                        preparedStmt.setString (4, t.getApellido());
                        preparedStmt.setString (5, t.getOrigen());
                        preparedStmt.setString (6, t.getCurriculum());
                        preparedStmt.setString (7, t.getDistincion());
                        preparedStmt.setString (8, t.getUsuario());
                        preparedStmt.setString (9, t.getDomicialiado());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
	 */
	 
}
