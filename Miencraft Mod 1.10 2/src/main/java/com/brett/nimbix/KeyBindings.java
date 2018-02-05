package com.brett.nimbix;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {
	
    public static KeyBinding AOESize;
    public static KeyBinding Power;
    
    public static void init() {
    	AOESize = new KeyBinding("Increase AOE Size", Keyboard.KEY_C, "Tools And Armor");
	    ClientRegistry.registerKeyBinding(AOESize);
	    Power = new KeyBinding("Increase Power", Keyboard.KEY_V, "Tools And Armor");
	    ClientRegistry.registerKeyBinding(Power);
    }
	
}
