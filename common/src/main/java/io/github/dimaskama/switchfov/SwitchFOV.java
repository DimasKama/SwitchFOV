package io.github.dimaskama.switchfov;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.SimpleOption;

public class SwitchFOV {
	public static final String MOD_ID = "switchfov";
	public static final KeyBinding SWITCH_KEYBINDING = new KeyBinding("key.switchfov.switch", -1, MOD_ID);
	private static final int MIN_FOV = 30;
	private static int lastFOV = MIN_FOV;

	public static void handleInput() {
		while (SWITCH_KEYBINDING.wasPressed()) {
			SimpleOption<Integer> fovOption = MinecraftClient.getInstance().options.getFov();
			int value = fovOption.getValue();
			if (value == MIN_FOV) {
				if (lastFOV != MIN_FOV) {
					fovOption.setValue(lastFOV);
				}
			} else {
				lastFOV = value;
				fovOption.setValue(MIN_FOV);
			}
		}
	}
}
