package com.example.concretecalc;
import java.text.DecimalFormat;
public class Estimate {
    private DecimalFormat df = new DecimalFormat("$#,###,###.00");
    private float Price_per;
    private double sqft;

    public Estimate(double Squareft, float price){
        Price_per = price;
        sqft = Squareft;
    }
    public double getEstimate(){
        double estimate;
        estimate = Price_per * sqft;
        return estimate;
    }
    public String toString(){
        return "Total Estimate: " + df.format(getEstimate());
    }
}
