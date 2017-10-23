<template>
  <div class="content">
    user from
    Spring Cloud
    Table of Contents
    Features
    Cloud Native Applications
    Spring Cloud Context: Application Context Services
    The Bootstrap Application Context
    Application Context Hierarchies
    Changing the Location of Bootstrap Properties
    Overriding the Values of Remote Properties
    Customizing the Bootstrap Configuration
    Customizing the Bootstrap Property Sources
    Environment Changes
    Refresh Scope
    Encryption and Decryption
    Endpoints
    Spring Cloud Commons: Common Abstractions
    @EnableDiscoveryClient
    ServiceRegistry
    Spring RestTemplate as a Load Balancer Client
    Spring WebFlux WebClient as a Load Balancer Client
    Ignore Network Interfaces
    HTTP Client Factories
    Spring Cloud Config
    Quick Start
    Client Side Usage
    Spring Cloud Config Server
    Environment Repository
    Health Indicator
    Security
    Encryption and Decryption
    Key Management
    Creating a Key Store for Testing
    Using Multiple Keys and Key Rotation
    Serving Encrypted Properties
    Serving Alternative Formats
    Serving Plain Text
    Embedding the Config Server
    Push Notifications and Spring Cloud Bus
    Spring Cloud Config Client
    Config First Bootstrap
    Discovery First Bootstrap
    Config Client Fail Fast
    Config Client Retry
    Locating Remote Configuration Resources
    Security
    Vault
    Spring Cloud Netflix
    Service Discovery: Eureka Clients
    How to Include Eureka Client
    Registering with Eureka
    Authenticating with the Eureka Server
    Status Page and Health Indicator
    Registering a Secure Application
    Eureka’s Health Checks
    Eureka Metadata for Instances and Clients
    Using the EurekaClient
    Alternatives to the native Netflix EurekaClient
    Why is it so Slow to Register a Service?
    Zones
    Service Discovery: Eureka Server
    How to Include Eureka Server
    How to Run a Eureka Server
    High Availability, Zones and Regions
    Standalone Mode
    Peer Awareness
    Prefer IP Address
    Circuit Breaker: Hystrix Clients
    How to Include Hystrix
    Propagating the Security Context or using Spring Scopes
    Health Indicator
    Hystrix Metrics Stream
    Circuit Breaker: Hystrix Dashboard
    Hystrix Timeouts And Ribbon Clients
    How to Include Hystrix Dashboard
    Turbine
    Turbine Stream
    Client Side Load Balancer: Ribbon
    How to Include Ribbon
    Customizing the Ribbon Client
    Customizing default for all Ribbon Clients
    Customizing the Ribbon Client using properties
    Using Ribbon with Eureka
    Example: How to Use Ribbon Without Eureka
    Example: Disable Eureka use in Ribbon
    Using the Ribbon API Directly
    Caching of Ribbon Configuration
    How to Configure Hystrix thread pools
    Declarative REST Client: Feign
    How to Include Feign
    Overriding Feign Defaults
    Creating Feign Clients Manually
    Feign Hystrix Support
    Feign Hystrix Fallbacks
    Feign and @Primary
    Feign Inheritance Support
    Feign request/response compression
    Feign logging
    External Configuration: Archaius
    Router and Filter: Zuul
    How to Include Zuul
    Embedded Zuul Reverse Proxy
    Zuul Http Client
    Cookies and Sensitive Headers
    Ignored Headers
    The Routes Endpoint
    Strangulation Patterns and Local Forwards
    Uploading Files through Zuul
    Query String Encoding
    Plain Embedded Zuul
    Disable Zuul Filters
    Providing Hystrix Fallbacks For Routes
    Rewriting Location header
    Zuul Developer Guide
    Polyglot support with Sidecar
    Metrics: Spectator, Servo, and Atlas
    Dimensional vs. Hierarchical Metrics
    Default Metrics Collection
    Metrics Collection: Spectator
    Metrics Collection: Servo
    Metrics Backend: Atlas
    Retrying Failed Requests
    HTTP Clients
    Spring Cloud Stream
    Introducing Spring Cloud Stream
    Main Concepts
    Application Model
    The Binder Abstraction
    Persistent Publish-Subscribe Support
    Consumer Groups
    Partitioning Support
    Programming Model
    Declaring and Binding Channels
    Binders
    Producers and Consumers
    Binder SPI
    Binder Detection
    Multiple Binders on the Classpath
    Connecting to Multiple Systems
    Binder configuration properties
    Configuration Options
    Spring Cloud Stream Properties
    Binding Properties
    Using dynamically bound destinations
    Content Type and Transformation
    MIME types
    MIME types and Java types
    Customizing message conversion
    @StreamListener and Message Conversion
    Schema evolution support
    Apache Avro Message Converters
    Converters with schema support
    Schema Registry Support
    Schema Registry Server
    Schema Registry Client
    Avro Schema Registry Client Message Converters
    Schema Registration and Resolution
    Inter-Application Communication
    Connecting Multiple Application Instances
    Instance Index and Instance Count
    Partitioning
    Testing
    Health Indicator
    Metrics Emitter
    Samples
    Getting Started
    Binder Implementations
    Apache Kafka Binder
    Usage
    Apache Kafka Binder Overview
    Configuration Options
    Dead-Letter Topic Processing
    RabbitMQ Binder
    Usage
    RabbitMQ Binder Overview
    Configuration Options
    Retry With the RabbitMQ Binder
    Dead-Letter Queue Processing
    Spring Cloud Bus
    Quick Start
    Addressing an Instance
    Addressing all instances of a service
    Application Context ID must be unique
    Customizing the Message Broker
    Tracing Bus Events
    Broadcasting Your Own Events
    Registering events in custom packages
    Spring Cloud Sleuth
    Terminology
    Purpose
    Adding to the project
    Additional resources
    Features
    Sampling
    Instrumentation
    Span lifecycle
    Creating and closing spans
    Continuing spans
    Creating spans with an explicit parent
    Naming spans
    @SpanName annotation
    toString() method
    Managing spans with annotations
    Rationale
    Creating new spans
    Continuing spans
    More advanced tag setting
    Customizations
    Spring Integration
    HTTP
    Example
    TraceFilter
    Custom SA tag in Zipkin
    Custom service name
    Customization of reported spans
    Host locator
    Sending spans to Zipkin
    Span Data as Messages
    Zipkin Consumer
    Custom Consumer
    Metrics
    Integrations
    Runnable and Callable
    Hystrix
    RxJava
    HTTP integration
    HTTP client integration
    Feign
    Asynchronous communication
    Messaging
    Zuul
    Running examples
    Spring Cloud Consul
    Install Consul
    Consul Agent
    Service Discovery with Consul
    How to activate
    Registering with Consul
    HTTP Health Check
    Using the DiscoveryClient
    Distributed Configuration with Consul
    How to activate
    Customizing
    Config Watch
    YAML or Properties with Config
    git2consul with Config
    Fail Fast
    Consul Retry
    Spring Cloud Bus with Consul
    How to activate
    Circuit Breaker with Hystrix
    Hystrix metrics aggregation with Turbine and Consul
    Spring Cloud Zookeeper
    Install Zookeeper
    Service Discovery with Zookeeper
    How to activate
    Registering with Zookeeper
    Using the DiscoveryClient
    Using Spring Cloud Zookeeper with Spring Cloud Netflix Components
    Ribbon with Zookeeper
    Spring Cloud Zookeeper and Service Registry
    Instance Status
    Zookeeper Dependencies
    Using the Zookeeper Dependencies
    How to activate Zookeeper Dependencies
    Setting up Zookeeper Dependencies
    Configuring Spring Cloud Zookeeper Dependencies
    Spring Cloud Zookeeper Dependency Watcher
    How to activate
    Registering a listener
    Presence Checker
    Distributed Configuration with Zookeeper
    How to activate
    Customizing
    ACLs
    Spring Cloud Security
    Quickstart
    OAuth2 Single Sign On
    OAuth2 Protected Resource
    More Detail
    Single Sign On
    Token Relay
    Configuring Authentication Downstream of a Zuul Proxy
    Spring Cloud for Cloud Foundry
    Discovery
    Single Sign On
    Spring Cloud Contract
    1. Spring Cloud Contract
    2. Spring Cloud Contract Verifier
    2.1. Introduction
    2.2. FAQ
    2.3. Spring Cloud Contract Verifier HTTP
    2.4. Spring Cloud Contract Verifier Messaging
    2.5. Spring Cloud Contract Stub Runner
    2.6. Stub Runner Core
    2.7. Stub Runner JUnit Rule
    2.8. Stub Runner Spring Cloud
    2.9. Stub Runner Boot Application
    2.10. Stubs Per Consumer
    2.11. Common
    2.12. Stub Runner for Messaging
    2.13. Stub Runner Camel
    2.14. Stub Runner Integration
    2.15. Stub Runner Stream
    2.16. Stub Runner Spring AMQP
    2.17. Contract DSL
    2.18. Customization
    2.19. Pluggable architecture
    2.20. Links
    3. Spring Cloud Contract WireMock
    3.1. Registering Stubs Automatically
    3.2. Using Files to Specify the Stub Bodies
    3.3. Alternative: Using JUnit Rules
    4. Relaxed SSL Validation for Rest Template
    5. WireMock and Spring MVC Mocks
    6. Generating Stubs using RestDocs
    7. Generating Contracts using RestDocs
    8. Migrations
    8.1. 1.0.x → 1.1.x
    8.2. 1.1.x → 1.2.x
    Spring Cloud Vault
    9. Quick Start
    10. Client Side Usage
    10.1. Authentication
    11. Authentication methods
    11.1. Token authentication
    11.2. AppId authentication
    11.3. AppRole authentication
    11.4. AWS-EC2 authentication
    11.5. TLS certificate authentication
    11.6. Cubbyhole authentication
    12. Secret Backends
    12.1. Generic Backend
    12.2. Consul
    12.3. RabbitMQ
    12.4. AWS
    13. Database backends
    13.1. Apache Cassandra
    13.2. MongoDB
    13.3. MySQL
    13.4. PostgreSQL
    14. Configure PropertySourceLocator behavior
    15. Service Registry Configuration
    16. Vault Client Fail Fast
    17. Vault Client SSL configuration
    18. Lease lifecycle management (renewal and revocation)
    Appendix: Compendium of Configuration Properties
    Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus). Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns. They will work well in any distributed environment, including the developer’s own laptop, bare metal data centres, and managed platforms such as Cloud Foundry.

    Version: Finchley.M2

    Features
    Spring Cloud focuses on providing good out of box experience for typical use cases and extensibility mechanism to cover others.

    Distributed/versioned configuration

    Service registration and discovery

    Routing

    Service-to-service calls

    Load balancing

    Circuit Breakers

    Distributed messaging

    Cloud Native Applications

    Cloud Native is a style of application development that encourages easy adoption of best practices in the areas of continuous delivery and value-driven development. A related discipline is that of building 12-factor Apps in which development practices are aligned with delivery and operations goals, for instance by using declarative programming and management and monitoring. Spring Cloud facilitates these styles of development in a number of specific ways and the starting point is a set of features that all components in a distributed system either need or need easy access to when required.

    Many of those features are covered by Spring Boot, which we build on in Spring Cloud. Some more are delivered by Spring Cloud as two libraries: Spring Cloud Context and Spring Cloud Commons. Spring Cloud Context provides utilities and special services for the ApplicationContext of a Spring Cloud application (bootstrap context, encryption, refresh scope and environment endpoints). Spring Cloud Commons is a set of abstractions and common classes used in different Spring Cloud implementations (eg. Spring Cloud Netflix vs. Spring Cloud Consul).

    If you are getting an exception due to "Illegal key size" and you are using Sun’s JDK, you need to install the Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files. See the following links for more information:
    user from
    Spring Cloud
    Table of Contents
    Features
    Cloud Native Applications
    Spring Cloud Context: Application Context Services
    The Bootstrap Application Context
    Application Context Hierarchies
    Changing the Location of Bootstrap Properties
    Overriding the Values of Remote Properties
    Customizing the Bootstrap Configuration
    Customizing the Bootstrap Property Sources
    Environment Changes
    Refresh Scope
    Encryption and Decryption
    Endpoints
    Spring Cloud Commons: Common Abstractions
    @EnableDiscoveryClient
    ServiceRegistry
    Spring RestTemplate as a Load Balancer Client
    Spring WebFlux WebClient as a Load Balancer Client
    Ignore Network Interfaces
    HTTP Client Factories
    Spring Cloud Config
    Quick Start
    Client Side Usage
    Spring Cloud Config Server
    Environment Repository
    Health Indicator
    Security
    Encryption and Decryption
    Key Management
    Creating a Key Store for Testing
    Using Multiple Keys and Key Rotation
    Serving Encrypted Properties
    Serving Alternative Formats
    Serving Plain Text
    Embedding the Config Server
    Push Notifications and Spring Cloud Bus
    Spring Cloud Config Client
    Config First Bootstrap
    Discovery First Bootstrap
    Config Client Fail Fast
    Config Client Retry
    Locating Remote Configuration Resources
    Security
    Vault
    Spring Cloud Netflix
    Service Discovery: Eureka Clients
    How to Include Eureka Client
    Registering with Eureka
    Authenticating with the Eureka Server
    Status Page and Health Indicator
    Registering a Secure Application
    Eureka’s Health Checks
    Eureka Metadata for Instances and Clients
    Using the EurekaClient
    Alternatives to the native Netflix EurekaClient
    Why is it so Slow to Register a Service?
    Zones
    Service Discovery: Eureka Server
    How to Include Eureka Server
    How to Run a Eureka Server
    High Availability, Zones and Regions
    Standalone Mode
    Peer Awareness
    Prefer IP Address
    Circuit Breaker: Hystrix Clients
    How to Include Hystrix
    Propagating the Security Context or using Spring Scopes
    Health Indicator
    Hystrix Metrics Stream
    Circuit Breaker: Hystrix Dashboard
    Hystrix Timeouts And Ribbon Clients
    How to Include Hystrix Dashboard
    Turbine
    Turbine Stream
    Client Side Load Balancer: Ribbon
    How to Include Ribbon
    Customizing the Ribbon Client
    Customizing default for all Ribbon Clients
    Customizing the Ribbon Client using properties
    Using Ribbon with Eureka
    Example: How to Use Ribbon Without Eureka
    Example: Disable Eureka use in Ribbon
    Using the Ribbon API Directly
    Caching of Ribbon Configuration
    How to Configure Hystrix thread pools
    Declarative REST Client: Feign
    How to Include Feign
    Overriding Feign Defaults
    Creating Feign Clients Manually
    Feign Hystrix Support
    Feign Hystrix Fallbacks
    Feign and @Primary
    Feign Inheritance Support
    Feign request/response compression
    Feign logging
    External Configuration: Archaius
    Router and Filter: Zuul
    How to Include Zuul
    Embedded Zuul Reverse Proxy
    Zuul Http Client
    Cookies and Sensitive Headers
    Ignored Headers
    The Routes Endpoint
    Strangulation Patterns and Local Forwards
    Uploading Files through Zuul
    Query String Encoding
    Plain Embedded Zuul
    Disable Zuul Filters
    Providing Hystrix Fallbacks For Routes
    Rewriting Location header
    Zuul Developer Guide
    Polyglot support with Sidecar
    Metrics: Spectator, Servo, and Atlas
    Dimensional vs. Hierarchical Metrics
    Default Metrics Collection
    Metrics Collection: Spectator
    Metrics Collection: Servo
    Metrics Backend: Atlas
    Retrying Failed Requests
    HTTP Clients
    Spring Cloud Stream
    Introducing Spring Cloud Stream
    Main Concepts
    Application Model
    The Binder Abstraction
    Persistent Publish-Subscribe Support
    Consumer Groups
    Partitioning Support
    Programming Model
    Declaring and Binding Channels
    Binders
    Producers and Consumers
    Binder SPI
    Binder Detection
    Multiple Binders on the Classpath
    Connecting to Multiple Systems
    Binder configuration properties
    Configuration Options
    Spring Cloud Stream Properties
    Binding Properties
    Using dynamically bound destinations
    Content Type and Transformation
    MIME types
    MIME types and Java types
    Customizing message conversion
    @StreamListener and Message Conversion
    Schema evolution support
    Apache Avro Message Converters
    Converters with schema support
    Schema Registry Support
    Schema Registry Server
    Schema Registry Client
    Avro Schema Registry Client Message Converters
    Schema Registration and Resolution
    Inter-Application Communication
    Connecting Multiple Application Instances
    Instance Index and Instance Count
    Partitioning
    Testing
    Health Indicator
    Metrics Emitter
    Samples
    Getting Started
    Binder Implementations
    Apache Kafka Binder
    Usage
    Apache Kafka Binder Overview
    Configuration Options
    Dead-Letter Topic Processing
    RabbitMQ Binder
    Usage
    RabbitMQ Binder Overview
    Configuration Options
    Retry With the RabbitMQ Binder
    Dead-Letter Queue Processing
    Spring Cloud Bus
    Quick Start
    Addressing an Instance
    Addressing all instances of a service
    Application Context ID must be unique
    Customizing the Message Broker
    Tracing Bus Events
    Broadcasting Your Own Events
    Registering events in custom packages
    Spring Cloud Sleuth
    Terminology
    Purpose
    Adding to the project
    Additional resources
    Features
    Sampling
    Instrumentation
    Span lifecycle
    Creating and closing spans
    Continuing spans
    Creating spans with an explicit parent
    Naming spans
    @SpanName annotation
    toString() method
    Managing spans with annotations
    Rationale
    Creating new spans
    Continuing spans
    More advanced tag setting
    Customizations
    Spring Integration
    HTTP
    Example
    TraceFilter
    Custom SA tag in Zipkin
    Custom service name
    Customization of reported spans
    Host locator
    Sending spans to Zipkin
    Span Data as Messages
    Zipkin Consumer
    Custom Consumer
    Metrics
    Integrations
    Runnable and Callable
    Hystrix
    RxJava
    HTTP integration
    HTTP client integration
    Feign
    Asynchronous communication
    Messaging
    Zuul
    Running examples
    Spring Cloud Consul
    Install Consul
    Consul Agent
    Service Discovery with Consul
    How to activate
    Registering with Consul
    HTTP Health Check
    Using the DiscoveryClient
    Distributed Configuration with Consul
    How to activate
    Customizing
    Config Watch
    YAML or Properties with Config
    git2consul with Config
    Fail Fast
    Consul Retry
    Spring Cloud Bus with Consul
    How to activate
    Circuit Breaker with Hystrix
    Hystrix metrics aggregation with Turbine and Consul
    Spring Cloud Zookeeper
    Install Zookeeper
    Service Discovery with Zookeeper
    How to activate
    Registering with Zookeeper
    Using the DiscoveryClient
    Using Spring Cloud Zookeeper with Spring Cloud Netflix Components
    Ribbon with Zookeeper
    Spring Cloud Zookeeper and Service Registry
    Instance Status
    Zookeeper Dependencies
    Using the Zookeeper Dependencies
    How to activate Zookeeper Dependencies
    Setting up Zookeeper Dependencies
    Configuring Spring Cloud Zookeeper Dependencies
    Spring Cloud Zookeeper Dependency Watcher
    How to activate
    Registering a listener
    Presence Checker
    Distributed Configuration with Zookeeper
    How to activate
    Customizing
    ACLs
    Spring Cloud Security
    Quickstart
    OAuth2 Single Sign On
    OAuth2 Protected Resource
    More Detail
    Single Sign On
    Token Relay
    Configuring Authentication Downstream of a Zuul Proxy
    Spring Cloud for Cloud Foundry
    Discovery
    Single Sign On
    Spring Cloud Contract
    1. Spring Cloud Contract
    2. Spring Cloud Contract Verifier
    2.1. Introduction
    2.2. FAQ
    2.3. Spring Cloud Contract Verifier HTTP
    2.4. Spring Cloud Contract Verifier Messaging
    2.5. Spring Cloud Contract Stub Runner
    2.6. Stub Runner Core
    2.7. Stub Runner JUnit Rule
    2.8. Stub Runner Spring Cloud
    2.9. Stub Runner Boot Application
    2.10. Stubs Per Consumer
    2.11. Common
    2.12. Stub Runner for Messaging
    2.13. Stub Runner Camel
    2.14. Stub Runner Integration
    2.15. Stub Runner Stream
    2.16. Stub Runner Spring AMQP
    2.17. Contract DSL
    2.18. Customization
    2.19. Pluggable architecture
    2.20. Links
    3. Spring Cloud Contract WireMock
    3.1. Registering Stubs Automatically
    3.2. Using Files to Specify the Stub Bodies
    3.3. Alternative: Using JUnit Rules
    4. Relaxed SSL Validation for Rest Template
    5. WireMock and Spring MVC Mocks
    6. Generating Stubs using RestDocs
    7. Generating Contracts using RestDocs
    8. Migrations
    8.1. 1.0.x → 1.1.x
    8.2. 1.1.x → 1.2.x
    Spring Cloud Vault
    9. Quick Start
    10. Client Side Usage
    10.1. Authentication
    11. Authentication methods
    11.1. Token authentication
    11.2. AppId authentication
    11.3. AppRole authentication
    11.4. AWS-EC2 authentication
    11.5. TLS certificate authentication
    11.6. Cubbyhole authentication
    12. Secret Backends
    12.1. Generic Backend
    12.2. Consul
    12.3. RabbitMQ
    12.4. AWS
    13. Database backends
    13.1. Apache Cassandra
    13.2. MongoDB
    13.3. MySQL
    13.4. PostgreSQL
    14. Configure PropertySourceLocator behavior
    15. Service Registry Configuration
    16. Vault Client Fail Fast
    17. Vault Client SSL configuration
    18. Lease lifecycle management (renewal and revocation)
    Appendix: Compendium of Configuration Properties
    Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus). Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns. They will work well in any distributed environment, including the developer’s own laptop, bare metal data centres, and managed platforms such as Cloud Foundry.

    Version: Finchley.M2

    Features
    Spring Cloud focuses on providing good out of box experience for typical use cases and extensibility mechanism to cover others.

    Distributed/versioned configuration

    Service registration and discovery

    Routing

    Service-to-service calls

    Load balancing

    Circuit Breakers

    Distributed messaging

    Cloud Native Applications

    Cloud Native is a style of application development that encourages easy adoption of best practices in the areas of continuous delivery and value-driven development. A related discipline is that of building 12-factor Apps in which development practices are aligned with delivery and operations goals, for instance by using declarative programming and management and monitoring. Spring Cloud facilitates these styles of development in a number of specific ways and the starting point is a set of features that all components in a distributed system either need or need easy access to when required.

    Many of those features are covered by Spring Boot, which we build on in Spring Cloud. Some more are delivered by Spring Cloud as two libraries: Spring Cloud Context and Spring Cloud Commons. Spring Cloud Context provides utilities and special services for the ApplicationContext of a Spring Cloud application (bootstrap context, encryption, refresh scope and environment endpoints). Spring Cloud Commons is a set of abstractions and common classes used in different Spring Cloud implementations (eg. Spring Cloud Netflix vs. Spring Cloud Consul).

    If you are getting an exception due to "Illegal key size" and you are using Sun’s JDK, you need to install the Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files. See the following links for more information:
  </div>
</template>

<script type="text/ecmascript-6">
  export default{}
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">

</style>
