package ae2s.mixins;

import ae2s.modBlocks.meProxy.MEProxyInventoryHandler;
import appeng.api.util.IConfigurableObject;
import appeng.blockentity.grid.AENetworkBlockEntity;
import appeng.blockentity.misc.InterfaceBlockEntity;
import appeng.helpers.InterfaceLogic;
import appeng.me.storage.NetworkStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yiranmushroom.ae2simplifier.AE2Simplifier;

import static yiranmushroom.ae2simplifier.Config.INSTANCE;
//import static yiranmushroom.ae2simplifier.Config.NullInterfaceIsProxy;

@Mixin(InterfaceBlockEntity.class)
public abstract class MixinMEInterface extends AENetworkBlockEntity implements IConfigurableObject {
    @Final
    @Shadow(remap = false)
    private InterfaceLogic logic;

    public MixinMEInterface(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState blockState) {
        super(blockEntityType, pos, blockState);
    }

    @Inject(method = "getCapability", at = @At("HEAD"), remap = false, cancellable = true)
    public <T> void getCapability(Capability<T> capability,
                                  @Nullable Direction facing, CallbackInfoReturnable<LazyOptional<T>> cir) {
        if ((!this.logic.getConfig().isEmpty())
//                || (!INSTANCE.getNullInterfaceIsProxy().get())
        ) {
            AE2Simplifier.INSTANCE.getLOGGER().info("Interface Checking Is Skipped Because " +
                    "There are Configs or Disabled");
            return;
        }

        if (getMainNode().getGrid() != null && (capability == ForgeCapabilities.ITEM_HANDLER ||
                capability == ForgeCapabilities.FLUID_HANDLER)) {
//            AE2Simplifier.INSTANCE.getLOGGER().info("Interface is proxying me network successfully");
            cir.setReturnValue(LazyOptional.of(() -> new MEProxyInventoryHandler
                    (((NetworkStorage) getMainNode().getGrid().getStorageService().getInventory()))).cast());
        }

        cir.setReturnValue(super.getCapability(capability, facing));
    }
}
