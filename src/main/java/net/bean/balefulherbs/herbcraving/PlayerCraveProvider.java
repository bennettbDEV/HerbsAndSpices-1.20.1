package net.bean.balefulherbs.herbcraving;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class PlayerCraveProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag>
{
    private final PlayerCrave playerCrave = new PlayerCrave();

    //LazyOptional wrapper for the capability instance
    private final LazyOptional<PlayerCrave> optional = LazyOptional.of(() -> playerCrave);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == ModCapabilities.PLAYER_CRAVE_CAPABILITY ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        tag.putLong("KempConsumedTime", playerCrave.getConsumedTime("kemp"));
        tag.putLong("KempPowderConsumedTime", playerCrave.getConsumedTime("kemp_powder"));
        tag.putLong("RefinedKempConsumedTime", playerCrave.getConsumedTime("refined_kemp"));

        tag.putLong("SilverSpeedberryConsumedTime", playerCrave.getConsumedTime("silver_speedberry"));
        tag.putLong("SilverSpeedberryPowderConsumedTime", playerCrave.getConsumedTime("silver_speedberry_powder"));
        tag.putLong("RefinedSilverSpeedberryConsumedTime", playerCrave.getConsumedTime("refined_silver_speedberry"));

        tag.putLong("IdoniteConsumedTime", playerCrave.getConsumedTime("idonite"));
        tag.putLong("IdonitePowderConsumedTime", playerCrave.getConsumedTime("idonite_powder"));
        tag.putLong("RefinedIdoniteConsumedTime", playerCrave.getConsumedTime("refined_idonite"));

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        playerCrave.setConsumedTime("kemp", nbt.getLong("KempConsumedTime"));
        playerCrave.setConsumedTime("kemp_powder", nbt.getLong("KempPowderConsumedTime"));
        playerCrave.setConsumedTime("refined_kemp", nbt.getLong("RefinedKempConsumedTime"));

        playerCrave.setConsumedTime("silver_speedberry", nbt.getLong("SilverSpeedberryConsumedTime"));
        playerCrave.setConsumedTime("silver_speedberry_powder", nbt.getLong("SilverSpeedberryPowderConsumedTime"));
        playerCrave.setConsumedTime("refined_silver_speedberry", nbt.getLong("RefinedSilverSpeedberryConsumedTime"));

        playerCrave.setConsumedTime("idonite", nbt.getLong("IdoniteConsumedTime"));
        playerCrave.setConsumedTime("idonite_powder", nbt.getLong("IdonitePowderConsumedTime"));
        playerCrave.setConsumedTime("refined_idonite", nbt.getLong("RefinedIdoniteConsumedTime"));
    }
}

