package Occurences;

import java.util.ArrayList;
import java.util.HashMap;

public class Task {


    public static void main(String[] args) {
        

        ArrayList<Integer> occs = new ArrayList<>();
        HashMap<String, String> occ = new HashMap<>();


        occ.put("Name", "Jhon");
        occ.put("Age", "23");
        occ.put("Role", "Dev");



        System.out.println(occ.get("Name"));


    }
    
}
