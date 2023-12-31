package com.mycompany.stealthchat;
/*Класс, который находит алгебраическое дополнение*/
public class AlgebraicCofactorMatrix {  // Объявление класса AlgebraicCofactorMatrix.
    private int matrix[][];

    public AlgebraicCofactorMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix1(int[][] matrix) {
    int n = matrix.length;
    int[][] transposedMatrix = new int[n][n];
    int[][] cofactorMatrix = new int[n][n];  // Создаем двумерный массив для хранения матрицы алгебраических дополнений.

    for (int i = 0; i < n; i++) {  // Цикл для перебора строк матрицы.
        for (int j = 0; j < n; j++) {  // Цикл для перебора элементов в строке.
            cofactorMatrix[i][j] = getCofactor(matrix, i, j);  // Вычисляем и сохраняем алгебраическое дополнение.
        }
    }
    for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[j][i] = cofactorMatrix[i][j];
            }
        }
    return transposedMatrix;
}

    public static int getCofactor(int[][] matrix, int row, int col) {  // Метод для вычисления алгебраического дополнения.
        int minorMatrixSize = matrix.length - 1;  // Размер матрицы минора (матрицы без строки и столбца).
        int[][] minorMatrix = new int[minorMatrixSize][minorMatrixSize];  // Создаем минорную матрицу.

        int minorRow = 0;  // Индекс строки в минорной матрице.
        for (int i = 0; i < matrix.length; i++) {  // Цикл для перебора строк исходной матрицы.
            if (i == row) {  // Если текущая строка соответствует удаленной строке.
                continue;  // Пропускаем эту строку и переходим к следующей.
            }
            int minorCol = 0;  // Индекс столбца в минорной матрице.
            for (int j = 0; j < matrix.length; j++) {  // Цикл для перебора элементов в строке.
                if (j == col) {  // Если текущий элемент соответствует удаленному столбцу.
                    continue;  // Пропускаем этот элемент и переходим к следующему.
                }
                minorMatrix[minorRow][minorCol] = matrix[i][j];  // Копируем элемент в минорную матрицу.
                minorCol++;  // Увеличиваем индекс столбца минора.
            }
            minorRow++;  // Увеличиваем индекс строки минора.
        }

        return (int) Math.pow(-1, row + col) * determinant(minorMatrix);  // Возвращаем алгебраическое дополнение.
    }

    public static int determinant(int[][] matrix) {  // Метод для вычисления определителя матрицы.
        int n = matrix.length;  // Получаем размер матрицы.

        if (n == 1) {  // Если матрица 1x1, то определитель равен этому элементу.
            return matrix[0][0];
        }

        if (n == 2) {  // Если матрица 2x2, то используем формулу для определителя матрицы 2x2.
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int det = 0;  // Переменная для хранения определителя.

        for (int j = 0; j < n; j++) {  // Цикл для перебора столбцов первой строки.
            det += matrix[0][j] * getCofactor(matrix, 0, j);  // Суммируем алгебраические дополнения.
        }

        return det;  // Возвращаем определитель.
    }
}

