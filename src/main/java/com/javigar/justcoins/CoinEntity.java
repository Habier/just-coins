package com.javigar.justcoins;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class CoinEntity extends EntityItem {

    public CoinEntity(World worldIn, double x, double y, double z, ItemStack stack) {
        super(worldIn, x, y, z, stack);
        isImmuneToFire = true;
    }

    public CoinEntity(World world) {
        super(world);
        isImmuneToFire = true;
    }

    @Override
    public boolean attackEntityFrom(@Nonnull DamageSource source, float amount) {
         if(source.getDamageType().equals(DamageSource.OUT_OF_WORLD.damageType)) {
            return true;
        }
        return false;
    }

}
