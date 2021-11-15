package daniel.lifesteal;

import daniel.lifesteal.events.PlayerDeathEventListener;
import daniel.lifesteal.events.PlayerJoinEventListener;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Lifesteal extends JavaPlugin {
    private FileConfiguration configuration;

    @Override
    public void onEnable() {
        // init config
        configuration = this.getConfig();
        configuration.options().copyDefaults(true);

        this.saveConfig();

        // init PlayerDeathListener
        getServer().getPluginManager().registerEvents(new PlayerDeathEventListener(this), this);

        // init PlayerJoinListener
        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(this), this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player player : getServer().getOnlinePlayers()) {
                    setPlayerHearts(player, configuration.getInt(String.valueOf(player.getUniqueId())));
                }
            }
        }, 0L, 20L);
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }

    public void setPlayerHearts(Player player, Integer hearts) {
        // sets the max health

        this.getServer().broadcast("PlayerHeart neu", "whatever");
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((double) hearts * 2);

        //getLogger().info("Player " + player.getName() + " hat nun " + player.getMaxHealth() + "Herzen");
    }
}
