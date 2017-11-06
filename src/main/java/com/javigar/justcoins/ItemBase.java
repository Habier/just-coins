package com.javigar.justcoins;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBase extends Item implements IModeledItem {

    public ItemBase(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(JustCoins.MODID + ":" + name);
        setCreativeTab(CreativeTabs.MISC);
        GameRegistry.register(this);
    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }

}
