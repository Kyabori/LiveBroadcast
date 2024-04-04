package org.kyabori.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kyabori.Main;
import org.kyabori.getMsg;

public class live implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("everlive.live")) {
                String playername = player.getName();
                String link = Main.getInstance().getConfig().getString("users." + playername + ".link");
                String piattaforma = Main.getInstance().getConfig().getString("users." + playername + ".piattaforma");
                if (link != null && piattaforma != null) {
                    String prefix = getMsg.getMsg("prefix");
                    Main.getInstance().getServer().broadcastMessage(prefix + "§6" + playername + " §7sta andando in live su §6" + piattaforma + "§7! Guardalo qui: §6" + link);
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "Non hai impostato alcun link! Impostalo con /setlink <link> <piattaforma>");
                    return false;
                }
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Non puoi eseguire questo comando da console!");
            return false;
        }
        return false;
    }
}