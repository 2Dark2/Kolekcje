package com.company;

import java.util.*;

public class Main {
    //Obiek ,który umożliwia użytkownikowi interakcje z programem
    Scanner scanner = new Scanner(System.in);

    //Obiekty dla Person i EqPerson ,które użytkownik będzie mógł dodawać bądź usuwać z Kolekcji i Map
    private static final Person person1 = new Person("Jan","Kowalski");
    private static final Person person2 = new Person("Robert","Nowak");
    private static final Person person3 = new Person("Robert","Lewandowski");
    private static final Person person4 = new Person("Robert","Lewandowski");

    private static final EqPerson eqPerson1 = new EqPerson("Jan","Kowalski");
    private static final EqPerson eqPerson2 = new EqPerson("Robert","Nowak");
    private static final EqPerson eqPerson3 = new EqPerson("Robert","Lewandowski");
    private static final EqPerson eqPerson4 = new EqPerson("Robert","Lewandowski");

    // Zdeklarowane Sety Mapy i Listy
    private static final Set<Person> hasSet = new HashSet();
    private static final Set<Person> treeSet = new TreeSet(new NameComp()); //Set uzywa Comparatora
    private static final List<Person> arrayList = new ArrayList();
    private static final List<Person> linkedList = new LinkedList();
    private static final Map<Integer,Person> hashMap = new HashMap();
    private static final Map<Integer,Person> treeMap = new TreeMap();

    private static final Set<EqPerson> eqHasSet = new HashSet();
    private static final Set<EqPerson> eqTreeSet = new TreeSet();
    private static final List<EqPerson> eqArrayList = new ArrayList();
    private static final List<EqPerson> eqLinkedList = new LinkedList();
    private static final Map<Integer,EqPerson> eqHashMap = new HashMap();
    private static final Map<Integer,EqPerson> eqTreeMap = new TreeMap();

    //Menu Programu
    private static final String MENU =
            "    M E N U   G Ł Ó W N E   \n" +
                    "1 - Dodaj osobe do wszystkich kolekcji     \n" +
                    "2 - Usuń osobe do wszystkich kolekcji      \n" +
                    "3 - Wyswietl wszystkie kolekcje            \n" +
                    "4 - Zakończ program do wszystkich kolekcji ";

    //Bład
    private final String  ERROR_MESSAGE =
            "Nieprawidłowe dane!";

    public static void main(String[] args) {
        Main main = new Main();
        main.runMainLoop();
    }

    //Metoda umożliwia dodawanie oraz odejmowanie obiektów
    //Pozwala również wypisać zawartość wszystich kolekcji oraz map a także zakończyć działąnie programu
    public void runMainLoop(){
        while (true){
            System.out.println(MENU);
            try {
                switch (scanner.nextInt()){
                    case 1:
                        addPerson();
                        break;
                    case 2:
                        deletePerson();
                        break;
                    case 3:
                        showAllCollections();
                        break;
                    case 4:
                        System.out.println("Koniec programu");
                        System.exit(0);
                    default:
                        System.out.println(ERROR_MESSAGE);
                }

            }catch (Exception e ){
                System.out.println(ERROR_MESSAGE);
                //gdy użytkownik wpisze stringa zamiast inta to scanner zostanie "zapchany"
                //aby go "odetkać" używamy funkcji scanner.nextLine();
                scanner.nextLine();
            }
        }

    }
    //Metoda wyświetla wszytkich użytkowników
    public void showAllAvailablePersons(){
        System.out.println("Dostepne osoby: ");
        System.out.println("1. " + person1);
        System.out.println("2. " + person2);
        System.out.println("3. " + person3);
        System.out.println("4. " + person4);
    }
    //Metoda wyświetla zawrtość kolekcji i map
    public void showAllCollections(){
        System.out.println("HashSet: ");
        iterateCollection(hasSet);
        System.out.println("Override");
        iterateCollection(eqHasSet);

        System.out.println("TreeSet: ");
        iterateCollection(treeSet);
        System.out.println("Override");
        iterateCollection(eqTreeSet);

        System.out.println("ArrayList: ");
        iterateCollection(arrayList);
        System.out.println("Override");
        iterateCollection(eqArrayList);

        System.out.println("LinkedList: ");
        iterateCollection(linkedList);
        System.out.println("Override");
        iterateCollection(eqLinkedList);

        System.out.println("HasMap: ");
        iterateMap(hashMap);
        System.out.println("Override");
        iterateMap(eqHashMap);

        System.out.println("TreeMap: ");
        iterateMap(treeMap);
        System.out.println("Override");
        iterateMap(eqTreeMap);
    }

