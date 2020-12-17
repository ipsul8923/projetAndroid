package com.example.latabledesgourmands.invite.rechercherUneTable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latabledesgourmands.R;
import com.example.latabledesgourmands.utilitaire.Models.Dessert;
import com.example.latabledesgourmands.utilitaire.Models.Entree;
import com.example.latabledesgourmands.utilitaire.Models.Evenement;
import com.example.latabledesgourmands.utilitaire.Models.Menu;
import com.example.latabledesgourmands.utilitaire.Models.Plat;
import com.example.latabledesgourmands.utilitaire.Models.Table;

public class RechercherTableStep1 extends AppCompatActivity {
    Table monFiltre;
    //test
    TextView dateInput;
    TextView heureInput;
    TextView adresseInput;
    TextView convivesInput;
    TextView prixMaxInput;

    LinearLayout menu;
    LinearLayout theme;

    Button menuToutSelected;
    Button menuVegeSelected;
    Button menuVeganSelected;
    Button menuSansGlutenSelected;

    Button themeToutSelected;
    Button themeAucunSelected;
    Button themePiratesSelected;
    Button themeHaloweenSelected;

    CheckBox fumeur;
    CheckBox animaux;
    CheckBox alcool;

    Boolean isDateInputVisible = false;
    Boolean isHeureInputVisible = false;
    Boolean isAdresseInputVisible = false;
    Boolean isNbrConvivesInputVisible = false;
    Boolean isMenuInputVisible = false;
    Boolean isPrixInputVisible = false;
    Boolean isThemeInputVisible = false;

