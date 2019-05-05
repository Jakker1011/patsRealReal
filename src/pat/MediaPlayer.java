
package pat;

import java.io.File;
import javafx.scene.media.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


/**
 *
 * @author Jacob Sacks
 */
public class MediaPlayer {
public void playSound() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Roar.wav").getAbsoluteFile()); //creates a new audioinputstream of the Roar wav file
        Clip clip = AudioSystem.getClip(); //instantiates a clip to hold the sample file 
        clip.open(audioInputStream); //sets the clip as the opened Roar.wav file
        clip.start(); //plays the clip audio
    } catch(Exception ex) {
        JOptionPane.showMessageDialog(null, "Error - the audio could not be played \nThe program can still be used \nPlease call IT Department for assisstance",null, JOptionPane.ERROR); //notifies the user that the clip couldn't be played
    }
}

public void playSound2() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("DOH.wav").getAbsoluteFile()); //creates a new audioinputstream of the Roar wav file
        Clip clip = AudioSystem.getClip(); //instantiates a clip to hold the sample file 
        clip.open(audioInputStream); //sets the clip as the opened Roar.wav file
        clip.start(); //plays the clip audio
    } catch(Exception ex) {
        JOptionPane.showMessageDialog(null, "Error - the audio could not be played \nThe program can still be used \nPlease call IT Department for assisstance",null, JOptionPane.ERROR); //notifies the user that the clip couldn't be played
    }
}
}