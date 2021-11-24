package Prolog;

import java.awt.EventQueue;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class AI_Driver {
	private static final String VOICENAME = "kevin16"; 
	private static Voice voice; 
	private VoiceManager vm = VoiceManager.getInstance();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainMenu("Covid-19 Management System"); 
				AI_Driver.TextToSpeech("kevin16", "Covid-19 Management System");
			}
		});
	}
	
	public static void TextToSpeech(String person, String words) {
	    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    voice = VoiceManager.getInstance().getVoice(person);
	    if (voice != null) {
	        voice.allocate();// Allocating Voice
	        try {
	            voice.setRate(190);// Setting the rate of the voice
	            voice.setPitch(150);// Setting the Pitch of the voice
	            voice.setVolume(3);// Setting the volume of the voice
	            voice.speak(words);// Calling speak() method

	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }

	    } else {
	        throw new IllegalStateException("Cannot find voice: " + person);
	    }
	}

}

