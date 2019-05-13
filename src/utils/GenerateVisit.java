/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;
import static utils.GeneratePeople.random;

/**
 *
 * @author daniel
 */
public class GenerateVisit {
    
    public static Random random = new Random();
    
    public static String generateType(){
        String[] array = "Enfermedad, Inflamación, Nutrición, Cirujía, Radiografía, Analítica, Checkeo".split(",");
        int choice = random.nextInt(array.length);
        return array[choice];
    }
    
    public static String generateResult(){
        String[] array = "Bueno, Malo, Necesita tratamiento, Va a morir, Requiere operación".split(",");
        int choice = random.nextInt(array.length);
        return array[choice];
    }
    
    public static Double generatePrice(){
        return random.nextDouble()*500;
    }
    
}
