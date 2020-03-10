package utility;

import models.Command;
import models.Point;

import java.awt.color.CMMException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instructions {
    private ArrayList<Command> commands;

    public Instructions(){
        this.commands = new ArrayList<Command>();
    }

    public void readCommands(File file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        Pattern p = Pattern.compile("[0-9]+");

        while((st = br.readLine()) != null){
            Matcher m = p.matcher(st);
            Point a, b;
            int num1 = 0;
            int num2 = 0 ;
            boolean isArc = false;
            boolean isClockWise = true;

            if(st.charAt(0) == 'l'){
                isArc = false;
            }
            if(st.charAt(1) == 'y'){
                isClockWise = true;
            }
            if(st.charAt(1) == 'n'){
                isClockWise = false;
            }
            if(st.charAt(0) == 'a'){
                isArc = true;
            }

            m.find();
            num1 = Integer.parseInt(m.group());
            m.find();
            num2 = Integer.parseInt(m.group());
            a = new Point(num1, num2);

            m.find();
            num1 = Integer.parseInt(m.group());
            m.find();
            num2 = Integer.parseInt(m.group());
            b = new Point(num1, num2);

            commands.add(new Command(a, b, isArc, isClockWise));
            //commands.add(readLine(st));
        }
    }

    public boolean areEqual(Point a, Point b){
        if(a.getX() == b.getX() && a.getY() == b.getY()){
            return true;
        }
        return false;
    }

    private Command readLine(String st){
        Pattern p = Pattern.compile("[0-9]+");

        System.out.println(st);
        Matcher m = p.matcher(st);
        Point a, b;
        int num1 = 0;
        int num2 = 0 ;

        m.find();
        num1 = Integer.parseInt(m.group());
        m.find();
        num2 = Integer.parseInt(m.group());
        a = new Point(num1, num2);

        m.find();
        num1 = Integer.parseInt(m.group());
        m.find();
        num2 = Integer.parseInt(m.group());
        b = new Point(num1, num2);

        return new Command(a, b);

    }

    private void readArc(String st){
        Pattern p = Pattern.compile("[0-9]+");

        System.out.println(st);
        Matcher m = p.matcher(st);
        Point a;
        int num1 = 0;
        int num2 = 0;
        int width, length, startAngle, arcAngle;

        m.find();
        num1 = Integer.parseInt(m.group());
        m.find();
        num2 = Integer.parseInt(m.group());
        a = new Point(num1, num2);

        m.find();
        width = Integer.parseInt(m.group());
        m.find();
        length = Integer.parseInt(m.group());
        m.find();
        startAngle = Integer.parseInt(m.group());
        m.find();
        arcAngle = Integer.parseInt(m.group());

    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    //    public static void main (String[] args){
//            File file = new File("D:\\University\\year_3\\SCS\\Project\\input.txt");
//
//            try{
//                readCommands(file);
//            }
//            catch(Exception e){
//
//            }
//    }
}
