package ro.mta.ip.lab4.tema3;

public class Student implements Human
{
    String nume;
    String prenume;
    String acronim;
    Integer varsta;
    Integer anStudiu;

    public Student(String nume, String prenume, String acronim, Integer varsta, Integer anStudiu)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.anStudiu = anStudiu;
    }

    public void greeting()
    {
        System.out.println("Buna ziua, eu sunt student!");

    };


    public void doWork()
    {


    };

    @Override
    public String toString() {
        return "Sd. " + nume + " " + prenume + ", Anul " + anStudiu + ", Fac. " + acronim + ", varsta " + varsta;

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

    public Integer getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(Integer anStudiu) {
        this.anStudiu = anStudiu;
    }

    public static void main(String[] args)
    {
        Student st = new Student("Andi","Andi","C", 22, 4);

        System.out.println(st.toString());
    }
}
