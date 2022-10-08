package Commands;


import Mess.Mess;
import Org.ColorEye;
import Org.ColorHair;
import Org.Country;

import java.util.Locale;

public class Validation {
    public boolean validation(String[] lin, int lineNumber) {
        try {
            if (lin[0].trim().equals("") || Long.parseLong(lin[0]) <= 0) {
                Mess.error("Неверный формат id у " + lineNumber + " строки");
                return false;
            }
        } catch (NumberFormatException e) {
            Mess.error("Неверный формат id у " +  lineNumber + " строки");
            return false;
        }

        if (lin[1].trim().equals("") || lin[1].trim().toLowerCase(Locale.ROOT).equals("none")) {
            Mess.error("Неверный формат name у " +  lineNumber + " строки");
            return false;
        }

        try {
            Float.parseFloat(lin[2]);
        } catch (NumberFormatException e) {
            Mess.error("Неверный формат X у " +  lineNumber + " строки");
            return false;
        }

        try {
            Integer.parseInt(lin[3]);
        } catch (NumberFormatException e) {
            Mess.error("Неверный формат Y у " +  lineNumber + " строки");
            return false;
        }

        try {
            Double.parseDouble(lin[5]);
        } catch (NumberFormatException e) {
            Mess.error("Неверный формат Y Роста " +  lineNumber + " строки");
            return false;
        }

        try {
            ColorEye.valueOf(lin[6]);
        } catch (IllegalArgumentException e) {
            Mess.error("Неверный формат weaponType у " +  lineNumber + " строки");
            return false;
        }

        try {
            ColorHair.valueOf(lin[7]);
        } catch (IllegalArgumentException e) {
            Mess.error("Неверный формат mood у " +  lineNumber + " строки");
            return false;
        }

        try {
            Country.valueOf(lin[8]);
        } catch (IllegalArgumentException e) {
            Mess.error("Неверный формат mood у " +  lineNumber + " строки");
            return false;
        }
        try {
            Float.parseFloat(lin[9]);
        } catch (NumberFormatException e) {
            Mess.error("Неверный формат X у " +  lineNumber + " строки");
            return false;
        }

        try {
            Integer.parseInt(lin[10]);
        } catch (NumberFormatException e) {
            Mess.error("Неверный формат Y у " +  lineNumber + " строки");
            return false;
        }

        try {
            Float.parseFloat(lin[11]);
        } catch (NumberFormatException e) {
            Mess.error("Неверный формат X у " +  lineNumber + " строки");
            return false;
        }


        return true;
    }
}