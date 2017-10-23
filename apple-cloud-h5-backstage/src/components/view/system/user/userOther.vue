<template>
  <div class="content">user other
    Spring Cloud Context: Application Context Services
    Spring Boot has an opinionated view of how to build an application with Spring: for instance it has conventional locations for common configuration file, and endpoints for common management and monitoring tasks. Spring Cloud builds on top of that and adds a few features that probably all components in a system would use or occasionally need.

    The Bootstrap Application Context
    A Spring Cloud application operates by creating a "bootstrap" context, which is a parent context for the main application. Out of the box it is responsible for loading configuration properties from the external sources, and also decrypting properties in the local external configuration files. The two contexts share an Environment which is the source of external properties for any Spring application. Bootstrap properties are added with high precedence, so they cannot be overridden by local configuration, by default.

    The bootstrap context uses a different convention for locating external configuration than the main application context, so instead of application.yml (or .properties) you use bootstrap.yml, keeping the external configuration for bootstrap and main context nicely separate. Example:

    bootstrap.yml
    spring:
    application:
    name: foo
    cloud:
    config:
    uri: ${SPRING_CONFIG_URI:http://localhost:8888}
    It is a good idea to set the spring.application.name (in bootstrap.yml or application.yml) if your application needs any application-specific configuration from the server.

    You can disable the bootstrap process completely by setting spring.cloud.bootstrap.enabled=false (e.g. in System properties).
  </div>
</template>

<script type="text/ecmascript-6">
  export default{}
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">

</style>
