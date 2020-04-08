package fr.brangers.bijismod.common.block;

import fr.brangers.bijismod.BijisMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {

	private String name;

	public BlockBase(Material material, String name) {
		super(Material.GRASS);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		// TODO Auto-generated constructor stub
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}
