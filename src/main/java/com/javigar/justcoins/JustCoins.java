package com.javigar.justcoins;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = JustCoins.MODID, version = JustCoins.VERSION)
public class JustCoins {
    public static final String MODID = "justcoins";
    public static final String VERSION = "1.0.0";


    public static Item copperCoin;
    public static Item silverCoin;
    public static Item goldCoin;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        copperCoin = new ItemCoin("copper_coin");
        silverCoin = new ItemCoin("silver_coin");
        goldCoin = new ItemCoin("gold_coin");

        ((IModeledItem) copperCoin).initModel();
        ((IModeledItem) silverCoin).initModel();
        ((IModeledItem) goldCoin).initModel();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        GameRegistry.addShapelessRecipe(new ItemStack(silverCoin, 8),
                new ItemStack(goldCoin));
        GameRegistry.addShapelessRecipe(new ItemStack(copperCoin, 8),
                new ItemStack(silverCoin));


        GameRegistry.addShapelessRecipe(new ItemStack(goldCoin, 1),
                new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin));
        GameRegistry.addShapelessRecipe(new ItemStack(silverCoin, 1),
                new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin));

        /*
        //Code from the old times.
        GameRegistry.addRecipe(new ItemStack(goldCoin, 1),
                "TTT", "T T", "TTT", 'T', silverCoin);
        GameRegistry.addRecipe(new ItemStack(silverCoin, 1),
                "TTT", "T T", "TTT", 'T', copperCoin);
        */
    }


}
