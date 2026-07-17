package vodavodochka.catonwatermelon.Block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import vodavodochka.catonwatermelon.tileentity.TileEntityWalrus;
import java.util.List;

public class BlockWalrus extends BlockEC {

    public BlockWalrus() {
        super(Material.clay, 2.0F, 10.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityWalrus();
    }

    @Override
    public boolean hasTileEntity(int meta) {
        return (meta & 8) == 0;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
                                EntityLivingBase player, ItemStack itemstack) {
        int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        int meta;
        if (l == 0) meta = 2;
        else if (l == 1) meta = 5;
        else if (l == 2) meta = 3;
        else meta = 4;

        world.setBlockMetadataWithNotify(x, y, z, meta, 2);

        int x2 = x, z2 = z;
        switch (meta) {
            case 2: z2 = z - 1; break;
            case 3: z2 = z + 1; break;
            case 4: x2 = x - 1; break;
            case 5: x2 = x + 1; break;
        }

        if (world.isAirBlock(x2, y, z2)) {
            world.setBlock(x2, y, z2, this, meta | 8, 2);
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, net.minecraft.block.Block block, int meta) {
        boolean isSecondPart = (meta & 8) != 0;
        int baseMeta = meta & 7;

        int ox = x, oz = z;
        switch (baseMeta) {
            case 2: oz = isSecondPart ? z + 1 : z - 1; break;
            case 3: oz = isSecondPart ? z - 1 : z + 1; break;
            case 4: ox = isSecondPart ? x + 1 : x - 1; break;
            case 5: ox = isSecondPart ? x - 1 : x + 1; break;
        }

        if (world.getBlock(ox, y, oz) == this) {
            world.setBlockToAir(ox, y, oz);
        }

        if ((meta & 8) == 0) {
            super.breakBlock(world, x, y, z, block, meta);
        }
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}