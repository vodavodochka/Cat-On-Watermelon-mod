package vodavodochka.catonwatermelon.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import vodavodochka.catonwatermelon.registry.ModContent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        ModContent.register();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }
}
