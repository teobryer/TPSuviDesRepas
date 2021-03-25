package bll;

import bo.Aliment;
import bo.Repas;
import dal.DALException;
import dal.DAOFact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RepasManager implements IRepasManager{
    @Override
    public void ajouterUnRepas(Date date, String listeAliments) throws DALException {
       var test = listeAliments.toLowerCase().trim().split(",");
        ArrayList<Aliment> listeDesAliments = new ArrayList<>();
        for (var s : test ) {
            Aliment check = DAOFact.getAlimentDAO().checkByName(s);
            if(check == null){
               Aliment a =  DAOFact.getAlimentDAO().insert(new Aliment(-1, s.trim().toLowerCase()));
               listeDesAliments.add(a);
            }
            else{
                listeDesAliments.add(check);
            }

        }

       Repas repas =  new Repas(-1,date, listeDesAliments );
        DAOFact.getRepasDAO().insert(repas);
    }

    @Override
    public List<Repas> recupererTousLesRepas() throws DALException {
      return  DAOFact.getRepasDAO().selectAll();
    }
}
