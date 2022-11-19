package br.com.unipar.flashcar.database.repository;

import br.com.unipar.flashcar.database.DatabaseConnection;
import br.com.unipar.flashcar.model.Cor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CorRepository {

    private String INSERT
            = "insert into COR(descricao) values(?);";
    private String UPDATE
            = "update COR set descricao = ? where id = ?;";
    private String DELETE
            = "delete COR where id = ?;";
    private String FIND_BY_ID
            = "select id, descricao from COR where ID = ?;";
    private String FIND_ALL
            = "select id, descricao from COR;";

    public void insert(Cor cor) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, cor.getDescricao());
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

    public ArrayList<Cor> findAll() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cor> listaResultado = new ArrayList<>();

        try {
            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {

                Cor cor = new Cor();
                cor.setDescricao(rs.getString("descricao"));
                cor.setId(rs.getInt(1));

                listaResultado.add(cor);
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

    public void delete(Cor cor) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, cor.getId());
            ps.execute();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(Cor cor) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, cor.getDescricao());
            ps.setInt(2, cor.getId());
            ps.execute();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public Cor findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cor resultado = new Cor();

        try {
            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                resultado.setDescricao(rs.getString("descricao"));
                resultado.setId(rs.getInt("id"));

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
        return resultado;
    }

}
