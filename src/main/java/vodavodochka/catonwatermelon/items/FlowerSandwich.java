package vodavodochka.catonwatermelon.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;

public class FlowerSandwich extends ItemFood {
    private Achievement eatFlowerSandwichAchievement;

    public FlowerSandwich(int healAmount, float saturation, boolean isWolfFood) {
        super(healAmount, saturation, isWolfFood);
        this.setMaxStackSize(64);
    }

    public FlowerSandwich setAchievement(Achievement achievement) {
        this.eatFlowerSandwichAchievement = achievement;
        return this;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);

        if (this.eatFlowerSandwichAchievement != null && !world.isRemote) {
            player.addStat(this.eatFlowerSandwichAchievement, 1);
        }
    }
}
