package vodavodochka.catonwatermelon.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ItemRendererCatOnWatermelon implements IItemRenderer {

    IModelCustom modelCat = AdvancedModelLoader
            .loadModel(new ResourceLocation("catonwatermelon", "models/cat_on_watermelon.obj"));
    ResourceLocation textureCat = new ResourceLocation("catonwatermelon",
            "textures/blocks/cat_on_watermelon.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        // Return true for in-hand and dropped items.
        // Return false for INVENTORY, so it falls back to a standard 2D item sprite.
        return type == ItemRenderType.EQUIPPED
                || type == ItemRenderType.EQUIPPED_FIRST_PERSON
                || type == ItemRenderType.ENTITY;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        Minecraft.getMinecraft().renderEngine.bindTexture(this.textureCat);
        GL11.glPushMatrix();
        switch (type) {
            case EQUIPPED_FIRST_PERSON:
                GL11.glRotated(180, 0, 1, 0);
                GL11.glTranslatef(-1F, 0.5F, -0.5F);
                break;
            case INVENTORY:
                GL11.glTranslatef(-0.5F, -0.5F, -0.1F);
                break;
            default:
                break;
        }
        this.modelCat.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
                                         ItemRendererHelper helper) {
        return true;
    }
}