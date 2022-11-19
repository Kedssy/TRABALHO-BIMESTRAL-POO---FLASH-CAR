package br.com.unipar.flashcar.database.repository;

import br.com.unipar.flashcar.database.DatabaseConnection;
import br.com.unipar.flashcar.model.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarcaRepository {

    private String INSERT = "INSERT INTO MARCA(NOME) VALUES (?);";
    private String UPDATE = "UPDATE MARCA SET NOME = ? WHERE ID = ?;";
    private String DELETE = "DELETE MARCA WHERE ID = ?;";
    private String FIND_BY_ID = "SELECT ID, NOME FROM MARCA WHERE ID = ?;";
    private String FIND_ALL = "SELECT ID, NOME FROM MARCA;";

    public void insert(Marca marca) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, marca.getNome());
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

    public ArrayList<Marca> findAll() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Marca> listaResultado = new ArrayList<>();

        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setNome(rs.getString("nome"));
                marca.setId(rs.getInt(1));

                listaResultado.add(marca);
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

    public void delete(Marca marca) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, marca.getId());
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

    }
    
    public void update(Marca marca) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, marca.getNome());
            ps.setInt(2, marca.getId());
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

    }
    
    public Marca findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Marca resultado = new Marca();
                
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                resultado.setNome(rs.getString("nome"));
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
