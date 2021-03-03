package eddd.pluginss.eventos;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import eddd.pluginss.PluginMy;

public class StartJoin implements Listener {
	
private PluginMy plugin;
	
	public StartJoin(PluginMy plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void JoinGame(PlayerJoinEvent event) {
		Player jugador = event.getPlayer();
		Location loc = new Location(jugador.getWorld(), 244, 85, 48, 178, 0); //(mundo, x, y, z, pitch) 244 85 48 178 / 0
		jugador.teleport(loc);
		
		
		FileConfiguration config = plugin.getConfig();
		String patch = "Config.mensaje-bienvenida";
		if(config.getString(patch).equals("true")) {
			String texto = "Config.mensaje bienvenida-texto";
			jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(texto)).replaceAll("%player%", jugador.getName()));
		}
		return;
	}
}
