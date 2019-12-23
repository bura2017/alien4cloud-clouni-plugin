package alien4cloud.plugin.clouni.config;

import alien4cloud.plugin.clouni.orchestrator.ClouniOrchestratorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author valerius
 */
@Configuration
public class PluginConfiguration {
    public PluginConfiguration() {
    }
    @Bean(
            name = {"clouni-orchestrator-factory"}
    )
    public ClouniOrchestratorFactory clouniOrchestratorFactory() {
        return new ClouniOrchestratorFactory();
    }
}
