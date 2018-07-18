package fuzs.simplifiedhorses.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;

public class GuiFactory implements IModGuiFactory {

    public void initialize(Minecraft minecraftInstance) {
    }

    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    public boolean hasConfigGui() {
        return true;
    }

    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new GuiFactory.GuiModConfig(parentScreen);
    }

    public static class GuiModConfig extends GuiConfig {
        public GuiModConfig(GuiScreen parentScreen) {
            super(parentScreen, getAllElements(), "simplifiedhorses", false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
        }

        public static List<IConfigElement> getAllElements() {
            List<IConfigElement> list = new ArrayList();
            List<IConfigElement> general = (new ConfigElement(ConfigurationHandler.config.getCategory("general"))).getChildElements();
            list.add(new DummyCategoryElement("General", (new ResourceLocation("simplifiedhorses", "config.category.general")).toString(), general));
            return list;
        }
    }
}
