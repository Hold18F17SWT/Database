package test01917;

import daoimpl01917.*;
import daointerfaces01917.DALException;
import dto01917.*;

import java.sql.SQLException;

import connector01917.Connector;

public class Main {
	private static int ec =0; //Exceptions thrown counter
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		testMySQLOperatorDAO();
		testMySQLProduktBatchDAO();
		testProduktBatchKompDAO();
		testRaavareBatchDAO();
		testRaavareDAO();
		testReceptDAO();
		testReceptKompDAO();

		System.out.println("\nAntal exceptions kastet: " + ec);
	}

	private static void testMySQLOperatorDAO() {
		System.out.println("Operatoer nummer 3:");
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		try { System.out.println(opr.getOperatoer(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Indsaettelse af ny operatoer");
		OperatoerDTO oprDTO = new OperatoerDTO(4,"Don Juan","DJ","000000-0000","iloveyou");
		try { opr.createOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++;}

		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opdatering af initialer for operatoer nummer 4");
		oprDTO.setIni("DoJu");
		try { opr.updateOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Alle operatoerer:");
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Operatoer nummer 5:");
		try { System.out.println(opr.getOperatoer(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}

	private static void testMySQLProduktBatchDAO() {
		System.out.println("Produkt batch nummer 3:");
		MySQLProduktBatchDAO pb = new MySQLProduktBatchDAO();
		try { System.out.println(pb.getProduktBatch(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Indsaettelse af nyt produkt batch med pb_id 6, status 2 og receptid 3");
		ProduktBatchDTO pbDTO = new ProduktBatchDTO(6,2,3);
		try { pb.createProduktBatch(pbDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Returner info fra produktbatch med id = 2");
		try { System.out.println(pb.getProduktBatch(2)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opdaterer status på produktbatch 6 til 1");
		pbDTO.setStatus(1);
		try { pb.updateProduktBatch(pbDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Henter en liste af produktbatches");
		try { System.out.println(pb.getProduktBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }
	}

	private static void testProduktBatchKompDAO () {
		MySQLProduktBatchKompDAO pbk = new MySQLProduktBatchKompDAO();

		System.out.println("Opretter ny produktbatch komponent");
		ProduktBatchKompDTO pbkd = new ProduktBatchKompDTO(5, 2, 0.5, 1.99, 2);
		try { pbk.createProduktBatchKomp(pbkd); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Henter produktbatch komponent");
		try { System.out.println(pbk.getProduktBatchKomp(1,4)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Henter liste over produktbatch komponenter");
		try { System.out.println(pbk.getProduktBatchKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Henter listen over produktbatch komponenter med id 3");
		try { System.out.println(pbk.getProduktBatchKompList(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opdaterer operator ID på produktbatch komponent 5 til 4");
		pbkd.setOprId(4);
		try { pbk.updateProduktBatchKomp(pbkd); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }
	}

	private static void testRaavareBatchDAO () {
		MySQLRaavareBatchDAO rabd = new MySQLRaavareBatchDAO();

	}

	private static void testRaavareDAO () {
		MySQLRaavareDAO rad = new MySQLRaavareDAO();

	}

	private static void testReceptDAO () {
		MySQLReceptDAO red = new MySQLReceptDAO();

	}

	private static void testReceptKompDAO () {
		MySQLReceptKompDAO rekd = new MySQLReceptKompDAO();

	}
}