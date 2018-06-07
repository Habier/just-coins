package com.javigar.justcoins;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@Mod(modid = JustCoins.MODID, version = JustCoins.VERSION)
public class JustCoins {
    public static final String MODID = "justcoins";
    public static final String VERSION = "1.2.1";


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

        if (event.getSide() == Side.CLIENT)
            modelInits();

    }

    @SideOnly(Side.CLIENT)
    private void modelInits() {
        ((IModeledItem) copperCoin).initModel();
        ((IModeledItem) silverCoin).initModel();
        ((IModeledItem) goldCoin).initModel();
        ((IModeledItem) coinSack).initModel();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CoinCommand());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // registerEntity(CoinEntity.class, "indestructible_coin");
    }
/*
    private void registerEntity(Class<? extends Entity> entity, String name) {
        EntityRegistry.registerModEntity(new ResourceLocation(MODID, name), entity, name,
                0, this, 128, 3, true);
    }
*/
}
