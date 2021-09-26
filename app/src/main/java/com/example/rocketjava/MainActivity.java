package com.example.rocketjava;

import androidx.appcompat.app.AppCompatActivity;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView firstBudgetOption;
    TextView secondBudgetOption;
    Simulation simulation = new Simulation();
    Simulation simulation2 = new Simulation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstBudgetOption = (TextView)findViewById(R.id.firstBudgetOption);
        secondBudgetOption = (TextView)findViewById(R.id.secondBudgetOption);

        try {
            startProgram(firstBudgetOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startProgram(View view) throws Exception {
        ArrayList<Item> itemPhase1 = simulation.loadItems(this,"phase-1.txt");
        ArrayList<Item> itemPhase2 = simulation.loadItems(this,"phase-2.txt");
        ArrayList<Rocket> listFullloadU1 = simulation.loadU1(itemPhase1);
        ArrayList<Rocket> listFullloadU2 = simulation.loadU1(itemPhase2);

        firstBudgetOption.setText(simulation.runSimulation(this, "U1", listFullloadU1, listFullloadU2));

        ArrayList<Item> itemPhase3 = simulation2.loadItems(this,"phase-1.txt");
        ArrayList<Item> itemPhase4 = simulation2.loadItems(this,"phase-2.txt");
        ArrayList<Rocket> listFullloadU3 = simulation2.loadU2(itemPhase3);
        ArrayList<Rocket> listFullloadU4 = simulation2.loadU2(itemPhase4);

        secondBudgetOption.setText(simulation.runSimulation(this, "U2", listFullloadU3, listFullloadU4));
    }
}