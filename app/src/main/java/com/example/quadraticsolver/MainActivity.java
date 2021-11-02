package com.example.quadraticsolver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double delta, root1, root2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText a = (EditText) findViewById(R.id.a);
        EditText b = (EditText) findViewById(R.id.b);
        EditText c = (EditText) findViewById(R.id.c);
        Button ans = (Button) findViewById(R.id.ans);
        TextView solution = (TextView) findViewById(R.id.solution);

        double ce_a = Double.parseDouble(a.toString());
        double ce_b = Double.parseDouble(b.toString());
        double ce_c = Double.parseDouble(c.toString());

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (a.getText().toString().equals("") && b.getText().toString().equals("") && c.getText().toString().equals(""))
                    {
                        report("Check whether you have entered the proper values");
                    }
                    else
                    {
                        String answer = solution.getText().toString();
                        answer = "The given quadratic equation is,\n\t"+a+"X² + ("+b+")X + ("+c+")";
                        delta = (ce_b*ce_b) - (4*ce_a*ce_c);
                        answer += "The discriminant value is, "+delta;
                        if(delta>0)
                        {
                            double de = 2*ce_a;
                            root1 = (-ce_b+Math.sqrt(delta))/de;
                            root2 = (-ce_b-Math.sqrt(delta))/de;
                            answer+="The roots are, "+root1+" and "+root2;
                        }
                    }
                } catch (Exception exception) {
                    report("Some error occured");
                }
            }
        });
    }

    public void report(String alert) {
        AlertDialog show = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Alert")
                .setMessage(alert)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        show.show();
    }

}