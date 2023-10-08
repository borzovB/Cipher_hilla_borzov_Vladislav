package com.mycompany.stealthchat;
//Класс который преобразовывает массив из символов в массив кодировки символов
public class ConvertingCharactersToNumbers {
    private char[] arrayChar;  // Массив символов для преобразования
    private int squareRoot;    // Квадратный корень числа символов
    private char[] arrayCharDecryptionCipher;  // Массив символов для дешифровки

    public ConvertingCharactersToNumbers(char[] arrayChar, int squareRoot, char[] arrayCharDecryptionCipher) {
        this.arrayChar = arrayChar;
        this.squareRoot =squareRoot;
        this.arrayCharDecryptionCipher = arrayCharDecryptionCipher;
    }
    // Метод возвращает массив символов, который используется для преобразования чисел в символы
    public char[] getCharacterStorage() {
    char[] arrayOfCharacters = new char[37];
    // Заполняем массив символами от 'а' до '?'
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
    // Метод преобразует символьный код из символов в числа, используя массив символов
    public int[][] getArrayCharConvertingCharactersToNumbersForTheDeterminant() {
        char[] counting = getCharacterStorage();
        int[][] ToNumbers = new int[squareRoot][squareRoot];
        int[] ToNumbersOne = new int[squareRoot*squareRoot];
        for(int i = 0; i<(squareRoot*squareRoot);i++){
            for(int j = 0;j<counting.length;j++){
                    if (arrayChar[i] == counting[j]) {
                        ToNumbersOne[i] = j;
                        break; // Если символ найден, можно выйти из внутреннего цикла
                    }
            }
        }
        
        int index = 0; // Инициализируем переменную index для отслеживания текущего индекса в массиве ToNumbersOne
        for (int i = 0; i < squareRoot; i++) { // Внешний цикл для перебора строк массива ToNumbers
             for (int j = 0; j < squareRoot; j++) { // Внутренний цикл для перебора столбцов массива ToNumbers
                  ToNumbers[i][j] = ToNumbersOne[index]; // Присваиваем элементу ToNumbers[i][j] значение из ToNumbersOne[index]
                  index++; // Увеличиваем индекс, чтобы перейти к следующему значению в ToNumbersOne
             }
        }
        return ToNumbers;
    }
     // Метод преобразует символьный код из символов в числа для дешифровки
    public int[] AlphabetArray() {
        char[] counting = getCharacterStorage();
        int n = arrayCharDecryptionCipher.length;
        int[] ToNumbersOne = new int[n];
        for(int i = 0; i<(n);i++){
            for(int j = 0;j<counting.length;j++){
                    if (arrayCharDecryptionCipher[i] == counting[j]) {
                        ToNumbersOne[i] = j;
                        break; // Если символ найден, можно выйти из внутреннего цикла
                    }
            }
        }
        
        return ToNumbersOne;
    }
    // Метод возвращает размер массива символов для кодировки
    public int getArrayAlphabetSize() {
        char[] counting = getCharacterStorage();
        int lenArray = counting.length;
        
        return lenArray;
}

}
