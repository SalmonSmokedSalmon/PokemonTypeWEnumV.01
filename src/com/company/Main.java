package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Please enter your pokemon type now...");

        String input = inputScanner.next();

        System.out.println("Is there another type? Y/N");

        String yesNo = inputScanner.next();

        if (yesNo.equalsIgnoreCase("n")) {
            Type.singleType(input);
        }
        else{

            System.out.println("Okay, please enter the second type now...");

            String input2 = inputScanner.next();

            Type.dualType(input, input2);

        }

    }

    public enum Type {

        FIRE(
                new String[]{"WATER", "GROUND", "ROCK", "DRAGON", "FIRE"},
                new String[]{"GRASS", "ICE", "BUG", "STEEL"},
                new String[]{"Null"}),
        WATER(
                new String[]{"GRASS", "WATER", "DRAGON"},
                new String[]{"FIRE", "GROUND", "ROCK"},
                new String[]{"Null"}),
        GRASS(
                new String[]{"FIRE", "GRASS", "POISON", "FLYING", "BUG", "DRAGON", "STEEL"},
                new String[]{"WATER", "GROUND", "ROCK"},
                new String[]{"Null"}),
        ELECTRIC(
                new String[]{"ELECTRIC", "GRASS", "DRAGON"},
                new String[]{"WATER", "FLYING"},
                new String[]{"GROUND"}),
        ICE(
                new String[]{"FIRE", "WATER", "ICE"},
                new String[]{"GRASS", "GROUND", "FLYING", "DRAGON"},
                new String[]{"Null"}),
        FIGHTING(
                new String[]{"POISON", "FLYING", "PSYCHIC", "BUG", "FAIRY"},
                new String[]{"NORMAL", "ICE", "ROCK", "DARK", "STEEL"},
                new String[]{"GHOST"}),
        POISON(
                new String[]{"POISON", "GROUND", "ROCK", "GHOST"},
                new String[]{"GRASS", "FAIRY"},
                new String[]{"STEEL"}),
        NORMAL(
                new String[]{"ROCK", "STEEL"},
                new String[]{"Null"},
                new String[]{"GHOST"}),
        GROUND(
                new String[]{"GRASS", "BUG"},
                new String[]{"FIRE", "ELECTRIC", "POISON", "ROCK", "STEEL"},
                new String[]{"FLYING"}),
        FLYING(
                new String[]{"ELECTRIC", "ROCK", "STEEL"},
                new String[]{"GRASS", "FIGHTING", "BUG"},
                new String[]{"Null"}),
        PSYCHIC(
                new String[]{"PSYCHIC", "STEEL"},
                new String[]{"FIGHTING", "POISON"},
                new String[]{"DARK"}),
        BUG(
                new String[]{"FIRE", "FIGHTING", "POISON", "FLYING", "GHOST", "STEEL", "FAIRY"},
                new String[]{"GRASS", "PSYCHIC", "DARK"},
                new String[]{"Null"}),
        ROCK(
                new String[]{"FIGHTING", "GROUND", "STEEL"},
                new String[]{"FIRE", "ICE", "FLYING", "BUG"},
                new String[]{"Null"}),
        GHOST(
                new String[]{"DARK"},
                new String[]{"PSYCHIC", "GHOST"},
                new String[]{"NORMAL"}),
        DRAGON(
                new String[]{"STEEL"},
                new String[]{"DRAGON"},
                new String[]{"FAIRY"}),
        DARK(
                new String[]{"FIGHTING", "DARK", "FAIRY"},
                new String[]{"PSYCHIC", "GHOST"},
                new String[]{"Null"}),
        STEEL(
                new String[]{"FIRE", "WATER", "ELECTRIC", "STEEL"},
                new String[]{"ICE", "ROCK", "FAIRY"},
                new String[]{"Null"}),
        FAIRY(
                new String[]{"FIRE", "POISON", "STEEL"},
                new String[]{"FIGHTING", "DRAGON", "DARK"},
                new String[]{"Null"});

        private final String[] weakVs;
        private final String[] strongVs;
        private final String[] noEffectVs;

        Type(String[] weakVs, String[] strongVs, String[] noEffectVs) {

            this.weakVs = weakVs;
            this.strongVs = strongVs;
            this.noEffectVs = noEffectVs;

        }


        Type type;

        public static void singleType(String input) {

            for (Type t : values()) {

                if (t.toString().equalsIgnoreCase(input)) {

                    Pokemon pokemon = new Pokemon(t.weakVs, t.strongVs, t.noEffectVs);

                    System.out.println("Single Type Pokemon Created.");
                    System.out.println("This type is strong against" + Arrays.toString(pokemon.strong1));
                    System.out.println("This type is weak against" + Arrays.toString(pokemon.weak1));
                    System.out.println("This type has no effect against" + Arrays.toString(pokemon.noEffect1));
                } else {
                    System.out.println("Not A Match");
                }

            }

        }

        public static void dualType(String input1, String input2) {

            for (Type t : values()) {

                if (t.toString().equalsIgnoreCase(input1)) {

                    String[] type1W = t.weakVs;
                    String[] type1S = t.strongVs;
                    String[] type1N = t.noEffectVs;

                    for (Type t2 : values()) {

                        if (t2.toString().equalsIgnoreCase(input2)) {

                            String[] type2W = t2.weakVs;
                            String[] type2S = t2.strongVs;
                            String[] type2N = t2.noEffectVs;

                            Pokemon pokemon = new Pokemon(t.weakVs, t.strongVs, t.noEffectVs, t2.weakVs, t2.strongVs, t2.noEffectVs);
                            System.out.println("Two Type Pokemon Created.");



                            System.out.println("This type is strong against " + Arrays.toString(pokemon.strong1));
                            System.out.println("This type is weak against " + Arrays.toString(pokemon.weak1));
                            System.out.println("This type has no effect against " + Arrays.toString(pokemon.noEffect1));
                            System.out.println("This type is super weak against " + Arrays.toString(pokemon.compareType(pokemon.weak1, pokemon.weak2)));
                            System.out.println("This type is super strong against" + Arrays.toString(pokemon.compareType(pokemon.strong1, pokemon.strong2)));

                        }
                    }
                } else {
                    System.out.println("No Match Found");
                }
            }
        }

        public String[] getWeakVs(String input) {
            return weakVs;
        }

        public String[] getStrongVs(String input) {
            return strongVs;
        }

        public String[] getNoEffectVs(String input) {
            return noEffectVs;
        }


    }

    public static class Pokemon {

        private String[] weak1;
        private String[] strong1;
        private String[] noEffect1;

        private String[] weak2;
        private String[] strong2;
        private String[] noEffect2;

        private String[] superWeak;
        private String[] superStrong;
        private String[] superCan1;
        private String[] superCan2;

        public Pokemon(String[] weak1, String[] strong1, String[] noEffect1) {

            this.weak1 = weak1;
            this.strong1 = strong1;
            this.noEffect1 = noEffect1;

        }

        public Pokemon(String[] weak1, String[] strong1, String[] noEffect1, String[] weak2, String[] strong2, String[] noEffect2) {

            this.weak1 = weak1;
            this.weak2 = weak2;

            this.strong1 = strong1;
            this.strong2 = strong2;

            this.noEffect1 = noEffect1;
            this.noEffect2 = noEffect2;

            this.superWeak = compareType(weak1, weak2);
            this.superStrong = compareType(strong1, strong2);

        }

        public String[] compareType(String[] superCan1, String[] superCan2) {

           this.superCan1 = superCan1;
           this.superCan2 = superCan2;

           String[] superAct;

            ArrayList<String> superActual = new ArrayList<>();

            for (String s : superCan1) {

                for (String value : superCan2) {

                    if (s.equalsIgnoreCase(value)) {

                        superActual.add(s);

                    }

                }

            }

            superAct = new String[]{String.valueOf(superActual.toArray())};

                    return superAct;
        }

    }
}