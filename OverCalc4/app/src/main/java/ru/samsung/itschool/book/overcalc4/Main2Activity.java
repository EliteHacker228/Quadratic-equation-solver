package ru.samsung.itschool.book.overcalc4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends MainActivity {
    public double k=0, x=0,bb=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        K=(EditText)findViewById(R.id.K);
        Be=(EditText)findViewById(R.id.BB);
        Answer=(TextView)findViewById(R.id.answer);
    }

    public void OnClick(View v) {


        String k1 = K.getText().toString();
        String b1 = Be.getText().toString();

        k = Double.parseDouble(k1);
        bb = Double.parseDouble(b1);
        x = -bb / k;
        String s1 = Double.toString(x);
        Answer.setText(s1);

    }

    public void onShareLine(View v) {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "Решено уравнение " + k + "*x+" + bb + "=0" + " и получен ответ: x= " + x;
        String shareSub = "Решено уравнение k*x+" + bb + "=0";
        myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
        myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(myIntent, "Share using"));
    }
}