package com.ultramega.botanypotstiers.block;

import com.ultramega.botanypotstiers.Constants;
import com.ultramega.botanypotstiers.PotTiers;
import net.darkhax.bookshelf.api.Services;
import net.darkhax.bookshelf.api.registry.RegistryObject;
import net.darkhax.bookshelf.api.serialization.Serializers;
import net.darkhax.botanypots.BotanyPotHelper;
import net.darkhax.botanypots.block.BlockBotanyPot;
import net.darkhax.botanypots.data.recipes.fertilizer.Fertilizer;
import net.darkhax.botanypots.data.recipes.potinteraction.PotInteraction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;

public class TieredBlockBotanyPot extends BlockBotanyPot {
    private static final Properties DEFAULT_PROPERTIES = Block.Properties.of(Material.CLAY, MaterialColor.COLOR_ORANGE).strength(1.25F, 4.2F).noOcclusion().lightLevel(state -> state.getValue(BlockStateProperties.LEVEL));

    public final PotTiers tier;

    public TieredBlockBotanyPot(PotTiers tier, boolean hasInventory) {
        this(tier, DEFAULT_PROPERTIES, hasInventory);
    }

    public TieredBlockBotanyPot(PotTiers tier, Block.Properties properties, boolean hasInventory) {
        super(hasInventory);

        BlockState defaultState = this.getStateDefinition().any();
        defaultState = defaultState.setValue(BlockStateProperties.WATERLOGGED, false);
        defaultState = defaultState.setValue(BlockStateProperties.LEVEL, 0);
        defaultState = defaultState.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH);
        this.registerDefaultState(defaultState);

        this.tier = tier;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        return world.getBlockEntity(pos) instanceof TieredBlockEntityBotanyPot pot ? pot.getComparatorLevel() : 0;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TieredBlockEntityBotanyPot(tier, pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (world.getBlockEntity(pos) instanceof TieredBlockEntityBotanyPot potEntity) {
            final ItemStack heldStack = player.getItemInHand(hand);

            // Apply fertilizers, only if a valid crop is growing.
            if (potEntity.areGrowthConditionsMet() && potEntity.getGrowthTime() > 0 && !potEntity.getDoneGrowing()) {
                final Fertilizer fertilizer = BotanyPotHelper.findFertilizer(state, world, pos, player, hand, heldStack, potEntity);

                if (fertilizer != null) {
                    fertilizer.apply(state, world, pos, player, hand, heldStack, potEntity);
                    return InteractionResult.CONSUME;
                }
            }

            // Attempt right click interaction recipes.
            final PotInteraction interaction = BotanyPotHelper.findPotInteraction(state, world, pos, player, hand, heldStack, potEntity);
            if (interaction != null) {
                interaction.apply(state, world, pos, player, hand, heldStack, potEntity);
                return InteractionResult.CONSUME;
            }

            // Attempt harvesting the pot.
            else if (!player.isCrouching() && !potEntity.isHopper() && potEntity.getDoneGrowing() && potEntity.getCrop() != null) {
                if (!world.isClientSide) {
                    for (ItemStack drop : BotanyPotHelper.generateDrop(potEntity.rng, world, pos, potEntity, potEntity.getCrop())) {
                        drop.setCount(drop.getCount() * tier.getMultiplier());
                        popResource(world, pos, drop);
                    }

                    potEntity.resetGrowth();
                }

                return InteractionResult.CONSUME;
            }

            // Open the pot GUI
            else if (player instanceof ServerPlayer serverPlayer) {
                Services.INVENTORY_HELPER.openMenu(serverPlayer, potEntity, buf -> Serializers.BLOCK_POS.toByteBuf(buf, pos));
                return InteractionResult.CONSUME;
            }

            return InteractionResult.SUCCESS;
        }

        return super.use(state, world, pos, player, hand, hitResult);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level worldLevel, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, (BlockEntityType) RegistryObject.deferred(Registry.BLOCK_ENTITY_TYPE, Constants.MOD_ID, tier.getName() + "_botany_pot").cast().get(), (level, pos, state1, pot) -> TieredBlockEntityBotanyPot.tickPot(level, pos, state1, (TieredBlockEntityBotanyPot) pot));
    }
}