package com.example.concretecalc;

public class CuFtPerUnit {
    private int Cubic_ft_perYard;
    private double Cuft_60;
    private double Cuft_80;
    private double Cuft_40;

    public CuFtPerUnit(int ft_per,double d80, double d60,double d40){
        Cubic_ft_perYard = ft_per;
        Cuft_80 = d80;
        Cuft_60 = d60;
        Cuft_40 = d40;
    }
    public int getCu_ft_perYard(){
        return Cubic_ft_perYard;
    }
    public double getCuft_80(){
        return Cuft_80;
    }
    public double getCuft_60(){
        return Cuft_60;
    }
    public double getCuft_40(){
        return Cuft_40;
    }
}
