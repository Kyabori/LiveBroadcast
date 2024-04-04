package org.kyabori.commands;

import org.bukkit.ChatColor;
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
                        success = success.replaceAll("%player%", player.getName());
                        String link = getMsg.getLink(player.getName());
                        success = success.replaceAll("%link%", link);
                        String piattaforma = "Twitch";
                        success = success.replaceAll("%piattaforma%", piattaforma);

                        player.sendMessage(prefix + success);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".link", strings[0]);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".piattaforma", strings[1]);
                        Main.getInstance().saveConfig();
                        return true;
                    } else if (strings[1].equalsIgnoreCase("youtube")) {
                        success = success.replaceAll("%player%", player.getName());
                        String link = getMsg.getLink(player.getName());
                        success = success.replaceAll("%link%", link);
                        String piattaforma = "YouTube";
                        success = success.replaceAll("%piattaforma%", piattaforma);

                        player.sendMessage(prefix + success);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".link", strings[0]);
                        Main.getInstance().getConfig().set("users." + player.getName() + ".piattaforma", strings[1]);
                        Main.getInstance().saveConfig();
                        return true;
                    } else {
                        player.sendMessage(prefix + "§cPiattaforma non valida! Utilizza 'twitch' o 'youtube'");
                        return false;
                    }
                } else {
                    player.sendMessage(prefix + "§cUtilizzo: /setlink <link> <piattaforma>");
                    return false;
                }
            }
        } else {
            commandSender.sendMessage(prefix + noperm);
            return false;
        }
        return false;
    }
}