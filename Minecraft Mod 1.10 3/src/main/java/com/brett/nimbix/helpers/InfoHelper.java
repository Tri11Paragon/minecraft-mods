package com.brett.nimbix.helpers;

//import cofh.api.energy.IEnergyContainerItem;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by Brandon on 1/07/2014.
 */
public class InfoHelper {

    public static final int GUI_TITLE = 0x00FFFF;


    /**
     * Add lore with a blank line above it
     */

    /**
     * Add the standard energy and lore information
     */
    /**
     * returns lore text or an empty string if the lore is not set
     */

    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isCtrlKeyDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
    }

    @SuppressWarnings("unchecked")
    public static boolean holdShiftForDetails(List list, boolean inverted) {
        if (isShiftKeyDown() == inverted)
            list.add(I18n.format("info.bc.holdShiftForDetails.txt", TextFormatting.AQUA + "" + TextFormatting.ITALIC, TextFormatting.RESET + "" + TextFormatting.GRAY));
        return isShiftKeyDown();
    }

    public static boolean holdShiftForDetails(List list) {
        return holdShiftForDetails(list, false);
    }

    /**
     * "Information Text Colour" The colour used for custom tool tip info
     */
    public static String ITC() {
        return "" + TextFormatting.RESET + "" + TextFormatting.DARK_AQUA;
    }

    /**
     * "Highlighted Information Text Colour" The colour used for parts that need to stand out
     */
    public static String HITC() {
        return "" + TextFormatting.RESET + "" + TextFormatting.ITALIC + "" + TextFormatting.GOLD;
    }


}
