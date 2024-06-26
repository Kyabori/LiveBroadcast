package org.kyabori;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class getMsg extends JavaPlugin{
    public static @NotNull String getMsg(String key) {
        return Main.getInstance().getConfig().getString("messages." + key).replaceAll("&", "§");
    }
    public static @NotNull String getLink(String key) {
        String string = Main.getInstance().getConfig().getString("users." + key + ".link");
        assert string != null;
        return string;
    }
    public static @NotNull String getPlatform(String key) {
        String string = Main.getInstance().getConfig().getString("users." + key + ".platform");
        assert string != null;
        return string;
    }
}