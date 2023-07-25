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

        
        JPanel jpb =  new JPanel();
        jpb.setLayout(new BorderLayout());
        jpb.setSize(50, 50);
        jpb.setBackground(Color.white);
        
        jpb.add(rad,BorderLayout.WEST);
        jpb.add(button,BorderLayout.EAST);
        
        drawpanel dp = new drawpanel();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH ,jpb);
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