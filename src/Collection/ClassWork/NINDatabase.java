package Collection.ClassWork;

import java.util.HashSet;
import java.util.Iterator;

public class NINDatabase {
    public static void main(String[] args) {

        NIN john = new NIN("John Okoro",123789456);
        NIN james = new NIN("James Akpan",456789321);
        NIN joy = new NIN("Joy Eze",321987654);

        HashSet<NIN> nin = new HashSet<>();
        nin.add(john);
        nin.add(james);
        nin.add(joy);

        System.out.println("The total number of NIN available now is: " + nin.size());

        Iterator iterator = nin.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
