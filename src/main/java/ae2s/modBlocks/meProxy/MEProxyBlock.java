package ae2s.modBlocks.meProxy;

import appeng.block.AEBaseEntityBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;


public class MEProxyBlock extends AEBaseEntityBlock<MEProxyBlockEntity> {
    public MEProxyBlock(Properties props) {
        super(props);
    }

    @NotNull
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new MEProxyBlockEntity(this.getBlockEntityType(), blockPos, blockState);
    }
}
