package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.MBeanUserFone;

public class MBeanUserFoneDAOTest {

	@Test
	public <E> void getListUserFonetest() {
		ArrayList<MBeanUserFone> itens = new MBeanUserFoneDAO().getListUserFone(4L);
		for (MBeanUserFone item : itens) {
			System.out.println(item);
		}
	}

}
