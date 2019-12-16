package com.example.multiplefragmentstransitions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.multiplefragmentstransitions.fragments.seed.Vileplume;
import com.example.multiplefragmentstransitions.fragments.seed.Venusaur;
import com.example.multiplefragmentstransitions.fragments.seed.Victrebeel;
import com.example.multiplefragmentstransitions.fragments.seed.Exeggutor;
import com.example.multiplefragmentstransitions.fragments.fire.Ninetales;
import com.example.multiplefragmentstransitions.fragments.fire.Arcanine;
import com.example.multiplefragmentstransitions.fragments.fire.Rapidash;
import com.example.multiplefragmentstransitions.fragments.fire.Charizard;
import com.example.multiplefragmentstransitions.fragments.water.Blastoise;
import com.example.multiplefragmentstransitions.fragments.water.Golduck;
import com.example.multiplefragmentstransitions.fragments.water.Seadra;
import com.example.multiplefragmentstransitions.fragments.water.Vaporeon;

public class MainActivity extends AppCompatActivity {

    private Fragment ninetales;
    private Fragment charizard;
    private Fragment arcanine;
    private Fragment rapidash;

    private Fragment venusaur;
    private Fragment exeggutor;
    private Fragment victreebel;
    private Fragment vileplume;

    private Fragment blastoise;
    private Fragment golduck;
    private Fragment vaporeon;
    private Fragment seadra;

    private Button ninetalesButton;
    private Button charizardButton;
    private Button arcanineButton;
    private Button rapidashButton;

    private Button venusaurButton;
    private Button exeggutorButton;
    private Button victreebelButton;
    private Button vileplumButton;

    private Button blastoiseButton;
    private Button golduckButton;
    private Button vaporeonButton;
    private Button seadraButton;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        initFire();
        initSeed();
        initWater();

        attachFragmentsToScreen();
        addListenerToButtons();
    }

    private void initFire(){
        ninetales = new Ninetales();
        charizard = new Charizard();
        arcanine = new Arcanine();
        rapidash = new Rapidash();

        ninetalesButton = findViewById(R.id.ninetales);
        charizardButton = findViewById(R.id.charizard);
        arcanineButton = findViewById(R.id.arcanine);
        rapidashButton = findViewById(R.id.rapidash);
    }

    private void initSeed(){
        venusaur = new Venusaur();
        exeggutor = new Exeggutor();
        victreebel = new Victrebeel();
        vileplume = new Vileplume();

        venusaurButton = findViewById(R.id.venusaur);
        exeggutorButton = findViewById(R.id.exeggutor);
        victreebelButton = findViewById(R.id.victreebel);
        vileplumButton = findViewById(R.id.vileplume);
    }

    private void initWater(){
        blastoise = new Blastoise();
        golduck = new Golduck();
        vaporeon = new Vaporeon();
        seadra = new Seadra();

        blastoiseButton = findViewById(R.id.blastoise);
        golduckButton = findViewById(R.id.golduck);
        vaporeonButton = findViewById(R.id.vaporeon);
        seadraButton = findViewById(R.id.seadra);
    }

    private void attachFragmentsToScreen(){
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.favourite_fragment_container, ninetales).commit();
        fragmentManager.beginTransaction().add(R.id.favourite_fragment_container, charizard).hide(charizard).commit();
        fragmentManager.beginTransaction().add(R.id.favourite_fragment_container, arcanine).hide(arcanine).commit();
        fragmentManager.beginTransaction().add(R.id.favourite_fragment_container, rapidash).hide(rapidash).commit();

        fragmentManager.beginTransaction().add(R.id.common_fragment_container, venusaur).commit();
        fragmentManager.beginTransaction().add(R.id.common_fragment_container, exeggutor).hide(exeggutor).commit();
        fragmentManager.beginTransaction().add(R.id.common_fragment_container, victreebel).hide(victreebel).commit();
        fragmentManager.beginTransaction().add(R.id.common_fragment_container, vileplume).hide(vileplume).commit();

        fragmentManager.beginTransaction().add(R.id.water_container, blastoise).commit();
        fragmentManager.beginTransaction().add(R.id.water_container, golduck).hide(golduck).commit();
        fragmentManager.beginTransaction().add(R.id.water_container, vaporeon).hide(vaporeon).commit();
        fragmentManager.beginTransaction().add(R.id.water_container, seadra).hide(seadra).commit();

    }

    private void addListenerToButtons(){
        ninetalesButton.setOnClickListener(new OpenNinetalesHandler());
        charizardButton.setOnClickListener(new OpenCharizardHandler());
        arcanineButton.setOnClickListener(new OpenArcanineHandler());
        rapidashButton.setOnClickListener(new OpenRapidashHandler());

        venusaurButton.setOnClickListener(new OpenVenusaurHandler());
        exeggutorButton.setOnClickListener(new OpenExeggutorHandler());
        victreebelButton.setOnClickListener(new OpenVictreebelHandler());
        vileplumButton.setOnClickListener(new OpenVileplumeHandler());

        blastoiseButton.setOnClickListener(new OpenBlastoiseHandler());
        golduckButton.setOnClickListener(new OpenGolduckHandler());
        vaporeonButton.setOnClickListener(new OpenVaporeonHandler());
        seadraButton.setOnClickListener(new OpenSeadraHandler());
    }

    private class OpenNinetalesHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllFirePokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(ninetales).commit();
        }
    }

    private class OpenCharizardHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllFirePokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(charizard).commit();
        }
    }

    private class OpenArcanineHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllFirePokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(arcanine).commit();
        }
    }

    private class OpenRapidashHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllFirePokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(rapidash).commit();
        }
    }

    private void hideAllFirePokemons(){
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(ninetales).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(charizard).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(arcanine).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(rapidash).commit();
    }

    private class OpenVenusaurHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllSeedPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(venusaur).commit();
        }
    }

    private class OpenExeggutorHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllSeedPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(exeggutor).commit();
        }
    }

    private class OpenVictreebelHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllSeedPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(victreebel).commit();
        }
    }

    private class OpenVileplumeHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideAllSeedPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(vileplume).commit();
        }
    }

    private void hideAllSeedPokemons(){
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(venusaur).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(exeggutor).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(victreebel).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(vileplume).commit();
    }


    private class OpenBlastoiseHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideWaterPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(blastoise).commit();
        }
    }

    private class OpenGolduckHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideWaterPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(golduck).commit();
        }
    }

    private class OpenVaporeonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideWaterPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(vaporeon).commit();
        }
    }

    private class OpenSeadraHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            hideWaterPokemons();
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).show(seadra).commit();
        }
    }

    private void hideWaterPokemons(){
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(blastoise).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(golduck).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(vaporeon).commit();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).hide(seadra).commit();
    }
}
