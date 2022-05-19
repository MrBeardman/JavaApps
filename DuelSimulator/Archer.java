/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javafullcourse.Apps.DuelSimulator;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author honza
 */
public class Archer extends Fighter {

    String name;
    int healthModifier =1;
    int strenghtModifier;
    int dexterityModifier;

    int archerHealth;
    int archerStrenght;
    int archerDexterity;

    Archer(int healthModifier, int strenghtModifier, int dexterityModifier) {

        this.healthModifier = healthModifier;
        this.strenghtModifier = strenghtModifier;
        this.dexterityModifier = dexterityModifier;

        System.out.println("Creating new Archer");
        System.out.println("Choose a name");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        System.out.println("Your archers name is " + name);
        System.out.println("Rolling Stats");
        Random random = new Random();

        this.archerHealth = random.nextInt(20) + 1 * healthModifier;
        this.archerStrenght = random.nextInt(10) + 1 * strenghtModifier;
        this.archerDexterity = random.nextInt(10) + 1 * dexterityModifier;
        System.out.println("Your stats are: Health: " + archerHealth + " Strentgh: " + archerStrenght + " Dex: " + archerDexterity + ".");
    }
}
