package com.example.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int flag=0;
    double a=0;
    TextView area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.figuras);

        final EditText lado1= (EditText) findViewById(R.id.L1);
        final EditText lado2 = (EditText) findViewById(R.id.L2);
        final EditText radio= (EditText) findViewById(R.id.R);
        final EditText altura = (EditText) findViewById(R.id.A);
        final EditText base= (EditText) findViewById(R.id.B);
        area = (TextView) findViewById(R.id.result);
        Button boton = (Button) findViewById(R.id.boton);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (flag){
                    case 1:
                        if( lado1.getText().toString().length() == 0 ) {
                            lado1.setError("LADO REQUERIDO");
                        }
                        else{
                           a =Double.parseDouble(lado1.getText().toString());
                           area.setText(Double.toString(Math.pow(a,2)));
                        }
                        break;
                    case 2:
                        if( lado1.getText().toString().length() == 0 ) {
                            lado1.setError("LADO REQUERIDO");
                        }
                        else if(lado2.getText().toString().length() == 0) {
                            lado2.setError("LADO REQUERIDO");
                        }
                        else{
                            a =(Double.parseDouble(lado1.getText().toString()))*(Double.parseDouble(lado2.getText().toString()));
                            area.setText(Double.toString(a));
                        }
                        break;
                    case 3:
                        if( radio.getText().toString().length() == 0 ) {
                            radio.setError("RADIO REQUERIDO");
                        }
                        else{
                            a =(Math.PI)*(Math.pow(Double.parseDouble(radio.getText().toString()),2));
                            area.setText(Double.toString(a));
                        }
                        break;
                    case 4:
                        if( altura.getText().toString().length() == 0 ) {
                            altura.setError("ALTURA REQUERIDA");
                        }
                        else if(base.getText().toString().length() == 0) {
                            base.setError("BASE REQUERIDOA");
                        }
                        else{
                            a =(Double.parseDouble(base.getText().toString()))*(Double.parseDouble(altura.getText().toString()));
                            area.setText(Double.toString(a/2));
                        }
                        break;
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("guardado", area.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        area.setText(savedInstanceState.getString("guardado"));
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.cuadrado:
                if (checked)
                    flag = 1;
                break;
            case R.id.rectangulo:
                if (checked)
                    flag = 2;
                break;
            case R.id.circulo:
                if (checked)
                    flag = 3;
                break;
            case R.id.triangulo:
                if (checked)
                    flag = 4;
                break;
            default:
                break;

        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
