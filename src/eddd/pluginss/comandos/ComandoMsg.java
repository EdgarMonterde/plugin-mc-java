package eddd.pluginss.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import eddd.pluginss.PluginMy;

public class ComandoMsg implements CommandExecutor{
	
	private PluginMy plugin;
	
	public ComandoMsg(PluginMy plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("-----------------------"+plugin.nombre+"------------------------");
			Bukkit.getConsoleSender().sendMessage( ChatColor.RED + "[" + ChatColor.BOLD +"ADVERTENCIA] " + ChatColor.YELLOW +"No puedes ejecutar este comando mediante la consola");
			Bukkit.getConsoleSender().sendMessage("-----------------------"+plugin.nombre+"------------------------");
			return false;
		}else {
			Player jugador = (Player) sender;
			jugador.sendMessage(ChatColor.GREEN + "Este es una prueba de este lindo plugin");
			
			return true;
		}
	}

}
