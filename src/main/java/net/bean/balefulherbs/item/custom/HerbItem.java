package net.bean.balefulherbs.item.custom;

import net.bean.balefulherbs.herbcraving.ModCapabilities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HerbItem extends Item {

    public HerbItem(Properties pProperties) {

        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity)
    {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pLivingEntity);

        if (pLivingEntity instanceof Player player && !pLevel.isClientSide())
        {
            player.getCapability(ModCapabilities.PLAYER_CRAVE_CAPABILITY).ifPresent(
                    data -> {
                        data.setKempConsumedTime(pLevel.getGameTime());
                    }
            );
        }

        return itemstack;
    }
}
