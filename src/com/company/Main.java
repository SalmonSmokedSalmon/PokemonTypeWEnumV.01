package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Please enter your pokemon type now...");

        String input = inputScanner.next();

        Type.singleType(input);


    }

 public enum Type {

        FIRE(new String[]{"WATER", "GROUND"}, new String[]{"GRASS"}, new String[]{"Null"}),
        WATER(new String[]{"GRASS"}, new String[]{"FIRE"}, new String[]{"Null"}),
        GRASS(new String[]{"FIRE"}, new String[]{"WATER"}, new String[]{"Null"});

        private final String[] weakVs;
        private final String[] strongVs;
        private final String[] noEffectVs;

        Type(String[] weakVs, String[] strongVs, String[] noEffectVs){

            this.weakVs = weakVs;
            this.strongVs = strongVs;
            this.noEffectVs = noEffectVs;

        }

        Type type;

        public static void singleType(String input){

            for (Type t : values()){

                    if (t.toString().equalsIgnoreCase(input)){

                        Pokemon pokemon = new Pokemon(t.weakVs, t.strongVs, t.noEffectVs);

                        System.out.println("Single Type Pokemon Created.");
                        System.out.println("This type is strong against"+ Arrays.toString(pokemon.strong1));
                        System.out.println("This type is weak against"+ Arrays.toString(pokemon.weak1));
                        System.out.println("This type has no effect against"+ Arrays.toString(pokemon.noEffect1));
                    }
                    else{
                        System.out.println("Not A Match");
                    }

            }

        }

     public static void dualType(String input1, String input2){

         for (Type t : values()){

             if (t.toString().equalsIgnoreCase(input1)){

                String[] type1W = t.weakVs;
                String[] type1S = t.strongVs;
                String[] type2N = t.noEffectVs;

                for (Type t2 : values()){

                    if (t2.toString().equalsIgnoreCase(input2)){

                        Pokemon pokemon = new Pokemon(t.weakVs, t.strongVs, t.noEffectVs, t2.weakVs, t2.strongVs, t2.noEffectVs);
                        System.out.println("Two Type Pokemon Created.");

                    }

                }
             }
             else{
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

       public Pokemon(String[] weak1, String[] strong1, String[] noEffect1 ){

           this.weak1 = weak1;
           this.strong1 = strong1;
           this.noEffect1 = noEffect1;

       }

       public Pokemon(String[] weak1, String[] strong1, String[] noEffect1, String[] weak2, String[] strong2, String[] noEffect2){

           this.weak1 = weak1;
           this.weak2 = weak2;

           this.strong1 = strong1;
           this.strong2 = strong2;

           this.noEffect1 = noEffect1;
           this.noEffect2 = noEffect2;

       }


 }

}