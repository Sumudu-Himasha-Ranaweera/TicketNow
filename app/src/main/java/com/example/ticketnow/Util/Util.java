package com.example.ticketnow.Util;

public class Util {

    public static  boolean EmailValidation(String value){
        if (value.length() == 0) {
            return false;
        } else if (!value.matches("^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$")) {
            return false;
        }else{
            return true;
        }
    }

    public static  boolean NICValidation(String value){
        if (value.length() == 0) {
            return false;
        } else if (!value.matches("^([0-9]{9}[x|X|v|V]|[0-9]{12})$")) {
            return false;
        }else{
            return true;
        }
    }

    public static  boolean mobileNumberValidation(String value){
        if (value.length() == 0) {
            return false;
        } else if (!value.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$")) {
            return false;
        }else{
            return true;
        }
    }
}
