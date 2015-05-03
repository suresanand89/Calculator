package com.example.anandsuresh.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Calculator2 extends ActionBarActivity implements View.OnClickListener {

    private EditText edit2;
    private String opSci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();

        if(getIntent().getStringExtra("currentNumber")!= null) {
            String num = intent.getStringExtra("currentNumber");
            double number = Double.parseDouble(num);
            ((Globals) this.getApplication()).setGnumber(number);
        }

        edit2 = (EditText) findViewById(R.id.edittext1);

        int listSci[] = {R.id.buttonSine,R.id.buttonCosine,R.id.buttonTangent,R.id.buttonNatLog,R.id.buttonLog,
                R.id.buttonPi,R.id.buttonExp,R.id.buttonMod,R.id.buttonFact,R.id.buttonSqrt,R.id.buttonPow};

        for(int id : listSci) {
            View v = findViewById(id);
            v.setOnClickListener(this);
        }
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonSine :
                opSci = "sin";
                setOp(opSci);
                break;

            case R.id.buttonCosine :

                opSci = "cos";
                setOp(opSci);
                break;

            case R.id.buttonTangent :

                opSci = "tan";
                setOp(opSci);
                break;

            case R.id.buttonNatLog :

                opSci = "ln";
                setOp(opSci);
                break;

            case R.id.buttonLog :

                opSci = "log";
                setOp(opSci);
                break;

            case R.id.buttonPi :

                opSci = "pi";
                setOp(opSci);
                break;

            case R.id.buttonExp :

                opSci = "e";
                setOp(opSci);
                break;

            case R.id.buttonMod :

                opSci = "%";
                setOp(opSci);
                break;

            case R.id.buttonFact :

                opSci = "!";
                setOp(opSci);
                break;

            case R.id.buttonSqrt :

                opSci = "sqrt";
                setOp(opSci);
                break;

            case R.id.buttonPow :

                opSci = "^";
                setOp(opSci);
                break;
        }
    }

    public void setOp(String op) {
        Intent intent = new Intent(Calculator2.this,MainActivity.class);
        intent.putExtra("operationSci",op);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
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
                Intent intent = new Intent(Calculator2.this,MainActivity.class);
                intent.putExtra("operationSci",opSci);
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
}
