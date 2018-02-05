package com.brett.nimbix;


import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	
	public static boolean AOESizeToggled;
	public static boolean PowerToggled;
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		//EnergyPickaxeBase.keyPressed();
		//EnergyAxeBase.keyPressed();
		if(KeyBindings.Power.isPressed()){
			PowerToggled = !PowerToggled;
		}
	}
	
}
