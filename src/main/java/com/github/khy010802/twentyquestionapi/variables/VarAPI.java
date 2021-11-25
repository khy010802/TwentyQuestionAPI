package com.github.khy010802.twentyquestionapi.variables;

public class VarAPI {

    /**
     * 해당 변수에 값을 추가합니다. 음수도 가능합니다.
     * @param var 변수명
     * @param value 값
     */
    public static void addValue(Variables var, int value){
        int old = var.getValue();
        var.getScore().setScore(old + value);
    }

    /**
     * 해당 변수의 값을 설정합니다. 음수도 가능합니다.
     * @param var 변수명
     * @param value 값
     */
    public static void setValue(Variables var, int value){
        var.getScore().setScore(value);
    }

    /**
     * 해당 변수의 값을 구합니다.
     * @param var 변수명
     * @return 값
     */
    public static int getValue(Variables var){
        return var.getValue();
    }


}
