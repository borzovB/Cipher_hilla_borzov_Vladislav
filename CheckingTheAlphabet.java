package com.mycompany.stealthchat;
/*Класс, который позволяет определять коректность ввода ключа и строки, если такого символа нет в алфавите, то программа выдает ошибку*/
public class CheckingTheAlphabet {
    private char[] keyOrLine;
    // Конструктор класса, принимает массив символов (ключ или строку) и сохраняет его
    public CheckingTheAlphabet(char[] keyOrLine) {
        this.keyOrLine = keyOrLine;
    }
    // Метод возвращает массив символов, используемый для проверки алфавита
    public char[] getkeyOrLine() {
    // Создаем массив символов, размером 37
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
    //Возвращает массив символов
}
    public int Check(){
        /*Определение соответствия символов*/
      int checking = 0;
      char[] counting = getkeyOrLine(); 
      /*Проходит по массиву строки или ключа и сравнивает символы в них с символами в библиотеки*/
      for (int i = 0; i < keyOrLine.length; i++) {
        for (int j = 0; j < counting.length; j++) {
            if (keyOrLine[i] == counting[j]) {
                checking++;
                /*Если есть совпадение символов, то считаем его*/
            }
        }
    }
        return checking;
    }
          public int getArrayAlphabetSize() {
         //Вывод длины массива алфавита
        char[] counting = getkeyOrLine();
        int lenArray = counting.length;
        
        return lenArray;
}
}
