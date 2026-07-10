package vodavodochka.catonwatermelon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import vodavodochka.catonwatermelon.lib.ModVars;
import vodavodochka.catonwatermelon.proxy.CommonProxy;

@Mod(modid = ModVars.Mod_ID, name=ModVars.Mod_Name, version = ModVars.Mod_Version)
public class Main {

    @Instance
    public static Main instance = new Main();

    @SidedProxy(clientSide = "vodavodochka.catonwatermelon.proxy.ClientProxy", serverSide = "vodavodochka.catonwatermelon.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
