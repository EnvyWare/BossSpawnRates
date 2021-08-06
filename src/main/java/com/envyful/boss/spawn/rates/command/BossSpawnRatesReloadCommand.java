package com.envyful.boss.spawn.rates.command;

import com.envyful.api.command.annotate.Command;
import com.envyful.api.command.annotate.Permissible;
import com.envyful.api.command.annotate.executor.CommandProcessor;
import com.envyful.api.command.annotate.executor.Sender;
import com.envyful.boss.spawn.rates.BossSpawnRates;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;

@Command(
        value = "bossspawnrates",
        description = "Reloads the config",
        aliases = {
                "bsreload"
        }
)
@Permissible("boss.spawn.rates.reload")
public class BossSpawnRatesReloadCommand {

   private final BossSpawnRates mod;

    public BossSpawnRatesReloadCommand(BossSpawnRates mod) {
        this.mod = mod;
    }

    @CommandProcessor
    public void reload(@Sender ICommandSender sender, String[] args) {
        this.mod.loadConfig();
        sender.sendMessage(new TextComponentString("§eReloaded spawn rates config"));
    }
}
