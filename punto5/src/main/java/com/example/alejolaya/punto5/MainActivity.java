package com.example.alejolaya.punto5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName = (EditText) findViewById(R.id.etNombre);
        final EditText etLName = (EditText) findViewById(R.id.etApellido);
        final EditText etId = (EditText) findViewById(R.id.etCedula);
        final RadioGroup rbSexoGrupo=(RadioGroup)findViewById(R.id.rgSexo);
        final RadioButton rbMujer= (RadioButton)findViewById(R.id.rbMujer);
        final RadioButton rbHombre= (RadioButton)findViewById(R.id.rbHombre);
        final DatePicker dpdate= (DatePicker)findViewById(R.id.dpFecha);
        final Spinner sCity=(Spinner) findViewById(R.id.sCiudades);
        final CheckBox cbH1=(CheckBox) findViewById(R.id.cbHobbie1);
        final CheckBox cbH2=(CheckBox) findViewById(R.id.cbHobbie2);
        final CheckBox cbH3=(CheckBox) findViewById(R.id.cbHobbie3);
        final CheckBox cbH4=(CheckBox) findViewById(R.id.cbHobbie4);
        Button mostrar=(Button) findViewById(R.id.bMostrar);
        final TextView tvName=(TextView)findViewById(R.id.tvNombre);
        final TextView tvLName=(TextView)findViewById(R.id.tvApellido);
        final TextView tvId=(TextView)findViewById(R.id.tvCedula);
        final TextView tvSex=(TextView)findViewById(R.id.tvGenero);
        final TextView tvDate=(TextView)findViewById(R.id.tvFecha);
        final TextView tvHobbises=(TextView)findViewById(R.id.tvHobbies);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, apellido, cedula, sexo, fecha,lugar, hobbys;
                try {
                    nombre = String.valueOf(etName.getText().toString());
                }catch (Exception ex){
                    nombre = "Sin Nombre";
                }
                try {
                    apellido = String.valueOf(etLName.getText().toString());
                }catch (Exception ex){
                    apellido = "Sin Apellido";
                }
                try {
                    cedula = String.valueOf(etId.getText().toString());
                }catch (Exception ex){
                    cedula = "Sin Cedula";
                }
                int selectedId = rbSexoGrupo.getCheckedRadioButtonId();
                String radioButtonSelected="";
                sexo="Sin Sexo";
                switch (selectedId) {
                    case R.id.rbHombre:
                        sexo = "Hombre";
                        break;
                    case R.id.rbMujer:
                        sexo="Mujer";
                    break;
                }
                fecha=String.valueOf(dpdate.getDayOfMonth())+"/"+String.valueOf(dpdate.getMonth()+1)+"/"+String.valueOf(dpdate.getYear());
                lugar=String.valueOf(sCity.getSelectedItem().toString());
                hobbys="";
                if(cbH1.isChecked()){
                    hobbys+="\n-"+String.valueOf(cbH1.getText());
                }
                if(cbH2.isChecked()){
                    hobbys+="\n-"+String.valueOf(cbH2.getText());
                }
                if(cbH3.isChecked()){
                    hobbys+="\n-"+String.valueOf(cbH3.getText());
                }
                if(cbH4.isChecked()){
                    hobbys+="\n-"+String.valueOf(cbH4.getText());
                }

                //*************************Mostrar los datos

                tvName.setText(nombre);
                tvLName.setText(apellido);
                tvId.setText(cedula);
                tvSex.setText(sexo);
                tvDate.setText(fecha);
                tvHobbises.setText(hobbys);




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
