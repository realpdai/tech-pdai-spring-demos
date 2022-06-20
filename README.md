> 持续更新中... @pdai

## SpringFramework 5.x+
> 首先， 从Spring框架的整体架构和组成对整体框架有个认知。@pdai

+ [Spring基础 - Spring和Spring框架组成](https://pdai.tech/md/spring/spring-x-framework-introduce.html)
  + Spring是什么？它是怎么诞生的？有哪些主要的组件和核心功能呢? 本文通过这几个问题帮助你构筑Spring和Spring Framework的整体认知。

> 其次，通过案例引出Spring的核心（IoC和AOP），同时对IoC和AOP进行案例使用分析。

+ [Spring基础 - Spring简单例子引入Spring的核心](https://pdai.tech/md/spring/spring-x-framework-helloworld.html)
  + 上文中我们简单介绍了Spring和Spring Framework的组件，那么这些Spring Framework组件是如何配合工作的呢？本文主要承接上文，向你展示Spring Framework组件的典型应用场景和基于这个场景设计出的简单案例，并以此引出Spring的核心要点，比如IOC和AOP等；在此基础上还引入了不同的配置方式， 如XML，Java配置和注解方式的差异。
+ [Spring基础 - Spring核心之控制反转(IOC)](https://pdai.tech/md/spring/spring-x-framework-ioc.html)
  + 在[Spring基础 - Spring简单例子引入Spring的核心](https://pdai.tech/md/spring/spring-x-framework-helloworld.html)中向你展示了IoC的基础含义，同时以此发散了一些IoC相关知识点; 本节将在此基础上进一步解读IOC的含义以及IOC的使用方式
+ [Spring基础 - Spring核心之面向切面编程(AOP)](https://pdai.tech/md/spring/spring-x-framework-aop.html)
  + 在[Spring基础 - Spring简单例子引入Spring的核心](https://pdai.tech/md/spring/spring-x-framework-helloworld.html)中向你展示了AOP的基础含义，同时以此发散了一些AOP相关知识点; 本节将在此基础上进一步解读AOP的含义以及AOP的使用方式。

> 基于Spring框架和IOC，AOP的基础，为构建上层web应用，需要进一步学习SpringMVC。

+ [Spring基础 - SpringMVC请求流程和案例](https://pdai.tech/md/spring/spring-x-framework-springmvc.html)
  + 前文我们介绍了Spring框架和Spring框架中最为重要的两个技术点（IOC和AOP），那我们如何更好的构建上层的应用呢（比如web 应用），这便是SpringMVC；Spring MVC是Spring在Spring Container Core和AOP等技术基础上，遵循上述Web MVC的规范推出的web开发框架，目的是为了简化Java栈的web开发。 本文主要介绍SpringMVC的请求流程和基础案例的编写和运行。

> Spring进阶 - IoC，AOP以及SpringMVC的源码分析

+ [Spring进阶 - Spring IOC实现原理详解之IOC体系结构设计](https://pdai.tech/md/spring/spring-x-framework-ioc-source-1.html)
  + 在对IoC有了初步的认知后，我们开始对IOC的实现原理进行深入理解。本文将帮助你站在设计者的角度去看IOC最顶层的结构设计
+ [Spring进阶 - Spring IOC实现原理详解之IOC初始化流程](https://pdai.tech/md/spring/spring-x-framework-ioc-source-2.html)
  + 上文，我们看了IOC设计要点和设计结构；紧接着这篇，我们可以看下源码的实现了：Spring如何实现将资源配置（以xml配置为例）通过加载，解析，生成BeanDefination并注册到IoC容器中的
+ [Spring进阶 - Spring IOC实现原理详解之Bean实例化(生命周期,循环依赖等)](https://pdai.tech/md/spring/spring-x-framework-ioc-source-3.html)
  + 上文，我们看了IOC设计要点和设计结构；以及Spring如何实现将资源配置（以xml配置为例）通过加载，解析，生成BeanDefination并注册到IoC容器中的；容器中存放的是Bean的定义即BeanDefinition放到beanDefinitionMap中，本质上是一个`ConcurrentHashMap<String, Object>`；并且BeanDefinition接口中包含了这个类的Class信息以及是否是单例等。那么如何从BeanDefinition中实例化Bean对象呢，这是本文主要研究的内容？
+ [Spring进阶 - Spring AOP实现原理详解之切面实现](https://pdai.tech/md/spring/spring-x-framework-aop-source-1.html)
  + 前文，我们分析了Spring IOC的初始化过程和Bean的生命周期等，而Spring AOP也是基于IOC的Bean加载来实现的。本文主要介绍Spring AOP原理解析的切面实现过程(将切面类的所有切面方法根据使用的注解生成对应Advice，并将Advice连同切入点匹配器和切面类等信息一并封装到Advisor，为后续交给代理增强实现做准备的过程)。
+ [Spring进阶 - Spring AOP实现原理详解之AOP代理](https://pdai.tech/md/spring/spring-x-framework-aop-source-2.html)
  + 上文我们介绍了Spring AOP原理解析的切面实现过程(将切面类的所有切面方法根据使用的注解生成对应Advice，并将Advice连同切入点匹配器和切面类等信息一并封装到Advisor)。本文在此基础上继续介绍，代理（cglib代理和JDK代理）的实现过程。
+ [Spring进阶 - Spring AOP实现原理详解之Cglib代理实现](https://pdai.tech/md/spring/spring-x-framework-aop-source-3.html)
  + 我们在前文中已经介绍了SpringAOP的切面实现和创建动态代理的过程，那么动态代理是如何工作的呢？本文主要介绍Cglib动态代理的案例和SpringAOP实现的原理。
+ [Spring进阶 - Spring AOP实现原理详解之JDK代理实现](https://pdai.tech/md/spring/spring-x-framework-aop-source-4.html)
  + 上文我们学习了SpringAOP Cglib动态代理的实现，本文主要是SpringAOP JDK动态代理的案例和实现部分。
+ [Spring进阶 - SpringMVC实现原理之DispatcherServlet初始化的过程](https://pdai.tech/md/spring/spring-x-framework-springmvc-source-1.html)
  + 前文我们有了IOC的源码基础以及SpringMVC的基础，我们便可以进一步深入理解SpringMVC主要实现原理，包含DispatcherServlet的初始化过程和DispatcherServlet处理请求的过程的源码解析。本文是第一篇：DispatcherServlet的初始化过程的源码解析。
+ [Spring进阶 - SpringMVC实现原理之DispatcherServlet处理请求的过程](https://pdai.tech/md/spring/spring-x-framework-springmvc-source-2.html)
  + 前文我们有了IOC的源码基础以及SpringMVC的基础，我们便可以进一步深入理解SpringMVC主要实现原理，包含DispatcherServlet的初始化过程和DispatcherServlet处理请求的过程的源码解析。本文是第二篇：DispatcherServlet处理请求的过程的源码解析。

## SpringBoot 2.5+ 
> 站在知识体系的视角，基于SpringBoot开发。@pdai

### SpringBoot入门
> 首先，在开始SpringBoot开发时，我们了解一些技术栈背景并通过Hello World级别应用程序开始延伸出SpringBoot入门应用的开发。

+ [SpringBoot入门 - SpringBoot 简介](https://pdai.tech/md/spring/springboot/springboot-x-overview.html)
  + 为什么有了SpringFramework还会诞生SpringBoot？简单而言，因为虽然Spring的组件代码是轻量级的，但它的配置却是重量级的；所以SpringBoot的设计策略是通过开箱即用和约定大于配置 来解决配置重的问题的。
+ [SpringBoot入门 - 创建第一个Hello world工程](https://pdai.tech/md/spring/springboot/springboot-x-hello-world.html)
  + 我们了解了SpringBoot和SpringFramework的关系之后，我们可以开始创建一个Hello World级别的项目了。
+ [SpringBoot入门 - 对Hello world进行MVC分层](https://pdai.tech/md/spring/springboot/springboot-x-hello-world-mvc.html)
  + 上文中我们创建一个简单的Hello Wold级别的web应用程序，但是存在一个问题，我们将所有代码都放在一个类中的, 这显然是不合理的，那么一个经典的CRUD项目如何分包呢？本文结合常见的MVC分层思路带你学习常见的包结构划分。
+ [SpringBoot入门 - 添加内存数据库H2](https://pdai.tech/md/spring/springboot/springboot-x-hello-h2-jpa.html)
  + 上文我们展示了通过学习经典的MVC分包结构展示了一个用户的增删查改项目，但是我们没有接入数据库；本文将在上文的基础上，增加一个H2内存数据库，并且通过Spring 提供的数据访问包JPA进行数据查询。
+ [SpringBoot入门 - 定制自己的Banner](https://pdai.tech/md/spring/springboot/springboot-x-hello-banner.html)
  +  我们在启动Spring Boot程序时，有SpringBoot的Banner信息，那么如何自定义成自己项目的信息呢？
+ [SpringBoot入门 - 添加Logback日志](https://pdai.tech/md/spring/springboot/springboot-x-hello-logback.html)
  + SpringBoot开发中如何选用日志框架呢？ 出于性能等原因，Logback 目前是springboot应用日志的标配； 当然有时候在生产环境中也会考虑和三方中间件采用统一处理方式。
+ [SpringBoot入门 - 配置热部署devtools工具](https://pdai.tech/md/spring/springboot/springboot-x-hello-devtool.html)
  + 在SpringBoot开发调试中，如果我每行代码的修改都需要重启启动再调试，可能比较费时间；SpringBoot团队针对此问题提供了spring-boot-devtools（简称devtools）插件，它试图提升开发调试的效率。
+ [SpringBoot入门 - 开发中还有哪些常用注解](https://pdai.tech/md/spring/springboot/springboot-x-hello-anno.html)
  + SpringBoot中常用的注解

### SpringBoot接口设计和实现

> 接着， 站在接口设计和实现的角度，从实战开发中梳理出，关于接口开发的技术要点。

+ [SpringBoot接口 - 如何统一接口封装](https://pdai.tech/md/spring/springboot/springboot-x-interface-response.html)
  + 在以SpringBoot开发Restful接口时，统一返回方便前端进行开发和封装，以及出现时给出响应编码和信息。
+ [SpringBoot接口 - 如何对参数进行校验](https://pdai.tech/md/spring/springboot/springboot-x-interface-param.html)
  + 在以SpringBoot开发Restful接口时, 对于接口的查询参数后台也是要进行校验的，同时还需要给出校验的返回信息放到上文我们统一封装的结构中。那么如何优雅的进行参数的统一校验呢？
+ [SpringBoot接口 - 如何参数校验国际化](https://pdai.tech/md/spring/springboot/springboot-x-interface-param-i18n.html)
  + 上文我们学习了如何对SpringBoot接口进行参数校验，但是如果需要有国际化的信息，应该如何优雅处理呢？
+ [SpringBoot接口 - 如何统一异常处理](https://pdai.tech/md/spring/springboot/springboot-x-interface-exception.html)
  + SpringBoot接口如何对异常进行统一封装，并统一返回呢？以上文的参数校验为例，如何优雅的将参数校验的错误信息统一处理并封装返回呢？
+ [SpringBoot接口 - 如何提供多个版本接口](https://pdai.tech/md/spring/springboot/springboot-x-interface-version.html)
  + 在以SpringBoot开发Restful接口时，由于模块，系统等业务的变化，需要对同一接口提供不同版本的参数实现（老的接口还有模块或者系统在用，不能直接改，所以需要不同版本）。如何更加优雅的实现多版本接口呢？
+ [SpringBoot接口 - 如何生成接口文档](https://pdai.tech/md/spring/springboot/springboot-x-interface-doc.html)
  + SpringBoot开发Restful接口，有什么API规范吗？如何快速生成API文档呢？
+ [SpringBoot接口 - 如何访问外部接口](https://pdai.tech/md/spring/springboot/springboot-x-interface-3rd.html)
  + 在SpringBoot接口开发中，存在着本模块的代码需要访问外面模块接口或外部url链接的需求, 比如调用外部的地图API或者天气API。那么有哪些方式可以调用外部接口呢？
+ [SpringBoot接口 - 如何对接口进行加密](https://pdai.tech/md/spring/springboot/springboot-x-interface-jiami.html)
  + 在以SpringBoot开发后台API接口时，会存在哪些接口不安全的因素呢？通常如何去解决的呢？本文主要介绍API**接口有不安全的因素**以及**常见的保证接口安全的方式**，重点**实践如何对接口进行签名**。
+ [SpringBoot接口 - 如何保证接口幂等](https://pdai.tech/md/spring/springboot/springboot-x-interface-mideng.html)
  + 在以SpringBoot开发Restful接口时，如何防止接口的重复提交呢？ 本文主要介绍接口幂等相关的知识点，并实践常见基于Token实现接口幂等。
+ [SpringBoot接口 - 如何实现接口限流之单实例](https://pdai.tech/md/spring/springboot/springboot-x-interface-xianliu.html)
  + 在以SpringBoot开发Restful接口时，当流量超过服务极限能力时，系统可能会出现卡死、崩溃的情况，所以就有了降级和限流。在接口层如何做限流呢？ 本文主要回顾限流的知识点，并实践单实例限流的一种思路。
+ [SpringBoot接口 - 如何实现接口限流之分布式](https://pdai.tech/md/spring/springboot/springboot-x-interface-xianliu-dist.html)
  + 上文中介绍了单实例下如何在业务接口层做限流，本文主要介绍分布式场景下限流的方案，以及什么样的分布式场景下需要在业务层加限流而不是接入层; 并且结合kailing开源的[ratelimiter-spring-boot-starter](https://gitee.com/kailing/ratelimiter-spring-boot-starter)为例， 学习**思路+代码封装+starter封装**。

### SpringBoot集成MySQL(JPA,MyBatis,MyBatis-Plus)
> 接下来，我们学习SpringBoot如何集成数据库，比如MySQL数据库，常用的方式有JPA和MyBatis。

+ [SpringBoot集成MySQL - 基于JPA的封装](https://pdai.tech/md/spring/springboot/springboot-x-mysql-jpa.html)
  + 在实际开发中，最为常见的是基于数据库的CRUD封装等，比如SpringBoot集成MySQL数据库，常用的方式有JPA和MyBatis； 本文主要介绍基于JPA方式的基础封装思路。
+ [SpringBoot集成MySQL - MyBatis XML方式](https://pdai.tech/md/spring/springboot/springboot-x-mysql-mybatis-xml.html)
  + 上文介绍了用JPA方式的集成MySQL数据库，JPA方式在中国以外地区开发而言基本是标配，在国内MyBatis及其延伸框架较为主流。本文主要介绍**MyBatis技栈的演化**以及**SpringBoot集成基础的MyBatis XML实现方式**的实例。
+ [SpringBoot集成MySQL - MyBatis 注解方式](https://pdai.tech/md/spring/springboot/springboot-x-mysql-mybatis-anno.html)
  + 上文主要介绍了Spring集成MyBatis访问MySQL，采用的是XML配置方式；我们知道除了XML配置方式，MyBatis还支持注解方式。本文主要介绍SpringBoot+MyBatis注解方式。
+ [SpringBoot集成MySQL - MyBatis PageHelper分页](https://pdai.tech/md/spring/springboot/springboot-x-mysql-mybatis-page.html)
  + 前文中，我们展示了Spring Boot与MyBatis的集成，但是没有展示分页实现。本文专门介绍分页相关知识体系和基于MyBatis的物理分页PageHelper。
+ [SpringBoot集成MySQL - MyBatis 多个数据源](https://pdai.tech/md/spring/springboot/springboot-x-mysql-mybatis-multi-ds.html)
  + 前文介绍的SpringBoot集成单个MySQL数据库的情形，那么什么场景会使用多个数据源以及什么场景会需要多个数据源的动态切换呢？本文主要介绍上述场景及SpringBoot+MyBatis实现多个数据源的方案和示例。
+ [SpringBoot集成MySQL - MyBatis-Plus方式](https://pdai.tech/md/spring/springboot/springboot-x-mysql-mybatis-plus.html)
  + MyBatis-Plus（简称 MP）是一个 MyBatis的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。MyBatis-Plus在国内也有很多的用户，本文主要介绍MyBatis-Plus和SpringBoot的集成。
+ [SpringBoot集成MySQL - MyBatis-Plus代码自动生成](https://pdai.tech/md/spring/springboot/springboot-x-mysql-mybatis-plus-gen.html)
  + 本文主要介绍 MyBatis-Plus代码自动生成，以及产生此类代码生成工具的背景和此类工具的基本实现原理。
+ [SpringBoot集成MySQL - MyBatis-Plus基于字段隔离的多租户](https://pdai.tech/md/spring/springboot/springboot-x-mysql-mybatis-plus-multi-tenant.html)
  + 本文主要介绍 MyBatis-Plus的基于字段隔离的多租户实现，以及MyBatis-Plus的基于字段的隔离方式实践和原理。

### SpringBoot集成ShardingJDBC
> 随着数据量和业务的增长，我们还需要进行分库分表，这里主要围绕ShardingSphere中间件来实现分库分表，读写分离和多租户等。

+ [SpringBoot集成ShardingJDBC - Sharding-JDBC简介和基于MyBatis的单库分表](https://pdai.tech/md/spring/springboot/springboot-x-mysql-shardingjdbc.html)
  + 本文主要介绍分表分库，以及SpringBoot集成基于ShardingJDBC的单库分表实践。
+ [SpringBoot集成ShardingJDBC - 基于JPA的单库分表](https://pdai.tech/md/spring/springboot/springboot-x-mysql-shardingjdbc-jpa.html)
  + 上文介绍SpringBoot集成基于ShardingJDBC的读写分离实践，本文在此基础上介绍SpringBoot集成基于ShardingJDBC+JPA的单库分表实践。
+ [SpringBoot集成ShardingJDBC - 基于JPA的读写分离](https://pdai.tech/md/spring/springboot/springboot-x-mysql-shardingjdbc-jpa-masterslave.html)
  + 本文主要介绍分表分库，以及SpringBoot集成基于ShardingJDBC的读写分离实践。
+ [SpringBoot集成ShardingJDBC - 基于JPA的DB隔离多租户方案](https://pdai.tech/md/spring/springboot/springboot-x-mysql-shardingjdbc-jpa-tenant-db.html)
  + 本文主要介绍ShardingJDBC的分片算法和分片策略，并在此基础上通过SpringBoot集成ShardingJDBC的几种策略（标准分片策略，行表达式分片策略和hint分片策略）向你展示DB隔离的多租户方案。

### SpringBoot集成连接池(HikariCP,Druid)
> 为了提高对数据库操作的性能，引出了数据库连接池，它负责分配、管理和释放数据库连接。历史舞台上出现了C3P0，DBCP，BoneCP等均已经被淘汰，目前最为常用（也是SpringBoot2标配的）是HikariCP，与此同时国内阿里Druid（定位为基于数据库连接池的监控）也有一些市场份额。

+ [SpringBoot集成连接池 - 数据库连接池和默认连接池HikariCP](https://pdai.tech/md/spring/springboot/springboot-x-mysql-HikariCP.html)
  + 本文主要介绍数据库连接池，以及SpringBoot集成默认的HikariCP的实践。
+ [SpringBoot集成连接池 - 集成数据库Druid连接池](https://pdai.tech/md/spring/springboot/springboot-x-mysql-druid.html)
  + 上文介绍默认数据库连接池HikariCP，本文主要介绍SpringBoot集成阿里的Druid连接池的实践; 客观的来说，阿里Druid只能说是中文开源中功能全且广泛的连接池为基础的监控组件，但是（仅从连接池的角度）在生态，维护性，开源规范性，综合性能等方面和HikariCP比还是有很大差距。

### SpringBoot集成数据迁移(Liquibase,Flayway)
> 在实际上线的应用中，随着版本的迭代，经常会遇到需要变更数据库表和字段，必然会遇到需要对这些变更进行记录和管理，以及回滚等等；同时只有脚本化且版本可管理，才能在让数据库实现真正的DevOps（自动化执行 + 回滚等）。在这样的场景下出现了Liquibase, Flayway等数据库迁移管理工具。

+ [SpringBoot数据库管理 - 用Liquibase对数据库管理和迁移](https://pdai.tech/md/spring/springboot/springboot-x-mysql-liquibase.html)
  + Liquibase是一个用于**用于跟踪、管理和应用数据库变化的开源工具**，通过日志文件(changelog)的形式记录数据库的变更(changeset)，然后执行日志文件中的修改，将数据库更新或回滚(rollback)到一致的状态。它的目标是提供一种数据库类型无关的解决方案，通过执行schema类型的文件来达到迁移。本文主要介绍SpringBoot与Liquibase的集成。
+ [SpringBoot数据库管理 - 用flyway对数据库管理和迁移](https://pdai.tech/md/spring/springboot/springboot-x-mysql-flyway.html)
  + 上文介绍了Liquibase，以及和SpringBoot的集成。除了Liquibase之外，还有一个组件Flyway也是经常被使用到的类似的数据库版本管理中间件。本文主要介绍Flyway, 以及SpringBoot集成Flyway。

### SpringBoot集成PostgreSQL
> 在企业级应用场景下开源数据库PostgreSQL对标的是Oracle，它的市场份额稳步攀升，并且它在自定义函数，NoSQL等方面也支持，所以PostgreSQL也是需要重点掌握的。

+ [SpringBoot集成Postgre - 基于JPA封装基础数据操作](https://pdai.tech/md/spring/springboot/springboot-x-postgre-jpa.html)
+ [SpringBoot集成Postgre - NoSQL特性JSONB的封装](https://pdai.tech/md/spring/springboot/springboot-x-postgre-jpa-jsonb.html)

### SpringBoot集成Redis
> 学习完SpringBoot和SQL数据库集成后，我们开始学习NoSQL数据库的开发和集成；最终要的是分布式的缓存库Redis，它是最为常用的key-value库。

+ [SpringBoot集成Redis - 基于RedisTemplate+Jedis的数据操作](https://pdai.tech/md/spring/springboot/springboot-x-redis-jedis.html)

### SpringBoot集成MongoDB
+ [SpringBoot集成MongoDB - 基于MongoTemplate的数据操作](https://pdai.tech/md/spring/springboot/springboot-x-mongodb-template.html)

### SpringBoot集成ElasticSearch

+ [SpringBoot集成ElasticSearch - 基于ElasticSearchTemplate的数据操作](https://pdai.tech/md/spring/springboot/springboot-x-elastic-template.html)


### SpringBoot集成Websocket
> 进一步，我们看下SpringBoot集成Socket

+ [SpringBoot集成Socket - 基础的Websocket实现](https://pdai.tech/md/spring/springboot/springboot-x-socket-websocket.html)
+ [SpringBoot集成Socket - 用Netty实现socket](https://pdai.tech/md/spring/springboot/springboot-x-socket-netty.html)

### SpringBoot集成定时任务(springtask,quartz,elastic-job,xxl-job)
> 开发中常用的还有定时任务，我们看下SpringBoot集成定时任务

+ [SpringBoot定时任务 - Timer实现方式](https://pdai.tech/md/spring/springboot/springboot-x-task-timer.html)
  + 定时任务在实际开发中有着广泛的用途，本文主要帮助你构建定时任务的知识体系，同时展示Timer 的schedule和scheduleAtFixedRate例子；后续的文章中我们将逐一介绍其它常见的与SpringBoot的集成。
+ [SpringBoot定时任务 - ScheduleExecutorService实现方式](https://pdai.tech/md/spring/springboot/springboot-x-task-executor-timer.html)
  + 上文介绍的Timer在实际开发中很少被使用， 因为Timer底层是使用一个单线程来实现多个Timer任务处理的，所有任务都是由同一个线程来调度，所有任务都是串行执行。而ScheduledExecutorService是基于线程池的，可以开启多个线程进行执行多个任务，每个任务开启一个线程； 这样任务的延迟和未处理异常就不会影响其它任务的执行了。
+ [SpringBoot定时任务 - Spring tasks实现方式](https://pdai.tech/md/spring/springboot/springboot-x-task-spring-task-timer.html)
  + Timer和ScheduledExecutorService是JDK内置的定时任务方案，而主流的SpringBoot集成方案有两种，一种是Spring Sechedule, 另一种是Spring集成Quartz； 本文主要介绍Spring Schedule实现方式。
+ [SpringBoot定时任务 - Netty HashedWheelTimer方式](https://pdai.tech/md/spring/springboot/springboot-x-task-hashwheeltimer-timer.html)
+ [SpringBoot定时任务 - 基础quartz实现方式](https://pdai.tech/md/spring/springboot/springboot-x-task-quartz-timer.html)
  + 除了SpringTask，最为常用的Quartz，并且Spring也集成了Quartz的框架。本文主要介绍Quartz和基础的Quartz的集成案例。
+ [SpringBoot定时任务 - 分布式quartz cluster方式](https://pdai.tech/md/spring/springboot/springboot-x-task-quartz-cluster-timer.html)
  + 通常我们使用quartz只是实现job单实例运行，本例将展示quartz实现基于数据库的分布式任务管理，和控制job生命周期。
+ [SpringBoot定时任务 - 分布式elastic-job方式](https://pdai.tech/md/spring/springboot/springboot-x-task-elastic-job-timer.html)
+ [SpringBoot定时任务 - 分布式xxl-job方式](https://pdai.tech/md/spring/springboot/springboot-x-task-xxl-job-timer.html)

### SpringBoot集成后端视图(Thymeleaf)
> SpringBoot集成后端视图

+ [SpringBoot后端视图 - 基于Thymeleaf视图解析](https://pdai.tech/md/spring/springboot/springboot-x-view-thymeleaf.html)


### SpringBoot集成监控(acturator,springboot-admin)
> SpringBoot集成监控

+ [SpringBoot监控 - 集成acturator监控工具](https://pdai.tech/md/spring/springboot/springboot-x-monitor-actuartor.html)
  + 当SpringBoot的应用部署到生产环境中后，如何监控和管理呢？比如审计日志，监控状态，指标收集等。为了解决这个问题，SpringBoot提供了Actuator。本文主要介绍Spring Boot Actuator及实现案例。
+ [SpringBoot监控 - 集成springboot admin监控工具](https://pdai.tech/md/spring/springboot/springboot-x-monitor-boot-admin.html)
  + 上文中展示了SpringBoot提供了Actuator对应用进行监控和管理， 而Spring Boot Admin能够将 Actuator 中的信息进行界面化的展示，也可以监控所有 Spring Boot 应用的健康状况，提供实时警报功能。 本文主要介绍springboot admin以及SpringBoot和springboot admin的集成。

### SpringBoot进阶
> SpringBoot进阶

+ [SpringBoot进阶 - 实现自动装配原理](https://pdai.tech/md/spring/springboot/springboot-y-auo-config.html)
+ [SpringBoot进阶 - 自定义starter](https://pdai.tech/md/spring/springboot/springboot-y-starter.html)
  + 如何将自己的模块封装成starter， 并给其它springBoot项目使用呢？ 本文主要介绍在Springboot封装一个自定义的Starter的一个Demo，从创建一个模块->封装starter->使用
+ [SpringBoot进阶 - 嵌入web容器Tomcat原理](https://pdai.tech/md/spring/springboot/springboot-y-wrap-tomcat.html)
+ [SpringBoot进阶 - 健康检查Acturator原理](https://pdai.tech/md/spring/springboot/springboot-y-th-actuartor.html)