package singleconnectionsjdbc;

import static org.junit.Assert.*;

import org.junit.Test;

import singleconnections.SingleConnectionsJDBC;
 
public class SingleConnectionsJDBCTest {

	@Test
	public void testSingleConnectionsJDBC() {
		SingleConnectionsJDBC.connect();
	}
	

}
