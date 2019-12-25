package alien4cloud.plugin.clouni.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"alien4cloud.plugin.clouni.orchestrator"})
public class ClouniOrchestratorContextConfiguration {
    public ClouniOrchestratorContextConfiguration() {}

}
