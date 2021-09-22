/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author ibrahim salah mohame
 */
public class information implements ActionListener {
    JFrame frame;
    JLabel player1,player2;
    JTextField name1, name2;
    JButton play;
    
    public information(){
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 500);
        frame.setLocation((screenWidth-frame.getWidth())/2, (screenHeight-frame.getHeight())/2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(new Color(163, 193, 255));
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        player1 = new JLabel("Player1(x): ");
        player1.setFont(new Font("Sans serif",Font.BOLD,26));
        player2 = new JLabel("Player2(o): ");  
        player2.setFont(new Font("Sans serif",Font.BOLD,26));
        name1= new JTextField("", 15);
        name1.setFont(new Font("Sans serif",Font.BOLD,20));
        name2= new JTextField("", 15);
        name2.setFont(new Font("Sans serif",Font.BOLD,20));
        play = new JButton("Play");
        play.setFont(new Font("Sans serif",Font.BOLD,20));
        play.addActionListener(this);
        contentPane.add(player1);  
        contentPane.add(name1);
        contentPane.add(player2);  
        contentPane.add(name2); 
        contentPane.add(play);
        layout.putConstraint(SpringLayout.WEST, player1,60,SpringLayout.WEST, contentPane); 
        layout.putConstraint(SpringLayout.NORTH, player1, 150, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, name1,210,SpringLayout.WEST, contentPane); 
        layout.putConstraint(SpringLayout.NORTH, name1, 153, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, player2,60,SpringLayout.WEST, contentPane); 
        layout.putConstraint(SpringLayout.NORTH, player2, 200, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, name2,210,SpringLayout.WEST, contentPane); 
        layout.putConstraint(SpringLayout.NORTH, name2, 203, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, name2,5,SpringLayout.EAST, player2);
        layout.putConstraint(SpringLayout.WEST, name1,5,SpringLayout.EAST, player1);
        layout.putConstraint(SpringLayout.WEST, play,200,SpringLayout.WEST, contentPane); 
        layout.putConstraint(SpringLayout.NORTH, play, 280, SpringLayout.NORTH, contentPane);
        
        
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play&&!"".equals(name1.getText())&&!"".equals(name2.getText())){
            Game1 game=new Game1(name1.getText(),name2.getText());
            frame.dispose();
        }
    }
    
    
}
