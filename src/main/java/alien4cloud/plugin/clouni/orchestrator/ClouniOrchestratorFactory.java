package alien4cloud.plugin.clouni.orchestrator;

import alien4cloud.model.orchestrators.ArtifactSupport;
import alien4cloud.model.orchestrators.locations.LocationSupport;
import alien4cloud.orchestrators.plugin.IOrchestratorPluginFactory;
import alien4cloud.plugin.clouni.config.ClouniConfig;
import alien4cloud.plugin.clouni.config.ClouniOrchestratorContextConfiguration;
import alien4cloud.utils.ClassLoaderUtil;
import org.alien4cloud.tosca.model.definitions.PropertyDefinition;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.Map;

/**
 * @author valerius
 */

public class ClouniOrchestratorFactory implements IOrchestratorPluginFactory<ClouniOrchestrator, ClouniConfig> {

    private static final Logger log = LoggerFactory.getLogger(ClouniOrchestratorFactory.class);
    @Autowired
    private ApplicationContext pluginContext;
    private Map<ClouniOrchestrator, AnnotationConfigApplicationContext> contextMap = Collections.synchronizedMap(Maps.newIdentityHashMap());

    public ClouniOrchestratorFactory(){}

    @Override
    public ClouniOrchestrator newInstance() {
        AnnotationConfigApplicationContext orchestratorContext = new AnnotationConfigApplicationContext();
        orchestratorContext.setParent(this.pluginContext);
        orchestratorContext.setClassLoader(this.pluginContext.getClassLoader());
        ClassLoaderUtil.runWithContextClassLoader(this.pluginContext.getClassLoader(), () -> {
            orchestratorContext.register(new Class[]{ClouniOrchestratorContextConfiguration.class});
            orchestratorContext.refresh();
        });
        log.info("Created new Clouni Orchestrator context {} for plugin {}", orchestratorContext.getId(), this.pluginContext.getId());
        ClouniOrchestrator orchestrator = (ClouniOrchestrator) orchestratorContext.getBean(ClouniOrchestrator.class);
        this.contextMap.put(orchestrator, orchestratorContext);
        return orchestrator;
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
