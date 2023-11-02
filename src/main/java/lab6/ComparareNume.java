package lab6;

public class ComparareNume {

    public int compare(Object o1, Object o2) {
        return (((Angajat)o1).getNume().compareToIgnoreCase(((Angajat) o2).getNume()));
    }
}
