package org.tasks.one;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();

        String regexFullPhone = "^((8|\\+7|7)?[\\- ]?)(\\(?9\\d{2}\\)?[\\- ]?)[\\d\\- ]{7,10}$";
        String regexReplaceSymbols = "[^0-9]";
        Pattern patternPhone = Pattern.compile(regexFullPhone);
        Matcher matcher = patternPhone.matcher(phoneNumber);
        if(matcher.find()){
            System.out.println("Отлично! Сейчас я отформатирую телефон в нужный формат!");
            String formattedPhoneNumber = formatPhoneNumber(phoneNumber,regexReplaceSymbols);
            char [] charPhoneNumber = formattedPhoneNumber.toCharArray();
            if(formattedPhoneNumber.length() == 10){
                formattedPhoneNumber = "7" + formattedPhoneNumber;
            }
            while (charPhoneNumber[0] == '8'){
                charPhoneNumber[0] = '7';
                formattedPhoneNumber = String.copyValueOf(charPhoneNumber);
            }
            System.out.println("Отформатированны телефон выгглядит так: "
                    + formattedPhoneNumber);
        }
        else {System.out.println("Неверный формат номера");}
    }
    public static String formatPhoneNumber(String phone, String regex) {
        return phone.replaceAll(regex,"");
    }
}