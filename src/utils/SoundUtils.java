/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Controlador.C_AddAnimal;
import Main.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author daniel
 */
public class SoundUtils {

    public static void playCatSound() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/cat.wav"));

            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(C_AddAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(C_AddAnimal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(C_AddAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void playAngryCatSound() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/angry_cat.wav"));
            
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void playErrorSound(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/computer_error.wav"));
            
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void playWarningSound(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/warning.wav"));
            
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void sayYay(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/yay.wav"));
            
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void playSuccessSound(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/success.wav"));
            
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void powerUp(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/powerup.wav"));
            
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void pop(){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/multimedia/pop.wav"));
            
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
