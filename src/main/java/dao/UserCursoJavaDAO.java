package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.UserCursoJava;
import singleconnections.SingleConnectionsJDBC;

public class UserCursoJavaDAO {

    private static Connection connection;

    public UserCursoJavaDAO() {
        connection = SingleConnectionsJDBC.getConnection();
    }

    public void saveUser(final UserCursoJava user) {
        final String sql = "insert into usercursojava (name, email) values (?,?)";
        PreparedStatement insert;

        try {
            insert = connection.prepareStatement(sql);
            insert.setString(1, user.getNome());
            insert.setString(2, user.getEmail());
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

    public ArrayList<UserCursoJava> getListUserCursoJava() {
        final ArrayList<UserCursoJava> listUser = new ArrayList<UserCursoJava>();
        final String sql = "select * from usercursojava";
        PreparedStatement select;
        ResultSet response;
        try {
            select = connection.prepareStatement(sql);
            response = select.executeQuery();

            while (response.next()) {
                final UserCursoJava user = new UserCursoJava();
                user.setId(response.getLong("id"));
                user.setNome(response.getString("name"));
                user.setNome(response.getString("name"));
                listUser.add(user);

            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public static UserCursoJava getUserCursoJava(final Long id) {
        final UserCursoJava user = new UserCursoJava();
        final String sql = "select * from usercursojava where id=" + id;
        PreparedStatement select;
        ResultSet response;
        try {
            select = connection.prepareStatement(sql);
            response = select.executeQuery();

            while (response.next()) {

                user.setId(response.getLong("id"));
                user.setNome(response.getString("name"));
                user.setNome(response.getString("name"));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUserCursoJavaSQL(final Long id, final String nome, final String email) {
        final String sql = "UPDATE usercursojava SET name=?, email=? WHERE id=?";
        PreparedStatement update;

        try {
            update = connection.prepareStatement(sql);
            update.setString(1, nome);
            update.setString(2, email);
            update.setLong(3, id);
            update.execute();
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

    public void updateUserCursoJava(final UserCursoJava user) {

        final String sql = "UPDATE usercursojava SET name=?, email=? WHERE id=?";
        PreparedStatement update;

        try {
            update = connection.prepareStatement(sql);
            update.setString(1, user.getNome());
            update.setString(2, user.getEmail());
            update.setLong(3, user.getId());
            update.execute();
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

    public void deleteUserCursoJava(final Long id) {
        final String sql = "delete from usercursojava where id=" + id;
        PreparedStatement select;

        try {
            select = connection.prepareStatement(sql);
            select.executeQuery();
            connection.commit();
        } catch (final Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
