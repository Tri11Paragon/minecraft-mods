package com.brett.direop;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings {

    // Declare two KeyBindings, ping and pong
    public static KeyBinding LB;
    public static KeyBinding RB;
    public static KeyBinding SH;

    public static void init() {
        // Define the "ping" binding, with (unlocalized) name "key.ping" and
        // the category with (unlocalized) name "key.categories.mymod" and
        // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
        LB = new KeyBinding("--", Keyboard.KEY_LBRACKET, "Diremod Stuff");
        // Define the "pong" binding, with (unlocalized) name "key.pong" and
        // the category with (unlocalized) name "key.categories.mymod" and
        // key code 25 ("P", LWJGL constant: Keyboard.KEY_P)
        RB = new KeyBinding("++", Keyboard.KEY_RBRACKET, "Diremod Stuff");
        SH = new KeyBinding("Shoot", Keyboard.KEY_U, "Diremod Stuff");

        // Register both KeyBindings to the ClientRegistry
        ClientRegistry.registerKeyBinding(RB);
        ClientRegistry.registerKeyBinding(LB);
    }

}