    //Metoda umożliwia dodawanie obiektów klasy Person oraz EqPerson do kolekcji i map
    public void addPerson(){
        System.out.println("Ktora osobe chcesz dodac?");
        showAllAvailablePersons();
        System.out.println("5. Cofnij");
        Person person=null;
        EqPerson eqPerson=null;
        int key=0;
        boolean flag = true;

        //wybór użytkownika
        try{
            switch (scanner.nextInt()){
                case 1:
                    person=person1;
                    eqPerson=eqPerson1;
                    break;
                case 2:
                    person=person2;
                    eqPerson=eqPerson2;
                    break;
                case 3:
                    person=person3;
                    eqPerson=eqPerson3;
                    break;
                case 4:
                    person=person4;
                    eqPerson=eqPerson4;
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    flag=false;
                    System.out.println(ERROR_MESSAGE);
            }
            //wybór oraz sprawdzenie klucza gdy osoba została wybrana poprawnie
            if(flag){
                System.out.println("Podaj klucz (liczba całkowita) ktora bedzie wykorzystana w Mapach");
                key=scanner.nextInt();
                if(!hashMap.isEmpty()){
                    for(Integer k : hashMap.keySet()){
                        if(key==k){
                            System.out.println("Dany klucz juz istnieje");
                            flag=false;
                        }
                    }
                }
            }
            if(flag)
            {
                hasSet.add(person);
                eqHasSet.add(eqPerson);

                treeSet.add(person);
                eqTreeSet.add(eqPerson);

                arrayList.add(person);
                eqArrayList.add(eqPerson);

                linkedList.add(person);
                eqLinkedList.add(eqPerson);

                hashMap.put(key,person);
                eqHashMap.put(key,eqPerson);

                treeMap.put(key,person);
                eqTreeMap.put(key,eqPerson);
            }
        }catch (Exception e){
            System.out.println(ERROR_MESSAGE);
            //gdy użytkownik wpisze stringa zamiast inta to scanner zostanie "zapchany"
            //aby go "odetkać" używamy funkcji scanner.nextLine();
            scanner.nextLine();
        }
    }
    //Metoda umożliwia usuwanie obiektów klasy Person oraz EqPerson do kolekcji i map
    public void deletePerson(){
        System.out.println("Ktora osobe chcesz usunac?");
        showAllAvailablePersons();
        System.out.println("5. Cofnij");
        Person person=null;
        EqPerson eqPerson=null;
        int key=0;
        boolean flag=true;
        //wybór osoby
        try {
            switch (scanner.nextInt()) {
                case 1:
                    person = person1;
                    eqPerson = eqPerson1;
                    break;
                case 2:
                    person = person2;
                    eqPerson = eqPerson2;
                    break;
                case 3:
                    person = person3;
                    eqPerson = eqPerson3;
                    break;
                case 4:
                    person = person4;
                    eqPerson = eqPerson4;
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    flag=false;
                    System.out.println(ERROR_MESSAGE);
            }
            //wybór oraz sprawdzenie klucza gdy osoba została wybrana poprawnie
            if(flag){
                System.out.println("Podaj klucz elementu którego chcesz usunac");
                key=scanner.nextInt();
                flag=false;

                for(Map.Entry<Integer,EqPerson> entry: eqHashMap.entrySet()){
                    if(entry.getKey()==key){
                        if(entry.getValue().equals(eqPerson)){
                            flag=true;
                        }
                    }
                }

                if(flag){
                    hasSet.remove(person);
                    eqHasSet.remove(eqPerson);

                    treeSet.remove(person);
                    eqTreeSet.remove(eqPerson);

                    arrayList.remove(person);
                    eqArrayList.remove(eqPerson);

                    linkedList.remove(person);
                    eqLinkedList.remove(eqPerson);

                    hashMap.remove(key);
                    eqHashMap.remove(key);

                    treeMap.remove(key);
                    eqTreeMap.remove(key);

                }
                else{
                    System.out.println("Bledny klucz");
                }

            }
        }catch (Exception e){
            System.out.println(ERROR_MESSAGE);
            //gdy użytkownik wpisze stringa zamiast inta to scanner zostanie "zapchany"
            //aby go "odetkać" używamy funkcji scanner.nextLine();
            scanner.nextLine();
        }
    }
    //Metoda iteruje po kolekcji oraz wyświetla jej zawartość
    public void iterateCollection (Collection<? extends Person> personCollection){
        for(Person collections: personCollection){
            System.out.println(collections);
        }
    }
    //Metoda iteruje po mapie oraz wyświetla jej zawartość
    public void iterateMap (Map<Integer, ? extends Person> map){
        for (Map.Entry<Integer, ? extends Person> m : map.entrySet()){
            System.out.println(m);
        }
    }

    //klasa Comperator potrzebna do pokaznia różnicy Comparable vs. Comparator
    //została ona zainicjalizowana w kolekcji TreeSet (linika 19)
    public final static class NameComp implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}