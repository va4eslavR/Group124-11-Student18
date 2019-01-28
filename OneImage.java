package com.company;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class OneImage {
    static byte k;
    static ImageSolver a;

    public OneImage(byte k, ImageSolver a) {
        this.k = k;
        this.a = a;
    }

    public byte getDimensions(ArrayList<ImageSolver> Learned) {

        ArrayList<Pair> Pairs = new ArrayList<>();

        for (int i = 0; i < Learned.size(); i++) {
            Pairs.add(new Pair(a.EuqDimOneImage(Learned.get(i)), Learned.get(i).getLabel()));
        }

 /*       Pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (int) (o1.dist - o2.dist);
            }
        });*/

        ArrayList<Pair> Keys = Pairs.stream().sorted().limit(k).collect(toCollection(ArrayList::new));

        LinkedHashMap<Byte, Double> Rezult = new LinkedHashMap<Byte, Double>();
        for (Pair key : Keys
        ) {
            if (Rezult.containsKey(key.getLabel())) {
                Rezult.compute(key.getLabel(), (Byte K, Double V) -> V += key.getDist());
            } else {
                Rezult.put(key.getLabel(), key.getDist());
            }
        }
        Byte maxEntry = Collections.max(Rezult.entrySet(), Map.Entry.comparingByValue()).getKey();

/*        if (maxEntry == a.Label) {
            System.out.println("Match" + maxEntry);
        } else {
            System.out.println("Fail");
        }*/


        return maxEntry;
    }

}

