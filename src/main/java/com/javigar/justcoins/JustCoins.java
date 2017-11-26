package com.javigar.justcoins;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = JustCoins.MODID, version = JustCoins.VERSION)
public class JustCoins {
    public static final String MODID = "justcoins";
    public static final String VERSION = "1.1.2";


    public static Item copperCoin;
    public static Item silverCoin;
    public static Item goldCoin;
    public static Item coinSack;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        copperCoin = new ItemBase("copper_coin");
        silverCoin = new ItemBase("silver_coin");
        goldCoin = new ItemBase("gold_coin");
        coinSack = new ItemBase("coin_sack");

        ((IModeledItem) copperCoin).initModel();
        ((IModeledItem) silverCoin).initModel();
        ((IModeledItem) goldCoin).initModel();
        ((IModeledItem) coinSack).initModel();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        GameRegistry.addShapelessRecipe(new ItemStack(goldCoin, 9),
                new ItemStack(coinSack));
        GameRegistry.addShapelessRecipe(new ItemStack(silverCoin, 8),
                new ItemStack(goldCoin));
        GameRegistry.addShapelessRecipe(new ItemStack(copperCoin, 8),
                new ItemStack(silverCoin));


        GameRegistry.addShapelessRecipe(new ItemStack(goldCoin, 1),
                new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin), new ItemStack(silverCoin));
        GameRegistry.addShapelessRecipe(new ItemStack(silverCoin, 1),
                new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin), new ItemStack(copperCoin));

        GameRegistry.addRecipe(new ItemStack(coinSack, 1),
                "TTT", "TTT", "TTT", 'T', goldCoin);

    }


}
