package xyz.bluspring.cornfelineorigin.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import xyz.bluspring.cornfelineorigin.CornFelineOrigin;

@Mixin(Player.class)
public class PlayerMixin {
    @WrapOperation(method = "eat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/food/FoodData;eat(Lnet/minecraft/world/item/Item;Lnet/minecraft/world/item/ItemStack;)V"))
    private void increaseFoodLevel(FoodData instance, Item item, ItemStack itemStack, Operation<Void> original) {
        var oldFood = instance.getFoodLevel();
        var oldSat = instance.getSaturationLevel();

        original.call(instance, item, itemStack);

        if (CornFelineOrigin.FISH_EATER_POWER.isActive((Player) (Object) this) && itemStack.is(ItemTags.FISHES)) {
            var newFood = instance.getFoodLevel();
            var newSat = instance.getSaturationLevel();

            var compFood = newFood - oldFood;
            var compSat = newSat - oldSat;

            var addedFood = (compFood * 0.75f);
            var addedSat = (compSat * 0.75f);

            instance.setFoodLevel(newFood + (int) addedFood);
            instance.setSaturation(newSat + addedSat);
        }
    }
}
