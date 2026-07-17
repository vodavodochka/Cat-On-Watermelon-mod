package vodavodochka.catonwatermelon.render.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererCatOnWatermelon extends TileEntitySpecialRenderer {

    IModelCustom modelCat = AdvancedModelLoader
            .loadModel(new ResourceLocation("catonwatermelon", "models/cat_on_watermelon.obj"));
    ResourceLocation textureCat = new ResourceLocation("catonwatermelon",
            "textures/blocks/cat_on_watermelon.png");

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y,
                                   double z, float partialTickTime) {
        Minecraft.getMinecraft().renderEngine.bindTexture(this.textureCat);

        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glTranslatef(0.5F, 0.0F, 0.5F);

        int orientation = tileentity.getBlockMetadata();
        if (orientation == 4) {
            GL11.glRotatef(90, 0, 1, 0);
        } else if (orientation == 5) {
            GL11.glRotatef(-90, 0, 1, 0);
        } else if (orientation == 3) {
            GL11.glRotatef(180, 0, 1, 0);
        }

        GL11.glTranslatef(0.0F, 0.3F, 0.0F);

        // --- FIXES FOR AI-GENERATED MODELS ---
        // 1. Turn off lighting to stop Shaders/Albedo from breaking the texture
        GL11.glDisable(GL11.GL_LIGHTING);

        // 2. Turn off culling to patch any invisible holes in the mesh
        GL11.glDisable(GL11.GL_CULL_FACE);

        // Render the model
        this.modelCat.renderAll();

        // --- RESTORE RENDER STATE ---
        // Turn everything back on so the rest of the world renders normally
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);

        GL11.glPopMatrix();
    }
}