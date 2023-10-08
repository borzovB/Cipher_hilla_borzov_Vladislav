package com.mycompany.stealthchat;
import java.util.Scanner;
/*Этот класс в Java представляет собой часть программы, предназначенной для шифрования и расшифрования текста с
использованием алгоритма расшифровки и зашифровки шифра Хилла.*/
public class StealthChat {
//Пример ввода:
/*Номер 1*/
/*Строка, для зашифровки: когда_обрывается_лентааа*/
/*Ключ: приветики*/
/*Строка для расшифровки: нёяижсгшгбьойгиюцдз,аааа*/
/*Номер 2*/
 /*Строка, для зашифровки: когда_обрывается_лентааа*/
/*Ключ: стол*/
/*Строка для расшифровки: влтт?мэоч??эжжжшжгцфищаа*/ 
/*Номер 3*/
/*Строка, для зашифровки: когда_обрывается_лента_скажи_мне*/
/*Ключ: приветики*/
/*Строка для расшифровки: нёяижсгшгбьойгиюцдз,ар?ьржне.ыяоо*/
    public static void main(String[] args) {
        // Создаем объект Scanner для считывания ввода пользователя с кодировкой Windows-1251
        Scanner s = new Scanner(System.in, "Windows-1251");
        // Просим пользователя ввести строку и сохраняем её в decryptionCipher
        System.out.print("Вводите строку: ");
        String decryptionCipher = s.nextLine();
        System.out.print("\n");
        // Просим пользователя ввести ключевое слово и сохраняем его в keyword
        System.out.print("Вводите ключевое слово: ");
        String keyword = s.nextLine();
        System.out.print("\n");
        // Вычисляем длину строки decryptionCipher
        int lengthDecryptionCipher = decryptionCipher.length();
        // Создаем массив символов для строки decryptionCipher
        char[] charArrayDecryptionCipher = new char[lengthDecryptionCipher];
        // Заполняем массив charArrayDecryptionCipher символами из decryptionCipher
        for (int i = 0; i < lengthDecryptionCipher; i++) {
            charArrayDecryptionCipher[i] = decryptionCipher.charAt(i);
        }
        
        int lengthKeyword = keyword.length();
        // Вычисляем длину ключевого слова keyword
        int squareRoot1 = (int) Math.sqrt(lengthKeyword);
        // Вычисляем квадратный корень от длины ключевого слова
        char[] charArrayKeyword = new char[lengthKeyword];
        // Создаем массив символов для ключевого слова keyword
        // Заполняем массив charArrayKeyword символами из keyword
        for (int i = 0; i < lengthKeyword; i++) {
            charArrayKeyword[i] = keyword.charAt(i);
        }
        // Вычисляем размер массива для числовых значений символов ключевого слова
        int ArrayNumKey =  (int)Math.sqrt(charArrayKeyword.length);
        // Создаем объект ConvertingCharactersToNumbers для преобразования символов
        // ключевого слова и строки в числа
        ConvertingCharactersToNumbers convertingCharactersToNumbers =new ConvertingCharactersToNumbers(charArrayKeyword, ArrayNumKey, charArrayDecryptionCipher);
        // Создаем объект CheckingTheAlphabet для проверки символов в строке
         int[][] intergers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();
         int[] intergersAlphabetArray = convertingCharactersToNumbers.AlphabetArray();
        CheckingTheAlphabet checkingTheAlphabetLine = new CheckingTheAlphabet(charArrayDecryptionCipher);
        CheckingTheAlphabet checkingTheAlphabetKey = new CheckingTheAlphabet(charArrayKeyword);
        // Создаем объект MatrixDeterminant для вычисления детерминанта матрицы
        
        MatrixDeterminant matrixDeterminant = new MatrixDeterminant(intergers);
        // Проверяем правильность ввода символов и детерминант матрицы
        int checkingLine = checkingTheAlphabetLine.Check();
        int numberInStorage = checkingTheAlphabetLine.getArrayAlphabetSize();
        int checkingKey = checkingTheAlphabetKey.Check();
        int conditionDeterminant = matrixDeterminant.Calculation(intergers);
        // Проверяем условия для выполнения операции
        // Проверяем, что длина ключа является квадратом целого числа
        if(conditionDeterminant == 0||conditionDeterminant == 1){
            System.out.print("\n");
            System.out.println("Не правильный ввод ключа, введите его ещё раз!!!");
            
        }else{
            double squareRoot = Math.sqrt(lengthKeyword);
            
            if (squareRoot == Math.floor(squareRoot)) {
                
                if(checkingLine!=charArrayDecryptionCipher.length){
                    
                    System.out.print("\n");
                    System.out.println("Не существующие символы в строке!!!");
                    // Выводим введенную строку и ключ
                }else{if(checkingKey!=charArrayKeyword.length){
                    
                   System.out.print("\n");
                   // Просим пользователя выбрать операцию (Зашифровать/Расшифровать)
                   System.out.println("Не существующие символы в ключе!!!"); 
                   
                }else{
                    
                    System.out.print("Введённая строка: ");
                   for (int i = 0; i < lengthDecryptionCipher; i++) {
            /*Вывод на экран введённой строки*/           
            System.out.print(charArrayDecryptionCipher[i]);
            
        }
                   
         System.out.print("\n");
         System.out.print("Введённый ключ: ");
         
         for (int i = 0; i < lengthKeyword; i++) {
             
            System.out.print(charArrayKeyword[i]);
            /*Вывод на экран введенного ключа*/
        }
        System.out.print("\n");
        System.out.print("Введите название операции (Зашифровать/Расшифровать): ");
        String operation = s.nextLine();
        System.out.print("\n");
        // В зависимости от выбранной операции выполняем соответствующие действия
        if(operation.equals("Зашифровать")){    
         // Создаем массив arrayOfText для хранения чисел, которые будут преобразованы в текст
        int[] arrayOfText = new int[ArrayNumKey];

        // Вычисляем остаток от деления длины массива intergersAlphabetArray на ArrayNumKey
        int remains = intergersAlphabetArray.length % ArrayNumKey;

        // Вычисляем размерность (dimension) для последующего расшифрования
        int dimension;

        // Если остаток от деления не равен нулю, увеличиваем размерность до ближайшего кратного ArrayNumKey числа
        if (remains != 0) {
          dimension = intergersAlphabetArray.length + (ArrayNumKey - remains);
         } else {
             // Иначе, оставляем размерность без изменений
            dimension = intergersAlphabetArray.length;
         }

         // Выводим заголовок перед результатом
         System.out.print("Результат: ");

         // Начинаем итерацию по массиву intergersAlphabetArray с шагом ArrayNumKey
        for (int i = 0; i < dimension; i += ArrayNumKey) {
        // Вычисляем количество элементов, которые нужно скопировать на текущей итерации
        int elementsToCopy = Math.min(ArrayNumKey, dimension - i);

        // Заполняем массив arrayOfText числами из intergersAlphabetArray
        for (int j = 0; j < elementsToCopy; j++) {
            if (i + j >= intergersAlphabetArray.length) {
               // Если вышли за пределы массива, используем символ с ASCII-кодом 35 (например, '#')
               arrayOfText[j] = 35;
            } else {
               // Иначе, копируем значение из intergersAlphabetArray в arrayOfText
               arrayOfText[j] = intergersAlphabetArray[i + j];
            }
        }

        // Создаем объект ConversionToText для преобразования чисел в текст
        ConversionToText conversionToText = new ConversionToText(intergers, arrayOfText, numberInStorage, ArrayNumKey);

        // Выполняем умножение матриц и получаем массив символов
        char[] arrayMatrix1 = conversionToText.MultiplyingMatrixByMatrix();

       // Выводим полученные символы на экран
         for (int k = 0; k < elementsToCopy; k++) {
          System.out.print(arrayMatrix1[k]);
         }
       }
        }else{
            
            if(operation.equals("Расшифровать")){
                
                // Создаем объект ChainShot для работы с шифрованными данными, передавая детерминант и число в хранилище
                ChainShot chainShot = new ChainShot(conditionDeterminant, numberInStorage);

               // Получаем значение, используемое в модульной арифметике, из объекта ChainShot
               int theNumberModulo = chainShot.getMyField();

               // Создаем объект AlgebraicCofactorMatrix для работы с алгебраическими дополнениями матрицы, передавая матрицу intergers
               AlgebraicCofactorMatrix algebraicCofactorMatrix = new AlgebraicCofactorMatrix(intergers);

               // Получаем матрицу алгебраических дополнений
               int[][] arraAddition = algebraicCofactorMatrix.getMatrix1(intergers);

              // Вычисляем количество строк и столбцов в матрице arraAddition
              int rows = arraAddition.length;
              int cols = arraAddition[0].length;

             // Создаем объект MultiplyingMatrixByNumber для умножения матрицы на число, передавая матрицу arraAddition, число в хранилище и модульное число
             MultiplyingMatrixByNumber matrixByNumber = new MultiplyingMatrixByNumber(arraAddition, numberInStorage, theNumberModulo);

             // Получаем результат умножения матрицы на число
            int[][] resultMatrixByNumber = matrixByNumber.MultiplicationMatrixByNumber();

             // Создаем массив arrayOfText1 для хранения чисел, которые будут преобразованы в текст
             int[] arrayOfText1 = new int[ArrayNumKey];

             // Вычисляем остаток от деления длины массива intergersAlphabetArray на ArrayNumKey
             int remains1 = intergersAlphabetArray.length % ArrayNumKey;

             // Вычисляем размерность (dimension1) для последующего расшифрования
             int dimension1;

             // Если остаток от деления не равен нулю, увеличиваем размерность до ближайшего кратного ArrayNumKey числа
             if (remains1 != 0) {
                dimension1 = intergersAlphabetArray.length + (ArrayNumKey - remains1);
             } else {
               // Иначе, оставляем размерность без изменений
                dimension1 = intergersAlphabetArray.length;
             }

                
            System.out.print("Результат: ");
            //Вывод результата
         for (int m = 0; m < dimension1; m += ArrayNumKey){
            // Вычисляем количество элементов, которые нужно скопировать на текущей итерации 
           int elementsToCopy1 = Math.min(ArrayNumKey, dimension1 - m);
           
           // Начинаем цикл для копирования значений из intergersAlphabetArray в arrayOfText1
           for (int l = 0; l < elementsToCopy1; l++) {
               // Проверяем, вышли ли за пределы массива intergersAlphabetArray
               if (m + l >= intergersAlphabetArray.length) {
               // Если вышли за пределы массива, устанавливаем значение 35 (ASCII-код символа '#')
               arrayOfText1[l] = 35;
               } else {
               // Иначе, копируем значение из intergersAlphabetArray в arrayOfText1
               arrayOfText1[l] = intergersAlphabetArray[m + l];
    }
}
           ConversionToText conversionToText = new ConversionToText(resultMatrixByNumber, arrayOfText1, numberInStorage, ArrayNumKey);
           /*Обращаемся к классу, который преобразовывает кодировку символов в строке в текст*/
           char[] arrayMatrix2 = conversionToText.MultiplyingMatrixByMatrix();
           //Вывод Символов из класса
           /*Вывод результата, после расшифрования*/
            for (int p = 0; p < elementsToCopy1; p++) {
                System.out.print(arrayMatrix2[p]);
             }
         
         }
            }else{
                System.out.println("Такой операции нет!!!");
            }
        } 
                }
                }
        } else {
            System.out.println("Неверный ключ. Длина ключа должна быть квадратом целого числа!!!");
            /*Неверный ключ.*/
        }
        }
        
    }
}
