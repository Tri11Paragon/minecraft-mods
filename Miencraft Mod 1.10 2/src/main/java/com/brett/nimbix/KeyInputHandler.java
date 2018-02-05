package com.brett.nimbix;

import com.brett.item.tools.AdvancedQuantumPickaxe;
import com.brett.item.tools.EnergyAxeBase;
import com.brett.item.tools.EnergyPickaxeBase;

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
