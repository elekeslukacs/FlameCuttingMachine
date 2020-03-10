package start;

import models.Command;
import utility.Instructions;
import view.DrawLines;

import java.io.File;
import java.util.ArrayList;

public class Start {

    public static void main (String[] args){
        File file = new File("D:\\University\\year_3\\SCS\\Project\\input.txt");

       // Instructions ins = new Instructions();
        DrawLines lines = new DrawLines(file);
    }
}
