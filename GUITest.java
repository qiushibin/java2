import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class GUITest {
    JButton button ;
    JRadioButton  rad ;
    JFrame frame;
    public static void main (String[] args){
        GUITest gui = new GUITest();
        gui.play();
    }

    public void play(){
     frame = new JFrame();
       
        rad = new JRadioButton("choose");
        button = new JButton("chick me", null);
        button.addActionListener(new inclass());
        JLabel lab = new JLabel("label");
        lab.setForeground(Color.GREEN);
        
        JPanel jpb =  new JPanel();
        //jpb.setLayout(new BorderLayout());
        jpb.setBackground(Color.DARK_GRAY);
        //jpb.add(rad);
        jpb.add(lab);
        
        JPanel jpb2 =  new JPanel();
        jpb2.setLayout(new BoxLayout(jpb2,BoxLayout.Y_AXIS));
        jpb2.setBackground(Color.LIGHT_GRAY);
        jpb2.add(rad);
        jpb2.add(button);

        drawpanel dp = new drawpanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH ,jpb);
        frame.getContentPane().add(BorderLayout.EAST ,jpb2);
        frame.getContentPane().add(BorderLayout.CENTER ,dp);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setTitle("ddGUIdd");
        
    }

   class inclass implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == button)
            button.setText("2222");
       frame.repaint();
    }
    
   }

    
}