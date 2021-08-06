package com.envyful.boss.spawn.rates.config;

import com.envyful.api.config.data.ConfigPath;
import com.envyful.api.config.yaml.AbstractYamlConfig;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

@ConfigPath("config/BossSpawnRates/config.yml")
@ConfigSerializable
public class BossSpawnRatesConfig extends AbstractYamlConfig {

    private double commonSpawnChance = 1.0;
    private double unCommonSpawnChance = 1.0;
    private double rareSpawnChance = 1.0;
    private double epicSpawnChance = 1.0;
    private double legendarySpawnChance = 1.0;
    private double ultimateSpawnChance = 1.0;

    public double getCommonSpawnChance() {
        return this.commonSpawnChance;
    }

    public double getUnCommonSpawnChance() {
        return this.unCommonSpawnChance;
    }

    public double getRareSpawnChance() {
        return this.rareSpawnChance;
    }

    public double getLegendarySpawnChance() {
        return this.legendarySpawnChance;
    }

    public double getUltimateSpawnChance() {
        return this.ultimateSpawnChance;
    }

    public double getEpicSpawnChance() {
        return this.epicSpawnChance;
    }
}
