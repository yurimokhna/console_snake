package com.company;

import java.util.ArrayList;

//Класс змейки
public class Snake {

   private static Directions lastCommand = Directions.NULL; //для записи прошлой команды

  // private Coordinate [] snakeMass2 = new Coordinate[10];
   ArrayList<Coordinate> snakeMass = new ArrayList<>();

   public void delete (int index) {
       this.snakeMass.remove(index);
   }

    // Добавить новый элемент тела
   public void addElement ( Coordinate coordinate) {
       this.snakeMass.add(coordinate);
   }
    //получить голову
    public Coordinate getHead () {
        return this.snakeMass.get(0);
    }
    //получить элемент змейки
    public Coordinate getElement (int index) {
        return this.snakeMass.get(index);
    }
    //получить размер массива
    public int getSizeSnakeMass (){
       return this.snakeMass.size();
    }
    //установка направления движения
    public void setDirection (Directions step) {
        Directions actualCommand = step;
        if (actualCommand != Directions.NULL) lastCommand = actualCommand;
    }
    //перемещение всей змейки
    public void move () {
        for (int j = this.snakeMass.size() - 1; j > 0; j--) {
            if (this.snakeMass.get(j) != null) {
                this.snakeMass.get(j).x = this.snakeMass.get(j - 1).x;
                this.snakeMass.get(j).y = this.snakeMass.get(j - 1).y;
           }
        }

        switch (lastCommand) {
            case LEFT:
                this.snakeMass.get(0).y--;
                break;
            case RIGTH:
                this.snakeMass.get(0).y++;
                break;
            case UP:
                this.snakeMass.get(0).x--;
                break;
            case DOWN:
                this.snakeMass.get(0).x++;
                break;
        }
    }
}


