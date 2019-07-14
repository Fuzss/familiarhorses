package com.fuzs.familiarhorses.handler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ForgeIngameGui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HorseHUDHandler extends ForgeIngameGui {

    public HorseHUDHandler() {
        super(Minecraft.getInstance());
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public void renderGameOverlay(RenderGameOverlayEvent.Pre evt) {

        if (evt.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        if (this.mc.player.getHorseJumpPower() == 0.0f) {
            renderJumpBar = false;
        }

        renderFood = true;

    }

}
