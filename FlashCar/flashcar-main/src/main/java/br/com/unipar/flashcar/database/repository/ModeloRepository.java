package br.com.unipar.flashcar.database.repository;

import br.com.unipar.flashcar.database.DatabaseConnection;
import br.com.unipar.flashcar.model.Marca;
import br.com.unipar.flashcar.model.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloRepository {
    private String INSERT = "INSERT INTO MODELO(DESCRICAO, ID_MARCA) VALUES (?, ?);";
    private String UPDATE = "UPDATE MODELO SET DESCRICAO = ?, ID_MARCA = ? WHERE ID = ?;";
    private String DELETE = "DELETE MODELO WHERE ID = ?;";
    private String FIND_BY_ID = "SELECT ID, DESCRICAO, ID_MARCA FROM MODELO WHERE ID = ?;";
    private String FIND_ALL = "SELECT ID, DESCRICAO, ID_MARCA FROM MODELO;";

    public void insert(Modelo modelo) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, modelo.getDescricao());
            ps.setInt(2, modelo.getIdMarca());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public ArrayList<Modelo> findAll() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Modelo> listaResultado = new ArrayList<>();

        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setDescricao(rs.getString("descricao"));
                modelo.setIdMarca(rs.getInt("id_marca"));
                modelo.setId(rs.getInt(1));

                listaResultado.add(modelo);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return listaResultado;
    }

    public void delete(Modelo modelo) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, modelo.getId());
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

    }
    
    public void update(Modelo modelo) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, modelo.getDescricao());
            ps.setInt(2, modelo.getIdMarca());
            ps.setInt(3, modelo.getId());
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

    }
    
    public Modelo findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Modelo resultado = new Modelo();
                
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                resultado.setDescricao(rs.getString("descricao"));
                resultado.setIdMarca(rs.getInt("id_marca"));
                resultado.setId(rs.getInt("id"));
                
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return resultado;

    }
}
