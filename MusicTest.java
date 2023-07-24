import javax.sound.midi.*;


public class MusicTest{
    public void play(){
        try{
            Sequencer  sequencer = MidiSystem.getSequencer();
            System.out.println("Successfully got a sequencer");
        } catch(MidiUnavailableException ex){
            System.out.println("Bummer");
        }
    }

    public static void main(string[] args){
        MusicTest mt = new MusicTest();
        mt.play();
    }

}
