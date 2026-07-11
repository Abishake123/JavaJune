package UDDT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // [1,jhon,Dev,2,Alex, QA]

        // {fish1, 20, fish2 , 30, fish3, 70}

        // [ {fishName : GoldFish , lifeSpan : 500} {fishName : Tiger Fish , lifeSpan :
        // 200} ]

        Integer x = 2;
        Integer y = 3;
        ArrayList<Integer> num = new ArrayList<>(); // [2,3]

        num.add(x);
        num.add(y);

        System.out.println(num);

        ArrayList<Fish> fishes = new ArrayList<>();

        Fish fish;

        fish = new Fish();

        fish.fishName = "GoldFish";
        fish.lifeSpanDays = 500;
        fish.isEddible = false;

        fishes.add(fish);

        fish = new Fish();

        fish.fishName = "Tiger Fish";
        fish.lifeSpanDays = 200;
        fish.isEddible = false;

        fishes.add(fish);

        System.out.println(fishes);
    }
}
