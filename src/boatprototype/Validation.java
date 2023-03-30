/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boatprototype;

/**
 *
 * @author danka
 */
public class Validation {
    public static boolean lengthCheck(int min, String check, int max ){
        return check.length() >= min && check.length() <= max;
    }
    public static boolean timeCheck( String check){
        return check.matches("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$");
    }
    public static boolean dateCheck(String check){
        return check.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
    }
    
}