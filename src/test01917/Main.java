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
		testRaavareDAO();
		testRaavareBatchDAO();
		testReceptDAO();
		testReceptKompDAO();

		System.out.println("\nAntal exceptions kastet: " + ec);
	}

	private static void testMySQLOperatorDAO() {
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();

		System.out.println("Operatoer nummer 3:");
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
		MySQLProduktBatchDAO pb = new MySQLProduktBatchDAO();

		System.out.println("Produkt batch nummer 3:");
		try { System.out.println(pb.getProduktBatch(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opretter nyt produkt batch med pb_id 6, status 2 og receptid 3");
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

		System.out.println("Henter produktbatch komponent");
		try { System.out.println(pbk.getProduktBatchKomp(1,4)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opretter ny produktbatch komponent");
		ProduktBatchKompDTO pbkd = new ProduktBatchKompDTO(5, 2, 0.5, 1.99, 2);
		try { pbk.createProduktBatchKomp(pbkd); }
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

	private static void testRaavareDAO () {
		MySQLRaavareDAO rad = new MySQLRaavareDAO();

		System.out.println("Raavare nummer 3:");
		try { System.out.println(rad.getRaavare(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Indsaettelse af ny Raavare");
		RaavareDTO radDTO = new RaavareDTO(4,"Ananas","Pen Pineapple ltd.");
		try { rad.createRaavare(radDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++;}

		System.out.println("Raavare nummer 4:");
		try { System.out.println(rad.getRaavare(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opdatering af leverandoer for raavare nummer 4");
		radDTO.setLeverandoer("Condiments by Satan");
		try { rad.updateRaavare(radDTO); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Raavare nummer 4:");
		try { System.out.println(rad.getRaavare(4)); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Alle Raavarer:");
		try { System.out.println(rad.getRaavareList()); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Raavare nummer 5:");
		try { System.out.println(rad.getRaavare(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}

	private static void testRaavareBatchDAO () {
		MySQLRaavareBatchDAO rabd = new MySQLRaavareBatchDAO();

		System.out.println("Raavare batch nummer 3:");
		try { System.out.println(rabd.getRaavareBatch(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opretter nyt raavare batch med rb_id 6, raavare id 2 og maengde 3");
		RaavareBatchDTO rbDTO = new RaavareBatchDTO(6,2,3);
		try { rabd.createRaavareBatch(rbDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Returner info fra raavarebatch med id = 2");
		try { System.out.println(rabd.getRaavareBatch(2)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opdaterer maengde på raavarebatch 6 til 5");
		rbDTO.setMaengde(4);
		try { rabd.updateRaavareBatch(rbDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Henter en liste af raavarebatches");
		try { System.out.println(rabd.getRaavareBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }
	}

	private static void testReceptDAO () {
		MySQLReceptDAO red = new MySQLReceptDAO();

		System.out.println("Recept nummer 3:");
		try { System.out.println(red.getRecept(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Indsaettelse af ny Recept");
		ReceptDTO redDTO = new ReceptDTO(4,"Hawaii");
		try { red.createRecept(redDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++;}

		System.out.println("Recept nummer 4:");
		try { System.out.println(red.getRecept(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opdatering af receptnavn for recept nummer 4");
		redDTO.setReceptNavn("Pizza med ananas");
		try { red.updateRecept(redDTO); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Recept nummer 4:");
		try { System.out.println(red.getRecept(4)); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Alle Recepter:");
		try { System.out.println(red.getReceptList()); }
		catch (DALException e) { System.out.println(e.getMessage());ec++; }

		System.out.println("Recept nummer 5:");
		try { System.out.println(red.getRecept(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}

	private static void testReceptKompDAO () {
		MySQLReceptKompDAO rekd = new MySQLReceptKompDAO();

		System.out.println("Henter recept komponent");
		try { System.out.println(rekd.getReceptKomp(1,4)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opretter ny recept komponent");
		ReceptKompDTO rekDTO = new ReceptKompDTO(1, 2, 6.0, 0.1);
		try { rekd.createReceptKomp(rekDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Henter liste over recept komponenter");
		try { System.out.println(rekd.getReceptKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Henter listen over recept komponenter med id 3");
		try { System.out.println(rekd.getReceptKompList(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }

		System.out.println("Opdaterer netto vaegt på recept komponent med recept id 1 til 4");
		rekDTO.setNomNetto(4);
		try { rekd.updateReceptKomp(rekDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); ec++; }
	}
}