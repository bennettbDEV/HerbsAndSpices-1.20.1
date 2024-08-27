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
    private final PlayerCrave playercrave = new PlayerCrave();

    //LazyOptional wrapper for the capability instance
    private final LazyOptional<PlayerCrave> optional = LazyOptional.of(() -> playercrave);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == ModCapabilities.PLAYER_CRAVE_CAPABILITY ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        tag.putLong("KempConsumedTime", playercrave.getConsumedTime("kemp"));
        tag.putLong("KempPowderConsumedTime", playercrave.getConsumedTime("kemp_powder"));
        tag.putLong("RefinedKempConsumedTime", playercrave.getConsumedTime("refined_kemp"));

        tag.putLong("SilverSpeedberryConsumedTime", playercrave.getConsumedTime("silver_speedberry"));
        tag.putLong("SilverSpeedberryPowderConsumedTime", playercrave.getConsumedTime("silver_speedberry_powder"));
        tag.putLong("RefinedSilverSpeedberryConsumedTime", playercrave.getConsumedTime("refined_silver_speedberry"));

        tag.putLong("IdoniteConsumedTime", playercrave.getConsumedTime("idonite"));
        tag.putLong("IdonitePowderConsumedTime", playercrave.getConsumedTime("idonite_powder"));
        tag.putLong("RefinedIdoniteConsumedTime", playercrave.getConsumedTime("refined_idonite"));

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        playercrave.setConsumedTime("kemp", nbt.getLong("KempConsumedTime"));
        playercrave.setConsumedTime("kemp_powder", nbt.getLong("KempPowderConsumedTime"));
        playercrave.setConsumedTime("refined_kemp", nbt.getLong("RefinedKempConsumedTime"));

        playercrave.setConsumedTime("silver_speedberry", nbt.getLong("SilverSpeedberryConsumedTime"));
        playercrave.setConsumedTime("silver_speedberry_powder", nbt.getLong("SilverSpeedberryPowderConsumedTime"));
        playercrave.setConsumedTime("refined_silver_speedberry", nbt.getLong("RefinedSilverSpeedberryConsumedTime"));

        playercrave.setConsumedTime("idonite", nbt.getLong("IdoniteConsumedTime"));
        playercrave.setConsumedTime("idonite_powder", nbt.getLong("IdonitePowderConsumedTime"));
        playercrave.setConsumedTime("refined_idonite", nbt.getLong("RefinedIdoniteConsumedTime"));
    }
}

