package com.example.concretecalc;

public class CubicFeet {
    private double Length;
    private double Width;
    private double Thickness;
    private double CuFT;
    private double sqft;

    public CubicFeet(double length, double width , double thickness){
        Length = length;
        Width = width;
        Thickness = thickness;
        CuFT = 0;
        sqft = 0;
    }
    public double getLength(){
        return Length;
    }
    public double getWidth(){
        return Width;
    }
    public double getThickness(){
        return Thickness;
    }
    public double getSqft(){
        return Length * Width;
    }
    public double getCubicft(){
        CuFT = Length * Width * Thickness;
        return CuFT;
    }
}
