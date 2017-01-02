package net.xornick.minetnt;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class MineTNT extends JavaPlugin {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (command.getName().equalsIgnoreCase("quicktnt")) {
            Player player = (Player) sender;
            if (!player.hasPermission("quicktnt.use")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }
            PlayerInventory inventory = player.getInventory();
            ItemStack sulphur = new ItemStack(Material.SULPHUR, 5);
            ItemStack sand = new ItemStack(Material.SAND, 4);
            ItemStack tnt = new ItemStack(Material.TNT, 1);

            if (inventory.containsAtLeast(sulphur, 5) && inventory.containsAtLeast(sand, 4)) {
                inventory.removeItem(new ItemStack(sulphur));
                inventory.removeItem(new ItemStack(sand));
                inventory.addItem(new ItemStack(tnt));
                player.sendMessage(ChatColor.GREEN + "You have successfully crafted TNT!");
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "You do not have enough ingredients to craft TNT.");
            }
        }
        return false;
    }
}
