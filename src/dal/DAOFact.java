package dal;

import bo.Aliment;
import bo.Repas;

public class DAOFact {
	public static DAO<Aliment> getAlimentDAO() {
		return new AlimentDAOImpl();
	}
	
	
	public static DAO<Repas> getRepasDAO() {
		return new RepasDAOImpl();
	}
	

}
