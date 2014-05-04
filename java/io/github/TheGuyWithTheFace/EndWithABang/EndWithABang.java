package io.github.TheGuyWithTheFace.EndWithABang;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EndWithABang extends JavaPlugin{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player target = sender.getServer().getPlayer(sender.getName());
			
			//sets health to minimum to guarantee Player killed by explosion.
			// (setting it to 0 after the explosion triggers two death messages,
			// which is annoying.
			target.setHealth(.5);
			target.getWorld().createExplosion(target.getLocation(), 8F, true); //standard TNT explosion is 4F power
			
			return true;
		} else {
			sender.sendMessage("You must be a player to use this command!");
			return true;
		}
	} 
}
