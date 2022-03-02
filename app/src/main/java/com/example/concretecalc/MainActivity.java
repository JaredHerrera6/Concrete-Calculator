package com.example.concretecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.EntityIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bDo;
    private DecimalFormat df = new DecimalFormat("0.00");
    private DecimalFormat dfQuote =  new DecimalFormat("$###,###,##0.00");
    private static ConcreteNeeded yrds;
    private static CuFtPerUnit cuFtPerUnit = new CuFtPerUnit(27,0.60,0.45,0.30);
                                                // SqFtPerUnit Stores the Cubicft that covered by either
                                                // yards, 60 lbs bag, or 80 lbs bag
    private static CubicFeet cubicFeet;
    private static Estimate estimate;
    private double Length;
    private double width;
    private double thickness;
    private float fPrice;
    private double Cubicft;
    private double Yards;
    private double sqft;
    private double b80;
    private double b60;
    private double b40;
    private double dQuote;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bDo = (Button)findViewById(R.id.clkButton);
        bDo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText editLength = findViewById(R.id.edtLength);
        EditText editWidth = findViewById(R.id.edtWidth);
        EditText editThickness = findViewById(R.id.edtThickness);
        EditText editPrice = findViewById(R.id.edtPricePer);
        Length = Double.parseDouble(editLength.getText().toString());
        width = Double.parseDouble(editWidth.getText().toString());
        thickness = Double.parseDouble(editThickness.getText().toString());
        fPrice= Integer.parseInt(editPrice.getText().toString());

        thickness = thickness/ 12; // turns thickness(inches) into feet by dividing by 12
        cubicFeet = new CubicFeet(Length,width, thickness);
        Cubicft = cubicFeet.getCubicft();

        yrds = new ConcreteNeeded(cuFtPerUnit,Cubicft);
        Yards = yrds.getYrds();
        b80 = yrds.getd80();
        b60 = yrds.getd60();
        b40 = yrds.getd40();

        sqft = cubicFeet.getSqft();
        estimate = new Estimate(sqft,fPrice);
        dQuote = estimate.getEstimate();

        // Text view boxes
        // Print yards
        TextView txtYards = findViewById(R.id.txtYards);
        txtYards.setText("Yards: " + Double.toString(Double.parseDouble(df.format(Yards))));
        //Print 80 Lbs bags of concrete needed
        TextView txt80 = findViewById(R.id.txtBags80);
        txt80.setText("80Lb Bags: " + Double.toString(Double.parseDouble(df.format(b80))));
        //Print 60 Lbs bags of concrete needed
        TextView txt60 = findViewById(R.id.txtBags60);
        txt60.setText("60Lb Bags: " + Double.toString(Double.parseDouble(df.format(b60))));
        //Print 40 lbs bas of concrete needed
        TextView txt40 = findViewById(R.id.txtBags40);
        txt40.setText("40Lb Bags: " + Double.toString((Double.parseDouble(df.format(b40)))));
        //Print Estimate
        TextView txtEstimate = findViewById(R.id.txtEstimate);
        txtEstimate.setText("Estimate: " + dfQuote.format(dQuote));
    }

}