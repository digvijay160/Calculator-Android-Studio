package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView t1;
    int n1,n2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean inputNum(){
        e1=(EditText) findViewById(R.id.num1);
        e2=(EditText) findViewById(R.id.num2);
        t1=(TextView) findViewById(R.id.result);

        //taking inp from text box
        String s1=e1.getText().toString();
        String s2=e2.getText().toString();

        if((s1.equals(null)&&s2.equals(null))||(s1.equals("")&&s2.equals(""))){
            String result="Please enter a value";
            t1.setText(result);

            return false;
        }
        else {

            n1=Integer.parseInt(s1);
            n2=Integer.parseInt(s2);
        }
        return true;
    }

    public void btnSum(View v){

        if(inputNum()){
            int sum=n1+n2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void btnDif(View v){

        if(inputNum()){
            int dif=n1-n2;
            t1.setText(Integer.toString(dif));
        }
    }

    public void btnMul(View v){

        if(inputNum()){
            int prod=n1*n2;
            t1.setText(Integer.toString(prod));
        }
    }

    public void btnDiv(View v){

        if(inputNum()){
            double div=n1/(n2*1.0);
            t1.setText(Double.toString(div));
        }
    }

    public void btnClr(View v){
        if(inputNum()){
            e1.setText("");
            e2.setText("");
        }
    }



}