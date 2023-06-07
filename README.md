<<<<<<< tema1


Definire proiect:

Name of app : What is going on in my library?

Evidenta librarie online unde sunt vandute produse de tip carte/manual, program facut pentru cel care detine libraria si vrea sa tina evidenta cumparatorilor si a comenzilor precum si a produselor(si daca sunt sau nu in stoc,cate din acelasi tip de produs sunt in stoc). 
...........................................................


OBIECTE:

codul e id-ul = cod unic 


a Produs (clasa baza,abstracta) : (cod,pret,editura,nume,einstoc,catesuntinstoc)

 1.Carte (clasa derivata a)      (+autor, sectiune)

  Exp sectiune : Beletristica,Istorie,Psihologie,Filosofie, Dezvoltare personala 
  

 2.Manual (clasa derivata a)       (+materie, clasa)
 
 
 3.Culegere (clasa derivata a)  (+materie, clasa)
 
       
b.Cumparator(id, adresa livrare, nume comparator, numar telefon, email)

c.Comanda : (id,date produse, pretul total, id cititor)

Main class
Service class
     
Enum: Tip produse
     
................................................................



ACTIUNI POSIBILE:


 1.Adaugare un tip de produs

 2.Adaugarea mai multor tipuri de produs

 3.Editare produs dupa id //aici se poate creste stocul cand mai vin livrari

 4.Stergere produs dupa id // aici poti sterge un tip de produs cand nu se mai vinde

 5.Afisare date unui produs

 6.Sortare produse crescator dupa cantitatea de stoc

 7.Adaugare cititor  //evidenta clienti 

 8.Gaseste cititor dupa id

 9.Adaugare comanda

 10.Gaseste comanda dupa id

.................................................................

**Stocul scade cand apare produsul in comanda, daca stoc = 0 atunci nu e in stoc, initial din fiecare produs sunt cate 3


Owner: Me-Zaharia Diana-Cristiana 


