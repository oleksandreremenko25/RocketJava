package com.example.rocketjava;


import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems (Context contextThis, String itemPhase) throws IOException {
        Context context = contextThis;
        AssetManager manegerForAsset = context.getAssets();
        Scanner scanner = new Scanner(manegerForAsset.open(itemPhase));
        ArrayList<Item> arrayListItem = new ArrayList<Item>();

        while(scanner.hasNextLine()) {
            String descriptionCargo = scanner.nextLine();
            String[] splitDescriptionCargo = descriptionCargo.split("=");
            Item item = new Item(splitDescriptionCargo[0], Integer.parseInt(splitDescriptionCargo[1]));

            arrayListItem.add(item);
        }

        return arrayListItem;
    }

    public ArrayList CalculationForLoadU1_2(String typeRocket, ArrayList<Item> itemArrayList) {
        ArrayList arrayListFullU1 = new ArrayList();

        int x = 0;
        while (itemArrayList.size() != 0) {
            if (typeRocket == "U1") {
                U1 fullU1 = new U1();
                for (int y = 0; y < itemArrayList.size(); y++) {
                    if (fullU1.canCarry(itemArrayList.get(y))) {
                        fullU1.carry(itemArrayList.get(y));
                        itemArrayList.remove(y);
                    }
                }

                arrayListFullU1.add(fullU1);
            } else {
                U2 fullU2 = new U2();
                for (int y = 0; y < itemArrayList.size(); y++) {
                    if (fullU2.canCarry(itemArrayList.get(y))) {
                        fullU2.carry(itemArrayList.get(y));
                        itemArrayList.remove(y);
                    }
                }

                arrayListFullU1.add(fullU2);
            }
            x++;
        }
        return arrayListFullU1;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemArrayList) throws FileNotFoundException {
        return CalculationForLoadU1_2("U1", itemArrayList);
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemArrayList) throws FileNotFoundException {
        return CalculationForLoadU1_2("U2", itemArrayList);
    }

    public String runSimulation(Context contextThis, String typeRocket, ArrayList<Rocket> arrayListFull_1, ArrayList<Rocket> arrayListFull_2) throws FileNotFoundException {
        int numberAllRocket = 0;

        arrayListFull_1.addAll(0, arrayListFull_2);

        int z = 0;
        while (z < arrayListFull_1.size()) {
            if (arrayListFull_1.get(z).land() || arrayListFull_1.get(z).launch()) {
                z++;
            }
        }

        int costOneRocket;
        if (typeRocket.equals("U1")) {
            U1 u1 = new U1();
            costOneRocket = u1.rocketCost;
        } else {
            U2 u2 = new U2();
            costOneRocket = u2.rocketCost;
        }

        String textAnswerFirstPart = contextThis.getString(R.string.textAnswerFirstPart);
        String textAnswerSecondPart = contextThis.getString(R.string.textAnswerSecondPart);
        String textAnswerThirddPart = contextThis.getString(R.string.textAnswerThirddPart);

        return textAnswerFirstPart + " " + z + " " + textAnswerSecondPart + " " + z * costOneRocket + " " + textAnswerThirddPart;
    }
}

