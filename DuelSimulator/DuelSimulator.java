/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javafullcourse.Apps.DuelSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author honza
 */
public class DuelSimulator {

    String[] fighters = {"(A)rcher", "(R)ogue", "(B)rawler"};
    public ArrayList<String> opponents;
    public Random random;

    DuelSimulator() {
        random = new Random();
        askQuestion();

    }

    public void askQuestion() {

        while (true) {
            System.out.println("*******************************");
            System.out.println("Welcome to the duel simualtor!");
            System.out.println("Choose Your Fighter!");
            System.out.println(Arrays.toString(fighters));
            Scanner scanner = new Scanner(System.in);
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response) {
                case 'A':
                    System.out.println("You chose Archer!");
                    Archer archer = new Archer(1, 1, 2); //make this load atributes automatically
                    Duel(archer.archerHealth, archer.archerDexterity, archer.archerStrenght);
                    break;
                case 'R':
                    System.out.println("You chose Rogue!");
                    break;
                case 'B':
                    System.out.println("You chose Brawler!");

                default:
                    System.out.println("Not a valid answer");
            }
        }

    }
//Implement to just use one class for all fighters

    public void Duel(int fighterHealth,int fighterDexterity, int fighterStrenght) {
        System.out.println("Entering the arena");
        System.out.println("You encountered a Cobold"); // this should choose from an array of opponents and load the stats of the chosen one.
        Enemy cobold = new Enemy(1, 1, 1);
        System.out.println("Fighter with higher desxterity attacks first!");
        System.out.println("Your dexterity is: " + fighterDexterity);
        System.out.println("Enemy Dexterity is: " + cobold.dexterity);
        boolean goFirst;
        int min = 1;
        int max  = 20;
         //shift up the min export value by adding min, then multiply by the range we want then adding 1 to get the max value as well
        if (fighterDexterity > cobold.dexterity) {
            System.out.println("you attack First!");
            goFirst = true;
        } else {
            System.out.println("Cobold attacks First");
            goFirst = false;
        }

        for (int k = 1; k <= 10; k++) {
            System.out.println("Round " + k);
            if ((goFirst = true) && (cobold.health > 0) && (fighterHealth > 0)) {
                System.out.println("you roll for attack");
                int attack = min + (int)(Math.random() * ((max - min) + 1));
                int defense = min + (int)(Math.random() * ((max - min) + 1));
                int damage = attack + fighterStrenght;
                int armor = defense + cobold.dexterity;
                if (damage >= armor ) {
                    System.out.println("you hit cobold for " + (damage)+ " damage");
                    cobold.health -= damage;
                }else{
                System.out.println("you miss");
                }
            }
            if ((goFirst = false) && (cobold.health > 0) && (fighterHealth > 0)) {
                System.out.println("Cobold roll for attack");
                int attack = min + (int)(Math.random() * ((max - min) + 1));
                int defense = min + (int)(Math.random() * ((max - min) + 1));
                int damage = attack + cobold.strenght;
                int armor = defense + fighterDexterity;
                if (damage >= armor ) {
                    System.out.println(" cobold hits you for " + (damage)+ " damage");
                    fighterHealth -= damage;
                }else{
                System.out.println("Cobold misses you");
                }
            }
            if (cobold.health <= 0) {
                System.out.println("you have Won!");
                break;
            }
            if (fighterHealth <= 0) {
                System.out.println("yo have Lost!");
                break;
            }

        }
    }
}
