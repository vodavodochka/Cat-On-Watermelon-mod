package vodavodochka.catonwatermelon.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import vodavodochka.catonwatermelon.registry.ModContent;
import vodavodochka.catonwatermelon.render.item.ItemRendererWalrus;
import vodavodochka.catonwatermelon.render.tileentity.TileEntityRendererWalrus;
import vodavodochka.catonwatermelon.tileentity.TileEntityWalrus;

public class ClientProxy extends CommonProxy{

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    public void init(FMLInitializationEvent e) {
        super.init(e);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWalrus.class, new TileEntityRendererWalrus());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModContent.blockWalrus), new ItemRendererWalrus());
    }

    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
