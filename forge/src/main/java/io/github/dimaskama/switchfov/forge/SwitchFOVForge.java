package io.github.dimaskama.switchfov.forge;

import io.github.dimaskama.switchfov.SwitchFOV;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(SwitchFOV.MOD_ID)
public class SwitchFOVForge {

    @Mod.EventBusSubscriber(modid = SwitchFOV.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(SwitchFOV.SWITCH_KEYBINDING);
        }
    }

    @Mod.EventBusSubscriber(modid = SwitchFOV.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onEndClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                SwitchFOV.handleInput();
            }
        }
    }
}
