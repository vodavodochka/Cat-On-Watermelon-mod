package vodavodochka.catonwatermelon.render.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererWalrus extends TileEntitySpecialRenderer {

    IModelCustom modelWalrus = AdvancedModelLoader
            .loadModel(new ResourceLocation("catonwatermelon", "models/walrus.obj"));
    ResourceLocation textureWalrus = new ResourceLocation("catonwatermelon",
            "textures/blocks/walrus.png");

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y,
                                double z, float partialTickTime) {
        Minecraft.getMinecraft().renderEngine.bindTexture(this.textureWalrus);
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

        GL11.glTranslatef(-0.5F, 0.0F, -0.2F);

        this.modelWalrus.renderAll();
        GL11.glPopMatrix();
    }
}