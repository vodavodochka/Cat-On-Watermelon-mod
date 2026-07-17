package vodavodochka.catonwatermelon.Block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import vodavodochka.catonwatermelon.tileentity.TileEntityCatOnWatermelon;

public class BlockCatOnWatermelon extends BlockEC {

    public BlockCatOnWatermelon() {
        super(Material.clay, 2.0F, 10.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityCatOnWatermelon();
    }

    @Override
    public int getRenderType() {
        return -1; // -1 Tells Minecraft to use a custom TileEntityRenderer
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack) {
        // Sets rotation based on player facing direction
        int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        int meta;
        if (l == 0) meta = 2;
        else if (l == 1) meta = 5;
        else if (l == 2) meta = 3;
        else meta = 4;

        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}