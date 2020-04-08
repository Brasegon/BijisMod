package fr.brangers.bijismod.common.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOre extends BlockBase {

	public BlockOre(Material material, String name) {
		super(material, name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setSoundType(SoundType.STONE);
	}
	
//	public Item getItemDropped(IBlockState state, Random rand, int fortune)
//    {
//        if (this == BijisBlock.COPPER)
//        {
//            return Items.COAL;
//        }
//        return null;
//    }
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this);
    }

}
