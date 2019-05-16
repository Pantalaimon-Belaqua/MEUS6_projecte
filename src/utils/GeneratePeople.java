package utils;




import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class GeneratePeople {
    
    public static Random random = new Random();
    
    public static String generateName(){
        String[] array = "Viki,Toya,Arlene,Gregory,Vennie,Sharla,Sharie,Kiyoko,Vilma,Tempie,Donny,Shaunda,Illa,Dewey,Ping,Evette,Leslie,Kimberley,Gwen,Sharon,Lawerence,Charlotte,Bennie,Kathey,Aaron,Madalene,Hye,Rosamond,Filomena,Lourie,Shery,Luciano,Rolf,Evita,Everett,Taunya,Elton,Elfrieda,Zulma,Tarra,Corrina,Johnie,Tifany,Tiana,Sandi,Chloe,Lavada,Kali,Gemma,Ariana".split(",");
        int choice = random.nextInt(array.length);
        return array[choice].trim();
    }
    
    public static String generateAddress(){
        String[] array = "Mordor,Granollers,Mercadona,Neverland,Barcelona,Madrid,Edinburgo,Paris,Berlín,Mongolia,Carrefour".split(",");
        int choice = random.nextInt(array.length);
        return array[choice].trim();
    }
    
    public static int generatePhoneNumber(){
        String number = "";
        for (int i = 0; i < 9; i++) {
            number += String.valueOf(random.nextInt(9));
        }
        
        return Integer.parseInt(number);
    }
    
    private static String getDNILetter(int DNI){
        String[] letters = "T,R,W,A,G,M,Y,F,P,D,X,B,N,J,Z,S,Q,V,H,L,C,K,E".split(",");
        
        return letters[DNI%23];
        
    }
    
    public static String generateDNI(){        
        
        String DNI = "";
        for (int i = 0; i < 8; i++) {
            DNI += String.valueOf(random.nextInt(9));
        }
        
        DNI += getDNILetter(Integer.valueOf(DNI));
        
        return DNI; 
    }
    
    public static double generateGrade(){
        return random.nextDouble()*11;
    }
    
    public static int generateAge(){
        return random.nextInt(99)+1;
    }
    
}
