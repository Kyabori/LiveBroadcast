package org.kyabori.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kyabori.Main;
import org.kyabori.getMsg;

public class setlink implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String prefix = getMsg.getMsg("prefix");
        String noperm = getMsg.getMsg("no-permission");
        String success = getMsg.getMsg("success");
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("everlive.setlink")) {
                if (strings.length == 2) {
                    if (strings[1].equalsIgnoreCase("twitch")) {
                        //get playerName and replace %player% with it
                        String playerName = player.getName();
                        success = success.replaceAll("%player%", playerName);

                        //get link and replace %link% with it
                        String link = strings[0];
                        success = success.replaceAll("%link%", link);

                        //get platform and replace %platform% with it
                        String platform = getMsg.getMsg("twitch");
                        success = success.replaceAll("%platform%", platform);

                        player.sendMessage(prefix + success);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".link", link);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".platform", platform);
                        Main.getInstance().saveConfig();
                        return true;
                    } else if (strings[1].equalsIgnoreCase("youtube")) {
                        //get playerName and replace %player% with it
                        String playerName = player.getName();
                        success = success.replaceAll("%player%", playerName);

                        //get link and replace %link% with it
                        String link = strings[0];
                        success = success.replaceAll("%link%", link);

                        //get platform and replace %platform% with it
                        String platform = getMsg.getMsg("youtube");
                        success = success.replaceAll("%platform%", platform);

                        player.sendMessage(prefix + success);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".link", link);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".platform", platform);
                        Main.getInstance().saveConfig();
                        return true;
                    } else {
                        //if player does not use a valid platform
                        player.sendMessage(prefix + "§cPlatform not valid, use 'twitch' or 'youtube'.");
                        return false;
                    }
                } else {
                    //if player does not use the correct syntax
                    player.sendMessage(prefix + "§cCorrect use: /setlink <link> <platform>");
                    return false;
                }
            }
        } else {
            //if sender is not a player
            commandSender.sendMessage(prefix + noperm);
            return false;
        }
        return false;
    }
}