    String aucun;
    String pirates;
    String haloween;
	
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_table_step1);
        initFiltreTableProcess();
        dateInput = findViewById(R.id.editTextDate);
        heureInput = findViewById(R.id.editTextTime);
        adresseInput = findViewById(R.id.editTextPostalAddress);
        convivesInput = findViewById(R.id.editTextNumberConvives);
        menuToutSelected = findViewById(R.id.buttonMenuTout);
        menuVegeSelected = findViewById(R.id.buttonMenuVégé);
        menuVeganSelected = findViewById(R.id.buttonMenuVegan);
        menuSansGlutenSelected = findViewById(R.id.buttonMenuSansGluten);
        prixMaxInput = findViewById(R.id.editTextPrixMax);
        themeToutSelected = findViewById(R.id.buttonThemeTout);
        themeAucunSelected = findViewById(R.id.buttonThemeAucun);
        themePiratesSelected = findViewById(R.id.buttonThemePirates);
        themeHaloweenSelected = findViewById(R.id.buttonThemeHaloween);
        fumeur = findViewById(R.id.checkBoxFumeur);
        animaux = findViewById(R.id.checkBoxAnimaux);
        alcool = findViewById(R.id.checkBoxAlcool);
        menu = findViewById(R.id.menuLayout);
        theme = findViewById(R.id.themeLayout);
    }

    private void initFiltreTableProcess(){
        monFiltre = new Table(
                new Menu(
                        new Entree(null, null, null, 0f, 0f, false, false, false),
                        new Plat(null, null, null, 0f, 0f, false, false, false, null),
                        new Dessert(null, null, null, 0f, 0f, false, false, false)
                ),
                new Evenement(null, null, null, 0, 0, null, null, null, null)
        );
    }


    public void onClickRechercherTableButton(View view){
        printDataFromUser();
        startRechercherTableStep2Activity();
    }

    public void printDataFromUser(){
        if(isDateInputVisible){
            monFiltre.getMonEvenement().setDate(dateInput.getText().toString());
        }
        if(isHeureInputVisible){
            monFiltre.getMonEvenement().setHeure(heureInput.getText().toString());
        }
        if(isAdresseInputVisible){
            monFiltre.getMonEvenement().setAdresse(adresseInput.getText().toString());
        }
        if(isNbrConvivesInputVisible){
            monFiltre.getMonEvenement().setNombreConvive(Integer.parseInt(convivesInput.getText().toString()));
        }
        if(isMenuInputVisible){
            if(menuToutSelected.isSelected()){
                monFiltre.getMonMenu().setVegetarien(false);
                monFiltre.getMonMenu().setVegan(false);
                monFiltre.getMonMenu().setSansGluten(false);
            }
            if(menuVegeSelected.isSelected()){
                monFiltre.getMonMenu().setVegetarien(true);
            }
            if(menuVeganSelected.isSelected()){
                monFiltre.getMonMenu().setVegan(true);
            }
            if(menuSansGlutenSelected.isSelected()){
                monFiltre.getMonMenu().setSansGluten(true);
            }
        }
        if(isPrixInputVisible){
            monFiltre.getMonMenu().setPrixDuMenuParPersonne(Float.parseFloat(prixMaxInput.getText().toString()));
        }
        if(isThemeInputVisible){
            if(themeToutSelected.isSelected()){
                monFiltre.getMonEvenement().setTheme("tout");
            }
            if(themeAucunSelected.isSelected()){
                monFiltre.getMonEvenement().setTheme("aucun");
            }
            if(themePiratesSelected.isSelected()){
                monFiltre.getMonEvenement().setTheme("pirates");
            }
            if(themeHaloweenSelected.isSelected()){
                monFiltre.getMonEvenement().setTheme("haloween");
            }
        }
        if(fumeur.isChecked()){
            monFiltre.getMonEvenement().setFumeurOk(true);
        }
        if(animaux.isChecked()){
            monFiltre.getMonEvenement().setAnimalOk(true);
        }
        if(alcool.isChecked()){
            monFiltre.getMonEvenement().setAlcoolOk(true);
        }
    }

    private void startRechercherTableStep2Activity(){
        Intent intent = new Intent(this, RechercherTableStep2.class);
        intent.putExtra("monFiltre", monFiltre);
        startActivity(intent);
    }

    // Update Visibility fonctions

    private void updateDateVisibility(){
        if(isDateInputVisible){
            dateInput.setVisibility(View.VISIBLE);
        }
        else{
            dateInput.setVisibility(View.INVISIBLE);
        }
    }

    private void updateHeureVisibility(){
        if(isHeureInputVisible){
            heureInput.setVisibility(View.VISIBLE);
        }
        else{
            heureInput.setVisibility(View.INVISIBLE);
        }
    }

    private void updateAdresseVisibility(){
        if(isAdresseInputVisible){
            adresseInput.setVisibility(View.VISIBLE);
        }
        else{
            adresseInput.setVisibility(View.INVISIBLE);
        }
    }

    private void updateConvivesVisibility(){
        if(isNbrConvivesInputVisible){
            convivesInput.setVisibility(View.VISIBLE);
        }
        else{
            convivesInput.setVisibility(View.INVISIBLE);
        }
    }

    private void updateMenuVisibility(){
        if(isMenuInputVisible){
            menu.setVisibility(View.VISIBLE);
        }
        else{
            menu.setVisibility(View.INVISIBLE);
        }
    }

    private void updatePrixVisibility(){
        if(isPrixInputVisible){
            prixMaxInput.setVisibility(View.VISIBLE);
        }
        else{
            prixMaxInput.setVisibility(View.INVISIBLE);
        }
    }

    private void updateThemeVisibility(){
        if(isThemeInputVisible){
            theme.setVisibility(View.VISIBLE);
        }
        else{
            theme.setVisibility(View.INVISIBLE);
        }
    }

    // OnClick fonctions
    public void onClickDateFilter(View view) {
        isDateInputVisible = !isDateInputVisible;
        view.setSelected(!view.isSelected());
        updateDateVisibility();
    }

    public void onClickHeureFilter(View view) {
        isHeureInputVisible = !isHeureInputVisible;
        view.setSelected(!view.isSelected());
        updateHeureVisibility();
    }

    public void onClickAdresseFilter(View view) {
        isAdresseInputVisible = !isAdresseInputVisible;
        view.setSelected(!view.isSelected());
        updateAdresseVisibility();
    }

    public void onClickConvivesFilter(View view) {
        isNbrConvivesInputVisible = !isNbrConvivesInputVisible;
        view.setSelected(!view.isSelected());
        updateConvivesVisibility();
    }

    public void onClickMenuFilter(View view) {
        isMenuInputVisible = !isMenuInputVisible;
        view.setSelected(!view.isSelected());
        updateMenuVisibility();
    }

    public void onClickPrixFilter(View view) {
        isPrixInputVisible = !isPrixInputVisible;
        view.setSelected(!view.isSelected());
        updatePrixVisibility();
    }

    public void onClickThemeFilter(View view) {
        isThemeInputVisible = !isThemeInputVisible;
        view.setSelected(!view.isSelected());
        updateThemeVisibility();
    }

    public void onClickButtonMenuTout(View view) {
        monFiltre.getMonMenu().setVegetarien(false);
        monFiltre.getMonMenu().setVegan(false);
        monFiltre.getMonMenu().setSansGluten(false);
        view.setSelected(!view.isSelected());
        menuVegeSelected.setSelected(false);
        menuVeganSelected.setSelected(false);
        menuSansGlutenSelected.setSelected(false);
    }

    public void onClickButtonMenuVege(View view) {
        monFiltre.getMonMenu().setVegetarien(true);
        view.setSelected(!view.isSelected());
        menuToutSelected.setSelected(false);
        menuVeganSelected.setSelected(false);
        menuSansGlutenSelected.setSelected(false);
    }

    public void onClickButtonMenuVegan(View view) {
        monFiltre.getMonMenu().setVegan(true);
        view.setSelected(!view.isSelected());
        menuVegeSelected.setSelected(false);
        menuToutSelected.setSelected(false);
        menuSansGlutenSelected.setSelected(false);
    }

    public void onClickButtonMenuSansGluten(View view) {
        monFiltre.getMonMenu().setSansGluten(true);
        view.setSelected(!view.isSelected());
        menuVegeSelected.setSelected(false);
        menuVeganSelected.setSelected(false);
        menuToutSelected.setSelected(false);
    }

    public void onClickButtonThemeTout(View view) {
        monFiltre.getMonEvenement().setTheme("tout");
        view.setSelected(!view.isSelected());
        themePiratesSelected.setSelected(false);
        themeHaloweenSelected.setSelected(false);
        themeAucunSelected.setSelected(false);
    }

    public void onClickButtonThemeAucun(View view) {
        monFiltre.getMonEvenement().setTheme("aucun");
        view.setSelected(!view.isSelected());
        themePiratesSelected.setSelected(false);
        themeHaloweenSelected.setSelected(false);
        themeToutSelected.setSelected(false);
    }

    public void onClickButtonThemePirates(View view) {
        monFiltre.getMonEvenement().setTheme("pirates");
        view.setSelected(!view.isSelected());
        themeToutSelected.setSelected(false);
        themeHaloweenSelected.setSelected(false);
        themeAucunSelected.setSelected(false);
    }

    public void onClickButtonThemeHaloween(View view) {
        monFiltre.getMonEvenement().setTheme("haloween");
        view.setSelected(!view.isSelected());
        themePiratesSelected.setSelected(false);
        themeToutSelected.setSelected(false);
        themeAucunSelected.setSelected(false);
    }
}
