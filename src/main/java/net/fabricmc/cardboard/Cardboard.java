package net.fabricmc.cardboard;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Cardboard implements ModInitializer {
	public static final Material REPLACEABLE_BLOCK;
	static {
		REPLACEABLE_BLOCK = (new Material.Builder(MapColor.BROWN)).allowsMovement().replaceable().burnable().build();
	}
	public static final Block CARDBOARD_BLOCK = new Block(FabricBlockSettings.of(REPLACEABLE_BLOCK).breakInstantly().sounds(BlockSoundGroup.SCAFFOLDING));
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("cardboard", "cardboard"), CARDBOARD_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("cardboard", "cardboard"), new BlockItem(CARDBOARD_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		LOGGER.info("Hello Fabric world!");
	}
}
