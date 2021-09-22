/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ibrahim salah mohame
 */
public class start implements ActionListener{
    JFrame frame;
    JPanel background,start,exit;
    JButton startb, exitb;
    public start(){
        // Createing JFrame
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setLocation((screenWidth-frame.getWidth())/2, (screenHeight-frame.getHeight())/2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // Creating backround panel
        background=new JPanel();
        background.setBackground(new Color(163, 193, 255));
        // Creating panel for start button
        start=new JPanel();
        start.setBackground(new Color(163, 193, 255));
        start.setBounds((500-220)/2, 120, 220, 70);
                  // Adding start button
        startb=new JButton("Start");
        startb.setFont(new Font("san serif", Font.BOLD, 40));
        startb.addActionListener(this);
        start.add(startb);
        // Creating panel for exit button
        exit=new JPanel();
        exit.setBackground(new Color(163, 193, 255));
        exit.setBounds((500-220)/2, 240, 220, 70);
                  // Adding exit button
        exitb=new JButton("Exit");
        exitb.setFont(new Font("san serif", Font.BOLD, 40));
        exitb.addActionListener(this);
        exit.add(exitb);
        // Adding components to the frame
        frame.add(start);
        frame.add(exit);
        frame.add(background);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startb){
            information info= new information();
            frame.dispose();
        }
        if(e.getSource()==exitb)
            frame.dispose();
    }
}
