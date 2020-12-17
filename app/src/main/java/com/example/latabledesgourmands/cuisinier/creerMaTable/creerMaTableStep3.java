package com.example.latabledesgourmands.cuisinier.creerMaTable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Table;

import java.util.Calendar;

public class creerMaTableStep3 extends AppCompatActivity {
    Table maTable;
    Calendar calendrier;
    DatePicker date;
    TimePicker heure;
    TextView adresse;
    TextView nombreConvives;
    TextView nomTheme;
    CheckBox fumeur;
    CheckBox alcool;
    CheckBox animaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_ma_table_step3);
        linkActivityToLayout();
        calendrier= Calendar.getInstance();
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("maTable")){
                maTable=intent.getParcelableExtra("maTable");
            }
        }
        initTimePicked();
        initDatePicked();
    }

    private void linkActivityToLayout(){
        date=findViewById(R.id.datePicker);
        heure=findViewById(R.id.timePicker);
        adresse=findViewById(R.id.editTextTextPostalAddress);
        nombreConvives=findViewById(R.id.editTextNumber);
        nomTheme=findViewById(R.id.editThemeText);
        fumeur=findViewById(R.id.checkBox);
        animaux=findViewById(R.id.checkBox2);
        alcool=findViewById(R.id.checkBox3);
    }
    public void initTimePicked(){
        heure.setIs24HourView(true);
        heure.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });
    }
    public void initDatePicked(){
        date.init(calendrier.YEAR, calendrier.DAY_OF_MONTH, calendrier.DAY_OF_MONTH, DatePicker::updateDate);
    }

    public void getDataFromUserInput() {
        int mois = date.getMonth()+1;
        String dateText = date.getDayOfMonth() + "/" + mois + "/" + date.getYear();
        String timeText = heure.getHour() +"h:" + heure.getMinute();
        maTable.getMonEvenement().setDate(dateText);
        maTable.getMonEvenement().setHeure(timeText);
        maTable.getMonEvenement().setAdresse(adresse.getText().toString());
        maTable.getMonEvenement().setNombreConvive(Integer.parseInt(nombreConvives.getText().toString()));
        maTable.getMonEvenement().setTheme(nomTheme.getText().toString());
        maTable.getMonEvenement().setAlcoolOk(alcool.isChecked());
        maTable.getMonEvenement().setFumeurOk(fumeur.isChecked());
        maTable.getMonEvenement().setAnimalOk(animaux.isChecked());
    }


    private void startcreerMaTablestep4Activity(){
        Intent intent = new Intent(this, creerMaTableStep4.class);
        intent.putExtra("maTable",maTable);
        startActivity(intent);
    }


    public void onClickNextStepButton(View view) {
        getDataFromUserInput();
        startcreerMaTablestep4Activity();
    }


}