package xyz.bluspring.cornfelineorigin.integration.appleskin;

import squeek.appleskin.api.AppleSkinApi;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;
import xyz.bluspring.cornfelineorigin.CornFelineOrigin;

public class CornFelineAppleSkinIntegration implements AppleSkinApi {
    @Override
    public void registerEvents() {
        FoodValuesEvent.EVENT.register(event -> {
            if (CornFelineOrigin.FISH_EATER_POWER.isActive(event.player)) {
                event.modifiedFoodValues = new FoodValues(event.defaultFoodValues.hunger + (int) (event.defaultFoodValues.hunger * 0.75), event.defaultFoodValues.saturationModifier + (event.defaultFoodValues.saturationModifier * 0.75f));
            }
        });
    }
}
