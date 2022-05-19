/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javafullcourse.Apps.DuelSimulator;

import java.util.Random;

/**
 *
 * @author honza
 */
class Enemy extends Fighter {
    
    int healthModifier;
    int strenghtModifier;
    int dexterityModifier;

    int health;
    int strenght;
    int dexterity;
 
   Enemy(int healthModifier, int strenghtModifier, int dexterityModifier) {

        this.healthModifier = healthModifier;
        this.strenghtModifier = strenghtModifier;
        this.dexterityModifier = dexterityModifier;


        System.out.println("Rolling Enemy Stats");
        Random random = new Random();

        this.health = random.nextInt(20) + 1 * healthModifier;
        this.strenght = random.nextInt(10) + 1 * strenghtModifier;
        this.dexterity = random.nextInt(10) + 1 * dexterityModifier;
        System.out.println("Enemy stats are: Health: " + health + " Strentgh: " + strenght + " Dex: " + dexterity + ".");
    }
}
