package io.github.dimaskama.switchfov.fabric;

import io.github.dimaskama.switchfov.SwitchFOV;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class SwitchFOVFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KeyBindingHelper.registerKeyBinding(SwitchFOV.SWITCH_KEYBINDING);
        ClientTickEvents.END_CLIENT_TICK.register(m -> SwitchFOV.handleInput());
    }
}