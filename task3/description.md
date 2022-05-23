**Lista zadań**
1. Zmodyfikuj klasę Link, która będzie teraz przechowywać dwie informacje: ciąg znaków referencji (pole ref) 
i wagę tego linku (pola weight). Teraz po nazwie linku (bez spacji) w nawiasie może znajdować się dodatnia
liczba całkowita, np. „link=abc(12)”. Mimo to mogą istnieć linki bez takiej liczby w nawiasach 
typu „Link=QeW” – w takim przypadku przyjmujemy, że waga jest równa jeden. Jeśli chcemy porównać 
dwa linki, porównywane będą tylko pola ref. Aby to zrobić, musisz zaimplementować interfejs Comparable 
dla klasy Link i użyć metod CompareTo() w wielu funkcjach.
2. Zmodyfikuj sposób konstruowania ciągu znaków w funkcji toString() dla klasy Document. Od teraz pod pierwszą 
linią musi być 10 linków z wagami w nawiasach oddzielonych jedną spacją (bez spacji po ostatnim linku w linii).
Oczywiście w ostatniej linii prezentowane są tylko pozostałe linki. Zaimplementuj również pomocnicze metody 
isCorrectId(String id) oraz createLink(String link), których znaczenie opisane zostało w poprzednich listach. 
Są one używane w klasie Main.
3. Zaimplementuj interfejs IList<E> za pomocą metody listIterator dla klasy TwoWayCycledOrderedListWithSentinel<T>. 
  Jest to uporządkowana dwukierunkowa lista cykliczna ze strażnikiem. Ponieważ lista jest uporządkowana,
  iterator nie może modyfikować uporządkowania listy. Z tego samego powodu załóżmy, że metody void add(int index, element E),
  E set(int index, element E), wyrzucą wyjątek UnsupportedOperationException. W add(E e) zakładamy, że element zostanie dodany
  na odpowiedniej pozycji w zależności od nazwy linku na najwyższej możliwej pozycji.
a. Zaimplementuj również metodę:
void add(TwoWayCycledOrderedListWithSentinel <T> anotherList), która spowoduje dodanie drugiej listy do tej listy.
  Po operacji druga lista musi być pusta, wszystkie elementy będą na pierwszej liście, ale oczywiście uporządkowane.
  Elementy o tej wartości linku z drugiej listy należy umieścić po elementach z tej listy. Złożoność tej metody musi wynosić O(n).
  Jeśli druga lista jest tą samą listą co bieżąca – nic nie rób.
b. Zaimplementuj również metodę:
void removeAll(E element), który usunie wszystkie elementy równe elementowi z parametru w czasie O(n).
4. Twoja implementacja klas TwoWayCycledOrderedListWithSentinel<E>, Link, Document zostanie przetestowana 
  w formacie określonym w załączniku. Jeśli wszablonieistniejekodthrow new UnsupportedOperationException(); - nie musisz 
  implementować danej metody.
