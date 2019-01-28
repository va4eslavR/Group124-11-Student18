package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;

public class combinedTeacher {
    byte k[];


    public combinedTeacher(byte[] k) {
        this.k = k;

    }

    public byte ProductiveNeighbors(ArrayList<ImageSolver> entering,
                                    ArrayList<ImageSolver> matcher) {
        byte max = 0;
        double PercentMax = 0;
        float count = 0;
        for (byte ka : k
        ) {
            double counter = 0;
            for (ImageSolver imageSolver : entering
            ) {


                ArrayList<Pair> Pairs = new ArrayList<>();

                for (int i = 0; i < matcher.size(); i++) {
                    Pairs.add(new Pair(imageSolver.EuqDimOneImage(matcher.get(i)), matcher.get(i).getLabel()));
                }


                ArrayList<Pair> Keys = Pairs.stream().sorted().limit(ka).collect(toCollection(ArrayList::new));

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


                if (maxEntry != imageSolver.getLabel())
                    counter += 1;
                float wait = count * 100 / ((float) entering.size() * k.length);
                System.out.print(wait + "\r");
                count += 1;

            }
            Double Percent = 100 - counter / entering.size() * 100;
            System.out.println(Percent.toString() + ka);
            if (Percent > PercentMax) {
                max = ka;
                PercentMax = Percent;
            }
        }
        System.out.println("эффективное кол-во соседей " + max);
        System.out.println("процент попаданий " + PercentMax);
        return max;
    }
}

