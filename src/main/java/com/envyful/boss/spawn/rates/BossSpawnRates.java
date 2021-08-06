package com.envyful.boss.spawn.rates;

import com.envyful.api.config.yaml.YamlConfigFactory;
import com.envyful.api.forge.command.ForgeCommandFactory;
import com.envyful.boss.spawn.rates.command.BossSpawnRatesReloadCommand;
import com.envyful.boss.spawn.rates.config.BossSpawnRatesConfig;
import com.envyful.boss.spawn.rates.listener.BossSpawnListener;
import com.google.common.collect.Maps;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.enums.EnumBossMode;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.IOException;
import java.util.Map;

@Mod(
        modid = "bossspawnrates",
        name = "BossSpawnRates Forge",
        version = "0.0.1",
        acceptableRemoteVersions = "*"
)
public class BossSpawnRates {

    private Map<EnumBossMode, Double> bossChances = Maps.newHashMap();

    @Mod.EventHandler
    public void onServerStarting(FMLPreInitializationEvent event) {
        this.loadConfig();
        Pixelmon.EVENT_BUS.register(new BossSpawnListener(this));
    }

    public void loadConfig() {
        try {
            BossSpawnRatesConfig instance = YamlConfigFactory.getInstance(BossSpawnRatesConfig.class);

            bossChances.clear();
            bossChances.put(EnumBossMode.Common, instance.getCommonSpawnChance());
            bossChances.put(EnumBossMode.Uncommon, instance.getUnCommonSpawnChance());
            bossChances.put(EnumBossMode.Rare, instance.getRareSpawnChance());
            bossChances.put(EnumBossMode.Epic, instance.getEpicSpawnChance());
            bossChances.put(EnumBossMode.Legendary, instance.getLegendarySpawnChance());
            bossChances.put(EnumBossMode.Ultimate, instance.getUltimateSpawnChance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        new ForgeCommandFactory().registerCommand(event.getServer(), new BossSpawnRatesReloadCommand(this));
    }

    public double getSpawnChance(EnumBossMode bossMode) {
        return this.bossChances.getOrDefault(bossMode, 1.0);
    }
}
