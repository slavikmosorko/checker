package com.pmi.checker.http.soundalert;

import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

@Component
public class SoundAlert implements ISoundAlert {
    @Override
    public synchronized void playSound() {
        Runnable playSound = () -> {
            try {
                Clip clip = AudioSystem.getClip();
                URL url = this.getClass().getResource("/audio/alert.wav");
                AudioInputStream inputStream =  AudioSystem.getAudioInputStream(url);
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        };
        new Thread(playSound).start();
    }
}
