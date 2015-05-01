package com.example.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int flag =0;
    double num1,num2,res;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        final EditText numero1 = (EditText) findViewById(R.id.N1);
        final EditText numero2 = (EditText) findViewById(R.id.N2);
        resultado = (TextView) findViewById(R.id.res);
        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (flag) {
                    case 1:
                        if( numero1.getText().toString().length() == 0 ) {
                            numero1.setError("NUMERO REQUERIDO");
                        }
                        else if(numero2.getText().toString().length() == 0){
                            numero2.setError("NUMERO REQUERIDO");
                        }

                        else {
                            num1 = Double.parseDouble(numero1.getText().toString());
                            num2 = Double.parseDouble(numero2.getText().toString());
                            res = num1 + num2;
                            resultado.setText(Double.toString(res));
                        }

                        break;
                    case 2:
                        if( numero1.getText().toString().length() == 0 ) {
                            numero1.setError("NUMERO REQUERIDO");
                        }
                        else if(numero2.getText().toString().length() == 0){
                            numero2.setError("NUMERO REQUERIDO");
                        }
                        else {
                            num1 = Double.parseDouble(numero1.getText().toString());
                            num2 = Double.parseDouble(numero2.getText().toString());
                            res = num1 - num2;
                            resultado.setText(Double.toString(res));
                        }
                        break;
                    case 3:
                        if( numero1.getText().toString().length() == 0 ) {
                            numero1.setError("NUMERO REQUERIDO");
                        }
                        else if(numero2.getText().toString().length() == 0){
                            numero2.setError("NUMERO REQUERIDO");
                        }
                        else {
                            num1 = Double.parseDouble(numero1.getText().toString());
                            num2 = Double.parseDouble(numero2.getText().toString());
                            res = num1 * num2;
                            resultado.setText(Double.toString(res));
                        }
                        break;
                    case 4:
                        if( numero1.getText().toString().length() == 0 ) {
                            numero1.setError("NUMERO REQUERIDO");
                        }
                        else if(numero2.getText().toString().length() == 0){
                            numero2.setError("NUMERO REQUERIDO");
                        }
                        else {
                            num1 = Double.parseDouble(numero1.getText().toString());
                            num2 = Double.parseDouble(numero2.getText().toString());
                            res = num1 / num2;
                            resultado.setText(Double.toString(res));
                        }
                        break;
                    default:
                        break;
                }
            }

     });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("guardado", resultado.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        resultado.setText(savedInstanceState.getString("guardado"));
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.suma:
                if (checked)
                    flag = 1;
                break;
            case R.id.resta:
                if (checked)
                    flag = 2;
                break;
            case R.id.multiplicacion:
                if (checked)
                    flag = 3;
                break;
            case R.id.division:
                if (checked)
                    flag = 4;
                break;
            default:
                break;

        }
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

