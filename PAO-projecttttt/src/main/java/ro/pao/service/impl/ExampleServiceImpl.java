package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.ExampleClass;
import ro.pao.service.ExampleService;
import ro.pao.model.produse.*;
import ro.pao.model.cumparator.*;
import ro.pao.model.comanda.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@NoArgsConstructor
@Getter
public class ExampleServiceImpl implements ExampleService {

    /**
     * Atentie sa fie static. Daca nu o sa fie static, fiecare instanta va avea propria ei lista si astfel vor aparea probleme la apelarea metodelor.
     * Se poate inlocui si cu un Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();
     * Si astfel veti avea o performanta la operatii.
     *
     * Puteti folosi diverse structuri de date in functie de nevoi, tinand cont de complexitate.
     */
    private static List<ExampleClass> eggList = new ArrayList<>();
    // private static Map<UUID, ExampleClass> exampleClassHashMap = new HashMap<>();

    @Override
    public Optional<ExampleClass> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<ExampleClass> getBySomeFieldOfClass(Object someFieldFromExampleClass) {
        return Optional.empty();
    }

    @Override
    public List<ExampleClass> getAllFromList() {
        return eggList;
    }

    @Override
    public void addAllFromGivenList(List<ExampleClass> exampleClassList) {
        eggList.addAll(exampleClassList);
    }

    @Override
    public void addOnlyOne(ExampleClass exampleClass) {
        eggList.add(exampleClass);
    }

    @Override
    public void removeElementById(UUID id) {
        eggList = eggList.stream()
                .filter(element -> !id.equals(element.getId())) // filtrez elementele astfel incat elementul cautat sa nu fie id-ul dat
                // astfel, o sa avem o lista care nu contine elementul dat
                .collect(Collectors.toList()); // daca folosim .toList() se va crea o lista imutabila.
                // .collect(Collectors.toList()) face o lista mutabila
    }

    @Override
    public void modificaElementById(UUID id, ExampleClass newElement) {
        // sterg elementul dat si adaug altul
        removeElementById(id);
        addOnlyOne(newElement);
    }

    public static void main(String[] args) {
        Culegere myobj= new Culegere();
        Manual myobj1= new Manual();
        Carte mycarte = new Carte();
        mycarte.setAutor("Diana");
        mycarte.setPret(2);
        myobj.setPret(10);
        myobj1.setPret(5);
        ArrayList<Produs> cumparat = new ArrayList<>();
        cumparat.add(myobj);
        cumparat.add(myobj1);
        Cos trei = new Cos();
        trei.setProduse(myobj);
        trei.setProduse(myobj1);
        trei.setProduse(mycarte);
        trei.getProduse();
        System.out.println(trei.getProdusnr(0));
        System.out.println(trei.getProdusnr(1));
        System.out.println(trei.getProdusnr(2));
        //System.out.println(trei);
        Cos unu= new Cos();
        Cos doi= new Cos();
        unu.setTotal(myobj);
        unu.setTotal(myobj1);
        doi.setTotal(myobj);
        Cumparator cum= new Cumparator();
        Cumparator cum2= new Cumparator("a","b","c","d");
        System.out.println(cum);
        System.out.println(cum2);
        System.out.println(cum.getId());
        System.out.println(cum2.getId());
        // System.out.println(doi);
        // System.out.println(unu);
}
}
