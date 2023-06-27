package ro.pao;

import ro.pao.application.csv.ClientActionLogger;
import ro.pao.exceptions.generic.Alreadythere;
import ro.pao.exceptions.generic.Inputincorect;
import ro.pao.exceptions.sameproducttwice;
import ro.pao.exceptions.wrongcomandaimput;
import ro.pao.model.comanda.Cos;
import ro.pao.model.comanda.generics.cossicump;
import ro.pao.model.comanda.generics.cossicumpbd;
import ro.pao.model.cumparator.Client;
import ro.pao.model.cumparator.Firma;
import ro.pao.model.designpatterndecorator.Arepret;
import ro.pao.model.designpatterndecorator.Discount;
import ro.pao.model.produse.Carte;
import ro.pao.model.produse.Culegere;
import ro.pao.model.produse.Manual;
import ro.pao.service.impl.CarteService;
import ro.pao.service.impl.ClientService;
import ro.pao.service.impl.CosService;
import ro.pao.service.impl.CossicumpbdService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ro.pao.application.csv.ClientActionLogger;
import ro.pao.exceptions.generic.Alreadythere;
import ro.pao.exceptions.generic.Inputincorect;
import ro.pao.exceptions.sameproducttwice;
import ro.pao.exceptions.wrongcomandaimput;
import ro.pao.model.comanda.Cos;
import ro.pao.model.comanda.generics.cossicump;
import ro.pao.model.comanda.generics.cossicumpbd;
import ro.pao.model.cumparator.Client;
import ro.pao.model.cumparator.Firma;
import ro.pao.model.designpatterndecorator.Arepret;
import ro.pao.model.designpatterndecorator.Discount;
import ro.pao.model.produse.Carte;
import ro.pao.model.produse.Culegere;
import ro.pao.model.produse.Manual;
import ro.pao.service.impl.CarteService;
import ro.pao.service.impl.ClientService;
import ro.pao.service.impl.CosService;
import ro.pao.service.impl.CossicumpbdService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ClientActionLogger cl = new ClientActionLogger();
        cl.initializeLogFile();
        ClientService clientService = new ClientService();
        CarteService produsService = new CarteService();
        CosService cosService = new CosService();
        CossicumpbdService cossicumpbdService = new CossicumpbdService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Actions Menu:");
            System.out.println("1. Create a client");
            System.out.println("2. Retrieve a client by ID");
            System.out.println("3. Update a client");
            System.out.println("4. See a cute text");
            System.out.println("5. Create a produs");
            System.out.println("6. Update a produs");
            System.out.println("7. Delete a produs");
            System.out.println("8. Create a cos si comanda asociata");
            System.out.println("9. Retrieve a cossicumpbd si cosul ei by ID");
            System.out.println("10. Get all cossicumpbd");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createClient(clientService, scanner);
                    break;
                case 2:
                    retrieveClientById(clientService, scanner);
                    break;
                case 3:
                    updateClient(clientService, scanner);
                    break;
                case 4:
                    System.out.print("You got this!");
                    break;
                case 5:
                    createProdus(produsService, cosService, scanner);
                    break;
                case 6:
                    updateProdus(produsService, scanner);
                    break;
                case 7:
                    deleteProdus(produsService, scanner);
                    break;
                case 8:
                    createCossicumpbd(cossicumpbdService, scanner);
                    break;
                case 9:
                    retrieveCossicumpbdById(cossicumpbdService,cosService, scanner);
                    break;
                case 10:
                    getAllCossicumpbd(cossicumpbdService,cosService);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void createClient(ClientService clientService, Scanner scanner) {
        System.out.print("Enter client first name: ");
        String firstName = scanner.next();

        System.out.print("Enter client email: ");
        String email = scanner.next();

        System.out.print("Enter client address: ");
        String address = scanner.next();

        System.out.print("Enter client phone number: ");
        String phoneNumber = scanner.next();

        Client client = new Client();
        client.setPrnume(firstName);
        client.setEmail(email);
        client.setAdresa(address);
        client.setTelefon(phoneNumber);

        clientService.createClient(client);
        System.out.println("Client created successfully.");
    }

    private static void retrieveClientById(ClientService clientService, Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();

        Client retrievedClient = clientService.getClientById(clientId);
        if (retrievedClient != null) {
            System.out.println("Retrieved client with ID " + clientId + ":");
            System.out.println(retrievedClient);
        } else {
            System.out.println("Client not found with ID " + clientId);
        }
    }

    private static void updateClient(ClientService clientService, Scanner scanner) {
        System.out.print("Enter client ID to update: ");
        int clientId = scanner.nextInt();

        Client retrievedClient = clientService.getClientById(clientId);
        if (retrievedClient != null) {
            System.out.print("Enter updated first name: ");
            String firstName = scanner.next();

            System.out.print("Enter updated email: ");
            String email = scanner.next();

            System.out.print("Enter updated address: ");
            String address = scanner.next();

            System.out.print("Enter updated phone number: ");
            String phoneNumber = scanner.next();

            retrievedClient.setPrnume(firstName);
            retrievedClient.setEmail(email);
            retrievedClient.setAdresa(address);
            retrievedClient.setTelefon(phoneNumber);

            clientService.updateClient(retrievedClient);
            System.out.println("Client updated successfully.");
        } else {
            System.out.println("Client not found with ID " + clientId);
        }
    }

    private static void deleteClient(ClientService clientService, Scanner scanner) {
        System.out.print("Enter client ID to delete: ");
        int clientId = scanner.nextInt();

        boolean deleted = clientService.deleteClient(clientId);
        if (deleted) {
            System.out.println("Client with ID " + clientId + " deleted successfully.");
        } else {
            System.out.println("Failed to delete client with ID " + clientId);
        }
    }

    private static void createProdus(CarteService produsService, CosService cosService, Scanner scanner) {
        System.out.print("Enter produs name: ");
        String name = scanner.next();

        System.out.print("Enter produs author: ");
        String author = scanner.next();

        System.out.print("Enter produs sect: ");
        String sct = scanner.next();

        System.out.print("Enter produs sub-sect: ");
        String sbsct = scanner.next();

        System.out.print("Enter produs publisher: ");
        String publisher = scanner.next();

        System.out.print("Enter produs pret: ");
        Double pret = Double.parseDouble(scanner.next());

        Carte produs = new Carte();
        produs.setNume(name);
        produs.setAutor(author);
        produs.setSect(sct);
        produs.setSubsect(sbsct);
        produs.setEditura(publisher);
        produs.setPret(pret);
        produs.setCosid(-1);
        produs.getCosid();
        produsService.createProdus(produs);
        System.out.println("Produs created successfully.");
    }

    private static void updateProdus(CarteService produsService, Scanner scanner) {
        System.out.print("Enter produs ID to update: ");
        int produsId = scanner.nextInt();

        Carte produsToUpdate = produsService.getProdusById(produsId);
        if (produsToUpdate != null) {
            System.out.print("Enter updated price: ");
            double price = scanner.nextDouble();

            produsToUpdate.setPret(price);

            produsService.updateProdus(produsToUpdate);
            System.out.println("Produs updated successfully.");
        } else {
            System.out.println("Produs not found with ID " + produsId);
        }
    }

    private static void deleteProdus(CarteService produsService, Scanner scanner) {
        System.out.print("Enter produs ID to delete: ");
        int produsId = scanner.nextInt();

        boolean deleted = produsService.deleteProdus(produsId);
        if (deleted) {
            System.out.println("Produs with ID " + produsId + " deleted successfully.");
        } else {
            System.out.println("Failed to delete produs with ID " + produsId);
        }
    }

    private static void createCossicumpbd(CossicumpbdService cossicumpbdService, Scanner scanner) {
        System.out.print("Enter cumparator ID: ");
        int cumparatorId = scanner.nextInt();
        double s=0;
        CosService cosService = new CosService();
         int cosId = cosService.createCos();
        System.out.print("Enter cate produse vrei sa adaugi in cos ");
        int n = scanner.nextInt();
         while(n>0) {
             System.out.print("Enter price of produs u want in cos: ");
             double pr = scanner.nextDouble();
             s= s+pr;
            cosService.updateCosTotal(cosId,s);
             n--;
         }
        int cossicumpbdId = cossicumpbdService.createCossicumpbd(cumparatorId, cosId);
        System.out.println("Cossicumpbd created successfully with ID: " + cossicumpbdId);
    }
    private static void retrieveCossicumpbdById(CossicumpbdService cossicumpbdService, CosService cosService, Scanner scanner) {
        System.out.print("Enter cossicumpbd ID: ");
        int cossicumpbdId = scanner.nextInt();

        cossicumpbd retrievedCossicumpbd = cossicumpbdService.getCossicumpbdById(cossicumpbdId);
        if (retrievedCossicumpbd != null) {
            System.out.println("Retrieved cossicumpbd with ID " + cossicumpbdId + ":");
            System.out.println(retrievedCossicumpbd);

            int cosId = retrievedCossicumpbd.getCosId();
            Cos retrievedCos = cosService.getCosById(cosId);
            if (retrievedCos != null) {
                System.out.println("Total from associated Cos ID " + cosId + ": " + retrievedCos.getTotal());
            } else {
                System.out.println("Cos not found with ID " + cosId);
            }
        } else {
            System.out.println("Cossicumpbd not found with ID " + cossicumpbdId);
        }
    }


    private static void getAllCossicumpbd(CossicumpbdService cossicumpbdService, CosService cosService) {
        List<cossicumpbd> cossicumpbdList = cossicumpbdService.getAllCossicumpbd();
        System.out.println("All cossicumpbd:");
        for (cossicumpbd cossicumpbd : cossicumpbdList) {
            System.out.println(cossicumpbd);
            int cosId = cossicumpbd.getCosId();
            Cos retrievedCos = cosService.getCosById(cosId);
            if (retrievedCos != null) {
                System.out.println("Total from associated Cos ID " + cosId + ": " + retrievedCos.getTotal());
            } else {
                System.out.println("Cos not found with ID " + cosId);
            }
        }
    }



}

