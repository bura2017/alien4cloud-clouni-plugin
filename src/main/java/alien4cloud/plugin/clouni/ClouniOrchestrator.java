package alien4cloud.plugin.clouni;

import alien4cloud.orchestrators.plugin.ILocationConfiguratorPlugin;
import alien4cloud.orchestrators.plugin.IOrchestratorPlugin;
import alien4cloud.orchestrators.plugin.model.PluginArchive;
import alien4cloud.paas.IPaaSCallback;
import alien4cloud.paas.exception.MaintenanceModeException;
import alien4cloud.paas.exception.OperationExecutionException;
import alien4cloud.paas.exception.PluginConfigurationException;
import alien4cloud.paas.model.*;
import alien4cloud.plugin.clouni.config.ClouniConfig;
import alien4cloud.plugin.clouni.location.ClouniLocationConfiguratorFactory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor()
public class ClouniOrchestrator implements IOrchestratorPlugin<ClouniConfig> {

    private @NonNull
    ClouniLocationConfiguratorFactory clouniLocationConfiguratorFactory;

    @Override
    public ILocationConfiguratorPlugin getConfigurator(String locationType) {
        return clouniLocationConfiguratorFactory.newInstance(locationType);
    }

    @Override
    public List<PluginArchive> pluginArchives() {
        return Collections.emptyList();
    }

    @Override
    public void setConfiguration(String orchestratorId, ClouniConfig clouniConfig) throws PluginConfigurationException {
        // empty
    }

    @Override
    public void init(Map<String, PaaSTopologyDeploymentContext> activeDeployments) {
        // init mapping service? unknown
    }

    @Override
    public void deploy(PaaSTopologyDeploymentContext paaSTopologyDeploymentContext, IPaaSCallback<?> iPaaSCallback) {

    }

    @Override
    public void update(PaaSTopologyDeploymentContext paaSTopologyDeploymentContext, IPaaSCallback<?> iPaaSCallback) {

    }

    @Override
    public void undeploy(PaaSDeploymentContext paaSDeploymentContext, IPaaSCallback<?> iPaaSCallback) {

    }

    @Override
    public void scale(PaaSDeploymentContext paaSDeploymentContext, String nodeTemplateId, int instances, IPaaSCallback<?> iPaaSCallback) {

    }

    @Override
    public void launchWorkflow(PaaSDeploymentContext paaSDeploymentContext, String s, Map<String, Object> map, IPaaSCallback<?> iPaaSCallback) {

    }

    @Override
    public void getStatus(PaaSDeploymentContext paaSDeploymentContext, IPaaSCallback<DeploymentStatus> iPaaSCallback) {

    }

    @Override
    public void getInstancesInformation(PaaSTopologyDeploymentContext paaSTopologyDeploymentContext, IPaaSCallback<Map<String, Map<String, InstanceInformation>>> iPaaSCallback) {

    }

    @Override
    public void getEventsSince(Date date, int i, IPaaSCallback<AbstractMonitorEvent[]> iPaaSCallback) {

    }

    @Override
    public void executeOperation(PaaSTopologyDeploymentContext paaSTopologyDeploymentContext, NodeOperationExecRequest nodeOperationExecRequest, IPaaSCallback<Map<String, String>> iPaaSCallback) throws OperationExecutionException {

    }

    @Override
    public void switchMaintenanceMode(PaaSDeploymentContext paaSDeploymentContext, boolean b) throws MaintenanceModeException {

    }

    @Override
    public void switchInstanceMaintenanceMode(PaaSDeploymentContext paaSDeploymentContext, String s, String s1, boolean b) throws MaintenanceModeException {

    }
}
