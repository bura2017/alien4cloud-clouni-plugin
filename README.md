# Alien4Cloud Clouni Plugin

A plugin which enables [clouni](https://github.com/ispras/tosca-tool) as 
Alien4Cloud [orchestrator](https://alien4cloud.github.io/#/documentation/2.0.0/orchestrators/orchestrators.html).

## Plugin structure

Plugin must be eventually packaged as zip-file which includes:
* **lib** contains all java archives
* **META-INF/plugin.yml** contains plugin description:
    * id
    * name
    * version
    * description
    * configuration_class (JAVA class to be loaded as Spring context configuration)
    * component_descriptors contains names of components specified in annotations _@Component("<name>")_

Current project settings are

~~~
 id: alien4cloud-clouni-plugin
 name: Orchestration plugin for Alien4Cloud
 version: ${project.version}
 description: >
   Plugin that uses Clouni (Cloud Unifier Tool for Service Orchestration)
 configuration_class: alien4cloud.plugin.clouni.config.PluginConfiguration
~~~

Configuration class look like

~~~
@Configuration
@ComponentScan(basePackages = "alien4cloud.plugin.clouni")
public class PluginConfiguration {
}
~~~

ComponentScan annotation configures packages to search for Spring annotations.

## SpringFramework

SpringFramework is used as the base for Alien4Cloud and let plugins to use alien4cloud resources.

Spring uses annotations _@Component_, _@Service_, _@Repository_, _@Controller_ and _@Configuration_ 
and registers them in _ApplicationContext_.

_Component_ is a generic stereotype for any Spring-managed component.

_Repository_ classes usually represent the database access layer in an application.

_Service_ class represents the business logic of application.

## Locations

Locations are the cloud providers to be used for infrastructure deployment

Supported locations: 

* _(partialy)_ OpenStack
* _(partialy)_ Amazon 
* _(future work)_ Kubernetes 

Location classes are in _alien4cloud.plugin.clouni.location_ package 
and are available from factory class _ClouniLocationConfiguratorFactory_ 

## Orchestrators 

The plugin provides Alien4Cloud Orchestrator which takes TOSCA templates to deploy services 
and their infrastructures. Templates use types specified by orchestrator or any other types. 

Existing Alien4Cloud orchestrators can be found [here](https://alien4cloud.github.io/#/documentation/2.0.0/orchestrators/orchestrators.html)

The class which defines the orchestrator _implements alien4cloud.orchestrators.plugin.IOrchestratorPlugin<T>_. 

The factory class which manages orchestrator lifecycle _implements IOrchestratorPluginFactory<T, V>_.

Both classes must be annotated as _Component_ classes. 

## Config 
Location config contains the following parameters
* provider - cloud provider name, choices: openstack, amazon
* auth - credentials for cloud provider 

## Lombok

You can annotate any field with @Getter and/or @Setter, 
to let lombok generate the default getter/setter automatically.
