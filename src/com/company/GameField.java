package com.company;
//Класс игрового поля
public class GameField {

    private int score = 0;
    public void increaseScore(){
        score++;
    }
    public int getScore(){
        return score;
    }
    public void lessenScore(int count) { score -= count;  }

    public Coordinate randomCoordinate (){
        return new Coordinate((int)(Math.random()*8), (int)(Math.random()*14));
    }
    public boolean isGameOver(Snake snake){
        if (snake.getHead().x < 0 || snake.getHead().y < 0 ||
                snake.getHead().x > 8 || snake.getHead().y > 14) {
            System.out.println("Змейка вышла за пределы игрового поля, ВЫ ПРОИГРАЛИ");
            return true;
        }
        return false;
    }

    public void snakeBitItself (Snake snake) {
        for (int j = 1; j < snake.getSizeSnakeMass(); j++) {
            if (snake.getElement(j) != null) {
                if (snake.getElement(j).x == snake.getHead().x && snake.getElement(j).y == snake.getHead().y) {
                    System.out.println("Змейка съела сама себя");
                    int countLessonScore = 0;
                    for (int i = j; i <snake.getSizeSnakeMass(); i++){
                        snake.delete(i);
                        countLessonScore++;
                    }
                    lessenScore(countLessonScore);
                }
            }
        }
    }
 }


