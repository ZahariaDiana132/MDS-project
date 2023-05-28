package ro.pao.model.cumparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    int id;
    String prnume, email, adresa, telefon, myclienttostring;
    Client myclient;

    @BeforeEach
    void setUp() {
        id = 100;
        prnume = "a";
        email = "b";
        adresa = "c";
        telefon = "d";
        myclient = new Client();
        myclient.setAdresa(adresa);
        myclient.setEmail(email);
        myclient.setPrnume(prnume);
        myclient.setId(id);
        myclient.setTelefon(telefon);
        myclienttostring = "Clientul: " + "a" + " cu email: " + "b" + " are adresa de livrare: "
                + "c" + " si telefonul " + "d";

    }

    @Test
    void getId() {
        Assertions.assertEquals(id, myclient.getId());
    }


    @Test
    void getPrnume() {
        Assertions.assertEquals(prnume, myclient.getPrnume());
    }


    @Test
    void getEmail() {
        Assertions.assertEquals(email, myclient.getEmail());
    }


    @Test
    void getTelefon() {
        Assertions.assertEquals(telefon, myclient.getTelefon());
    }


    @Test
    void getAdresa() {
        Assertions.assertEquals(adresa, myclient.getAdresa());
    }

    @Test
    void testToString() {
        Assertions.assertEquals(myclienttostring, myclient.toString());
    }
}

