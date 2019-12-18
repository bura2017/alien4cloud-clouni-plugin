package alien4cloud.plugin.clouni.location;

import alien4cloud.orchestrators.plugin.ILocationConfiguratorPlugin;
import org.springframework.stereotype.Component;

@Component
public class ClouniLocationConfiguratorFactory {
    public ILocationConfiguratorPlugin newInstance(String locationType) {
        // returns ILocationConfiguratorPlugin object depending on location type
        return null;
    }
}
