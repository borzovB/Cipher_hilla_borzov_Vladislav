package com.mycompany.stealthchat;
//Класс для нахождения определителя матрицы шифрования ключа
public class MatrixDeterminant {
    private int Array[][]; // Двумерный массив, представляющий матрицу

    public MatrixDeterminant(int[][] Array) {
        this.Array = Array; // Конструктор класса, принимает матрицу в качестве аргумента и сохраняет ее
    }

    // Метод для вычисления определителя матрицы
    public int Calculation(int[][] Array) {
        int n = Array.length; // Размерность матрицы (количество строк)

        int determinant = 0; // Инициализируем переменную для хранения определителя

        // Если матрица 1x1, возвращаем ее единственный элемент
        if (n == 1) {
            return Array[0][0];
        }
        // Если матрица 2x2, используем формулу для вычисления определителя 2x2 матрицы
        else if (n == 2) {
            return Array[0][0] * Array[1][1] - Array[1][0] * Array[0][1];
        }

        // Для матриц большего размера используем разложение по первой строке
        for (int j = 0; j < n; j++) {
            // Вычисляем минор (определитель подматрицы) и учитываем знак
            determinant += Array[0][j] * Math.pow(-1, 0 + j) * Calculation(submatrix(Array, 0, j));
        }

        return determinant; // Возвращаем итоговый определитель
    }

    // Метод для создания подматрицы, удаляя указанную строку и столбец
    public static int[][] submatrix(int[][] matrix, int row, int col) {
        int n = matrix.length; // Размерность оригинальной матрицы

        int[][] submatrix = new int[n - 1][n - 1]; // Создаем подматрицу с размерностью на 1 меньше

        int newRow = 0;
        // Проходим по строкам оригинальной матрицы, начиная со второй строки
        for (int i = 1; i < n; i++) {
            int newCol = 0;
            // Проходим по столбцам оригинальной матрицы
            for (int j = 0; j < n; j++) {
                // Пропускаем указанную строку и столбец
                if (j == col) {
                    continue;
                }

                // Заполняем подматрицу элементами из оригинальной матрицы
                submatrix[newRow][newCol] = matrix[i][j];
                newCol++;
            }

            newRow++;
        }

        return submatrix; // Возвращаем подматрицу без указанной строки и столбца
    }
}
