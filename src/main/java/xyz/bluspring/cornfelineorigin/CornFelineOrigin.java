package xyz.bluspring.cornfelineorigin;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerTypeReference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class CornFelineOrigin implements ModInitializer {
    public static final PowerTypeReference<Power> FISH_EATER_POWER = new PowerTypeReference<>(new ResourceLocation("crimecraft", "fish_eater"));

    @Override
    public void onInitialize() {

    }
}
