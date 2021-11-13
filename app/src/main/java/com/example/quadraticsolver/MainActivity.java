package com.example.quadraticsolver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

        EditText a = (EditText) findViewById(R.id.co_a);
        EditText b = (EditText) findViewById(R.id.co_b);
        EditText c = (EditText) findViewById(R.id.co_c);
        Button answer = (Button) findViewById(R.id.ans);
        TextView solve = (TextView) findViewById(R.id.solution);


        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (a.getText().toString().equals(null) &&
                            b.getText().toString().equals(null) &&
                            c.getText().toString().equals(null))
                    {
                        report("Check whether you have entered the proper values");
                        solve.setText("Check your values");
                    }
                    else
                    {
                        double cea = Double.parseDouble(a.getText().toString());
                        double ceb = Double.parseDouble(b.getText().toString());
                        double cec = Double.parseDouble(c.getText().toString());
                        while(a.getText().toString().equals(""))
                        {
                            cea = 0.0;
                        }
                        while(b.getText().toString().equals(""))
                        {
                            ceb = 0.0;
                        }
                        while(c.getText().toString().equals(""))
                        {
                            cec = 0.0;
                        }
                        String answer = solve.getText().toString();
                        answer = "The given quadratic equation is,\n" +
                                "(" +a.getText().toString()+") X² + " +
                                "("+b.getText().toString()+") X + " +
                                "("+c.getText().toString()+")";
                        delta = (ceb*ceb) - (4*cea*cec);
                        answer += "\nDiscriminant  =  "+delta;
                        if(delta==0)
                        {
                            answer+="\nThe given quadratic equation has real and equal roots";
                            double de = 2*cea;
                            root1 = (-ceb)/de;
                            root2 = (-ceb)/de;
                            answer+="\nThe roots are,   "+String.format("%.2f",root1)+"  and  "+String.format("%.2f",root2);
                        }
                        else if(delta>0)
                        {
                            answer+="\nThe given quadratic equation has real and unequal roots";
                            double de = 2*cea;
                            root1 = (-ceb+Math.sqrt(delta))/de;
                            root2 = (-ceb-Math.sqrt(delta))/de;
                            answer+="\nThe roots are,   "+String.format("%.2f",root1)+"  and  "+String.format("%.2f",root2);
                        }
                        else
                        {
                            answer+="\nThe given quadratic equation has imaginary roots";
                            double de = 2*cea;
                            String nu = String.format("%.2f", ((-ceb)/de));
                            double com = (Math.sqrt(-1*delta))/de;
                            answer+="\nThe roots are,\n"
                                    +nu+" + ("+String.format("%.2f",com)+")i  and  "
                                    +nu+" - ("+String.format("%.2f",com)+")i";
                        }
                        solve.setText(answer);
                    }
                } catch (Exception exception) {
                    report("OOPS! Some error occured");
                    solve.setText("OOPS! Some error occured");
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
