package com.company;

import java.io.IOException;
// Класс отрисовки игры
public class DrawGame {
    public static void draw(Snake snake, Bonus bonus, GameField gameField) throws IOException, InterruptedException {

        String [][] mass = new String [9][15]; //создаем массив для отображения игры

        for (int i = 0; i < mass.length; i++) {                                 //очищаем
            for (int j = 0; j < mass[0].length; j++) { mass[i][j] = " "; }      //игровой
        }                                                                       //массив

       mass[bonus.coordinate.x][bonus.coordinate.y] = "O";                      //помещаем в массив бонус

       for (int i = 0; i < snake.getSizeSnakeMass(); i++){                       //помещаем
           if(snake.getElement(i) != null) {                                     //в массив
               mass[snake.getElement(i).x][snake.getElement(i).y] = "*";         //тело змейки
           }
       }


        System.out.println(" " + "_______________" + "" + "");                   // отрисовка
        for (int i = 0; i < 9; i++) {                                            // игрового
            System.out.print("|");                                               // поля
            for (int j = 0; j < 15; j++) {
                System.out.print(mass[i][j]);
            }
            System.out.println("|");
        }

        System.out.println(" " + "---------------");
        System.out.print("Ваш счет: ");
        if(gameField.getScore() == 0)  System.out.println(gameField.getScore() + " очков");                 // вывод
        else if(gameField.getScore() == 1)  System.out.println(gameField.getScore() + " очко");             // счета
        else if(gameField.getScore() == 2 || gameField.getScore() == 3 || gameField.getScore() == 4)        //игры
            System.out.println(gameField.getScore() + " очка");
        else System.out.println(gameField.getScore() + "" + " очков");

        System.out.println("Текущая координата бонуса по Х " + bonus.coordinate.x);
        System.out.println("Текущая координата бонуса по У " + bonus.coordinate.y);
        int sleep = 400;
        if (gameField.getScore() <= 1 ) Thread.sleep(sleep);
        else if (gameField.getScore() <= 3 ) Thread.sleep(sleep-60);
        else if (gameField.getScore() <= 5 ) Thread.sleep(sleep-120);
        else if (gameField.getScore() <= 7 ) Thread.sleep(sleep-180);
        else if (gameField.getScore() > 7 ) Thread.sleep(sleep-240);

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // ощищаем консольдля отрисовки игры
    }
}

