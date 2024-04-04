package org.kyabori.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kyabori.getMsg;

public class live implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            String prefix = getMsg.getMsg("prefix");
            String liveMessage = getMsg.getMsg("livemessage");
            Player player = (Player) commandSender;
            if (player.hasPermission("everlive.live")) {
                //get playerName and replace %player% with it
                String playerName = player.getName();
                liveMessage = liveMessage.replaceAll("%player%", playerName);

                //get link and replace %link% with it
                String link = getMsg.getLink(playerName);
                liveMessage = liveMessage.replaceAll("%link%", link);

                //get platform and replace %platform% with it
                String rawPlatform = getMsg.getPlatform(playerName);
                String platform = "";
                if (rawPlatform.equalsIgnoreCase("twitch")) {
                    platform = getMsg.getMsg("twitch");
                    liveMessage = liveMessage.replaceAll("%platform%", platform);
                } else if (rawPlatform.equalsIgnoreCase("youtube")) {
                    platform = getMsg.getMsg("youtube");
                    liveMessage = liveMessage.replaceAll("%platform%", platform);
                }
                if (link != null && platform != null) {
                    String[] lines = liveMessage.split("\n");
                    for (String line : lines) {
                        player.sendMessage(prefix + line);
                    }
                    return true;
                } else {
                    player.sendMessage(prefix + "§cYou have not set your link yet, use /live <platform> to set it.");
                    return false;
                }
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
            return false;
        }
        return false;
    }
}