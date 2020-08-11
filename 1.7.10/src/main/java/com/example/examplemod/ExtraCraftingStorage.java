package com.example.examplemod;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = ExtraCraftingStorage.MODID, version = ExtraCraftingStorage.VERSION,dependencies="required-after:extracells;required-after:appliedenergistics2")
public class ExtraCraftingStorage
{
    public static final String MODID = "ExtraCraftingStorage";
    public static final String VERSION = "1.0";

    public static Block blockCraftingStorage;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        GameRegistry.registerBlock(blockCraftingStorage = new BlockExCraftingStorage(), ItemBlockExCraftingStorage.class, "blockExCraftingStorage");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Item itemECstorageCell = GameRegistry.findItem("extracells", "storage.component");
        Block blockAECU = GameRegistry.findBlock("appliedenergistics2", "tile.BlockCraftingUnit");

        for(int i=0;!(i==4);i++)
            GameRegistry.addShapelessRecipe(new ItemStack(blockCraftingStorage, 1, i), new ItemStack(blockAECU,1,0),new ItemStack(itemECstorageCell,1,i));
    }
}
