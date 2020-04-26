package com.company;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, AWTException {

        GameField gameField = new GameField(); //создание игрового поля
        Bonus bonus = new Bonus(gameField.randomCoordinate()); // создание бонуса в случайном месте в перделах массива

        Snake snake = new Snake();  //создаем объект змейки
      //  int numberElements = 0; //инициализируем переменную для вставки элементов змейки в массив
        snake.addElement(new Coordinate(1,8)); // Создаем голову змейки и помещаем в первый элемент массива
        boolean gameComplete = false; // переменная окончания игры

            while (!gameComplete){
                DrawGame.draw(snake, bonus, gameField);                     // рисуем игру
                if ((snake.getHead().x == bonus.coordinate.x) &&            // проверяем на столкновение
                        (snake.getHead().y == bonus.coordinate.y)) {        // головы с едой
                    gameField.increaseScore();                                       // увеличиваем счет
                    snake.addElement(new Coordinate(bonus.coordinate.x, bonus.coordinate.y));
                    bonus = new Bonus(gameField.randomCoordinate());     //  в случае столкновения добавляем новый элемент тела и новую еду
                }

                System.out.print("Ввод команды: ");
                Directions step = Input.input();        //получаем ввод команды для изменения положения гоовы змейки
                snake.setDirection(step);               // меняем направление движения
                snake.move() ;                          //меняем направление движения змейки

                gameComplete = gameField.isGameOver(snake);                    //проверка на проигрыш
                gameField.snakeBitItself(snake);
               /* if(gameField.getScore() == snake.getSizeSnakeMass() - 1) {     //проверка
                    System.out.println("ВЫ ПОБЕДИЛИ");                         //на
                    gameComplete = true;                                        //победу
                }*/

               if (gameField.getScore() == 13) {                        //проверка
                   System.out.println("ВЫ ПОБЕДИЛИ");                   //на
                   gameComplete = true;                                  //победу
               }
            }

        System.out.println("Пока"); //завершение игры
   }
}




