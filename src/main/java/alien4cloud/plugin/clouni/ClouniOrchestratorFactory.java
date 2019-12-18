package alien4cloud.plugin.clouni;

import alien4cloud.model.orchestrators.ArtifactSupport;
import alien4cloud.model.orchestrators.locations.LocationSupport;
import alien4cloud.orchestrators.plugin.IOrchestratorPluginFactory;
import alien4cloud.plugin.clouni.config.ClouniConfig;
import com.google.common.collect.Maps;
import org.alien4cloud.tosca.model.definitions.PropertyDefinition;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("clouni-orchestrator-factory")
public class ClouniOrchestratorFactory implements IOrchestratorPluginFactory<ClouniOrchestrator, ClouniConfig> {

    @Autowired
    private BeanFactory beanFactory;

    @Override
    public ClouniOrchestrator newInstance() {
        return beanFactory.getBean(ClouniOrchestrator.class);
    }

    @Override
    public void destroy(ClouniOrchestrator clouniOrchestrator) {
        // unknown
    }

    @Override
    public ClouniConfig getDefaultConfiguration() {
        // no default configuraion
        return new ClouniConfig();
    }

    @Override
    public Class<ClouniConfig> getConfigurationType() {
        return ClouniConfig.class;
    }

    @Override
    public LocationSupport getLocationSupport() {
        return new LocationSupport(true, new String[] {"openstack", "amazon"});
    }

    @Override
    public ArtifactSupport getArtifactSupport() {
        return new ArtifactSupport();
    }

    @Override
    public Map<String, PropertyDefinition> getDeploymentPropertyDefinitions() {
        return Maps.newHashMap();
    }

    @Override
    public String getType() {
        return "Clouni";
    }
}
