import java.util.*;

public class Listsort {

    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("Umesh");
        names.add("Zara");
        names.add("Alex");
        names.add("Bob");
        names.add("Jhon");
        names.add("Bob");
        names.add("Umesh");

        System.out.println("Before Sorting "+names);
        Collections.sort(names);
        System.out.println("After Sorting"+names);
        Set<String> uniquenames = new HashSet<>(names);
        System.out.println("Uniques names: "+uniquenames);


    }


}



