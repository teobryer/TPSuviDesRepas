package bll;

import bo.Repas;
import dal.DALException;

import java.util.Date;
import java.util.List;

public interface IRepasManager {
    void ajouterUnRepas(Date date, String listeAliments) throws DALException;

    List<Repas> recupererTousLesRepas() throws DALException;

}
