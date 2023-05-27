package ro.pao;

import ro.pao.application.Menu;
import ro.pao.exceptions.generic.Alreadythere;
import ro.pao.exceptions.generic.Inputincorect;
import ro.pao.exceptions.sameproducttwice;
import ro.pao.exceptions.wrongcomandaimput;
import ro.pao.model.comanda.Cos;
import ro.pao.model.comanda.generics.cossicump;
import ro.pao.model.cumparator.Client;
import ro.pao.model.cumparator.Firma;
import ro.pao.model.designpatterndecorator.Arepret;
import ro.pao.model.designpatterndecorator.Discount;
import ro.pao.model.produse.Carte;
import ro.pao.model.produse.Culegere;
import ro.pao.model.produse.Manual;
import ro.pao.service.impl.ClientService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            Menu menu = Menu.getInstance();
//
//            menu.intro();
//
//            if ("exit".equals(scanner.next())) {
//                break;
//            }
//        }

        //       testare clase:

        Culegere myobj = new Culegere();
        Manual myobj1 = new Manual();
        Carte mycarte = new Carte();
        mycarte.setAutor("Diana");
        mycarte.setPret(2);
        myobj.setPret(10);
        myobj1.setPret(5);
        Cos trei = new Cos();
        trei.setProduse(myobj);
        trei.setProduse(myobj1);
        trei.setProduse(mycarte);
        //trei.getProduse();
        Carte mycarte2 = new Carte("Calin", "Cash", "bine pe cash", "da", "paralela", 20);
        trei.setProduse(mycarte2);
//        System.out.println(trei.getProdusnr(0));
//        System.out.println(trei.getProdusnr(1));
//        System.out.println(trei.getProdusnr(2));
//        System.out.println(trei.getProdusnr(3));
//        System.out.println(mycarte2);
        //System.out.println(trei);
        Cos unu = new Cos();
        Cos doi = new Cos();
        unu.setProduse(myobj);
        unu.setProduse(myobj1);
        doi.setProduse(myobj);
        Client cum = new Client();
        Firma f = new Firma(1234, "da");
        Client cum2 = new Client("a", "b", "c", "d");
        cossicump c = new cossicump(unu, cum2);
        cossicump c2 = new cossicump(trei, f);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        Inputincorect w = new Inputincorect<>();
        try {

            w.checkEligibility(trei);
        } catch (wrongcomandaimput exception) {
            System.out.println("We found an exception:");


            System.out.println(exception);

        }
        String nm="da",au="Calin",ed="paralela";


        Alreadythere a = new Alreadythere();
        try {
            // call method checkEligibility() to check whether the user is eligible for exam or not
            a.checkEligibility(nm,au,ed,unu.getCump());
        } catch (sameproducttwice exception) {
            System.out.println("We found an exception:");


            System.out.println(exception);

        }

        Arepret carte= new Carte("Diana", "frumos","foarte", "Poezie","buna",10);
        Carte al =new Carte("iana", "frum","arte", "Poe","buna",20);
        Arepret discCarte = new Discount(al, al.getPret());

        carte.disc(0.3);
        discCarte.disc(0.2);

        ClientService clientService = new ClientService();

//        // Create a new client
//        Client client1 = new Client();
//        client1.setPrnume("Joh");
//        client1.setEmail("jo.doe@example.com");
//        client1.setAdresa("Main St");
//        client1.setTelefon("1234");
//        clientService.createClient(client1);
//        System.out.println("Client created successfully.");

        // Retrieve a client by ID
        int clientId = 3;
        Client retrievedClient = clientService.getClientById(clientId);
        if (retrievedClient != null) {
            System.out.println("Retrieved client with ID " + clientId + ":");
            System.out.println(retrievedClient);
        } else {
            System.out.println("Client not found with ID " + clientId);
        }

        // Update the retrieved client's information
        if (retrievedClient != null) {
            retrievedClient.setPrnume("Janet Smith");
            retrievedClient.setEmail("janet.smith@example.com");
            retrievedClient.setAdresa("456778 Elm St");
            retrievedClient.setTelefon("1111");
            clientService.updateClient(retrievedClient);
            System.out.println("Client updated successfully.");
        }

        // Retrieve the previous client by ID to see the change
        if (retrievedClient != null) {
            System.out.println("Retrieved client with ID " + clientId + ":");
            System.out.println(retrievedClient);
        } else {
            System.out.println("Client not found with ID " + clientId);
        }

        // Delete a client
        int deleteClientId = 9;
        boolean deleted = clientService.deleteClient(deleteClientId);
        if (deleted) {
            System.out.println("Client with ID " + deleteClientId + " deleted successfully.");
        } else {
            System.out.println("Failed to delete client with ID " + deleteClientId);
        }


        // cossicump c4 = new cossicump(trei,unu); //eroare pt ca am pus sealed pt valoarea generica sa accepte doar cumparatori,
        //altfel afisa cele 2 cosuri
        // System.out.println(f);
        //System.out.println(c);
        //System.out.println(c2);
        // if(f.getClass().equals(Firma.class))
        // System.out.println("da");
        //System.out.println(c4);
//        System.out.println(cum);
//         System.out.println(cum2);
//        System.out.println(cum.getId());
//        System.out.println(cum2.getId());
        // System.out.println(doi);
        // System.out.println(unu);
    }
}

