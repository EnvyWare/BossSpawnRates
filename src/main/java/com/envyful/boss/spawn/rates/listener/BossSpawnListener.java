package com.envyful.boss.spawn.rates.listener;

import com.envyful.api.math.UtilRandom;
import com.envyful.boss.spawn.rates.BossSpawnRates;
import com.pixelmonmod.pixelmon.api.events.spawning.PixelmonSpawnerEvent;
import com.pixelmonmod.pixelmon.api.events.spawning.SpawnEvent;
import com.pixelmonmod.pixelmon.api.spawning.archetypes.entities.pokemon.SpawnActionPokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumBossMode;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BossSpawnListener {

    private final BossSpawnRates mod;

    public BossSpawnListener(BossSpawnRates mod) {
        this.mod = mod;
    }

    @SubscribeEvent
    public void onBossSpawn(PixelmonSpawnerEvent event) {
        if (event.spec.boss == null) {
            return;
        }

        EnumBossMode bossMode = EnumBossMode.getMode(event.spec.boss);

        if (bossMode == null || Objects.equals(bossMode, EnumBossMode.NotBoss)) {
            return;
        }

        double chance = ThreadLocalRandom.current().nextDouble();

        if (chance > this.mod.getSpawnChance(bossMode)) {
            event.setCanceled(true);
        }
    }
}
