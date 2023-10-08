package com.mycompany.stealthchat;
/*Класс, который позволяет умножать матрицу на число.*/
public class MultiplyingMatrixByNumber {
    private int Array1[][];    // Массив, который будет умножен на число
    private int number;        // Число, на которое будет умножаться каждый элемент массива
    private int number2;       // Второе число, которое будет использоваться при умножении

    // Конструктор класса, принимающий массив, число, и второе число
    public MultiplyingMatrixByNumber(int[][] Array1, int number, int number2) {
        this.Array1 = Array1;
        this.number = number;
        this.number2 = number2;
    }

    // Метод для умножения массива на число и взятия остатка по модулю
    public int[][] MultiplicationMatrixByNumber() {
        int rows1 = Array1.length;     // Количество строк в Array1
        int[][] result = new int[rows1][rows1]; 

        // Проходимся по каждому элементу массива
        for (int i = 0; i < rows1; i++) {
           for (int j = 0; j < rows1; j++) {
            // Вычисляем произведение элемента массива на number2 и берем остаток по модулю числа
            result[i][j] = Math.floorMod(Array1[i][j] * number2,number);
            }
}

        return result; // Возвращаем результирующий массив
    }
}
