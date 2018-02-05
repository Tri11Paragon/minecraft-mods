package com.brett.nimbix;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
    @SubscribeEvent
    public void ItemPickupEvent(EntityItemPickupEvent event) {
        //System.out.println("Item picked up!");
    }
    
	
}
