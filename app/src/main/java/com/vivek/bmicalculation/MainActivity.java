package com.vivek.bmicalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText txtWeight,txtHeightFt,txtHeightIn;
        Button btnBMI;
        TextView txtResult,txtBMIScore;
        LinearLayout mainColor;


        txtWeight = findViewById(R.id.txtWeight);
        txtHeightFt = findViewById(R.id.txtHeightFt);
        txtHeightIn = findViewById(R.id.txtHeightIn);
        btnBMI = findViewById(R.id.btnBMI);
        txtResult = findViewById(R.id.txtResult);
        mainColor = findViewById(R.id.mainColor);
        txtBMIScore = findViewById(R.id.txtBMIScore);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(txtWeight.getText().toString());
                int htFeet = Integer.parseInt(txtHeightFt.getText().toString());
                int htInch = Integer.parseInt(txtHeightIn.getText().toString());

                int totalHeight = htFeet*12+htInch;
                double totalCM = totalHeight*2.53;
                double  totalM = totalCM/100;

                double bmi = wt/(totalM*totalM);
                double data = Double.parseDouble(String.format("%.5f",bmi));
                if(bmi<18.5){
                    txtResult.setText("You're Underweight");
                    txtBMIScore.setText("Your BMI Score is "+data);
                    mainColor.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }else if(bmi>=18.5 && bmi<=24.9){
                    txtResult.setText("Congratulations.... You're Healthy ");
                    txtBMIScore.setText("Your BMI score is "+data);
                    mainColor.setBackgroundColor(getResources().getColor(R.color.healthy));
                } else if(bmi>=25 && bmi<=29.9){
                    txtResult.setText("You're Overweight ");
                    txtBMIScore.setText("Your BMI score is "+data);
                    mainColor.setBackgroundColor(getResources().getColor(R.color.overweight));
                }else{
                    txtResult.setText("You're under Obesity ");
                    txtBMIScore.setText("Your BMI score is "+data);
                    mainColor.setBackgroundColor(getResources().getColor(R.color.obesity));
                }
            }
        });
    }
}