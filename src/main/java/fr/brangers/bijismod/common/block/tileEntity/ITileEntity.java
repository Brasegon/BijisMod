package fr.brangers.bijismod.common.block.tileEntity;

import javax.annotation.Nullable;

import fr.brangers.bijismod.common.block.BlockBase;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class ITileEntity<TE extends TileEntity> extends BlockBase {

	protected ITileEntity(Material materialIn, String name) {
		super(materialIn, name);
		// TODO Auto-generated constructor stub
	}
	public abstract Class<TE> getTileEntityClass();
	
	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE)world.getTileEntity(pos);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public abstract TE createTileEntity(World world, IBlockState state);

}
