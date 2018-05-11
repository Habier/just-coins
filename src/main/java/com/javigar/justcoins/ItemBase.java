package com.javigar.justcoins;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBase extends Item implements IModeledItem {

    public ItemBase(String name) {
        super();
        this.setUnlocalizedName(name);
        this.setRegistryName(JustCoins.MODID + ":" + name);
        this.setCreativeTab(CreativeTabs.MISC);
        ForgeRegistries.ITEMS.register(this);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity old, ItemStack stack) {
        CoinEntity myEntity = new CoinEntity(world, old.posX, old.posY, old.posZ, stack);
        myEntity.motionX = old.motionX;
        myEntity.motionY = old.motionY;
        myEntity.motionZ = old.motionZ;
        myEntity.setDefaultPickupDelay();
        return myEntity;
    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }

}
