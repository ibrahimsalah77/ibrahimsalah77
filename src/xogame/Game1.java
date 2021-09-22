/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

/**
 *
 * @author ibrahim salah mohame
 */
public class Game1 implements ActionListener{
    JFrame frame;
    Label name1 ,name2,result,x_score,o_score;
    JPanel p1,p2;
    JButton[] b;
    SpringLayout layout;
    int counter,xscore=0,oscore=0;
    int[] win;

    public  Game1(String player1,String player2){
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(500, 600);
        frame.setLocation((screenWidth-frame.getWidth())/2, (screenHeight-frame.getHeight())/2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        counter=0;

        p1=new JPanel();
        p1.setLayout(new GridLayout(3, 3));
        win=new int[9];
        for(int i=0;i<9;i++){
            win[i]=0;
        }
        b=new JButton[9];
        for(int i=0;i<9;i++){
            JButton button =new JButton();
            button.setBackground(new Color(20,189,172));
            button.setBorder(new LineBorder(new Color(16,161,146), 5, false));
            button.addActionListener(this);
            b[i]=button;
            p1.add(button);
        }
        p2=new JPanel();
 
        layout=new SpringLayout();
        p2.setLayout(layout);
        p2.setBackground(Color.white);
        p2.setPreferredSize(new Dimension(500 , 150));
        result = new Label("result");
        result.setFont(new Font("san serif", Font.BOLD, 26));
        name1 = new Label(player1);
        name1.setFont(new Font("san serif", Font.BOLD, 26));
        name2 = new Label(player2);
        name2.setFont(new Font("san serif", Font.BOLD, 26));
        x_score=new Label(String.valueOf(xscore));
        x_score.setFont(new Font("san serif", Font.BOLD, 26));
        o_score=new Label(String.valueOf(oscore));
        o_score.setFont(new Font("san serif", Font.BOLD, 26));
        p2.add(result);
        p2.add(name1);
        p2.add(name2);
        p2.add(x_score);
        p2.add(o_score);
        layout.putConstraint(SpringLayout.WEST, result, 210, SpringLayout.WEST, p2);
        layout.putConstraint(SpringLayout.WEST, name1, 30, SpringLayout.WEST, p2);
        layout.putConstraint(SpringLayout.NORTH, name1, 50, SpringLayout.NORTH, p2);
        layout.putConstraint(SpringLayout.WEST, name2, 30, SpringLayout.WEST, p2);
        layout.putConstraint(SpringLayout.NORTH, name2, 80, SpringLayout.NORTH, p2);
        layout.putConstraint(SpringLayout.WEST, x_score, 300, SpringLayout.WEST, p2);
        layout.putConstraint(SpringLayout.NORTH, x_score, 50, SpringLayout.NORTH, p2);
        layout.putConstraint(SpringLayout.WEST,o_score, 300, SpringLayout.WEST, p2);
        layout.putConstraint(SpringLayout.NORTH, o_score, 80, SpringLayout.NORTH, p2);
        frame.add(p1,BorderLayout.CENTER);
        frame.add(p2,BorderLayout.SOUTH);
    }
    
    public boolean XHasWon(){
        boolean test=false;
         if((win[0]==1&&win[1]==1&&win[2]==1)||(win[3]==1&&win[4]==1&&win[5]==1)
                        ||(win[6]==1&&win[7]==1&&win[8]==1)
                        ||(win[0]==1&&win[3]==1&&win[6]==1)
                        ||(win[1]==1&&win[4]==1&&win[7]==1)
                        ||(win[2]==1&&win[5]==1&&win[8]==1)
                        ||(win[0]==1&&win[4]==1&&win[8]==1)
                        ||(win[2]==1&&win[4]==1&&win[6]==1)){
                    test=true;
                   
                }
         return test;
    }
    public boolean OHasWon(){
        boolean test=false;
        if((win[0]==1&&win[1]==1&&win[2]==1)||(win[3]==1&&win[4]==1&&win[5]==1)
                        ||(win[6]==2&&win[7]==2&&win[8]==2)
                        ||(win[0]==2&&win[3]==2&&win[6]==2)
                        ||(win[1]==2&&win[4]==2&&win[7]==2)
                        ||(win[2]==2&&win[5]==2&&win[8]==2)
                        ||(win[0]==2&&win[4]==2&&win[8]==2)
                        ||(win[2]==2&&win[4]==2&&win[6]==2)){
                     test=true;
                }
        return test;
    }
    
    public boolean isDraw(){
        return(!XHasWon()&&!OHasWon());
            }
    
    public void repaint(){
        counter=0;
        p1.removeAll();
        for(int i=0;i<9;i++){
            JButton button =new JButton();
            button.setBackground(new Color(20,189,172));
            button.setBorder(new LineBorder(new Color(16,161,146), 5, false));
            button.addActionListener(this);
            b[i].setText("  ");
            b[i]=button;
            p1.add(button);
        }
        for(int i=0;i<9;i++){
            win[i]=0;
        }
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<9;i++){
            if(e.getSource()==b[i]){
                if(counter%2==0&&"".equals(b[i].getText())){
                b[i].setText("x");
                b[i].setFont(new Font("san serif", Font.BOLD,124));
                b[i].setForeground(new Color(255,194,0));
                win[i]=1;
                counter++;  
                if (XHasWon()){
                    x_score.setText(String.valueOf(++xscore));
                    repaint();   
                }
                }
                else if(counter%2!=0&&"".equals(b[i].getText())) {
                    b[i].setText("o");
                    b[i].setFont(new Font("san serif", Font.BOLD,124));
                    win[i]=2;    
                    counter++; 
                    if(OHasWon()){
                        o_score.setText(String.valueOf(++oscore));
                        repaint();          
                }
                }  
                if(isDraw()&&counter==9)
                repaint();
            } 
            
            
           
            
        }
        
        
        }
            }
        

    

