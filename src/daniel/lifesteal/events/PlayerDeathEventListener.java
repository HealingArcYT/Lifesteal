package daniel.lifesteal.events;

import daniel.lifesteal.Lifesteal;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class PlayerDeathEventListener implements Listener {
    private final Lifesteal plugin;

    public PlayerDeathEventListener(Lifesteal lifesteal) {
        plugin = lifesteal;
    }

    @EventHandler
    public void onPlayerDeath(EntityDamageByEntityEvent event) {
        /*if (Objects.requireNonNull(event.getEntity().getLastDamageCause()).getEntity() instanceof Player) {
            // set new heartamount
            Player killer = (Player) event.getEntity().getLastDamageCause().getEntity();
            Player killed = event.getEntity();

            // Values berechnen
            Integer killerHealth = this.plugin.getConfiguration().getInt(String.valueOf(killer.getUniqueId())) + 1;
            Integer killedHealth = this.plugin.getConfiguration().getInt(String.valueOf(killed.getUniqueId())) - 1;

            this.plugin.getLogger().info("KillerHealth: " + killerHealth);
            this.plugin.getLogger().info("KilledHealth: " + killedHealth);

            // Config bearbeiten
            this.plugin.getConfiguration().set(String.valueOf(killer.getUniqueId()), killerHealth);
            this.plugin.getConfiguration().set(String.valueOf(killed.getUniqueId()), killedHealth);
            this.plugin.saveConfig();

            // Health setzen
            this.plugin.setPlayerHearts(killer, this.plugin.getConfiguration().getInt(String.valueOf(killer.getUniqueId())));
            this.plugin.setPlayerHearts(killed, this.plugin.getConfiguration().getInt(String.valueOf(killed.getUniqueId())));
        }*/
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player killer = (Player) event.getDamager();
            Player killed = (Player) event.getEntity();

            // Values berechnen
            Integer killerHealth = this.plugin.getConfiguration().getInt(String.valueOf(killer.getUniqueId())) + 1;
            Integer killedHealth = this.plugin.getConfiguration().getInt(String.valueOf(killed.getUniqueId())) - 1;

            this.plugin.getLogger().info("KillerHealth: " + killerHealth);
            this.plugin.getLogger().info("KilledHealth: " + killedHealth);

            // Config bearbeiten
            this.plugin.getConfiguration().set(String.valueOf(killer.getUniqueId()), killerHealth);
            this.plugin.getConfiguration().set(String.valueOf(killed.getUniqueId()), killedHealth);
            this.plugin.saveConfig();

            // Health setzen
            this.plugin.setPlayerHearts(killer, this.plugin.getConfiguration().getInt(String.valueOf(killer.getUniqueId())));
            this.plugin.setPlayerHearts(killed, this.plugin.getConfiguration().getInt(String.valueOf(killed.getUniqueId())));
        }
    }
}
