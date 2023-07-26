import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GUITest {
    JButton button, bsave;
    JRadioButton rad, rad2;
    JFrame frame;
    JLabel lab;
    JTextField text = new JTextField("pleass:", 20);
    int i;
    ButtonGroup bg = new ButtonGroup();

    public static void main(String[] args) {
        GUITest gui = new GUITest();
        gui.play();
    }

    public void play() {
        frame = new JFrame();

        rad = new JRadioButton("save file");
        rad2 = new JRadioButton("dialog");
        button = new JButton("chick me", null);
        button.addActionListener(new inclass());
        bsave = new JButton("save", null);
        bsave.addActionListener(new inclass());

        lab = new JLabel("label:");
        lab.setForeground(Color.GREEN);
        bg.add(rad);
        bg.add(rad2);

        JPanel jpb = new JPanel();
        // jpb.setLayout(new BorderLayout());
        jpb.setBackground(Color.DARK_GRAY);
        // jpb.add(rad);
        jpb.add(lab);
        jpb.add(text);
        text.addActionListener(new inclasst());

        JPanel jpb2 = new JPanel();
        jpb2.setLayout(new BoxLayout(jpb2, BoxLayout.Y_AXIS));
        jpb2.setBackground(Color.LIGHT_GRAY);
        jpb2.add(rad);
        jpb2.add(rad2);
        jpb2.add(button);
        jpb2.add(bsave);

        drawpanel dp = new drawpanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, jpb);
        frame.getContentPane().add(BorderLayout.EAST, jpb2);
        frame.getContentPane().add(BorderLayout.CENTER, dp);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setTitle("ddGUIdd");

    }

    class inclass implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button && i % 2 == 1)
                button.setText("2222");
            else
                button.setText("1111");
            if (e.getSource() == bsave) {

                try {
                    if (rad2.isSelected()) {
                        JFileChooser fs = new JFileChooser();
                        fs.showOpenDialog(frame);
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fs.getSelectedFile()));
                        writer.write("dialog  " + text.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(null, "dig save over", "title: no null",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        try (FileWriter fw = new FileWriter("foo.txt")) {
                            fw.write(text.getText());
                            fw.close();
                            JOptionPane.showMessageDialog(null, "save over", "title: no null",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

            } else {
                frame.repaint();
                i++;
                lab.setText("lab:" + Integer.toString(i));
                text.requestFocus();
            }
        }

    }

    class inclasst implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null, text.getText(), "title: no null", JOptionPane.ERROR_MESSAGE);
        }

    }

}