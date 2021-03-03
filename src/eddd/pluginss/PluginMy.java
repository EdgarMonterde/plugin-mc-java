package eddd.pluginss;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import eddd.pluginss.comandos.ComandoMsg;
import eddd.pluginss.comandos.ComandoPrincipal;
import eddd.pluginss.eventos.StartJoin;

public class PluginMy extends JavaPlugin {
	public String rutaConfig;
	
	PluginDescriptionFile ffile = getDescription();
	public String version = ffile.getVersion();
	public String nombre = ChatColor.YELLOW + "[" + ChatColor.WHITE + ffile.getName() + ChatColor.YELLOW + "]"; //[PluginMy]
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC +"--------------------------------------------------------------");
		Bukkit.getConsoleSender().sendMessage("Creador:"+ ChatColor.DARK_BLUE +" Edgar");
		Bukkit.getConsoleSender().sendMessage(nombre + " Se ha"+ ChatColor.GREEN + " activado"+ ChatColor.YELLOW +", version("+version+")");
		Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC +"--------------------------------------------------------------");
		
		registerCommands();
		registerEvents();
		registerConfig();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC +"--------------------------------------------------------------");
		Bukkit.getConsoleSender().sendMessage("Creador:"+ ChatColor.DARK_BLUE +" Edgar");
		Bukkit.getConsoleSender().sendMessage(nombre + " Se ha " + ChatColor.RED + "desactivado" + ChatColor.YELLOW + ", version("+version+")");
		Bukkit.getConsoleSender().sendMessage(ChatColor.MAGIC +"--------------------------------------------------------------");
	}
	
	public void registerCommands() {
		this.getCommand("clasicon").setExecutor(new ComandoMsg(this));
		this.getCommand("tt").setExecutor(new ComandoPrincipal(this));
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new StartJoin(this), this);
	}
	
	public void registerConfig() {
		File config = new File(this.getDataFolder(),"config.yml");
		rutaConfig = config.getPath();
		if(!config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}
}
