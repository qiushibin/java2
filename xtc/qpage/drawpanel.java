package xtc.qpage;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class drawpanel extends JPanel{
   
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        Color   sc = new Color(red, blue, green);

         red = (int) (Math.random() * 255);
         blue = (int) (Math.random() * 255);
         green = (int) (Math.random() * 255);
        Color   ec = new Color(red, blue, green);

        GradientPaint grad = new GradientPaint(70, 70, sc, 200, 200, ec);
        g2d.setPaint(grad);
        g2d.fillOval(200, 70, 100, 100);
    }

}