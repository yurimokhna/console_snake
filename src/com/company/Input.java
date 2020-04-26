package com.company;
//Класс управления вводом хода игры
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Input {
    static String step;
    public static Directions input () throws AWTException {
        Robot r = new Robot();
        Scanner scan = new Scanner(System.in,  "Cp866");
        r.keyPress(KeyEvent.VK_ENTER);
        step = scan.nextLine();
        if(step.length() == 0) return Directions.NULL;
        if(step.equals("a")||step.equals("ф")) return Directions.LEFT;
        if(step.equals("d")||step.equals("в")) return Directions.RIGTH;
        if(step.equals("w")||step.equals("ц")) return Directions.UP;
        if(step.equals("s")||step.equals("ы")) return Directions.DOWN;
        return Directions.NULL;
    }
}
