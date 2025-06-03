package com.alex.guzhenren;

import com.alex.guzhenren.block.ModBlocks;
import com.alex.guzhenren.effect.ModEffects;
import com.alex.guzhenren.effect.ModEvents;
import com.alex.guzhenren.item.ModItemGroups;
import com.alex.guzhenren.item.ModItems;
import com.alex.guzhenren.network.ModNetworking;
import com.alex.guzhenren.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Guzhenren implements ModInitializer {
	public static final String MOD_ID = "guzhenren";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerItems();
		ModItemGroups.registerGroups();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();

		ModEvents.registerAttackEvent();

		ModWorldGeneration.generationModWorldGen();

		ModNetworking.init();
	}
}