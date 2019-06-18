package dao;

import java.util.ArrayList;

import org.junit.Test;

import dao.UserCursoJavaDAO;
import model.UserCursoJava;

public class UserCursoJavaDAOTest {

    @Test
    public void saveUserTest() {
        final UserCursoJavaDAO userCursoJavaDAO = new UserCursoJavaDAO();
        final UserCursoJava userCursoJava = new UserCursoJava();

        userCursoJava.setNome("Giorgy");
        userCursoJava.setEmail("teste@email.com");
        userCursoJavaDAO.saveUser(userCursoJava);
    }

    @Test
    public void getListUserCursoJavaTest() {
        final UserCursoJavaDAO userDAO = new UserCursoJavaDAO();
        final ArrayList<UserCursoJava> list = userDAO.getListUserCursoJava();

        for (final UserCursoJava user : list) {
            System.out.println("---------------------");
            System.out.println(user.toString());
        }
    }

    @Test
    public void getUserCursoJavaTest() {
        final UserCursoJavaDAO userDAO = new UserCursoJavaDAO();
        final UserCursoJava user = userDAO.getUserCursoJava(2L);

        System.out.println("--------------------");
        System.out.println(user.toString());
    }

    @Test
    public void updateUserCursoJavaSQLTest() {
        final UserCursoJavaDAO userDAO = new UserCursoJavaDAO();
        userDAO.updateUserCursoJavaSQL(4L, "Update de INformação registro Quatro", "tas@tas.com");
    }

    @Test
    public void updateUserCursoJAvaTest() {
        final UserCursoJavaDAO userDAO = new UserCursoJavaDAO();

        final UserCursoJava user = userDAO.getUserCursoJava(1L);
        System.out.println(user.toString());

        user.setNome("Giorgy");
        userDAO.updateUserCursoJava(user);
        System.out.println(user.toString());
    }
}
