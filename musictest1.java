import javax.sound.midi.*;
public class musictest1{
	public void play(){
		try{
		Sequencer sequencer=MidiSystem.getSequencer();
		System.out.println("We got a sequence");
	} catch(MidiUnavailableException ex){
		System.out.println("Damnit");
	}
	}
	public static void main(String[] args){
		musictest1 mt=new musictest1();
		mt.play();
	}
}