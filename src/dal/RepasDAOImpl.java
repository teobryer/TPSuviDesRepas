package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.stream.Collectors;

import bo.Aliment;
import bo.Repas;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RepasDAOImpl implements DAO<Repas> {

    private final String SELECT_BY_ID = "USE SuiviRepas SELECT * FROM Repas WHERE idRepas=?";
    private final String SELECT_ALL = "USE SuiviRepas SELECT * FROM Repas";
    private final String UPDATE = "USE SuiviRepas UPDATE Repas SET nom = ? ,idRepas = ? ,dateRepas = ? ,listeAliment = ? WHERE idRepas = ?";
    private final String INSERT = "USE SuiviRepas INSERT INTO Repas ( dateRepas, listeAliment) VALUES (?,?)";
    private final String DELETE = "USE SuiviRepas DELETE FROM Repas WHERE idRepas= ?";

    private Connection connect() {
        try {
            // Je vais chercher le fichier context.xml
            Context context = new InitialContext();
            // Je vais lire le fichier context.xml
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            // J'ouvre une connection
            Connection cnx = ds.getConnection();
            return cnx;
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Repas selectById(int id) throws DALException {
        Repas repas = null;
        try  {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // TODO : ajouter la gestion de l'idCar dans la BO et le rÃ©cupÃ©rer ici
                // gitignore

                int idRepas = rs.getInt("idRepas");

                Date dateRepas = rs.getDate("dateRepas");
                ArrayList<String> listeIdAlimentsString= new Gson().fromJson(rs.getString("listeAliment"),
                        new TypeToken<ArrayList<String>>() {
                        }.getType());
                ArrayList<Integer> listeIdAliments = new ArrayList<Integer>() ;
                for (String s: listeIdAlimentsString) {
                    listeIdAliments.add(Integer.parseInt(s));
                }
                ArrayList<Aliment> alimentArrayList = new ArrayList<Aliment>();
                for (int i: listeIdAliments) {
                    alimentArrayList.add(DAOFact.getAlimentDAO().selectById(i));
                }


                repas = new Repas(idRepas, dateRepas, alimentArrayList);

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'un repas");
        }
        return repas;
    }

    @Override
    public List<Repas> selectAll() throws DALException {
        List<Repas> listRepas = new ArrayList<Repas>();
        try  {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idRepas = rs.getInt("idRepas");
                Date dateRepas = rs.getDate("dateRepas");
                ArrayList<Integer> listeIdAliments= new Gson().fromJson(rs.getString("listeAliment"),
                        new TypeToken<ArrayList<Integer>>() {
                        }.getType());

                ArrayList<Aliment> alimentArrayList = new ArrayList<Aliment>();
                for (int i: listeIdAliments) {
                    alimentArrayList.add(DAOFact.getAlimentDAO().selectById(i));
                }

                listRepas.add(new Repas(idRepas, dateRepas, alimentArrayList));

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la sélection d'un repas");
        }
        return listRepas;
    }

    @Override
    public void update(Repas r) throws DALException {
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(UPDATE);

            stmt.setInt(1, r.getIdRepas());

            stmt.setObject(2, r.getDateRepas());
            stmt.setString(3,new Gson().toJson( r.getListeAliments()));

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la mise à jour d'un repas");
        }

    }

    @Override
    public Repas insert(Repas r) throws DALException {

        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

          var date =   r.getDateRepas().getTime();
            stmt.setTimestamp(1,  new java.sql.Timestamp(date) );
            stmt.setString(2,new Gson().toJson( r.getListeAliments().stream().map(Aliment::getIdAliment).collect(Collectors.toList())));

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            r.setIdRepas(generatedKey);
            System.out.println(generatedKey);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans l'insertion d'un repas");
        }
        return  r;
    }

    @Override
    public void delete(int id) throws DALException {
        try {
            Connection cnx = connect();
            PreparedStatement stmt = cnx.prepareStatement(DELETE);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("Problème dans la suppression d'un repas");

        }

    }

    @Override
    public Repas checkByName(String name) throws DALException {
        return null;
    }

}