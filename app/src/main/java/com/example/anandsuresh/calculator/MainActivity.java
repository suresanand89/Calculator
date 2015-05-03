package com.example.anandsuresh.calculator;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText edit;
    private double number=0,numberBf;
    private String operation,current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        operation = intent.getStringExtra("operationSci");

        edit = (EditText) findViewById(R.id.edittext);



        //.setText(operation);

        int list[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
                R.id.button7, R.id.button8, R.id.button9, R.id.buttonadd, R.id.buttonsub, R.id.buttonmul, R.id.buttondiv,
                R.id.buttoneq, R.id.buttondot, R.id.buttondel};


        for(int l : list) {
            View view = (View) findViewById(l);
            view.setOnClickListener(this);
        }


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0 :
                setScreen(((Button) view).getText().toString());

                break;

            case R.id.button1 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button2 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button3 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button4 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button5 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button6 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button7 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button8 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.button9 :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.buttondot :
                setScreen(((Button) view).getText().toString());
                break;

            case R.id.buttonadd :
                calculate("+");
                break;

            case R.id.buttonsub :
                calculate("-");
                break;

            case R.id.buttonmul :
                calculate("*");
                break;

            case R.id.buttondiv :
                calculate("/");
                break;

            case R.id.buttondel :
                edit.setText("");
                break;

            case R.id.buttoneq :
                calculateAnswer();
                break;
        }
    }

    public void setScreen(String numb) {

        current = edit.getText().toString();

        current += numb;
        edit.setText(current);


    }

    public void calculate(String op) {
        number = Float.parseFloat(edit.getText().toString());
        operation = op;
        edit.setText("");
    }

    public void calculateAnswer() {

        double numberNew = Double.parseDouble(edit.getText().toString());



        double answer;
        double pi = 3.14;

        if(operation.equals("+")) {
            answer = number + numberNew;
            edit.setText(answer + "");
        }
        if(operation.equals("-")) {
            answer = number - numberNew;
            edit.setText(answer + "");
        }
        if(operation.equals("*")) {
            answer = number * numberNew;
            edit.setText(answer + "");
        }
        if(operation.equals("/")) {
            answer = number / numberNew;
            edit.setText(answer + "");
        }
        if(operation.equals("sin")) {
            answer = Math.sin(numberNew);
            edit.setText(answer + "");
        }
        if(operation.equals("cos")) {
            answer = Math.cos(numberNew);
            edit.setText(answer + "");
        }
        if(operation.equals("tan")) {
            answer = Math.tan(numberNew);
            edit.setText(answer + "");
        }
        if(operation.equals("ln")) {
            answer = Math.log(numberNew);
            edit.setText(answer + "");
        }
        if(operation.equals("log")) {
            answer = Math.log10(numberNew);
            edit.setText(answer + "");
        }
        if(operation.equals("pi")) {
            if (numberNew == 0.0)
                edit.setText(pi + "");
            answer = 3.14 * numberNew;
            edit.setText(answer + "");
        }
        if(operation.equals("e")) {
            answer = Math.exp(numberNew);
            edit.setText(answer + "");
        }
        if(operation.equals("sqrt")) {
            answer = Math.sqrt(numberNew);
            edit.setText(answer + "");
        }
        if(operation.equals("!")) {
            answer = factorial(numberNew);
            edit.setText(answer + "");
        }
        if (operation.equals("%")) {
            double num = ((Globals) this.getApplication()).getGnumber();
            answer = num % numberNew;

            edit.setText(answer + "");
        }
        if(operation.equals("^")) {
            double num = ((Globals) this.getApplication()).getGnumber();
            answer = Math.pow(num,numberNew);
            edit.setText(answer + "");
        }
    }

    public double factorial(double num) {
        if(num <= 1)
           return 1;
        else
            num = num * factorial(num - 1);
        return num;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_switch :

                Intent intent = new Intent(MainActivity.this,Calculator2.class);
                intent.putExtra("currentNumber",current);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

                break;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


}


