package jp.mydns.dyukusi.myplugin;

import jp.mydns.dyukusi.craftlevel.CraftLevel;
import jp.mydns.dyukusi.myplugin.listener.PlayerEffect;
import jp.mydns.dyukusi.myplugin.mycommand.MyCommand;
import jp.mydns.dyukusi.myplugin.mycommand.SaySomething;
import me.teej107.customachievement.CAPluginAPI;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {
	CraftLevel craftlevel;

	@Override
	public void onEnable() {

		if ((this.craftlevel = (CraftLevel) this.getServer().getPluginManager()
				.getPlugin("CraftLevel")) == null) {

		}
		
		this.getCommand("s").setExecutor(new SaySomething(this));

		getLogger().info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@MYPLUGIN");

		this.getServer().getPluginManager()
				.registerEvents(new PlayerEffect(this,craftlevel), this);
		// register command
		this.getCommand("mp").setExecutor(new MyCommand(this));
	}

	@Override
	public void onDisable() {

	}
	

}
