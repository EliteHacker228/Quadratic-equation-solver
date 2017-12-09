package ru.samsung.itschool.book.overcalc4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText A;
    private EditText B;
    private EditText C;
    private TextView X1;
    private TextView X2;
    private double a=0,b=0,c=0,D=0,x1=0,x2=0;

    public EditText K;
    public EditText Be;
    public TextView Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        A= findViewById(R.id.coeffA);
        B= findViewById(R.id.coeffB);
        C= findViewById(R.id.coeffC);
        X1= findViewById(R.id.rootOne);
        X2= findViewById(R.id.rootTwo);


    }

    public void ClickButton(View v){

        String A1 = A.getText().toString();
        String B1 = B.getText().toString();
        String C1 = C.getText().toString();

        a=Double.parseDouble(A1);
        b=Double.parseDouble(B1);
        c=Double.parseDouble(C1);

        D=(b*b)-(4*a*c);

        if(D>=0){
            x1=(-b+Math.sqrt(D))/(2*a);
            x2=(-b-Math.sqrt(D))/(2*a);

            String s1 = Double.toString(x1);
            String s2 = Double.toString(x2);

            X1.setText(s1);
            X2.setText(s2);

        }
        if(D<0){
            X1.setText("Нет решений");
            X2.setText("Нет решений");
        }

    }



    public void onSharequad(View v){
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "Решено уравнение " +a+ "x^2+" +b+ "x" +c+"=0 "+" и получен результат: "+"\n"+"x1="+x1+" x2="+x2;
        String shareSub = "Решено уравнение " +a+ "x^2+" +b+ "x" +c+"=0";
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
        myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(myIntent,"Share using"));

    }

}