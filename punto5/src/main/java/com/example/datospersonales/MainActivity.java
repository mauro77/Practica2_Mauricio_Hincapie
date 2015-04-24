package com.example.datospersonales;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;




public class MainActivity extends ActionBarActivity {

        static int mes=0, dia=0,ano=0;
        int flagsex=0,flagh=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);

        final EditText eNombre = (EditText) findViewById(R.id.eNombre);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono = (EditText) findViewById(R.id.eTel);
        final TextView sName = (TextView) findViewById(R.id.snombre);
        final TextView sMail = (TextView) findViewById(R.id.scorreo);
        final TextView sTel = (TextView) findViewById(R.id.stelefono);
        final TextView sSex = (TextView) findViewById(R.id.ssexo);
        final TextView sCity = (TextView) findViewById(R.id.sciudad);
        final TextView sPasa = (TextView) findViewById(R.id.shobbie);
        final TextView sBirth = (TextView) findViewById(R.id.snacimiento);
        final CheckBox deporte=(CheckBox) findViewById(R.id.deporte);
        final CheckBox cine=(CheckBox) findViewById(R.id.cine);
        final CheckBox video=(CheckBox) findViewById(R.id.videojuegos);
        final CheckBox lectura=(CheckBox) findViewById(R.id.lectura);
        Button boton= (Button)findViewById(R.id.boton);
        final Spinner spiner=(Spinner)findViewById(R.id.spin);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.fecha);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName.setText(eNombre.getText());
                sMail.setText(eCorreo.getText());
                sTel.setText(eTelefono.getText());
                dia = datePicker.getDayOfMonth();
                mes = datePicker.getMonth();
                ano= datePicker.getYear();
                sBirth.setText(String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(ano));
                sCity.setText(spiner.getSelectedItem().toString());



                switch(flagh){
                    case 1:
                        sPasa.setText(R.string.deporte);
                        break;
                    case 2:
                        sPasa.setText(R.string.cine);
                        break;
                    case 3:
                        sPasa.setText(R.string.videojuegos);
                        break;
                    case 4:
                        sPasa.setText(R.string.lectura);
                        break;
                    default:
                        break;
                }

                switch(flagsex){
                    case 1:
                        sSex.setText(R.string.fem);
                        break;
                    case 2:
                        sSex.setText(R.string.mas);
                        break;
                    default:
                        break;
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spin);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.deporte:
                if(checked){flagh=1;}
                else{flagh=0;}
                break;
            case R.id.cine:
                if(checked){flagh=2;}
                else{flagh=0;}
                break;
            case R.id.videojuegos:
                if(checked){flagh=3;}
                else{flagh=0;}
                break;
            case R.id.lectura:
                if(checked){flagh=4;}
                else{flagh=0;}
            default:
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.femenino:
                if (checked)
                    flagsex = 1;
                break;
            case R.id.masculino:
                if (checked)
                    flagsex = 2;
                break;
            default:
                break;

        }
    }



    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

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

