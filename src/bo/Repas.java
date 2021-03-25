package bo;

import java.util.Date;
import java.util.List;

public class Repas {
    private int idRepas;
    private Date dateRepas;
    private List<Aliment> listeAliments;


    public Repas(int idRepas, Date dateRepas, List<Aliment> listeAliments) {
        this.idRepas = idRepas;
        this.dateRepas = dateRepas;
        this.listeAliments = listeAliments;
    }

    public int getIdRepas() {
        return idRepas;
    }

    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public Date getDateRepas() {
        return dateRepas;
    }

    public void setDateRepas(Date dateRepas) {
        this.dateRepas = dateRepas;
    }

    public List<Aliment> getListeAliments() {
        return listeAliments;
    }

    public void setListeAliments(List<Aliment> listeAliments) {
        this.listeAliments = listeAliments;
    }

    @Override
    public String toString() {
        return "Repas{" +
                "idRepas=" + idRepas +
                ", dateRepas=" + dateRepas +
                ", listeAliments=" + listeAliments +
                '}';
    }
}
