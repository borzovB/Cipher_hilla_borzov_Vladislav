package com.mycompany.stealthchat;
/*Класс для преобразования кодировки символов в символы*/
public class ConvertingNumericCodeIntoCharacters {
   private int[][] arrayInt;
    private int squareRoot;
    // Конструктор класса, принимает двумерный массив чисел и квадратный корень числа символов
    public ConvertingNumericCodeIntoCharacters(int[][] arrayInt, int squareRoot) {
        this.arrayInt = arrayInt;
        this.squareRoot = squareRoot;
    }
    // Метод возвращает массив символов, который используется для преобразования чисел в символы
    public char[] getCharacterStorageInterger() {
    char[] arrayOfCharacters = new char[37];

    arrayOfCharacters[0] = 'а';
    arrayOfCharacters[1] = 'б';
    arrayOfCharacters[2] = 'в';
    arrayOfCharacters[3] = 'г';
    arrayOfCharacters[4] = 'д';
    arrayOfCharacters[5] = 'е';
    arrayOfCharacters[6] = 'ё';
    arrayOfCharacters[7] = 'ж';
    arrayOfCharacters[8] = 'з';
    arrayOfCharacters[9] = 'и';
    arrayOfCharacters[10] = 'й';
    arrayOfCharacters[11] = 'к';
    arrayOfCharacters[12] = 'л';
    arrayOfCharacters[13] = 'м';
    arrayOfCharacters[14] = 'н';
    arrayOfCharacters[15] = 'о';
    arrayOfCharacters[16] = 'п';
    arrayOfCharacters[17] = 'р';
    arrayOfCharacters[18] = 'с';
    arrayOfCharacters[19] = 'т';
    arrayOfCharacters[20] = 'у';
    arrayOfCharacters[21] = 'ф';
    arrayOfCharacters[22] = 'х';
    arrayOfCharacters[23] = 'ц';
    arrayOfCharacters[24] = 'ч';
    arrayOfCharacters[25] = 'ш';
    arrayOfCharacters[26] = 'щ';
    arrayOfCharacters[27] = 'ъ';
    arrayOfCharacters[28] = 'ы';
    arrayOfCharacters[29] = 'ь';
    arrayOfCharacters[30] = 'э';
    arrayOfCharacters[31] = 'ю';
    arrayOfCharacters[32] = 'я';
    arrayOfCharacters[33] = '.';
    arrayOfCharacters[34] = ',';
    arrayOfCharacters[35] = '_';
    arrayOfCharacters[36] = '?';

    return arrayOfCharacters;
}
    public char[] ConvertingStringCodeFromNumbersToCharacters() {
    char[] counting = getCharacterStorageInterger();
    //Вызываем класс, который хранит символоы и их кодировку
    char[] ToNumbersOne = new char[squareRoot]; 
    //Инициализируем матрицу кодировок и символов
    // Проходим по каждому числу и находим соответствующий символ из массива символов
    for (int i = 0; i < squareRoot; i++) {
        for (int j = 0; j < counting.length; j++) {
            if (arrayInt[i][0] == j) {
                ToNumbersOne[i] = counting[j];
            }
        }
    }
    return ToNumbersOne;
    /*Возвращаем строку символов*/
}
    
}
