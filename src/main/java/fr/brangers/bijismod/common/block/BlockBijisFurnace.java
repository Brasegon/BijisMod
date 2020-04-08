package fr.brangers.bijismod.common.block;

import javax.annotation.Nullable;

import fr.brangers.bijismod.common.block.tileEntity.ITileEntity;
import fr.brangers.bijismod.common.block.tileEntity.TileEntityBijisFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockBijisFurnace extends ITileEntity<TileEntityBijisFurnace>{

	protected BlockBijisFurnace(Material materialIn, String name) {
		super(materialIn, name);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntityBijisFurnace tile = getTileEntity(world, pos);
			if (side == EnumFacing.DOWN) {
				tile.decrementCount();
			} else if (side == EnumFacing.UP) {
				tile.incrementCount();
			}
			player.sendMessage(new TextComponentString("Count: " + tile.getCount()));
		}
		return true;
	}
	
	@Override
	public Class<TileEntityBijisFurnace> getTileEntityClass() {
		return TileEntityBijisFurnace.class;
	}
	
	@Nullable
	@Override
	public TileEntityBijisFurnace createTileEntity(World world, IBlockState state) {
		return new TileEntityBijisFurnace();
	}
}
