/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;

/**
 *
 * @author daniel
 */
public class GenerateAnimals {
    
    public static Random random = new Random();
    
    public static String generateName() {
        String[] array = "{Abba,Ada,Alaska,Atila,Apolo,Ary,Bart,Bali,Bella,Bigotes,Blondie,Bola,Bran,Brown,Bruno,Brenda,Bruce,Bu,Candy,Chester,Chispa,Coco,Dina,Duna,Emily,Elsa,Emy,Fer,Flash,Flopy,Fox,Gandhi,Hachiko,Iron,Iris,Jerry,Kim,Kiwi,Lázaro,Lily,Morey,Murphy,Neo,Nico,Novo,Orion,Osa,Panda,Perla,Pipa,Rayo,Roco,Ron,Sam,Snow,Ucla,Ursus,Urko ,West ,Yoko}".split(",");
        int choice = random.nextInt(array.length);
        return array[choice];
    }
    
    public static String generateSpecies(){
        String [] array = "{Gato, Tortuga, León, Perro, Serpiente, Loro, Elefante, Lagartija, Mono, Perezoso, Pez}".split(",");
        int choice = random.nextInt(array.length);
        return array[choice];
    }
    
    
}
