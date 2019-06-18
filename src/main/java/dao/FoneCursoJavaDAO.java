package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.FoneCursoJava;
import singleconnections.SingleConnectionsJDBC;

public class FoneCursoJavaDAO {

    private static Connection connection;

    public FoneCursoJavaDAO() {
        connection = SingleConnectionsJDBC.getConnection();
    }

    public void saveFone(final FoneCursoJava fone) {
        final String sql = "insert into fonecursojava (number, type, user_id) values (?,?,?)";
        PreparedStatement insert;

        try {
            insert = connection.prepareStatement(sql);
            insert.setString(1, fone.getType());
            insert.setString(2, fone.getNumber());
            insert.setLong(3, fone.getUserUID());
            insert.execute();
            connection.commit();
        } catch (final SQLException e) {
            try {
                connection.rollback();
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public static ArrayList<FoneCursoJava> getListFoneCursoJava() {
        final ArrayList<FoneCursoJava> listFone = new ArrayList<FoneCursoJava>();
        final String sql = "select * from fonecursojava";
        PreparedStatement select;
        ResultSet response;
        try {
            select = connection.prepareStatement(sql);
            response = select.executeQuery();

            while (response.next()) {
                final FoneCursoJava fone = new FoneCursoJava();
                fone.setId(response.getLong("id"));
                fone.setNumber(response.getString("number"));
                fone.setType(response.getString("type"));
                fone.setUserUID(response.getLong("user_id"));
                listFone.add(fone);

            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return listFone;
    }

    public FoneCursoJava getFoneCursoJava(final Long id) {
        final FoneCursoJava fone = new FoneCursoJava();
        final String sql = "select * from fonecursojava where id=" + id;
        PreparedStatement select;
        ResultSet response;
        try {
            select = connection.prepareStatement(sql);
            response = select.executeQuery();

            while (response.next()) {
                fone.setId(response.getLong("id"));
                fone.setNumber(response.getString("number"));
                fone.setType(response.getString("type"));
                fone.setUserUID(response.getLong("user_id"));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return fone;
    }

    // public void updateUserCursoJavaSQL(final Long id, final String nome, final String email) {
    // final String sql = "UPDATE usercursojava SET name=?, email=? WHERE id=?";
    // PreparedStatement update;
    //
    // try {
    // update = connection.prepareStatement(sql);
    // update.setString(1, nome);
    // update.setString(2, email);
    // update.setLong(3, id);
    // update.execute();
    // connection.commit();
    //
    // } catch (final SQLException e) {
    // try {
    // connection.rollback();
    // } catch (final SQLException e1) {
    // e1.printStackTrace();
    // }
    // e.printStackTrace();
    // }
    // }
    //
    // public void updateUserCursoJava(final UserCursoJava user) {
    //
    // final String sql = "UPDATE usercursojava SET name=?, email=? WHERE id=?";
    // PreparedStatement update;
    //
    // try {
    // update = connection.prepareStatement(sql);
    // update.setString(1, user.getNome());
    // update.setString(2, user.getEmail());
    // update.setLong(3, user.getId());
    // update.execute();
    // connection.commit();
    //
    // } catch (final SQLException e) {
    // try {
    // connection.rollback();
    // } catch (final SQLException e1) {
    // e1.printStackTrace();
    // }
    // e.printStackTrace();
    // }
    // }
    //
    // public void deleteUserCursoJava(final Long id) {
    // final String sql = "delete from usercursojava where id=" + id;
    // PreparedStatement select;
    // try {
    // select = connection.prepareStatement(sql);
    // select.executeQuery();
    // } catch (final SQLException e) {
    // e.printStackTrace();
    // }
    // }

}
