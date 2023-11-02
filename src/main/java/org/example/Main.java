package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) throws IOException {
        List<Angajat> angajati=citire();
        System.out.println(angajati);
        for(Angajat a:angajati){
            System.out.println(a);
        }
        angajati.add(new Angajat("Maria","developer", LocalDate.of(2021,03,21),2000));
        angajati.add(new Angajat("Ovidiu","manager", LocalDate.of(2019,07,02),5000));
        scriere(angajati);

        afis_salariu_peste2500(angajati, a->a.getSalariu()>2500);
    }

    public static void scriere(List<Angajat> lista) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        File file=new File("src/main/resources/angajati.json");
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.writeValue(file,lista);
    }

    public static List<Angajat> citire() throws IOException {
        File file=new File("src/main/resources/angajati.json");
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
        mapper.registerModule(new JavaTimeModule());
        return angajati;
    }

    public static void afis_salariu_peste2500(List<Angajat> angajati,Predicate<Angajat> f)
    {
        for(Angajat a:angajati)
            if(f.test(a))
                System.out.println(a);
    }
}