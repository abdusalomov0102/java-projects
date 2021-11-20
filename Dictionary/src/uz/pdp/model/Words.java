package uz.pdp.model;

import java.util.ArrayList;

public class Words {

    private String translate;
    private String defination;
    private ArrayList<String> sysnonmy;
    private ArrayList<String> example;

    public Words() {
    }

    public Words(String translate, String defination, ArrayList<String> sysnonmy, ArrayList<String> example) {
        this.translate = translate;
        this.defination = defination;
        this.sysnonmy = sysnonmy;
        this.example = example;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getDefination() {
        return defination;
    }

    public void setDefination(String defination) {
        this.defination = defination;
    }

    public ArrayList<String> getSysnonmy() {
        return sysnonmy;
    }

    public void setSysnonmy(ArrayList<String> sysnonmy) {
        this.sysnonmy = sysnonmy;
    }

    public ArrayList<String> getExample() {
        return example;
    }

    public void setExample(ArrayList<String> example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Words{" +
                "translate='" + translate + '\'' +
                ", defination='" + defination + '\'' +
                ", sysnonmy=" + sysnonmy +
                ", example=" + example +
                '}';
    }

}
