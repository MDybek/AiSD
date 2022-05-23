**Lista zadań**
1. Użyj implementacji klas HashTable, Link i interfejsu IWithName z poprzedniej listy zadań. Należy zmodyfikować sposób 
zbierania informacji o linkach w klasie Document. Na tej liście zadań linki są przechowywane w drzewie wyszukiwania binarnego.
2. Zaimplementuj generyczną klasę BST, która ma możliwość dodawania i usuwania elementu. Elementy muszą być przechowywane 
w węźle z dodatkowymi polami left, right i parent. Bazuj na pierwszej realizacji z wykładu. Potrzebna jest również metoda,
która zwróci napisy z prezentacją węzłów w możliwych kolejnościach: in-order, pre-order i post-order.
3. Zakłada się, że obiekty przechowywane w BST implementują interfejs Comparable, więc musisz rzutować elementy na Comparable
 podczas operacji dodawania i usuwania, aby użyć metody CompareTo.
4. W klasie BST zaimplementuj funkcję size(), która zwróci numer przechowywanego elementu i metodę successor(), która zwróci 
następnika argumentu. Jeśli następnik nie istnieje, metoda ma zwracać null.
