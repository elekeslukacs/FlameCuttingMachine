package view;

import models.Arc;
import models.Command;
import utility.Instructions;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.io.File;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class DrawLines extends JFrame {

    Instructions ins;
    File file;
    public DrawLines(File file){
        this.setTitle("Graphics");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        ins = new Instructions();
        this.file = file;
        try {
            ins.readCommands(file);
        }
        catch(Exception e){

        }
        ArrayList<Command> commands = ins.getCommands();
        if(!ins.areEqual(commands.get(0).getA(),commands.get(commands.size()-1).getB())){
            showMessageDialog(null, "WARNING: Start and final finish point are not the same!");
        }
    }

    public void paint(Graphics g){

        for(Command c : ins.getCommands()) {
            System.out.println(c.toString());
            g.setColor(Color.BLACK);
            if (c.isArc()) {
                Arc arc = new Arc(c.getA(), c.getB(), c.isClockWise());
                for(int i = arc.getLength(); i >=0; i-=5){
                    if(c.isReverse()){
                        if(arc.isClockWise()){
                            g.drawArc(arc.getX(), arc.getY(), arc.getLength(), arc.getWidth(), arc.getStartAngle(), arc.getArcAngle() +i);
                        }
                        else{
                            g.drawArc(arc.getX(), arc.getY(), arc.getLength(), arc.getWidth(), arc.getStartAngle(), arc.getArcAngle() - i);
                        }
                    }
                    else {
                        if(arc.isClockWise()){
                            g.drawArc(arc.getX(), arc.getY(), arc.getLength(), arc.getWidth(), arc.getStartAngle(), arc.getArcAngle() + i);
                        }
                        else {
                            g.drawArc(arc.getX(), arc.getY(), arc.getLength(), arc.getWidth(), arc.getStartAngle(), arc.getArcAngle() - i);
                        }

                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {

                    }
                }
//                g.drawArc(arc.getX(), arc.getY(), arc.getLength(), arc.getWidth(), arc.getStartAngle(), arc.getArcAngle());
            } else {

                for(int i = c.getLength() - 5; i >= 0; i-=5){
                    if(c.isHorizontal()){
                        if(c.isReverse()){
                            g.drawLine(c.getA().getX(), c.getA().getY(), c.getB().getX()+i, c.getB().getY());
                        }
                        else {
                            g.drawLine(c.getA().getX(), c.getA().getY(), c.getB().getX() - i, c.getB().getY());
                        }
                    }
                    else {
                        if(c.isReverse()){
                            g.drawLine(c.getA().getX(), c.getA().getY(), c.getB().getX(), c.getB().getY()+i);
                        }
                        else {
                            g.drawLine(c.getA().getX(), c.getA().getY(), c.getB().getX(), c.getB().getY() -i );
                        }
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }

//        for(int i = 100; i >=0; i-=5){
//            g.drawLine(400, 250, 300i, 250);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//
//            }
//        }
        //g.drawLine(0, 250, 500, 250);
        //g.drawArc(250, 200, 100, 100, 90, 180);

    }

}
