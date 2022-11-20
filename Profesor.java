package ro.mta.ip.lab4.tema3;

public class Profesor implements Human
{
    public static void main(String[] args) {
        Profesor prof = new Profesor("Gogu", "Mihail","C", 47, "fizica");
        System.out.println(prof.toString());
    }
    String nume;
    String prenume;
    String acronim;
    Integer varsta;
    String materie;

    public Profesor(String nume, String prenume, String acronim, Integer varsta, String materie)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.materie = materie;
    }
    public void greeting()
    {
        System.out.println("Salut, eu sunt Profesor!");

    };
    public void doWork()
    {


    };
    @Override
    public String toString()
    {
        return "Prof. " + nume + " " + prenume + ", Fac. " + acronim + ", varsta " + varsta + ", materie predata - " + materie;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public String getAcronim() {
        return acronim;
    }
    public void setAcronim(String acronim) {
        this.acronim = acronim;
    }
    public Integer getVarsta() {
        return varsta;
    }
    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }
    public String getMaterie() {
        return materie;
    }
    public void setMaterie(String materie) {
        this.materie = materie;
    }


}
