package fuzs.simplifiedhorses.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ConfigurationHandler {
    public static Configuration config;
    public static int chooseModel;
    public static boolean useImprovements;

    public ConfigurationHandler() {
    }

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            loadConfiguration();
        }

    }

    private static void loadConfiguration() {
        chooseModel = config.get("general", "Choose a model to be used", 0).getInt(0);
        useImprovements = config.get("general", "Apply small improvements", true).getBoolean(true);
        if (config.hasChanged()) {
            config.save();
        }

    }

    @SubscribeEvent
    public static void onConfigurationChangedEvent(OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase("simplifiedhorses")) {
            loadConfiguration();
        }

    }
}
