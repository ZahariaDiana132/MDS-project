# PAO-lab :proiect + activitate lab

Proiect:
# PAO-librarie-online


Tema 1:
Definire proiect:

Name of library: Infinite stock 

Evidenta librarie online unde sunt vandute produse de tip carte/manual, program facut pentru cel care detine libraria si vrea sa tina evidenta cumparatorilor si a comenzilor precum si a produselor(si daca sunt sau nu in stoc,cate din acelasi tip de produs sunt in stoc). 

OBIECTE:

codul e id-ul = cod unic 
a Produs (clasa baza,abstracta) : (cod,pret,editura,nume,einstoc,catesuntinstoc)

 1.Carte (clasa derivata a)      (+,autor, sectiune,sub-sectiune)

Exp sectiune : Beletristica,Istorie,Psihologie,Filosofie, Dezvoltare personala 

Exemple sub- sectiuni : 
Beletristica: Literatura universala  Literatura romaneasca, Thriller/Politiste ,Adolescenti  Carti ecranizate Carti de dragoste  Fantezie  SF 
Istorie : Religii Istorie universala  Istoria romaniei Istorie antica si medieval Biogarfie/Autobiografie
Dezvoltare personala: Sanatate   Terapie prin relaxare si arta  Parenting  Spiritualitate 

     11 Carti pt copii    (clasa derivata 1)
    (+varsta de recomandare)

     12 serii de carti  (clasa derivata 1)
      (+numar volum)

 2.Manuale (clasa derivata a)       (+materie)

    21 Manuale scolare & Culegeri si caiete auxiliare (clasa derivata 2)    
      (+ nivel educational pe clase) 
  
    22 Examene  (clasa derivata 2)    
    ( + denumire examen : evaluarea nationala, Bac, admitere facultate, examen licenta)             

b.Cumparator(id, adresa livrare, nume comparator, numar telefon, email)

c.Comanda : (id-urile produselor, pretul total, id cititor)

Main class

Service classes + Service-implement classes:

ProdusService + ProdusServiceImpl
ComandaService + ComandaServiceImpl
UserService + UserServiceImpl

ACTIUNI POSIBILE:
Pentru cine se ocupa de site:
Actiuni pe carti:
1.Adaugare produs
2.Adaugare produse
3.Editare produs dupa id
4.Stergere produs dupa id
5.Afisare date unui produs
6.Afisarea tuturor produselor care nu sunt in stoc
7.Adaugare cititor
8.Stergere cititor
9.Adaugare comanda
10.Stergere comanda


**Stocul scade cand apare in comanda, daca stoc = 0 atunci nu e in stoc, initial din fiecare produs sunt cate 3


Owner: Me-Zaharia Diana-Cristiana 


