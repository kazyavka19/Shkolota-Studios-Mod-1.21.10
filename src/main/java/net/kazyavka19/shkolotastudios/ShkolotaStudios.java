package net.kazyavka19.shkolotastudios;

import net.fabricmc.api.ModInitializer;

import net.kazyavka19.shkolotastudios.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShkolotaStudios implements ModInitializer {
	public static final String MOD_ID = "shkolotastudios";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}