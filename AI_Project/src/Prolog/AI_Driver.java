package Prolog;

import java.awt.EventQueue;
import java.util.Stack;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class AI_Driver {
	private static Voice voice; 
	private VoiceManager vm = VoiceManager.getInstance();
	private static Stack<Thread> threadStack = new Stack<Thread>(); 
	private static String Words;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainMenu("Covid-19 Expert System"); 
				AI_Driver.TextToSpeech("kevin16", "Covid-19 Expert System");
			}
		});
	}
	
	public static void TextToSpeech(String person, String words) {
		Words = words;
	    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    voice = VoiceManager.getInstance().getVoice(person);
	    if (voice != null) {
	        voice.allocate();// Allocating Voice
	        try {
	            voice.setRate(190);// Setting the rate of the voice
	            voice.setPitch(180);// Setting the Pitch of the voice
	            voice.setVolume(5);// Setting the volume of the voice
	           
	            distroyThreads();//stop any running thread
	        	voiceThread.start();// start voiceover
	        	threadStack.push(voiceThread);//add voiceover to the thread
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	    } else {
	        throw new IllegalStateException("Cannot find voice: " + person);
	    }
	}
	
	
	private static Thread voiceThread = new Thread() {  
		public void run() {
			voice.speak(Words);
			voice.deallocate();
		}
	};
	
	public static void  distroyThreads() {
		while (!threadStack.isEmpty()){
			Thread thread = threadStack.pop();
			thread.stop();
			thread = null;
		}
	}
}

