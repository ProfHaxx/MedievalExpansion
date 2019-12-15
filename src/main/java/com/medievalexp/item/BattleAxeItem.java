package com.medievalexp.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;

public class BattleAxeItem extends ToolItem {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(
            Blocks.COBWEB, Blocks.OAK_LOG, Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG, Blocks.ACACIA_LOG, Blocks.SPRUCE_LOG, Blocks.DARK_OAK_LOG,
            Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_DARK_OAK_LOG,
            Blocks.STRIPPED_OAK_WOOD, Blocks.STRIPPED_BIRCH_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.STRIPPED_ACACIA_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD,
            Blocks.OAK_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.SPRUCE_DOOR, Blocks.DARK_OAK_DOOR,
            Blocks.OAK_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.ACACIA_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.DARK_OAK_BUTTON,
            Blocks.OAK_FENCE, Blocks.BIRCH_FENCE, Blocks.JUNGLE_FENCE, Blocks.ACACIA_FENCE, Blocks.SPRUCE_FENCE, Blocks.DARK_OAK_FENCE,
            Blocks.OAK_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE,
            Blocks.OAK_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.DARK_OAK_PLANKS,
            Blocks.OAK_PRESSURE_PLATE, Blocks.BIRCH_PRESSURE_PLATE, Blocks.JUNGLE_PRESSURE_PLATE, Blocks.ACACIA_PRESSURE_PLATE, Blocks.SPRUCE_PRESSURE_PLATE, Blocks.DARK_OAK_PRESSURE_PLATE,
            Blocks.OAK_SIGN, Blocks.BIRCH_SIGN, Blocks.JUNGLE_SIGN, Blocks.ACACIA_SIGN, Blocks.SPRUCE_SIGN, Blocks.DARK_OAK_SIGN,
            Blocks.OAK_SLAB, Blocks.BIRCH_SLAB, Blocks.JUNGLE_SLAB, Blocks.ACACIA_SLAB, Blocks.SPRUCE_SLAB, Blocks.DARK_OAK_SLAB,
            Blocks.OAK_STAIRS, Blocks.BIRCH_STAIRS, Blocks.JUNGLE_STAIRS, Blocks.ACACIA_STAIRS, Blocks.SPRUCE_STAIRS, Blocks.DARK_OAK_STAIRS,
            Blocks.OAK_TRAPDOOR, Blocks.BIRCH_TRAPDOOR, Blocks.JUNGLE_TRAPDOOR, Blocks.ACACIA_TRAPDOOR, Blocks.SPRUCE_TRAPDOOR, Blocks.DARK_OAK_STAIRS,
            Blocks.OAK_WALL_SIGN, Blocks.BIRCH_WALL_SIGN, Blocks.JUNGLE_WALL_SIGN, Blocks.ACACIA_WALL_SIGN, Blocks.SPRUCE_WALL_SIGN, Blocks.DARK_OAK_WALL_SIGN,
            Blocks.LADDER, Blocks.BAMBOO, Blocks.BAMBOO_SAPLING, Blocks.BARREL, Blocks.CHEST, Blocks.CRAFTING_TABLE, Blocks.CARTOGRAPHY_TABLE, Blocks.CAMPFIRE,
            Blocks.CHORUS_FLOWER, Blocks.CHORUS_PLANT, Blocks.JUKEBOX, Blocks.NOTE_BLOCK, Blocks.PUMPKIN, Blocks.TRAPPED_CHEST, Blocks.CARVED_PUMPKIN
    );

    private static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).build();

    public BattleAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(net.minecraftforge.common.ToolType.AXE, tier.getHarvestLevel()));
    }

    @SuppressWarnings("all")
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.TALL_PLANTS && material != Material.BAMBOO ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

    @SuppressWarnings("all")
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
        if (block != null) {
            PlayerEntity playerentity = context.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote) {
                world.setBlockState(blockpos, block.getDefaultState().with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
                if (playerentity != null) {
                    context.getItem().damageItem(1, playerentity, (p_220040_1_) -> p_220040_1_.sendBreakAnimation(context.getHand()));
                }
            }

            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.PASS;
        }
    }
}
