**Lista zadań**
  1. Zaimplementuj interfejs IList<E> z metodą listIterator dla klasy TwoWayUnorderedListWithHeadAndTail<E>.
Nie używaj wartownika dla tej klasy. Użyj tej listy, aby uzyskać listę obiektów Link, które będą przechowywany
w obiekcie klasy Document. W obiekcie klasy Link znajduje się tylko jedno pole – ref typu String.
Operacja ładowania (metoda void load (...)) zostanie wykonana podczas budowy obiektu klasy Document analogicznie
jak na poprzedniej liście zadań. Dla tej listy można użyć pole size, ale można spróbować zaimplementować listę bez niego.
  2. W klasie implementującej interfejs ListIterator wystarczy implementacja metod next(), previous(), hasNext(), hasPrevious().
  3. Zaimplementuj w klasie TwoWayUnorderedListWithHeadAndTail<E>:
a. Metodę void add(TwoWayUnorderedListWithHeadAndTail <E> anotherList), która spowoduje dodanie kolejnej listy na koniec listy,
dla której została użyta ta metoda. Po operacji dodana lista musi być pusta (gdyż elementy z niej zostaną przesunięte 
na koniec "pierwszej" listy). Złożoność tej metody musi wynosić O(1). Jeśli druga lista jest tą samą listą (czyli jest to ta sama
referencja) – nic nie rób.
b. metodę String toStringReverse() w którym musisz użyć
ListIterator<E> w sposób przedstawiony w szablonie (przesuwamy się
iteratorem do ostatniego elementu, a następnie cofamy się do początku) .
  4. Twoja implementacja klas TwoWayUnorderedListWithHeadAndTail<E>,
Link, Document zostanie przetestowana w formacie określonym w załączniku.
