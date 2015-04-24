package com.example.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    int flag1=0,flag2=0,flag3=0,flag4=0;
    double n1,n2,n3,n4,c1,c2,c3,c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas);

        final EditText Nota1 = (EditText) findViewById(R.id.N1);
        final EditText Nota2 = (EditText) findViewById(R.id.N2);
        final EditText Nota3 = (EditText) findViewById(R.id.N3);
        final EditText Nota4 = (EditText) findViewById(R.id.N4);
        final TextView definitiva=(TextView)findViewById(R.id.Nfinal);
        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Nota1.getText().toString().length() == 0 ) {
                    Nota1.setError("NOTA REQUERIDO");
                }
                else {
                    n1 = Double.parseDouble(Nota1.getText().toString());
                    if((n1>5)||(n1<0)){
                        Nota1.setError("Nota invalida");
                    }
                    else{
                        c1=n1;
                        flag1=1;
                    }
                }

                if( Nota2.getText().toString().length() == 0 ) {
                    Nota2.setError("NOTA REQUERIDO");
                }
                else {
                    n2=Double.parseDouble(Nota2.getText().toString());
                    if((n2>5)||(n2<0)){
                        Nota2.setError("Nota invalida");
                    }else{
                        c2=n2;
                        flag2=1;
                    }

                }

                if( Nota3.getText().toString().length() == 0 ) {
                    Nota3.setError("NOTA REQUERIDO");
                }
                else {
                    n3=Double.parseDouble(Nota3.getText().toString());
                    if((n3>5)||(n3<0)){
                        Nota3.setError("Nota invalida");
                    }
                    else{
                        c3=n3;
                        flag3=1;
                    }
                }

                if( Nota4.getText().toString().length() == 0 ) {
                    Nota4.setError("NOTA REQUERIDO");
                }
                else {
                    n4=Double.parseDouble(Nota4.getText().toString());
                    if((n4>5)||(n4<0)){
                        Nota4.setError("Nota invalida");
                    }
                    else{
                        c4=n4;
                        flag4=1;
                    }
                }
                if ((flag1==1)&&(flag2==1)&&(flag3==1)&&(flag4==1)) {
                    definitiva.setText(Double.toString(c1 * 0.15 + c2 * 0.1 + c3 * 0.4 + c4 * 0.35));
                }
            }
        });
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

