package org.Risk;

import java.util.ArrayList;

/**
 * @Author: yanshilong
 * @Date: 18-9-22 上午1:43
 * @Version 1.0
 */
public class UserDao {
    private int shencha;
    private int pizhu;
    private int increase;
    private ArrayList riskList;
    private ArrayList suggestionList;
    private String text;
    public UserDao(int shencha, int pizhu, int increase, ArrayList riskList, ArrayList suggestionList,String text) {
        this.shencha = shencha;
        this.pizhu = pizhu;
        this.increase = increase;
        this.riskList = riskList;
        this.suggestionList = suggestionList;
        this.text=text;
    }

    public int getShencha() {
        return shencha;
    }

    public int getPizhu() {
        return pizhu;
    }

    public int getIncrease() {
        return increase;
    }

    public ArrayList getRiskList() {
        return riskList;
    }

    public ArrayList getSuggestionList() {
        return suggestionList;
    }

    public String getText() {
        return text;
    }
}
