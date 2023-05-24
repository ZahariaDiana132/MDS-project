# Etapa II
 ## Extindeți proiectul din prima etapa prin realizarea persistentei utilizând o baza de date relationala si JDBC.

Să se realizeze servicii care sa expună operații de tip create, read, update si delete pentru cel puțin 4 dintre clasele definite. Se vor realiza servicii singleton generice pentru scrierea și citirea din baza de date.

### ACTIUNI in baza de date:


Adaugare un tip de produs


Adaugarea mai multor tipuri de produs


Editare produs dupa id //(daca se modifica pretul)


Stergere produs dupa id // (pt a sterge un tip de produs cand nu se mai vinde sau nu mai e in stoc)


Afisare date unui produs // evidenta produse (apare doar ce e inca in stoc)


Adauga cumparator  //evidenta clienti pt email-uri si telefon

Edit cumparator

Afisare cumparator


Adaugare comanda  //evidenta comezi

Afisare comanda

Edit comanda (daca a gresit ceva la introducere)

(stergere comanda nu are sens)

Gaseste comanda cea mai profitabila si cine a facut // oferta pt acel client 


## Realizarea unui serviciu de audit

Se va realiza un serviciu care sa scrie într-un fișier de tip CSV de fiecare data când este executată una dintre acțiunile descrise în prima etapa.

Structura fișierului: nume_actiune, timestamp.
