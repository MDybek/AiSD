**Lista zadań**
1. Zaimplementuj klasę HashTable z funkcjami określonymi w szablonie kodu. Wewnętrzna reprezentacja tablicy mieszającej 
 będzie używać tablicy list. Użyj implementacji bibliotecznej LinkedList. Zakłada się, że operacja add() dla listy w tej
 tablicy dodaje nowy link na końcu listy. Tablica mieszająca przechowuje maksymalny współczynnik obciążenia (domyślnie równy 0,7).
2. Klasa HashTable używa funkcji hashCode() z obiektu, więc zaimplementuj tę funkcję dla klasy Document. Zakładamy, że funkcja 
działa w następujący sposób:
Użyjemy ciągu 7,11,13,17,19,7,11,13,... czyli 7,11,13,17,19 w cyklu. W wyniku otrzymujemy kod pierwszej litery i jeśli 
jest kolejna litera, mnożymy kolejno pierwszą literę przez pierwszą liczbę i dodajemy ją do kodu drugiej litery. Jeżeli 
jest kolejna litera, to częściowy wynik mnożymy przez kolejną liczbę w sekwencji i dodajemy kod na kolejną literę itd.
Np. dla ciągu „abcd” kolejność obliczeń będzie następująca:
97 (dla „a”)
97*7+98=777 (dla „ab”)
777*11+99=8646 (dla „abc”)
8646*13+90=112488 (dla „abcd”)
Użyć odpowiednich operacji modulo, gdy obliczenia wychodzą poza zakres użytego typu
3. Jeżeli liczba elementów przekracza współczynnik obciążenia, należy podwoić pojemność tablicy za pomocą funkcji doubleArray()
 i przenieść element do odpowiedniej nowej listy z pomocą funkcji hashCode().
4. Funkcja add() dla HashTable nie może dodać dokumentu o nazwie, która nadal znajduje się w tablicy mieszającej.
 W tym przypadku musi zwrócić false.
5. Należy zaimplementować funkcję equals() dla dokumentu, która będzieporównywać nazwy dokumentów.
6. Funkcja toString() dla HashTable wypisze tablicę list w postaci: indeks tablicy, dwukropek. Jeśli lista nie jest pusta, 
drukuj jedną spację, to nazwa pierwszego dokumentu na liście. Jeśli jest następny dokument, wypisz przecinek, jedną spację 
i nazwę drugiego dokumentu itd. Każda pozycja w tablicy w oddzielnym wierszu. Aby mieć dostęp do nazwy dokumentu należy
rzutować typ elementu na typ IWithName.
