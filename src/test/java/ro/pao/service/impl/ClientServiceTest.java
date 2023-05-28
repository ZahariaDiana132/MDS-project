//package ro.pao.service.impl;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import ro.pao.model.cumparator.Client;
//import ro.pao.repository.impl.ClientRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ClientServiceTest {
//    @Mock
//    ClientRepository clientRepository;
//
//    @InjectMocks
//    ClientService clientService;
//
//    Client client;
//
//
//    @BeforeEach
//    void setUp() {
//        client = new Client("a","b","c","d");
//        client.setId(2000);
//        clientService.createClient(client);
//    }
//
//    @Test
//    void createClient() {
//
//        Assertions.assertEquals(client,clientService.getClientById(2000));
//    }
//
//    @Test
//    void getClientById() {
//    }
//
//    @Test
//    void updateClient() {
//    }
//
//    @Test
//    void deleteClient() {
//    }
//}