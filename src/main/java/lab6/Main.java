package lab6;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;




public class Main {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/angajati.json");
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire() throws IOException {


            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return angajati;


    }
//    public static void ordonare(List<Angajat> angajati)
//    {
//        System.out.println("----Ordonare nume, varianta 1---");
//        Collections.sort(angajati, new ComparareNume());
//        System.out.println(angajati);
//    }
//
//    public static void cautare_sef(List<Angajat> angajati, String post) {
//        int x=Collections.binarySearch(angajati, new Angajat(post),
//                (a,b)->a.getNume().compareToIgnoreCase(b.getNume()));
//        if (x>=0)
//            System.out.println(post+" gasita pe pozitia "+x);
//        else
//            System.out.println(post+" nu a fost gasita");
//    }
//}

    public static void main(String[] args) throws IOException {

//        List<Angajat> angajati=new ArrayList<>();
//        angajati.add(new Angajat("Maria","profesor", LocalDate.of(2021,03,21),2500));
//        angajati.add(new Angajat("Bogdan","developer", LocalDate.of(2019,05,23),6500));
//        scriere(angajati);


        List<Angajat> angajati=citire();
        System.out.println(angajati);
        angajati.forEach(System.out::println);
    }

}
