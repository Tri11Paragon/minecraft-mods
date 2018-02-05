package com.brett.direop;

import com.brett.direop.armor.Uarmor;
import com.brett.direop.guns.gun;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
    	System.out.println(Uarmor.number);
        if(KeyBindings.LB.isPressed()){
        	Uarmor.number--;
        }
        if(KeyBindings.RB.isPressed()){
        	Uarmor.number++;
        }
        if(KeyBindings.SH.isPressed()){
        	if(gun.rapidfire){
        		gun.rapidfire = false;
        	}
        	gun.rapidfire = true;
        	System.out.println(gun.rapidfire);
        }
    }

}