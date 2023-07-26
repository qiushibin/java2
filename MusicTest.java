import javax.sound.midi.*;

public class MusicTest {
    public void play() throws badex{
        try{
            Sequencer  sequencer = MidiSystem.getSequencer();
            
            int i = 1;
            if(i>10){
                throw new badex();
            }
            
            sequencer.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track t = seq.createTrack();
            
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            t.add(noteOn);
            
            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            t.add(noteOff);

            sequencer.setSequence(seq);
            sequencer.start();
            System.out.println("Successfully got a sequencer");

        } catch(MidiUnavailableException | InvalidMidiDataException ex){
            System.out.println("Bummer");
            ex.printStackTrace();
        }
        
    }

    public class badex extends Exception{
    }

    public static void main(String[] args){
        MusicTest mt = new MusicTest();
        try{
            mt.play();
        }catch(badex ex){
            System.out.println("badex");
        }finally{
            System.out.println("finally");
        }
    }

}