//public class Main {
//
//    public static void main(String[] args) {
//
////
//        ClientService clientService = new ClientService();
//        ClientActionLogger cl = new ClientActionLogger();
//        cl.initializeLogFile();
//
//
//
//        // Create a new client
//        Client client1 = new Client();
//        client1.setPrnume("Joh");
//        client1.setEmail("jo.doe@example.com");
//        client1.setAdresa("Main St");
//        client1.setTelefon("1234");
//        clientService.createClient(client1);
//        System.out.println("Client created successfully.");
//
//        // Retrieve a client by ID
//        int clientId = 2;
//        Client retrievedClient = clientService.getClientById(clientId);
//        if (retrievedClient != null) {
//            System.out.println("Retrieved client with ID " + clientId + ":");
//            System.out.println(retrievedClient);
//        } else {
//            System.out.println("Client not found with ID " + clientId);
//        }
//
//        // Update the retrieved client's information
//        if (retrievedClient != null) {
//            retrievedClient.setPrnume("Janet Smith");
//            retrievedClient.setEmail("janet.smith@example.com");
//            retrievedClient.setAdresa("456778 Elm St");
//            retrievedClient.setTelefon("1111");
//            clientService.updateClient(retrievedClient);
//            System.out.println("Client updated successfully.");
//        }
//
//        // Retrieve the previous client by ID to see the change
//        if (retrievedClient != null) {
//            System.out.println("Retrieved client with ID " + clientId + ":");
//            System.out.println(retrievedClient);
//        } else {
//            System.out.println("Client not found with ID " + clientId);
//        }
//
//        // Delete a client
//        int deleteClientId = 1;
//        boolean deleted = clientService.deleteClient(deleteClientId);
//        if (deleted) {
//            System.out.println("Client with ID " + deleteClientId + " deleted successfully.");
//        } else {
//            System.out.println("Failed to delete client with ID " + deleteClientId);
//        }
//
//
//
//        CarteService produsService = new CarteService();
//        ArrayList<Carte> produsListt = produsService.getAllProdus();
//
//        System.out.println("All Carte objects:");
//
//        if (produsListt.isEmpty()) {
//            System.out.println("No Carte objects found.");
//        } else {
//            for (Carte produs : produsListt) {
//                System.out.println(produs);
//            }
//        }
//        CosService cosService = new CosService();
//        int cosId = cosService.createCos();
//        Carte produs1 = new Carte();
//        String nmm="Produs";
//        String auu="John";
//        String edd="Publis";
//
//        Alreadythere aa = new Alreadythere(nmm,auu,edd);
//
//        try {
//            aa.checkEligibility(nmm,auu,edd,produsListt);
//        } catch (sameproducttwice exception) {
//            System.out.println("We found an exception");
//
//            System.out.println(exception);
//        }
//
//        nmm=aa.getNume();
//        auu=aa.getAutor();
//        edd=aa.getEditura();
//
//
//        produs1.setAutor(auu);
//        produs1.setSect("s ");
//        produs1.setSubsect("S");
//        produs1.setNume(nmm);
//        produs1.setEditura(edd);
//        produs1.setPret(50);
//        produs1.setNr(produs1.getNr());
//        produs1.setCosid(cosId);
//        produsService.createProdus(produs1,cosId);
//        System.out.println("Carte created.");
//
//
//        Cos cos=new Cos(produs1);
//        cosService.updateCosTotal(cosId,cos.getTotal());
//        System.out.println("Cos created with ID: " + cosId);
//
//        // Update a Carte
//        Carte produsToUpdate = produsListt.get(1);
//        produsToUpdate.setPret(0.0);
//        produsService.updateProdus(produsToUpdate);
//        System.out.println("Carte updated: " + produsToUpdate);
//
//        // Delete a Carte
//        Carte produsToDelete = produsListt.get(2);
//        produsService.deleteProdus(produsToDelete.getId());
//        System.out.println("Carte deleted: " + produsToDelete);
//
//        // Get all Carte objects for a Cos
//        List<Carte> produsList = produsService.getAllProdusByCosId(cosId);
//        System.out.println("Carte objects for Cos with ID " + cosId + ":");
//        for (Carte produs : produsList) {
//            System.out.println(produs);
//        }
//
//
//
//        CossicumpbdService cossicumpbdService = new CossicumpbdService();
//
//        // Create a cossicumpbd
//        int cumparatorId = 3;
//        int cosIdd = 6;
//        int cossicumpbdId = cossicumpbdService.createCossicumpbd(cumparatorId, cosIdd);
//        System.out.println("Created cossicumpbd");
//
//        // Get a cossicumpbd by ID
//        cossicumpbd retrievedCossicumpbd = cossicumpbdService.getCossicumpbdById(cossicumpbdId+1);
//        System.out.println("Retrieved cossicumpbd: " + retrievedCossicumpbd);
//
//
//        // Get all cossicumpbd
//        List<cossicumpbd> cossicumpbdList = cossicumpbdService.getAllCossicumpbd();
//        System.out.println("All cossicumpbd:");
//        for (cossicumpbd cossicumpbd : cossicumpbdList) {
//            System.out.println(cossicumpbd);
//        }
//
//        // Delete a cossicumpbd by id
//        cossicumpbdService.deleteCossicumpbd(5);
//        System.out.println("Deleted cossicumpbd");
//
//    }
//        }

        /*        //testare clase:

//        Culegere myobj = new Culegere();
//        Manual myobj1 = new Manual();
//        Carte mycarte = new Carte();
//        mycarte.setAutor("Diana");
//        mycarte.setPret(2);
//        myobj.setPret(10);
//        myobj1.setPret(5);
//        Cos trei = new Cos();
//        trei.setProduse(myobj);
//        trei.setProduse(myobj1);
//        trei.setProduse(mycarte);
//        //trei.getProduse();
//        Carte mycarte2 = new Carte("Calin", "Cash", "bine pe cash", "da", "paralela", 20);
//        trei.setProduse(mycarte2);
//        System.out.println(trei.getProdusnr(0));
//        System.out.println(trei.getProdusnr(1));
//        System.out.println(trei.getProdusnr(2));
//        System.out.println(trei.getProdusnr(3));
//        System.out.println(mycarte2);
        //System.out.println(trei);
//        Cos unu = new Cos();
//        Cos doi = new Cos();
//        unu.setProduse(myobj);
//        unu.setProduse(myobj1);
//        doi.setProduse(myobj);
//        Client cum = new Client();
//        Firma f = new Firma(1234, "da");
//        Client cum2 = new Client("a", "b", "c", "d");
//        cossicump c = new cossicump(unu, cum2);
//        cossicump c2 = new cossicump(trei, f);
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        Inputincorect w = new Inputincorect<>();
//        try {
//
//            w.checkEligibility(trei);
//        } catch (wrongcomandaimput exception) {
//            System.out.println("We found an exception:");
//
//
//            System.out.println(exception);
//
//        }
//        String nm="da",au="Calin",ed="paralela";
//
//
//        Alreadythere a = new Alreadythere();
//        try {
//
//            a.checkEligibility(nm,au,ed,trei.getCump());
//        } catch (sameproducttwice exception) {
//            System.out.println("We found an exception:");
//
//
//            System.out.println(exception);
//
//        }
//
//        Arepret carte= new Carte("Diana", "frumos","foarte", "Poezie","buna",10);
//        Carte al =new Carte("iana", "frum","arte", "Poe","buna",20);
//        Arepret discCarte = new Discount(al, al.getPret());
//
//        carte.disc(0.3);
//        discCarte.disc(0.2);
        ////  cossicump c4 = new cossicump(trei,unu); //eroare pt ca am pus sealed pt valoarea generica sa accepte doar cumparatori,
        //altfel afisa cele 2 cosuri
//         System.out.println(f);
//        System.out.println(c);
//        System.out.println(c2);
//         if(f.getClass().equals(Firma.class))
//         System.out.println("da");
//       // System.out.println(c4);
//        System.out.println(cum);
//         System.out.println(cum2);
//        System.out.println(cum.getId());
//        System.out.println(cum2.getId());
//         System.out.println(doi);
//         System.out.println(unu);

         */




