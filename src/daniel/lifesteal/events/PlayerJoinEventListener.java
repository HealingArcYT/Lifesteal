package daniel.lifesteal.events;

import daniel.lifesteal.Lifesteal;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventListener implements Listener {
    private final Lifesteal plugin;

    public PlayerJoinEventListener(Lifesteal lifesteal) {
        this.plugin = lifesteal;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!this.plugin.getConfiguration().contains(String.valueOf(event.getPlayer().getUniqueId()))) {
            this.plugin.getConfiguration().set(String.valueOf(event.getPlayer().getUniqueId()), 10);
        }

        // Health setzen nach join
        this.plugin.setPlayerHearts(event.getPlayer(), this.plugin.getConfiguration().getInt(String.valueOf(event.getPlayer().getUniqueId())));
    }
}
