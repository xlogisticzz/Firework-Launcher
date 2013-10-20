package com.xlogisticzz.fireworkLauncher.client;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.xlogisticzz.fireworkLauncher.entities.EntityRocket;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRocket extends Render {
    
    // TODO replace "example" with wherever you store it, it works the same as the naming for item and block icons
    private static final ResourceLocation[] textures = new ResourceLocation[] { new ResourceLocation("fireworkLauncher", "textures/models/rocket1.png"), new ResourceLocation("fireworkLauncher", "textures/models/rocket23.png"), new ResourceLocation("fireworkLauncher", "textures/models/rocket3.png") };
    
    protected ModelRocket model;
    
    public RenderRocket() {
    
        this.shadowSize = 0.5F;
        this.model = new ModelRocket();
    }
    
    public void renderRocket(EntityRocket rocket, double x, double y, double z, float yaw, float partialTickTime) {
    
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        
        this.getEntityTexture(rocket);
        
        this.model.render(rocket, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        GL11.glPopMatrix();
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.client.renderer.entity.Render#doRender(net.minecraft.entity.Entity, double, double, double, float, float)
     */
    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
    
        this.renderRocket((EntityRocket) entity, x, y, z, yaw, partialTickTime);
    }
    
    // TODO return the correct id depending on the firework type
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.client.renderer.entity.Render#getEntityTexture(net.minecraft.entity.Entity)
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
    
        return textures[0];
    }
}
