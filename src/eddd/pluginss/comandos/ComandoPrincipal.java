package eddd.pluginss.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eddd.pluginss.PluginMy;

public class ComandoPrincipal implements CommandExecutor{
	private PluginMy plugin;
	
	public ComandoPrincipal(PluginMy plugin) {
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
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("help")) {
					jugador.sendMessage(ChatColor.GREEN+ "Este es la ayuda necesaria para este plugin llamado"+ ChatColor.AQUA +plugin.nombre);
					jugador.sendMessage("");
					jugador.sendMessage(ChatColor.GOLD+"--------------Comandos--------------");
					jugador.sendMessage(ChatColor.GOLD+"/tt spawn -> Te regresa al spawn");
					jugador.sendMessage(ChatColor.GOLD+"/tt info -> Ver la informacion del plugin");
					jugador.sendMessage(ChatColor.GOLD+"/tt reload -> Recargar la configuracion del plugin");
					jugador.sendMessage(ChatColor.GOLD+"--------------Comandos--------------");
					return true;
				}
				else if(args[0].equalsIgnoreCase("spawn")) {
					Location loc = new Location(jugador.getWorld(), 244, 85, 48, 178, 0); //(mundo, x, y, z, pitch) 244 85 48 178 / 0
					jugador.teleport(loc);
					return true;
				}
				else if(args[0].equalsIgnoreCase("info")) {
					jugador.sendMessage(ChatColor.GREEN+"--------------Informacion de "+plugin.nombre+"--------------");
					jugador.sendMessage(ChatColor.GOLD+"Nombre del plugin --> "+ plugin.nombre);
					jugador.sendMessage(ChatColor.GOLD+"Version de plugin --> "+ChatColor.GREEN+ plugin.version);
					jugador.sendMessage(ChatColor.GOLD+"Creado pór -->"+ChatColor.GREEN+" Edgar Monterde (Clasicon)");
					jugador.sendMessage(ChatColor.GREEN+"--------------Informacion de "+plugin.nombre+"--------------");
					return true;
				}
				else if(args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					jugador.sendMessage(ChatColor.GREEN +"¡La configuracion del plugin ha sido recargado exitosamente!");
					
					Bukkit.getConsoleSender().sendMessage("-----------------------"+plugin.nombre+"------------------------");
					Bukkit.getConsoleSender().sendMessage( ChatColor.RED + "[" + ChatColor.BOLD +"RECARGA] " + ChatColor.YELLOW +"Un jugador ha recargado el plugin exitosamente!");
					Bukkit.getConsoleSender().sendMessage("-----------------------"+plugin.nombre+"------------------------");
					return true;
				}
				else {
					jugador.sendMessage(ChatColor.RED+"Este comando no existe, por favor digite /tt help");
					return true;
				}
				
			}else {
				jugador.sendMessage(ChatColor.GOLD+"Usa /tt help para ver la ayuda");
				return true;
			}
		}
	}
}
