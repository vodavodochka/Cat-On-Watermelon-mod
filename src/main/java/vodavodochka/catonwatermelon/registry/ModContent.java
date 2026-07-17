package vodavodochka.catonwatermelon.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import vodavodochka.catonwatermelon.Block.BlockEC;
import vodavodochka.catonwatermelon.Block.BlockWalrus;
import vodavodochka.catonwatermelon.items.FlowerSandwich;
import vodavodochka.catonwatermelon.lib.ModVars;
import vodavodochka.catonwatermelon.tileentity.TileEntityWalrus;

public final class ModContent {
    public static FlowerSandwich flowerSandwich;
    public static Achievement eatFlowerSandwichAchievement;
    public static BlockWalrus blockWalrus;

    private ModContent() {
    }

    public static void register() {
        registerBlocks();
        registerItems();
        registerAchievements();
    }

    public static void registerItems() {
        flowerSandwich = new FlowerSandwich(4, 0.6F, false);
        flowerSandwich.setUnlocalizedName("flower_sandwich")
                .setTextureName(ModVars.Mod_ID + ":flower_sandwich")
                .setCreativeTab(CreativeTabs.tabFood);

        GameRegistry.registerItem(flowerSandwich, "flower_sandwich");
    }

    public static void registerBlocks() {
        blockWalrus = new BlockWalrus();

        // Change setUnlocalizedName to setBlockName
        blockWalrus.setBlockName("walrus");
        blockWalrus.setCreativeTab(CreativeTabs.tabFood);

        GameRegistry.registerBlock(blockWalrus, "walrus");
        GameRegistry.registerTileEntity(TileEntityWalrus.class, "tileEntityWalrus");
    }

    public static void registerAchievements() {
        eatFlowerSandwichAchievement = new Achievement(
                "achievement.eatFlowerSandwich",
                "eatFlowerSandwich",
                0,
                0,
                flowerSandwich,
                AchievementList.openInventory
        );
        eatFlowerSandwichAchievement.registerStat();

        AchievementPage.registerAchievementPage(
                new AchievementPage("Cat On Watermelon", new Achievement[] { eatFlowerSandwichAchievement })
        );
        flowerSandwich.setAchievement(eatFlowerSandwichAchievement);
    }
}
