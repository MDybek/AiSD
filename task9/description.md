**Lista zadań**
1. Użyj implementacji klasy Document z dowolnej poprzedniej listy. Wewnątrz klasy przechowuj w dowolny sposób kolekcję 
obiektów Link. Możesz także skorzystać z dowolnej kolekcji bibliotecznej (np. SortedSet).
2. W klasie Main użyj dowolnej reprezentacji kolekcji obiektów Document.
3. Zaimplementuj klasę Graph, która implementuje graf jako dwuwymiarową tablicę liczb całkowitych. W konstruktorze jako 
parametr musi znajdować się kolekcja wybrana w zadaniu 2. W obiekcie Graph można przechowywać dowolne informacje potrzebne
do odwzorowania nazwy dokumentu na indeks oraz odwzorowania wstecznego. Obiekt klasy Document jest reprezentacją wierzchołka,
a Link to krawędzie od tego wierzchołka, ale w klasie Graph wszystkie te informacje muszą być odwzorowane na liczbę całkowitą.
4. W klasie Graph zaimplementuj metody bfs(name) i dfs(name), które zwrócą String z sekwencją nazw odwiedzanych dokumentów 
przy użyciu algorytmów przeszukiwania wszerz i w głąb. Jako argument będzie to nazwa dokumentu startowego. Jeśli w trakcie 
działania algorytmu masz wybór wierzchołka do którego prowadzi krawędź, przeanalizuj wierzchołki w porządku leksykograficznym.
5. W klasie Graph zaimplementuj metodę connectedComponents(), która zwróci liczbę składowych spójnych. Użyj zaimplementowanej
 wcześniej klasy DisjointSetForest. Musisz dodać funkcję zliczającą liczbę rozłącznych zbiorów w tej klasie.
