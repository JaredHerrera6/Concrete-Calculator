package com.example.concretecalc;

public class ConcreteNeeded {

    private CuFtPerUnit cuFtPerUnit;
    private double yrds;
    private double d80;
    private double d60;
    private double d40;
    private double Cuft;

    public ConcreteNeeded(CuFtPerUnit cubic, double cuft ){
        cuFtPerUnit = cubic;
        Cuft = cuft;
        yrds = 0;
        d80 = 0;
        d60 = 0;
        d40 = 0;
    }
    public double getYrds(){
        int yield = cuFtPerUnit.getCu_ft_perYard();
        yrds = Cuft / (double) yield;
        return yrds;
    }
    public double getd80(){
        double yield = cuFtPerUnit.getCuft_80();
        d80 = Cuft /yield;
        return d80;
    }
    public double getd60(){
        double yield = cuFtPerUnit.getCuft_60();
        d60 = Cuft / yield;
        return d60;
    }
    public double getd40(){
        double yield = cuFtPerUnit.getCuft_40();
        d40 = Cuft / yield;
        return d40;
    }


}
