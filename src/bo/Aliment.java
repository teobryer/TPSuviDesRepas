package bo;

public class Aliment {
    private int idAliment;
    private String nomAliment;

    public Aliment(int idAliment, String nomAliment) {
        this.idAliment = idAliment;
        this.nomAliment = nomAliment;
    }

    public int getIdAliment() {
        return idAliment;
    }

    public void setIdAliment(int idAliment) {
        this.idAliment = idAliment;
    }

    public String getNomAliment() {
        return nomAliment;
    }

    public void setNomAliment(String nomAliment) {
        this.nomAliment = nomAliment;
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "idAliment=" + idAliment +
                ", nomAliment='" + nomAliment + '\'' +
                '}';
    }
}
