package db

import play.api.mvc.RequestHeader

import models._
import utils.Constant._

object MockCareers extends ICareer {

  // careers
  object career1 extends Career("147a8302c32b412dace1f3627a574ca5", "Mobile Marketing Manager", "http://www.balloon.com/api/careers/147a8302c32b412dace1f3627a574ca5", "Mobile Marketing Managers are responsible for the reation, planning, design, execution and delivery of mobile marketing campaigns and activity to drive ROI for the business.")

  object career2 extends Career("35652eb64a97451a87d95f80d947a4de", "Android Developer", "http://www.balloon.com/api/careers/35652eb64a97451a87d95f80d947a4de", "Android Developers work closely with clients, developers and designers to create applications for the Google Android platform.")

  object career3 extends Career("4d1ebcf47a0c44b78d4b7ba0fe0d1796", "Mobile Product Manager", "http://www.balloon.com/api/careers/4d1ebcf47a0c44b78d4b7ba0fe0d1796", "Mobile Product Managers are responsible for driving mobile product initiatives to achieve specific business goals, including mobile product development cycle, product requirements, success metrics, and ongoing management and adoption.")

  object career4 extends Career("5cec9c1b792340f182ac52c0118787da", "Mobile Game Developer", "http://www.balloon.com/api/careers/5cec9c1b792340f182ac52c0118787da", "Mobile game developers create and produce games for smart phones, tablets and other mobile devices. The job encompasses a wide variety of tasks: creating the gameÕs look and how it plays; animating characters and objects; creating the audio; programming; testing and production.")

  object career5 extends Career("84fcf05567854c3a9f22b5890192cbab", "Mobile Designer", "http://www.balloon.com/api/careers/84fcf05567854c3a9f22b5890192cbab", "Mobile Designers are responsible for employing user experience design techniques to conceptualize, build, and support mobile applications and websites from concept to launch.")

  object career6 extends Career("954abfdd72414c088843ec78ff3cec6d", "Mobile Analyst", "http://www.balloon.com/api/careers/954abfdd72414c088843ec78ff3cec6d", "Mobile Analysts are responsible for analyzing and evaluating mobile device products and systems available in the marketplace, providing end-user requirements to the development team, recommending to management the support or nonsupport of evaluated products and participating in the development and customization of products.")

  object career7 extends Career("96a2876766c6448e90a4e9c6efdb745f", "Mobile Developer", "http://www.balloon.com/api/careers/96a2876766c6448e90a4e9c6efdb745f", "Mobile Developers build hybrid and web applications using the latest technologies and frameworks, integrating 3rd party SDKs, building digital products with various software platforms and interacting with internal clients to determine requirements and architecture")

  object career8 extends Career("9b932798d9634b3f8246ab108815d3c1", "Mobile Application Architect", "http://www.balloon.com/api/careers/9b932798d9634b3f8246ab108815d3c1", "Mobile application architects handle a wide range of design activities related to translating business requirements into specific mobile systems (smartphones, tablet). At the senior level or higher, they need to have deep knowledge across multiple mobility platforms, processes or architectures, as well as broad knowledge of new technologies and device architectures.")

  object career9 extends Career("a7c3df7f593e4091ab746969e7089468", "Mobile Architect", "http://www.balloon.com/api/careers/a7c3df7f593e4091ab746969e7089468", "Mobile Architects are responsible for translating mobile/wireless business requirements into specific system, application or process designs.")

  object career10 extends Career("b52594fd395041038a4d3fa4bdf7d17f", "Mobile Testing Engineer", "http://www.balloon.com/api/careers/b52594fd395041038a4d3fa4bdf7d17f", "Mobile Testing Engineers work closing with product and development teams to develop a robust suite of manual and automated mobile tests for mobile applications and execute these tests for regular application releases.")

  object career11 extends Career("cff09eeb10a0488fa9cd9c35f5253018", "Mobile Device Technician", "http://www.balloon.com/api/careers/cff09eeb10a0488fa9cd9c35f5253018", "Mobile Device Technicians are responsible for providing service and support to mobile device end users by configuring new devices, guiding users on application installation and device functionality and delivering a high degree of customer service to troubleshoot and resolve problems.")

  object career12 extends Career("f7bc71513b1444c2842ce53d3e8c00ea", "iOS Developer", "http://www.balloon.com/api/careers/f7bc71513b1444c2842ce53d3e8c00ea", "iOS Developers create and design mobile applications for the iPhone, iPad, and mobile devices running Apple\'s iOS operating system.")


  override def getAll(params: Map[String, Any] = Map[String, Any](), orderBy : String = ORDER_BY_DEFAULT, sortOrder : String = SORT_ORDER_DEFAULT,  page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[Career] = List(career1, career2, career3, career4, career5, career6, career7, career8, career9, career10, career11, career12)

  override def update(id: String, data: Map[String, Any])(implicit request: RequestHeader): Option[Career] = ???

  override def delete(id: String)(implicit request: RequestHeader): Int = ???

  override def create(entity: Career, flush : Boolean = false)(implicit request: RequestHeader): Int = ???

  override def get(id: String)(implicit request: RequestHeader): Option[Career] = ???
}

object MockCategories extends ICategory {

  object category1 extends Category("aa5c82e8a1af46a9997dd87d01e58be2", "Mobile", "http://www.balloon.com/api/categorys/aa5c82e8a1af46a9997dd87d01e58be2", "As the devices we use to manage our work and personal lives get smaller, the demand for mobile professionals is only getting bigger. Whether youÕre an app developer or a mobile marketing pro, in this field itÕs important to keep up with the ever-evolving technologies, coding languages and user demands.")

  override def getAll(params: Map[String, Any] = Map[String, Any](), orderBy : String = ORDER_BY_DEFAULT, sortOrder : String = SORT_ORDER_DEFAULT, page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[Category] = List(category1)

  override def update(id: String, data: Map[String, Any])(implicit request: RequestHeader): Option[Category] = ???

  override def delete(id: String)(implicit request: RequestHeader): Int = ???

  override def create(entity: Category, flush : Boolean = false)(implicit request: RequestHeader): Int = ???

  override def get(id: String)(implicit request: RequestHeader): Option[Category] = ???
}

object MockCourses extends ICourse {

  object course1 extends Course("01b5979d087e485da17de1c4f48255b9", "Web Fundamentals and Design", "http://www.balloon.com/api/courses/01b5979d087e485da17de1c4f48255b9", "In this 5-day course, you will learn the most up-to-date methods for  designing web pages using HTML 4.01 and XHTML 1.0 as established by the W3C  within a Web Standards framework. Gain the skills you need to design a truly  attractive and fully functional web site as you learn the fundamentals of HTML  layout and design and master dynamic technologies including Cascading Style  Sheets (CSS) and JavaScript.")

  object course2 extends Course("123f2ce6dc2842478078e2d72ed6178a", "Loops", "http://www.balloon.com/api/courses/123f2ce6dc2842478078e2d72ed6178a", "Loops allow you to quickly iterate over information in Python. In this lesson, we\'ll cover two types of loop: \'while\' and \'for\'.")

  object course3 extends Course("17f0faa1786f4397a9e7af213390d099", "Student Becomes the Teacher", "http://www.balloon.com/api/courses/17f0faa1786f4397a9e7af213390d099", "Use what you\'ve learned so far to manage your own class.")

  object course4 extends Course("1a815c84c58c40d891d5db98086bfb49", "Lists and Functions", "http://www.balloon.com/api/courses/1a815c84c58c40d891d5db98086bfb49", "Now that you\'ve learned about lists, let\'s turbo-charge them with functions.")

  object course5 extends Course("1de452a7ba5040839165944a89bcdb27", "Strings & Console Output", "http://www.balloon.com/api/courses/1de452a7ba5040839165944a89bcdb27", "This course will introduce you to strings and console output in Python, including creating string literals, calling a variety of string methods, and using the \"print\" keyword.")

  object course6 extends Course("24495d3e5a3446eea1fef5e9d9b88053", "Building JEE Web Applications", "http://www.balloon.com/api/courses/24495d3e5a3446eea1fef5e9d9b88053", "In this comprehensive course, you will learn how to design and program servlets and JSPs, including all the important concepts and hands-on labs that will have you building working server-side applications.  You will gain core JEE knowledge and skills used as the foundation for developing production-quality web applications to a basic level. Throughout this training, you will be confronted with common web application design problems and given the tools you will need to solve them, such as JEE design patterns. You will also be exposed to a range of JEE and web technologies such as Servlets, JSPs, EJBs, JNDI, XML, and advice on when and how to use them. You will learn about the capabilities of servlets, their advantages, servlet architecture, and session management.  You will also learn about JSP syntax, deployment, and application models, how to use Java as a scripting language, how to use custom tags, and how to build robust and capable web applications using Servlets and JSP.  You will begin with web application architecture. A major part of the course is spent on servlets and JavaServer pages (JSP). You will cover interacting databases using JDBC, Java\'s database access technology.  The course includes an introduction to web services.  You will create code for an online store and learn not only specific topics and APIs but also how to fit the pieces together into a complete application.  You will leave the course armed with the required skills to design and build scalable, secure, maintainable web applications.")

  object course7 extends Course("2c7c4a4db36f4be69a4588b26820432f", "Developing Applications for IBM WebSphere Portal 7.0", "http://www.balloon.com/api/courses/2c7c4a4db36f4be69a4588b26820432f", "This course is designed for users who are new to developing applications for WebSphere Portal Server 7.0. You will learn the fundamentals of designing and creating portlets, and move on to put to use of the new features. Specialized topics include migrating a 6.1 theme to the new version 7.0 theme architecture using Client Side Aggregation V2 (CSA2), developing custom themes using CSA2, and customizing the user interface for tagging and rating. You will learn about iWidgets for the Mashup Center and gain experience customizing and using these for a WebSphere Portal 7.0 site. In addition, you will have the opportunity to apply best coding practices throughout the course, developing robust portlet applications and portal themes using Dojo, AJAX and client-side aggregation. This course makes extensive use of Rational Application Developer 8.0.1 to develop and test JSR 286 compliant portlets.")

  object course8 extends Course("3006db25574b497b9397a1616a815467", "A Day at the Supermarket", "http://www.balloon.com/api/courses/3006db25574b497b9397a1616a815467", "Let\'s manage our own supermarket and buy some goods along the way!")

  object course9 extends Course("37fd37d05cb847098dac4be7cdcfae40", "PygLatin", "http://www.balloon.com/api/courses/37fd37d05cb847098dac4be7cdcfae40", "In this project we\'ll put together all of the Python skills we\'ve learned so far including string manipulation and branching.  We\'ll be building a Pyg Latin translator.  (That\'s Pig Latin for Python Programmers!)")

  object course10 extends Course("3e0fcd8980b547f49066be8b1a8d1d76", "Review of Functions in JavaScript", "http://www.balloon.com/api/courses/3e0fcd8980b547f49066be8b1a8d1d76", "A quick overview of functions, how to define them, and how variable scope affects when and where variables can be accessed within functions.")

  object course11 extends Course("51ffbfe860ac4e70909946d1e34ba99b", "Introduction to Web Development with Microsoft Visual Studio 2010", "http://www.balloon.com/api/courses/51ffbfe860ac4e70909946d1e34ba99b", "In this five-day, instructor-led course, you will gain the knowledge and skills to develop web applications with Microsoft Visual Studio 2010. In 14 hands-on labs, you\'ll learn the basics, from creating web applications using Visual Studio 2010 and .NET-based languages to implementing advanced technologies supported by Visual Studio 2010 for web development.  Global Knowledge Exclusive!  Continue developing your skills after class with 24/7 access to our live   remote labs for six months, providing you with valuable extra time for hands-on   practice.")

  object course12 extends Course("5acbc37475484697952fbaecac47ac01", "Introduction to Functions in JS", "http://www.balloon.com/api/courses/5acbc37475484697952fbaecac47ac01", "This course introduces functions, why we use them, and how to use them. The course also combines functions with other programming concepts previously learned.")

  object course13 extends Course("6409d7b531174e7c90dc7a2055ee5c39", "SWSA - Securing the Web with Cisco Web Security Appliance", "http://www.balloon.com/api/courses/6409d7b531174e7c90dc7a2055ee5c39", "In this comprehensive two-day course containing hands-on labs, demos, and presentations, you will learn to install, configure, operate, and maintain the S-Series web security appliances. You will focus on HTTP and HTTPS proxy services, L4 traffic monitoring, authentication and web access control, URL filtering, anti-malware filtering, troubleshooting S-Series configuration issues, and S-Series deployment. Hands-on labs provide you with a safe environment to experiment with malware and attempt configurations that might not be appropriate for a production network.")

  object course14 extends Course("6c27ae9873334ca995b2ff222d1f14ef", ".NET Web Developer", "http://www.balloon.com/api/courses/6c27ae9873334ca995b2ff222d1f14ef", "In this 5-day course, you will learn the fundamentals of building interactive,  dynamic web applications using the .NET framework. You\'ll learn the essentials  of the framework using either C# or VB.NET - with examples and exercises  provided in both - and get an introduction to the .NET base class library. Then,  move on to ASP.NET and learn to put your skills to use building interactive,  feature-rich web pages.")

  object course15 extends Course("72c9af43678145c8ac621e79261a4241", "Taking a Vacation", "http://www.balloon.com/api/courses/72c9af43678145c8ac621e79261a4241", "Hard day at work? Rough day at school? Take a load off with a programming vacation!")

  object course16 extends Course("743a0eaac80a4b31bc8b3676a7366a75", "Introduction to Web Development with Microsoft Visual Studio 2010", "http://www.balloon.com/api/courses/743a0eaac80a4b31bc8b3676a7366a75", "In this five-day, instructor-led course, you will gain the knowledge and skills to develop web applications with Microsoft Visual Studio 2010. In 14 hands-on labs, you\'ll learn the basics, from creating web applications using Visual Studio 2010 and .NET-based languages to implementing advanced technologies supported by Visual Studio 2010 for web development.  Global Knowledge Exclusive!  Continue developing your skills after class with 24/7 access to our live   remote labs for six months, providing you with valuable extra time for hands-on   practice.")

  object course17 extends Course("74ef596c07a14890b2ad4dadc8ee22c1", "Developing Windows Azure and Web Services", "http://www.balloon.com/api/courses/74ef596c07a14890b2ad4dadc8ee22c1", "In this course, you will learn to design and develop services that access   local and remote data from various data sources. You will also learn to develop   and deploy services to hybrid environments, including on-premises servers and   Windows Azure.  This course incorporates materials from the Official Microsoft Learning   Product 20487: Developing Windows Azure and Web Services.  Global Knowledge Exclusive!  Continue developing your skills after class with 24/7 access to our live   remote labs for six months, providing you with valuable extra time for hands-on   practice.")

  object course18 extends Course("770380fa9cba47f19c98909d7a4d9e66", "Developing Web Applications with Microsoft Visual Studio 2010", "http://www.balloon.com/api/courses/770380fa9cba47f19c98909d7a4d9e66", "Develop advanced ASP.NET MVC and Web Forms applications using .NET Framework 4 tools and technologies. Through 15 hands-on labs, you will practice coding activities that can enhance the performance and scalability of web site applications. During the course, you will compare ASP.NET MVC with Web Forms and learn when each should/could be used.    Also, this course will prepare you for Exam 70-515: TS: Web Applications Development with Microsoft .NET Framework 4. Success on Exam 70-515 earns you the MCTS: .NET Framework 4, Web Applications certification and credit towards MCPD: Web Developer 4 certification.  Global Knowledge Exclusive!  Continue developing your skills after class with 24/7 access to our live   remote labs for six months, providing you with valuable extra time for hands-on   practice.")

  object course19 extends Course("78fe2391583a47cf9d35a1028f203432", "Administration of IBM WebSphere DataPower SOA Appliances V4.0", "http://www.balloon.com/api/courses/78fe2391583a47cf9d35a1028f203432", "In this 3-day course, students learn how to perform system administration tasks for the IBM WebSphere DataPower SOA Appliances.  The IBM WebSphere DataPower SOA Appliances allow users to simplify, accelerate, and enhance the security capabilities of Extensible Markup Language (XML) and web services deployments, and extend the capabilities of a service-oriented architecture (SOA) infrastructure.  Through instructor-led lectures and hands-on lab exercises, students learn how to perform various administrative procedures, from initial installation and setup through ongoing maintenance of the appliances in production. Students learn about the available management interfaces, such as the command-line interface (CLI), Web GUI, and XML Management Interface. Students also learn how to use these interfaces to perform various administrative tasks, such as upgrading firmware, performing backup and restore operations, monitoring system performance, and configuring user accounts and domains.  This course applies to all appliances in the family of WebSphere DataPower SOA Appliances, including:  WebSphere DataPower XML Accelerator XA35  WebSphere DataPower XML Security Gateway XS40  WebSphere DataPower Integration Appliance XI50  WebSphere DataPower Integration Blade XI50B  WebSphere DataPower Integration Blade XI50z  WebSphere DataPower B2B Appliance XB60  WebSphere DataPower Low Latency Appliance XM70")

  object course20 extends Course("84d791d44eaf4df99c5bc38639ea21f0", "Code\'n\'Tell", "http://www.balloon.com/api/courses/84d791d44eaf4df99c5bc38639ea21f0", "Apply your jQuery learning to build your own project!")

  object course21 extends Course("89eb65f3f595491a8627cfda451bc6f0", "Build \"Rock, Paper, Scissors\"", "http://www.balloon.com/api/courses/89eb65f3f595491a8627cfda451bc6f0", "Make use of functions to program this game.")

  object course22 extends Course("8b234f421f244b29ba6382ece77ee082", "Classes", "http://www.balloon.com/api/courses/8b234f421f244b29ba6382ece77ee082", "Make your own Car and learn how to driveCar()!")

  object course23 extends Course("8dbf49befef540c4b9eb3d5940f0aeba", "Building a Cash Register", "http://www.balloon.com/api/courses/8dbf49befef540c4b9eb3d5940f0aeba", "The cash register has failed and the boss is not happy, help save the day and create your own cash register.")

  object course24 extends Course("8f2a6694459545bbb4405fc12fced331", "Getting Started with Programming", "http://www.balloon.com/api/courses/8f2a6694459545bbb4405fc12fced331", "Time to become a coding ninja.")

  object course25 extends Course("9029d82f19d548ccbaf76b375ba7fc5f", "Mastering SOA and JEE Web Services", "http://www.balloon.com/api/courses/9029d82f19d548ccbaf76b375ba7fc5f", "In this course, you will be introduced to the fundamentals of Service Oriented Architectures (SOA) and the core standards that enable web services.  You will focus on what separates an ad hoc set of web services (NOT SOA) from a managed, vibrant, reusable catalog of enterprise services (definitely SOA).  You will examine the entire spectrum from the promise of cloud computing to the grit of XML content.  You will get a clear picture of how a service orientation can fundamentally change the dynamics of how software is developed and \"lives\" within an enterprise.  You will gain a better understanding of the fundamental technologies used in web services.  This understanding is critical to being able to diagnose, troubleshoot, tune, and perform other lifecycle activities. You will leave the course armed with the required skills to design, implement, test, and support J2EE web services.")

  object course26 extends Course("918a11bbdf8a4551b1bfa83d2a276e8e", "Securing .Net Web Applications - Lifecycle", "http://www.balloon.com/api/courses/918a11bbdf8a4551b1bfa83d2a276e8e", "This course will arm you with the skills required to recognize actual and   potential software vulnerabilities, implement defenses for those   vulnerabilities, and test those defenses for sufficiency. You will be introduced   to the most common security vulnerabilities faced by web applications today.   Each vulnerability will be examined from a .Net perspective through a process of   describing the threat and attack mechanisms, recognizing associated   vulnerabilities, and designing, implementing, and testing effective defenses.   You will learn basic programming skills, and dig deep into sound processes and   practices that apply to the entire software development lifecycle. Multiple   practical labs reinforce these concepts with real vulnerabilities and attacks.   You will also design and implement the layered defenses needed to defend your   own applications.  You will thoroughly examine best practices for defensively coding .Net web   applications, including XML processing and web services. You will   repeatedly attack and then defend various assets associated with a   fully-functional web application. This hands-on approach drives home the   mechanics of how to secure .Net web applications in the most practical of terms.  This course is a companion course with several developer-oriented courses and   seminars. Although this edition of the course is .Net-specific, it may also be   presented using Java or other programming languages. The comprehensive   application security and secure coding courses address each of these critical   issues head-on:    	Teach programmers what these errors are   	Demonstrate, in real terms, the potential impact of each of these   	errors   	Recognize and properly address these errors   	How to defend against the potential consequences of security   	breaches in other parts of their IT infrastructure.  	Cross-reference materials, vulnerabilities, and attacks that are   	covered with both the")

  object course27 extends Course("91bcceedd89842c88e2bc5a0d0aa0961", "Conditionals & Control Flow", "http://www.balloon.com/api/courses/91bcceedd89842c88e2bc5a0d0aa0961", "In this course, we\'ll learn how to create programs that generate different outcomes based on user input!")

  object course28 extends Course("98288503a38042cf820aa33557b296c7", "Adobe Photoshop CS6 Advanced: Web and Video", "http://www.balloon.com/api/courses/98288503a38042cf820aa33557b296c7", "In this course, you will increase your effectiveness in Photoshop and learn to work with web and video images.")

  object course29 extends Course("99a1394cb91e41e9a66871850b208a13", "Object-Oriented Coding for Mobile Development (Java)", "http://www.balloon.com/api/courses/99a1394cb91e41e9a66871850b208a13", "Mobile application development is one of the more complex forms of software development. In this course designed for programmers who do not have object-oriented programming experience, you will get a formal introduction to the programming skills required to develop applications for the mobile arena. You will learn to use Java to develop applications for Android mobile devices.")

  object course30 extends Course("a3a268efcf1e4f1ea0cc0e1c9dfe7aaa", "Tip Calculator", "http://www.balloon.com/api/courses/a3a268efcf1e4f1ea0cc0e1c9dfe7aaa", "Now that you\'ve completed the lesson on Python syntax, let\'s see if you can put your newfound skills to use. In this project, you\'ll create a simple calculator that determines the price of a meal after tax and tip.")

  object course31 extends Course("ad3f973a84d04aac8554cb8c638cf758", "Introduction to Objects I", "http://www.balloon.com/api/courses/ad3f973a84d04aac8554cb8c638cf758", "An introduction to object oriented thinking in JavaScript. Objects are the building blocks of object oriented programming (OOP) so we begin here!")

  object course32 extends Course("b9af04f690914cfb8cb684d4daf8f68e", "Developing Web Applications Using Microsoft Visual Studio 2008 SP1", "http://www.balloon.com/api/courses/b9af04f690914cfb8cb684d4daf8f68e", "In this five-day instructor-led course, you\'ll gain the knowledge and skills  to develop web applications using Microsoft Visual Studio 2008 SP1.  This course incorporates material from the Official Microsoft Learning  Product (OMLP) 2310D: Developing Web Applications Using Microsoft Visual Studio  2008 SP1.  Global Knowledge Exclusive!  Continue developing your skills after class with 24/7 access to our live   remote labs for six months, providing you with valuable extra time for hands-on   practice.")

  object course33 extends Course("be5a7377c2434ee3b0418fc1e6bb075f", "Administration of IBM WebSphere DataPower SOA Appliances V5", "http://www.balloon.com/api/courses/be5a7377c2434ee3b0418fc1e6bb075f", "In this 3-day course, you learn how to perform system administration tasks for the IBM WebSphere DataPower SOA Appliances.  The IBM WebSphere DataPower SOA Appliances allow users to simplify, accelerate, and enhance the security capabilities of Extensible Markup Language (XML) and web services deployments, and extend the capabilities of a service-oriented architecture (SOA) infrastructure.  Through a combination of instructor-led lectures and hands-on lab exercises, you learn how to perform various administrative procedures, from initial installation and setup through ongoing maintenance of the appliances in production. You learn about the available management interfaces, such as the command-line interface (CLI), Web GUI, and XML Management Interface. You also learn how to use these interfaces to perform various administrative tasks, such as upgrading firmware, performing backup and restore operations, monitoring system performance, configuring user accounts and domains, and much more.  This course applies to all appliances in the family of WebSphere DataPower SOA Appliances, including:  WebSphere DataPower XML Security Gateway XG45  WebSphere DataPower Integration Appliance XI50/XI52  WebSphere DataPower Integration Blade XI50B/XI52B  WebSphere DataPower Integration Blade XI50z/XI52z  WebSphere DataPower B2B Appliance XB62  The lab environment for this course uses the Linux platform in an ESX image.")

  object course34 extends Course("c1184b01261e4fe393534ad86e25137c", "Advanced Web Development with HTML5, CSS3 and JQuery", "http://www.balloon.com/api/courses/c1184b01261e4fe393534ad86e25137c", "In this in-depth web development course, you will discover of the latest in web technologies, performance, optimization, and user interface design patterns and best practices.  You will work through practical labs designed to take you through HTML5, CSS3, and related technologies.  You will leave this course armed with the new skills to design, implement, and deploy robust, flexible, and safe web applications.")

  object course35 extends Course("c32a750f6322486ea402500f2b68f0e8", "Building an Address Book", "http://www.balloon.com/api/courses/c32a750f6322486ea402500f2b68f0e8", "This project makes use of objects in the context of an address book.")

  object course36 extends Course("c95255eb885a44cfa632274c3aab293c", "Developing ASP.NET MVC 4 Web Applications", "http://www.balloon.com/api/courses/c95255eb885a44cfa632274c3aab293c", "In this course, you will learn to develop advanced ASP.NET   Model-View-Controller (MVC) 4 applications using .NET Framework 4.5 tools and   technologies. You will learn how to enhance the performance and scalability of   the web site application through coding activities. You will also be introduced   to ASP.NET MVC 4 with comparison to Web Forms so you know when each should/could   be used. You will learn how to create web sites that separate the user   interface, data access, and application logic.  This course uses Microsoft Visual Studio 2012. It incorporates material from   the Official Microsoft Learning Product 20486: Developing ASP.NET MVC 4 Web   Applications and can assist you in your preparation for Exam 70-486.  Global Knowledge Exclusive!  Continue developing your skills after class with 24/7 access to our live   remote labs for six months, providing you with valuable extra time for hands-on   practice.")

  object course37 extends Course("cbfc2769a9174c1b8cd5aa12b3a447a0", "Administration of IBM WebSphere DataPower SOA Appliances V5", "http://www.balloon.com/api/courses/cbfc2769a9174c1b8cd5aa12b3a447a0", "In this 3-day course, you learn how to perform system administration tasks for the IBM WebSphere DataPower SOA Appliances.  The IBM WebSphere DataPower SOA Appliances allow users to simplify, accelerate, and enhance the security capabilities of Extensible Markup Language (XML) and web services deployments, and extend the capabilities of a service-oriented architecture (SOA) infrastructure.  Through a combination of instructor-led lectures and hands-on lab exercises, you learn how to perform various administrative procedures, from initial installation and setup through ongoing maintenance of the appliances in production. You learn about the available management interfaces, such as the command-line interface (CLI), Web GUI, and XML Management Interface. You also learn how to use these interfaces to perform various administrative tasks, such as upgrading firmware, performing backup and restore operations, monitoring system performance, configuring user accounts and domains, and much more.  This course applies to all appliances in the family of WebSphere DataPower SOA Appliances, including:  WebSphere DataPower XML Security Gateway XG45  WebSphere DataPower Integration Appliance XI50/XI52  WebSphere DataPower Integration Blade XI50B/XI52B  WebSphere DataPower Integration Blade XI50z/XI52z  WebSphere DataPower B2B Appliance XB62  The lab environment for this course uses the Linux platform in an ESX image.")

  object course38 extends Course("cc011c4807894e42a5ed4a551952ec41", "Introduction to Objects II", "http://www.balloon.com/api/courses/cc011c4807894e42a5ed4a551952ec41", "A closer look at objects in JavaScript and an introduction to object-oriented programming concepts.")

  object course39 extends Course("cfb71afac6084ed1b3a924e21dfeebf3", "Spring 3.0, Rich Interfaces and the Web", "http://www.balloon.com/api/courses/cfb71afac6084ed1b3a924e21dfeebf3", "In this course, you will gain a better understanding of how to use Spring in conjunction with the various technologies used in and supporting rich web interfaces.  You will leave the course armed with the required skills to design and implement Spring applications that effectively and transparently use various web interface tools and technologies.  You will also cover of the concepts and practices for interacting between Spring and JSF, Struts, Web Flow, Ajax, and other components.")

  object course40 extends Course("d0cf089fb65e4fc3baa6877123cf1e36", "Python Syntax", "http://www.balloon.com/api/courses/d0cf089fb65e4fc3baa6877123cf1e36", "This tutorial will introduce you to Python, a general-purpose, object-oriented interpreted language you can use for countless standalone projects or scripting applications.")

  object course41 extends Course("d3555014272f40d49b7d6882585b58e8", "Introduction to \'For\' Loops in JS", "http://www.balloon.com/api/courses/d3555014272f40d49b7d6882585b58e8", "For loops are one of the most commonly used bits of code - it\'s so powerful and so useful!")

  object course42 extends Course("d3fb3ba66c9241b5a5862548032ab800", "Python Lists and Dictionaries", "http://www.balloon.com/api/courses/d3fb3ba66c9241b5a5862548032ab800", "Lists and dictionaries are powerful tools you can use to store, organize, and manipulate all kinds of information.")

  object course43 extends Course("d7b58dbad5754e6e9ea4e5806fca57c4", "Exam Statistics", "http://www.balloon.com/api/courses/d7b58dbad5754e6e9ea4e5806fca57c4", "Your students just took their first test. It\'s time to see how everyone did. Let\'s write a program to compute the mean, variance, and standard deviation of the test scores.")

  object course44 extends Course("d94bf22d690a4df9a1fce5a3753609c8", "Date and Time", "http://www.balloon.com/api/courses/d94bf22d690a4df9a1fce5a3753609c8", "This project is a follow up to Unit 2: Strings and Console input and will give you practice with the concepts introduced in that course.")

  object course45 extends Course("ddbb79a937414b059a89df6b1771f761", "Choose Your Own Adventure!", "http://www.balloon.com/api/courses/ddbb79a937414b059a89df6b1771f761", "Let\'s create your very own \"choose your own adventure\" game.")

  object course46 extends Course("e08dd7f0b8d04a71a05e82823ba0c2ea", "Web Testing Core Fundamentals", "http://www.balloon.com/api/courses/e08dd7f0b8d04a71a05e82823ba0c2ea", "Placing a new system in live operation or modifying an existing one can often  lead to unwanted surprises. With incompatible browsers, new tools, rapidly  changing technologies, and uncooperative web sites, the end result of your hard  work can be a guessing game. This course will help you minimize the risks,  whether launching a new application or an entire web site.  Gain a thorough understanding of how to test the basic controls, content,  navigability, and features of your web site or e-commerce application in a  workable, real-world environment. This information-packed course will expose you  to ideas and techniques that you can incorporate immediately, all offered to  help you streamline every aspect of your testing process, assuring on-time  delivery with a solid product.")

  object course47 extends Course("e9e1c8adfd8d433b9c66a5aea5174c24", "Functions", "http://www.balloon.com/api/courses/e9e1c8adfd8d433b9c66a5aea5174c24", "A function is a reusable section of code written to perform a specific task in a program. We gave you a taste of functions in Unit 3; here, you\'ll learn how to create your own.")

  object course48 extends Course("ef334300e5844405b724f84a78f9bd11", "Battleship!", "http://www.balloon.com/api/courses/ef334300e5844405b724f84a78f9bd11", "In this project we will make a simplified version of the classic board game Battleship!  We\'ll use functions, lists, and conditionals to make our game.")

  object course49 extends Course("f0339f4a4b044604b9052151057f7f5a", "Introduction to Bitwise Operators", "http://www.balloon.com/api/courses/f0339f4a4b044604b9052151057f7f5a", "Bitwise operations directly manipulate bits\\u2014patterns of 0s and 1s. Though they can be tricky to learn at first, their speed makes them a useful addition to any programmer\'s toolbox.")

  object course50 extends Course("f0e5128e4a26484d8eb7275175d197dd", "Practice Makes Perfect", "http://www.balloon.com/api/courses/f0e5128e4a26484d8eb7275175d197dd", "You know a lot of Python now. Let\'s do some practice problems!")

  object course51 extends Course("f48261bc8bfe40a8949d55d6c1c58188", "Programming Fundamentals of Web Applications", "http://www.balloon.com/api/courses/f48261bc8bfe40a8949d55d6c1c58188", "In this course, you will gain the knowledge and skills to develop web   applications using Microsoft Visual Studio and WebMatrix 2. This course   introduces you to the Microsoft web stack and shows you how to use WebMatrix 2   to develop web applications. You will gain a better understanding of basic web   development concepts and how to use existing applications from the Application   Gallery. You will learn CSS, plug-ins, scripting, basic data access, and   application hosting. You will also learn how to use Windows Azure for   application hosting and how to move beyond WebMatrix 2 into Visual Studio.  This course incorporates materials from the Official Microsoft Learning   Product 10958: Programming Fundamentals of Web Applications.  Global Knowledge Exclusive!  Continue developing your skills after class with 24/7 access to our live   remote labs for six months, providing you with valuable extra time for hands-on   practice.")

  object course52 extends Course("f77ba840018441629e046de3a8dc8026", "Developing Rule Solutions in IBM WebSphere Operational Decision Management V8", "http://www.balloon.com/api/courses/f77ba840018441629e046de3a8dc8026", "This 5-day course introduces developers to IBM WebSphere Operational Decision Management V8. In this course, you learn the concepts and skills that you need to design, develop, and integrate a business rule solution with WebSphere Operational Decision Management.  The course begins with an overview of Operational Decision Management, which is composed of two main environments: IBM WebSphere Decision Server for technical users, and IBM WebSphere Decision Center for business users. The course outlines the collaboration between development and business teams during project development. Through presentations and hands-on lab exercises, you learn about the core features of IBM WebSphere Decision Server, which is the primary working environment for developers. You design a business rule application, and work with the object models that are required to author and execute rule artifacts. You also get experience with rule execution and the rule engine API so that you can integrate rule artifacts for execution within an enterprise environment.  In addition, you become familiar with rule authoring so that you can support business users to set up and customize the authoring, validation, and management environments. You learn how to identify governance issues and use Operational Decision Management features to support decision governance.  The lab environment for this course uses the Windows XP platform.")


  override def getAll(params: Map[String, Any] = Map[String, Any](), orderBy : String = ORDER_BY_DEFAULT, sortOrder : String = SORT_ORDER_DEFAULT, page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[Course] = List(course1, course2, course3, course4, course5, course6, course7, course8, course9, course10, course11, course12, course13, course14, course15, course16, course17, course18, course19, course20, course21, course22, course23, course24, course25, course26, course27, course28, course29, course30, course31, course32, course33, course34, course35, course36, course37, course38, course39, course40, course41, course42, course43, course44, course45, course46, course47, course48, course49, course50, course51, course52)

  override def update(id: String, data: Map[String, Any])(implicit request: RequestHeader): Option[Course] = ???

  override def delete(id: String)(implicit request: RequestHeader): Int = ???

  override def create(entity: Course, flush : Boolean = false)(implicit request: RequestHeader): Int = ???

  override def get(id: String)(implicit request: RequestHeader): Option[Course] = ???
}

object MockJobs extends IJob {

  object job1 extends Job("000bc0bd9eaa46cb98594c571aa4f825", "Mobile Engineer", "http://www.balloon.com/api/jobs/000bc0bd9eaa46cb98594c571aa4f825", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job2 extends Job("02c86a3b3d8249d3b406ba74cc87eb35", "iOS Mobile App Developer", "http://www.balloon.com/api/jobs/02c86a3b3d8249d3b406ba74cc87eb35", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job3 extends Job("0e4ae5716dc648c29d3250c798bdafab", "Android Developer", "http://www.balloon.com/api/jobs/0e4ae5716dc648c29d3250c798bdafab", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job4 extends Job("0e5e0bc2005c4b8b92bd533f3762d39b", "Sr. iOS Engineer", "http://www.balloon.com/api/jobs/0e5e0bc2005c4b8b92bd533f3762d39b", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job5 extends Job("108d216eba744547ae32a12ddd864dae", "iOS Mobile Developer", "http://www.balloon.com/api/jobs/108d216eba744547ae32a12ddd864dae", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job6 extends Job("1111d548159341cb8681cbb5e409839b", "Mobile Engineer", "http://www.balloon.com/api/jobs/1111d548159341cb8681cbb5e409839b", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job7 extends Job("1a43bd699ac24733b6b36c6dfeae5ad0", "Lead iOS Developer", "http://www.balloon.com/api/jobs/1a43bd699ac24733b6b36c6dfeae5ad0", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job8 extends Job("2bbd50bd27204f55bb8e74c21e93f8b9", "Sr. iOS Engineer", "http://www.balloon.com/api/jobs/2bbd50bd27204f55bb8e74c21e93f8b9", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job9 extends Job("306900c8a6364decbbcb576f7e0c33ec", "Android Developer", "http://www.balloon.com/api/jobs/306900c8a6364decbbcb576f7e0c33ec", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job10 extends Job("3a94bf2cb49647c88254138294d4202b", "Contract to Hire iOS Developer", "http://www.balloon.com/api/jobs/3a94bf2cb49647c88254138294d4202b", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job11 extends Job("3fcbfa21df7b452f9bae6be1db75fc3c", "Android Developer", "http://www.balloon.com/api/jobs/3fcbfa21df7b452f9bae6be1db75fc3c", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job12 extends Job("4a8a1a53c6834a73871228f4a884d5fa", "Lead IOS Developer", "http://www.balloon.com/api/jobs/4a8a1a53c6834a73871228f4a884d5fa", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job13 extends Job("4bdd33af85cf4273bd7a8d49f34b4783", "Sr. iOS Developer", "http://www.balloon.com/api/jobs/4bdd33af85cf4273bd7a8d49f34b4783", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job14 extends Job("4fc748dd4f234aa6974fe31f77402bcd", "Android Developer", "http://www.balloon.com/api/jobs/4fc748dd4f234aa6974fe31f77402bcd", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job15 extends Job("57dae5e6eddb45d3a04e50248b38fecb", "Android Developer", "http://www.balloon.com/api/jobs/57dae5e6eddb45d3a04e50248b38fecb", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job16 extends Job("63e9be9229df4ddfae36039c1662363d", "Senior iOS Developer", "http://www.balloon.com/api/jobs/63e9be9229df4ddfae36039c1662363d", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job17 extends Job("69fd8a45ceb342b3ab19fba2288c7a71", "Android Developer", "http://www.balloon.com/api/jobs/69fd8a45ceb342b3ab19fba2288c7a71", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job18 extends Job("6dac563b27d249b3b0bc8692887fd292", "Principal iOS Developer", "http://www.balloon.com/api/jobs/6dac563b27d249b3b0bc8692887fd292", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job19 extends Job("6ddbd1f76a784ad881c20462bbea20c9", "Mobile Software Engineer", "http://www.balloon.com/api/jobs/6ddbd1f76a784ad881c20462bbea20c9", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job20 extends Job("7dd5d961d4d349c9a4018fdef4e973a9", "Senior iOS Engineer", "http://www.balloon.com/api/jobs/7dd5d961d4d349c9a4018fdef4e973a9", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job21 extends Job("87524cb7eee645529099d1764df4a4ab", "iOS Mobile App Developer", "http://www.balloon.com/api/jobs/87524cb7eee645529099d1764df4a4ab", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job22 extends Job("8b292f887e9b44769c877e81176c4c2c", "Senior iOS Developer", "http://www.balloon.com/api/jobs/8b292f887e9b44769c877e81176c4c2c", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job23 extends Job("8e8e31278e944f5f971238b00d84430a", "Urgent iOS Developer", "http://www.balloon.com/api/jobs/8e8e31278e944f5f971238b00d84430a", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job24 extends Job("9fa4772b261049a48f0cc9c3f54e432d", "Android Developer", "http://www.balloon.com/api/jobs/9fa4772b261049a48f0cc9c3f54e432d", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job25 extends Job("bb1785abf02c4c04a1407ee604844f51", "Mobile Engineer", "http://www.balloon.com/api/jobs/bb1785abf02c4c04a1407ee604844f51", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job26 extends Job("cf3a824b5d4d42279e616afdb3b62424", "Android Developer", "http://www.balloon.com/api/jobs/cf3a824b5d4d42279e616afdb3b62424", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job27 extends Job("d0935fd33948483a8b86d0be850ef49d", "Sr. iOS Developer", "http://www.balloon.com/api/jobs/d0935fd33948483a8b86d0be850ef49d", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job28 extends Job("edb88116a2234fd282156354d001b044", "Lead iOS Developer", "http://www.balloon.com/api/jobs/edb88116a2234fd282156354d001b044", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job29 extends Job("f182262ba16e4682a3f451d9f7c18856", "Principal IOS Developer", "http://www.balloon.com/api/jobs/f182262ba16e4682a3f451d9f7c18856", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job30 extends Job("f665aab53c9848a188a354a5e4fe47b8", "Mobile Software Engineer", "http://www.balloon.com/api/jobs/f665aab53c9848a188a354a5e4fe47b8", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job31 extends Job("f942c67e903e443fab4c571007d76c17", "Senior iOS Developer", "http://www.balloon.com/api/jobs/f942c67e903e443fab4c571007d76c17", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job32 extends Job("f98b4426f5da400ba03c676d019ff263", "Software Engineer", "http://www.balloon.com/api/jobs/f98b4426f5da400ba03c676d019ff263", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")

  object job33 extends Job("fdbe705ade6e411084dacda919b78bcc", "Sr. IOS Developer", "http://www.balloon.com/api/jobs/fdbe705ade6e411084dacda919b78bcc", "name raw", "description", "employer", "metro", "PUBLISHED", "New Curation")


  override def getAll(params: Map[String, Any] = Map[String, Any](), orderBy : String = ORDER_BY_DEFAULT, sortOrder : String = SORT_ORDER_DEFAULT, page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[Job] = List(job1, job2, job3, job4, job5, job6, job7, job8, job9, job10, job11, job12, job13, job14, job15, job16, job17, job18, job19, job20, job21, job22, job23, job24, job25, job26, job27, job28, job29, job30, job31, job32, job33)

  override def update(id: String, data: Map[String, Any])(implicit request: RequestHeader): Option[Job] = ???

  override def delete(id: String)(implicit request: RequestHeader): Int = ???

  override def create(entity: Job, flush : Boolean = false)(implicit request: RequestHeader): Int = ???

  override def get(id: String)(implicit request: RequestHeader): Option[Job] = ???
}

object MockSkills extends ISkill {

  object skill1 extends Skill("0206a97c41754c849effeeea46876313", "iOS", "http://www.balloon.com/api/skills/0206a97c41754c849effeeea46876313", "Ion implantation is a materials engineering process by which ions of a material are accelerated in an electrical field and impacted into a solid. This process is used to change the physical, chemical, or electrical properties of the solid. Ion implantation is used in semiconductor device fabrication and in metal finishing, as well as various applications in materials science research. The ions alter the elemental composition of the target, if the ions differ in composition from the target, stop in the target and stay there. They also cause much chemical and physical change in the target by transferring their energy and momentum to the electrons and atomic nuclei of the target material. This causes a structural change, in that the crystal structure of the target can be damaged or even destroyed by the energetic collision cascades. Because the ions have masses comparable to those of the target atoms, they knock the target atoms out of place more than electron beams do. If the ion energy is sufficiently high (usually tens of MeV) to overcome the coulomb barrier, there can even be a small amount of nuclear transmutation.")

  object skill2 extends Skill("05039698528d4f2e8e99231d28e732ec", "Airwatch", "http://www.balloon.com/api/skills/05039698528d4f2e8e99231d28e732ec", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill3 extends Skill("0f6837aaf5f3464294c811013bb4ff1c", "C#", "http://www.balloon.com/api/skills/0f6837aaf5f3464294c811013bb4ff1c", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill4 extends Skill("29bb66e16b5849799dc2463aa2ca1242", "Blackberry", "http://www.balloon.com/api/skills/29bb66e16b5849799dc2463aa2ca1242", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill5 extends Skill("32461f6423a641e19334963bb9cda38e", "JSP", "http://www.balloon.com/api/skills/32461f6423a641e19334963bb9cda38e", "A journal (through French from Latin diurnalis, daily) has several related meanings:")

  object skill6 extends Skill("32a0d1063e6045c787f921138ecb87bd", "Scripting Language", "http://www.balloon.com/api/skills/32a0d1063e6045c787f921138ecb87bd", "The Standard Commands for Programmable Instruments (SCPI) (often pronounced \\skippy\\) defines a standard for syntax and commands to use in controlling programmable test and measurement devices.")

  object skill7 extends Skill("333388b402264e288a2852a6e4d20272", "Programming Language", "http://www.balloon.com/api/skills/333388b402264e288a2852a6e4d20272", "A programming language is an artificial language designed to communicate instructions to a machine, particularly a computer. Programming languages can be used to create programs that control the behavior of a machine and/or to express algorithms precisely.")

  object skill8 extends Skill("3fcd04e32b0d4ae3ace10bff3ed65498", "TippingPoint", "http://www.balloon.com/api/skills/3fcd04e32b0d4ae3ace10bff3ed65498", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill9 extends Skill("402c00884d15442a9139da8c7308707a", "Blackberry Enterprise Server", "http://www.balloon.com/api/skills/402c00884d15442a9139da8c7308707a", "BlackBerry Enterprise Server designates the middleware software package that is part of the BlackBerry wireless platform supplied by Research In Motion (RIM). The software and service connects to messaging and collaboration software (Microsoft Exchange, Lotus Domino, Novell GroupWise, Alt-N MDaemon) on enterprise networks and redirects emails and synchronize contacts and calendaring information between servers, desktop workstations, and mobile devices. Some third-party connectors exist, including Scalix, Zarafa, Zimbra, and the Google Apps BES Connector, although these are not supported by RIM.")

  object skill10 extends Skill("486b2767880c41489dca0790ff5923e1", "JSON", "http://www.balloon.com/api/skills/486b2767880c41489dca0790ff5923e1", "A journal (through French from Latin diurnalis, daily) has several related meanings:")

  object skill11 extends Skill("4ab013f80a1a42e7b4d28e25f04e594f", "Eclipse", "http://www.balloon.com/api/skills/4ab013f80a1a42e7b4d28e25f04e594f", "In computer programming, Eclipse is a multi-language integrated development environment (IDE) comprising a base workspace and an extensible plug-in system for customizing the environment. It is written mostly in Java. It can be used to develop applications in Java and, by means of various plug-ins, other programming languages including Ada, C, C++, COBOL, Fortran, Haskell, JavaScript, Perl, PHP, Python, R, Ruby (including Ruby on Rails framework), Scala, Clojure, Groovy, Scheme, and Erlang. It can also be used to develop packages for the software Mathematica. Development environments include the Eclipse Java development tools (JDT) for Java and Scala, Eclipse CDT for C/C++ and Eclipse PDT for PHP, among others.")

  object skill12 extends Skill("4c99ab2182314b7aab1c8c92c1fa2bbf", "Blackberry", "http://www.balloon.com/api/skills/4c99ab2182314b7aab1c8c92c1fa2bbf", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill13 extends Skill("52bd3bd4482245ae8db0cedfc6113b31", "SourceFire", "http://www.balloon.com/api/skills/52bd3bd4482245ae8db0cedfc6113b31", "Sourcefire, Inc develops network security hardware and software. Sourcefire\\u2019s FirePOWER network security appliances are based on Snort, an open-source intrusion detection engine.")

  object skill14 extends Skill("55683d573c7943619fd722a15825b344", "CSS", "http://www.balloon.com/api/skills/55683d573c7943619fd722a15825b344", "The C shell (csh or the improved version, tcsh, on most machines) is a Unix shell that was created by Bill Joy while a graduate student at University of California, Berkeley in the late 1970s. It has been distributed widely, beginning with the 2BSD release of the BSD Unix system that Joy began distributing in 1978. Other early contributors to the ideas or the code were Michael Ubell, Eric Allman, Mike O\'Brien and Jim Kulp.")

  object skill15 extends Skill("5cee195716e34fd8a6071bdd1f7bb99c", "Mobile Application Management", "http://www.balloon.com/api/skills/5cee195716e34fd8a6071bdd1f7bb99c", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill16 extends Skill("621fc6e153af4d7da743d16c6fa1a502", "Windows Mobile", "http://www.balloon.com/api/skills/621fc6e153af4d7da743d16c6fa1a502", "Windows Mobile is a family of mobile operating systems developed by Microsoft for smartphones and Pocket PCs. In February 2010, Microsoft announced Windows Phone to supersede Windows Mobile, with the new operating system incompatible with Windows Mobile devices and software. As a result, Windows Mobile has been discontinued.")

  object skill17 extends Skill("68c215362c8948b2a8d6dfd25df925c7", "iOS", "http://www.balloon.com/api/skills/68c215362c8948b2a8d6dfd25df925c7", "Ion implantation is a materials engineering process by which ions of a material are accelerated in an electrical field and impacted into a solid. This process is used to change the physical, chemical, or electrical properties of the solid. Ion implantation is used in semiconductor device fabrication and in metal finishing, as well as various applications in materials science research. The ions alter the elemental composition of the target, if the ions differ in composition from the target, stop in the target and stay there. They also cause much chemical and physical change in the target by transferring their energy and momentum to the electrons and atomic nuclei of the target material. This causes a structural change, in that the crystal structure of the target can be damaged or even destroyed by the energetic collision cascades. Because the ions have masses comparable to those of the target atoms, they knock the target atoms out of place more than electron beams do. If the ion energy is sufficiently high (usually tens of MeV) to overcome the coulomb barrier, there can even be a small amount of nuclear transmutation.")

  object skill18 extends Skill("77a8d50657cc4f91b4fa64db70348c99", "XHTML", "http://www.balloon.com/api/skills/77a8d50657cc4f91b4fa64db70348c99", "Extended Copy Protection (XCP) is a software package developed by the British company First 4 Internet (which on 20 November 2006, changed its name to Fortium Technologies Ltd) and sold as a copy protection or digital rights management (DRM) scheme for Compact Discs. It was used on some CDs distributed by Sony BMG and sparked the 2005 Sony BMG CD copy protection scandal; in that context it is also known as the Sony rootkit.")

  object skill19 extends Skill("7ae9cae404174e97b47d3f06d105b471", "Java", "http://www.balloon.com/api/skills/7ae9cae404174e97b47d3f06d105b471", "Java, which derives much of its syntax from C and C++,  is a general-purpose, concurrent, class-based, object-oriented computer programming language that is specifically designed to have as few implementation dependencies as possible")

  object skill20 extends Skill("7c74c10042b548c9acc18c52831b358b", "Network Security", "http://www.balloon.com/api/skills/7c74c10042b548c9acc18c52831b358b", "Network security consists of the provisions and policies adopted by a network administrator to prevent and monitor unauthorized access, misuse, modification, or denial of a computer network and network-accessible resources. Network security involves the authorization of access to data in a network, which is controlled by the network administrator. Users choose or are assigned an ID and password or other authenticating information that allows them access to information and programs within their authority. Network security covers a variety of computer networks, both public and private, that are used in everyday jobs conducting transactions and communications among businesses, government agencies and individuals. Networks can be private, such as within a company, and others which might be open to public access. Network security is involved in organizations, enterprises, and other types of institutions. It does as its title explains: It secures the network, as well as protecting and overseeing operations being done. The most common and simple way of protecting a network resource is by assigning it a unique name and a corresponding password.")

  object skill21 extends Skill("80daf82342504eb0a9bf8fe56e69d29f", "Windows Mobile", "http://www.balloon.com/api/skills/80daf82342504eb0a9bf8fe56e69d29f", "Windows Mobile is a family of mobile operating systems developed by Microsoft for smartphones and Pocket PCs. In February 2010, Microsoft announced Windows Phone to supersede Windows Mobile, with the new operating system incompatible with Windows Mobile devices and software. As a result, Windows Mobile has been discontinued.")

  object skill22 extends Skill("81f9f60dd7c5422993bf4284bee66731", "HTML", "http://www.balloon.com/api/skills/81f9f60dd7c5422993bf4284bee66731", "H-Sphere is a web hosting Automation Control Panel for shared web hosting services that was developed by Positive Software and acquired by Parallels, Inc. in September 2007. It is available for Linux, Unix and Windows environments and works with MySQL, PostgreSQL and Microsoft SQL Server databases. H-Sphere has been written in Java and works with any SQL-compliant database.")

  object skill23 extends Skill("8f83f425589349bfa039f0a45938ab1d", "IPS", "http://www.balloon.com/api/skills/8f83f425589349bfa039f0a45938ab1d", "IPFilter (commonly referred to as ipf) is an open source software package that provides firewall services and network address translation (NAT) for many UNIX-like operating systems. The author and software maintainer is Darren Reed. IPFilter supports both IPv4 and IPv6 protocols, and is a stateful firewall.")

  object skill24 extends Skill("93e6ba0417134b0d9459b4257c000c29", "Mobile Operating Systems", "http://www.balloon.com/api/skills/93e6ba0417134b0d9459b4257c000c29", "A mobile operating system, also referred to as mobile OS, is the operating system that operates a smartphone, tablet, PDA, or other digital mobile devices. Modern mobile operating systems combine the features of a personal computer operating system with touchscreen, cellular, Bluetooth, WiFi, GPS mobile navigation, camera, video camera, speech recognition, voice recorder, music player, Near field communication, personal digital assistant (PDA) and other features.")

  object skill25 extends Skill("94aaa15fca5c4d0cbe2a3b3a93fd1705", "Mobile Iron", "http://www.balloon.com/api/skills/94aaa15fca5c4d0cbe2a3b3a93fd1705", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill26 extends Skill("9929beb3a81641899cd7371a24b34e78", "XML", "http://www.balloon.com/api/skills/9929beb3a81641899cd7371a24b34e78", "Extended Copy Protection (XCP) is a software package developed by the British company First 4 Internet (which on 20 November 2006, changed its name to Fortium Technologies Ltd) and sold as a copy protection or digital rights management (DRM) scheme for Compact Discs. It was used on some CDs distributed by Sony BMG and sparked the 2005 Sony BMG CD copy protection scandal; in that context it is also known as the Sony rootkit.")

  object skill27 extends Skill("b5d0fa8f30fa436392dac0e256ed0222", "Xcode", "http://www.balloon.com/api/skills/b5d0fa8f30fa436392dac0e256ed0222", "xCBL is a collection of XML specifications (both DTD and XML Schema) for use in e-business. It was created by Commerce One Inc. and is maintained by Perfect Commerce.")

  object skill28 extends Skill("bad35a2240814a6e83ffb55513f34cf1", "C++", "http://www.balloon.com/api/skills/bad35a2240814a6e83ffb55513f34cf1", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill29 extends Skill("bd8f16bf092944c8bb6cc28ab3c9f6ee", "Android", "http://www.balloon.com/api/skills/bd8f16bf092944c8bb6cc28ab3c9f6ee", "Android is an open-source, Linux-based operating system designed primarily for touchscreen mobile devices such as smartphones and tablet computers.")

  object skill30 extends Skill("db56591413bd407dbd99238661167acf", "IDS", "http://www.balloon.com/api/skills/db56591413bd407dbd99238661167acf", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill31 extends Skill("ddcb1273c6c04c4f847827146780631a", "Android", "http://www.balloon.com/api/skills/ddcb1273c6c04c4f847827146780631a", "Android is an open-source, Linux-based operating system designed primarily for touchscreen mobile devices such as smartphones and tablet computers.")

  object skill32 extends Skill("dfd02e90fa504e19b6428cc20d71d6ed", "Objective-C", "http://www.balloon.com/api/skills/dfd02e90fa504e19b6428cc20d71d6ed", "Objective-C is a general-purpose, high-level, object-oriented programming language that adds Smalltalk-style messaging to the C programming language. It is the main programming language used by Apple for the OS X and iOS operating systems and their respective APIs, Cocoa and Cocoa Touch.")

  object skill33 extends Skill("dfddb1e3796d4ffa8b014bda7fcda34b", "Mobile Device Management", "http://www.balloon.com/api/skills/dfddb1e3796d4ffa8b014bda7fcda34b", "Mobile Device Management (MDM) software secures, monitors, manages and supports mobile devices deployed across mobile operators, service providers and enterprises. MDM functionality typically includes over-the-air distribution of applications, data and configuration settings for all types of mobile devices, including mobile phones, smartphones, tablet computers, ruggedized mobile computers, mobile printers, mobile POS devices, etc. This applies to both company-owned and employee-owned (BYOD) devices across the enterprise or mobile devices owned by consumers.")

  object skill34 extends Skill("e516d22f4e064263a94de2f8686bf69c", "Network Architecture", "http://www.balloon.com/api/skills/e516d22f4e064263a94de2f8686bf69c", "Network architecture is the design of a communications network. It is a framework for the specification of a network\'s physical components and their functional organization and configuration, its operational principles and procedures, as well as data formats used in its operation.")

  object skill35 extends Skill("f3afdbf6a45241c6953a73bf58cef8c5", "Development Frameworks", "http://www.balloon.com/api/skills/f3afdbf6a45241c6953a73bf58cef8c5", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")

  object skill36 extends Skill("fdf54ec8c34c4c89a3a8928f7c59d0ef", "Good", "http://www.balloon.com/api/skills/fdf54ec8c34c4c89a3a8928f7c59d0ef", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.")


  override def getAll(params: Map[String, Any] = Map[String, Any](), orderBy : String = ORDER_BY_DEFAULT, sortOrder : String = SORT_ORDER_DEFAULT, page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[Skill] = List(skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, skill9, skill10, skill11, skill12, skill13, skill14, skill15, skill16, skill17, skill18, skill19, skill20, skill21, skill22, skill23, skill24, skill25, skill26, skill27, skill28, skill29, skill30, skill31, skill32, skill33, skill34, skill35, skill36)

  override def update(id: String, data: Map[String, Any])(implicit request: RequestHeader): Option[Skill] = ???

  override def delete(id: String)(implicit request: RequestHeader): Int = ???

  override def create(entity: Skill, flush : Boolean = false)(implicit request: RequestHeader): Int = ???

  override def get(key: String)(implicit request: RequestHeader): Option[Skill] = ???
}

object MockDatabase extends Database {
  override def job: IJob = MockJobs

  override def course: ICourse = MockCourses

  override def category: ICategory = MockCategories

  override def career: ICareer = MockCareers

  override def skill: ISkill = MockSkills

  var careers = career.getAll()(null)
  var courses = course.getAll()(null)
  var jobs = job.getAll()(null)
  var skills = skill.getAll()(null)
  var allSkills = skills
  var allJobs = jobs

  def getSkill(field: String, value: String)(implicit request: RequestHeader): Option[Skill] = {
    field match {
      case "id" => {
        skill.getAll().find(f => f.id == value)
      }
      case _ => None
    }
  }


  def getCareersByJobId(id: String,algo:String=defaultAlgo,filters : Map[String,Any], page:Int, limit:Int)(implicit request: RequestHeader): List[(Career, Double)] = {
    val job = this.getJob("id", id).get
    var result: List[(Career, Double)] = List()

    for (career <- this.career.getAll()) {
      val jobs: List[(Job, Double)] = career.getJobs()
      for (j <- jobs) {
        if (j._1.id == job.id) {
          result = result ++ Map(career -> j._2).toList
        }
      }
    }

    result
  }

  def getCareersBySkillId(id: String,algo:String=defaultAlgo,filters : Map[String,Any], page:Int, limit:Int)(implicit request: RequestHeader): List[(Career, Double)] = {
    val skill = this.getSkill("id", id).get
    var result: List[(Career, Double)] = List()

    for (career <- this.career.getAll()) {
      val skills: List[(Skill, Double)] = career.getSkills()
      for (s <- skills) {
        if (s._1.id == skill.id) {
          result = result ++ Map(career -> s._2).toList
        }
      }
    }

    result
  }


  def getCareer(field: String, value: String)(implicit request: RequestHeader): Option[Career] = {
    field match {
      case "id" => {
        career.getAll().find(f => f.id == value)
      }
      case _ => None
    }
  }

  def getCategory(field: String, value: String)(implicit request: RequestHeader): Option[Category] = {
    field match {
      case "id" => {
        category.getAll().find(f => f.id == value)
      }
      case _ => None
    }
  }

  def getCourse(field: String, value: String)(implicit request: RequestHeader): Option[Course] = {
    field match {
      case "id" => {
        course.getAll().find(f => f.id == value)
      }
      case _ => None
    }
  }

  def getJob(field: String, value: String)(implicit request: RequestHeader): Option[Job] = {
    field match {
      case "id" => {
        job.getAll().find(f => f.id == value)
      }
      case _ => None
    }
  }


  def getSkillsByCareerId(id: String,algo:String=defaultAlgo, filters: Map[String,Any],  page:Int, limit:Int)(implicit request: RequestHeader): List[(Skill, Double)] = if (page > 0) List[(Skill, Double)]() else getCareer("id", id).get.getSkills()

  def getSkillsByCourseId(id: String,algo:String=defaultAlgo, filters: Map[String,Any], page:Int, limit:Int)(implicit request: RequestHeader): List[(Skill, Double)] = if (page > 0) List[(Skill, Double)]() else getCourse("id", id).get.getSkills()

  def getSkillsByJobId(id: String,algo:String=defaultAlgo, filters: Map[String,Any],  page:Int, limit:Int)(implicit request: RequestHeader): List[(Skill, Double)] = if (page > 0) List[(Skill, Double)]() else getJob("id", id).get.getSkills()

  def getJobsByCareerId(id: String,algo:String=defaultAlgo, filters: Map[String,Any], page:Int,limit:Int)(implicit request: RequestHeader): List[(Job, Double)] = if (page > 0) List[(Job, Double)]() else getCareer("id", id).get.getJobs()


  // add skills to careers
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 0.77))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 0.13))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 0.28))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "94aaa15fca5c4d0cbe2a3b3a93fd1705").get -> 1.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 0.63))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 0.16))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 0.97))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "333388b402264e288a2852a6e4d20272").get -> 0.04))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "29bb66e16b5849799dc2463aa2ca1242").get -> 0.33))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 0.15))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 0.03))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 0.92))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "32461f6423a641e19334963bb9cda38e").get -> 0.22))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 0.24))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 0.52))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 0.67))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 0.53))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 0.77))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 0.56))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 0.76))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 0.96))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 0.82))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 0.33))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 0.61))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "4c99ab2182314b7aab1c8c92c1fa2bbf").get -> 0.26))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 0.87))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 0.25))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 0.34))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 0.25))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 0.20))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 0.86))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 0.64))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 0.17))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "77a8d50657cc4f91b4fa64db70348c99").get -> 0.97))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 0.95))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "68c215362c8948b2a8d6dfd25df925c7").get -> 0.92))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 0.76))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 0.08))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "80daf82342504eb0a9bf8fe56e69d29f").get -> 0.90))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 0.35))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 0.05))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "bd8f16bf092944c8bb6cc28ab3c9f6ee").get -> 0.06))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 0.96))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 0.91))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 0.03))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 0.91))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addSkills(Map(allSkills.find(s => s.id == "77a8d50657cc4f91b4fa64db70348c99").get -> 0.31))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 0.15))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "bd8f16bf092944c8bb6cc28ab3c9f6ee").get -> 0.82))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 0.40))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "29bb66e16b5849799dc2463aa2ca1242").get -> 0.10))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 0.30))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 0.88))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 0.62))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "77a8d50657cc4f91b4fa64db70348c99").get -> 0.97))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 0.53))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 0.89))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 0.23))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 0.60))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 0.79))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 0.97))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 0.15))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "29bb66e16b5849799dc2463aa2ca1242").get -> 0.93))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 0.34))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 0.43))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 0.95))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 0.90))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 0.28))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 0.54))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 0.72))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 0.10))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 0.15))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 0.38))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 0.08))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 0.23))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "bd8f16bf092944c8bb6cc28ab3c9f6ee").get -> 0.04))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 0.59))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 0.65))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addSkills(Map(allSkills.find(s => s.id == "4c99ab2182314b7aab1c8c92c1fa2bbf").get -> 0.14))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 0.20))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "77a8d50657cc4f91b4fa64db70348c99").get -> 0.94))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 0.05))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 0.02))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 0.22))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 0.38))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 0.74))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addSkills(Map(allSkills.find(s => s.id == "94aaa15fca5c4d0cbe2a3b3a93fd1705").get -> 0.93))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 0.80))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addSkills(Map(allSkills.find(s => s.id == "32461f6423a641e19334963bb9cda38e").get -> 0.72))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 0.67))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 0.16))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 0.13))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 0.37))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addSkills(Map(allSkills.find(s => s.id == "80daf82342504eb0a9bf8fe56e69d29f").get -> 0.69))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addSkills(Map(allSkills.find(s => s.id == "0206a97c41754c849effeeea46876313").get -> 0.19))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 0.74))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addSkills(Map(allSkills.find(s => s.id == "68c215362c8948b2a8d6dfd25df925c7").get -> 0.14))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "333388b402264e288a2852a6e4d20272").get -> 0.38))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 0.10))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 0.40))


  // add jobs to careers
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "000bc0bd9eaa46cb98594c571aa4f825").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "4a8a1a53c6834a73871228f4a884d5fa").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "f98b4426f5da400ba03c676d019ff263").get -> 0.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "0e4ae5716dc648c29d3250c798bdafab").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "69fd8a45ceb342b3ab19fba2288c7a71").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "7dd5d961d4d349c9a4018fdef4e973a9").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "3fcbfa21df7b452f9bae6be1db75fc3c").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "4bdd33af85cf4273bd7a8d49f34b4783").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "8b292f887e9b44769c877e81176c4c2c").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "000bc0bd9eaa46cb98594c571aa4f825").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "f182262ba16e4682a3f451d9f7c18856").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "d0935fd33948483a8b86d0be850ef49d").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "02c86a3b3d8249d3b406ba74cc87eb35").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "63e9be9229df4ddfae36039c1662363d").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "3fcbfa21df7b452f9bae6be1db75fc3c").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "1a43bd699ac24733b6b36c6dfeae5ad0").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "0e5e0bc2005c4b8b92bd533f3762d39b").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "57dae5e6eddb45d3a04e50248b38fecb").get -> 0.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "f98b4426f5da400ba03c676d019ff263").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "57dae5e6eddb45d3a04e50248b38fecb").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "1111d548159341cb8681cbb5e409839b").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "57dae5e6eddb45d3a04e50248b38fecb").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "108d216eba744547ae32a12ddd864dae").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "02c86a3b3d8249d3b406ba74cc87eb35").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "4a8a1a53c6834a73871228f4a884d5fa").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "f665aab53c9848a188a354a5e4fe47b8").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "f665aab53c9848a188a354a5e4fe47b8").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "2bbd50bd27204f55bb8e74c21e93f8b9").get -> 0.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "63e9be9229df4ddfae36039c1662363d").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "4bdd33af85cf4273bd7a8d49f34b4783").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "d0935fd33948483a8b86d0be850ef49d").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "bb1785abf02c4c04a1407ee604844f51").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "0e5e0bc2005c4b8b92bd533f3762d39b").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "02c86a3b3d8249d3b406ba74cc87eb35").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "1111d548159341cb8681cbb5e409839b").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "87524cb7eee645529099d1764df4a4ab").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "0e4ae5716dc648c29d3250c798bdafab").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "4bdd33af85cf4273bd7a8d49f34b4783").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "0e4ae5716dc648c29d3250c798bdafab").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "d0935fd33948483a8b86d0be850ef49d").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "4bdd33af85cf4273bd7a8d49f34b4783").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "6dac563b27d249b3b0bc8692887fd292").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "1111d548159341cb8681cbb5e409839b").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "f98b4426f5da400ba03c676d019ff263").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "4a8a1a53c6834a73871228f4a884d5fa").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "0e5e0bc2005c4b8b92bd533f3762d39b").get -> 0.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "f98b4426f5da400ba03c676d019ff263").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "0e4ae5716dc648c29d3250c798bdafab").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "cf3a824b5d4d42279e616afdb3b62424").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "d0935fd33948483a8b86d0be850ef49d").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "4fc748dd4f234aa6974fe31f77402bcd").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "6dac563b27d249b3b0bc8692887fd292").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "69fd8a45ceb342b3ab19fba2288c7a71").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "7dd5d961d4d349c9a4018fdef4e973a9").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "f98b4426f5da400ba03c676d019ff263").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "57dae5e6eddb45d3a04e50248b38fecb").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "3fcbfa21df7b452f9bae6be1db75fc3c").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "6ddbd1f76a784ad881c20462bbea20c9").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "02c86a3b3d8249d3b406ba74cc87eb35").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "0e4ae5716dc648c29d3250c798bdafab").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "000bc0bd9eaa46cb98594c571aa4f825").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "4fc748dd4f234aa6974fe31f77402bcd").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "3a94bf2cb49647c88254138294d4202b").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "4a8a1a53c6834a73871228f4a884d5fa").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "f182262ba16e4682a3f451d9f7c18856").get -> 0.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "f665aab53c9848a188a354a5e4fe47b8").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "edb88116a2234fd282156354d001b044").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "9fa4772b261049a48f0cc9c3f54e432d").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "02c86a3b3d8249d3b406ba74cc87eb35").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "6dac563b27d249b3b0bc8692887fd292").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "69fd8a45ceb342b3ab19fba2288c7a71").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "4fc748dd4f234aa6974fe31f77402bcd").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "d0935fd33948483a8b86d0be850ef49d").get -> 0.00))
  careers.find(f => f.id == "9b932798d9634b3f8246ab108815d3c1").get.addJobs(Map(allJobs.find(s => s.id == "f98b4426f5da400ba03c676d019ff263").get -> 0.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "108d216eba744547ae32a12ddd864dae").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "d0935fd33948483a8b86d0be850ef49d").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "9fa4772b261049a48f0cc9c3f54e432d").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "02c86a3b3d8249d3b406ba74cc87eb35").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "f665aab53c9848a188a354a5e4fe47b8").get -> 0.00))
  careers.find(f => f.id == "b52594fd395041038a4d3fa4bdf7d17f").get.addJobs(Map(allJobs.find(s => s.id == "69fd8a45ceb342b3ab19fba2288c7a71").get -> 0.00))
  careers.find(f => f.id == "96a2876766c6448e90a4e9c6efdb745f").get.addJobs(Map(allJobs.find(s => s.id == "0e4ae5716dc648c29d3250c798bdafab").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "2bbd50bd27204f55bb8e74c21e93f8b9").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "9fa4772b261049a48f0cc9c3f54e432d").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "1111d548159341cb8681cbb5e409839b").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "57dae5e6eddb45d3a04e50248b38fecb").get -> 0.00))
  careers.find(f => f.id == "cff09eeb10a0488fa9cd9c35f5253018").get.addJobs(Map(allJobs.find(s => s.id == "4bdd33af85cf4273bd7a8d49f34b4783").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "57dae5e6eddb45d3a04e50248b38fecb").get -> 0.00))
  careers.find(f => f.id == "147a8302c32b412dace1f3627a574ca5").get.addJobs(Map(allJobs.find(s => s.id == "4fc748dd4f234aa6974fe31f77402bcd").get -> 0.00))
  careers.find(f => f.id == "a7c3df7f593e4091ab746969e7089468").get.addJobs(Map(allJobs.find(s => s.id == "7dd5d961d4d349c9a4018fdef4e973a9").get -> 0.00))
  careers.find(f => f.id == "954abfdd72414c088843ec78ff3cec6d").get.addJobs(Map(allJobs.find(s => s.id == "7dd5d961d4d349c9a4018fdef4e973a9").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "f942c67e903e443fab4c571007d76c17").get -> 0.00))
  careers.find(f => f.id == "4d1ebcf47a0c44b78d4b7ba0fe0d1796").get.addJobs(Map(allJobs.find(s => s.id == "cf3a824b5d4d42279e616afdb3b62424").get -> 0.00))
  careers.find(f => f.id == "5cec9c1b792340f182ac52c0118787da").get.addJobs(Map(allJobs.find(s => s.id == "7dd5d961d4d349c9a4018fdef4e973a9").get -> 0.00))
  careers.find(f => f.id == "35652eb64a97451a87d95f80d947a4de").get.addJobs(Map(allJobs.find(s => s.id == "f182262ba16e4682a3f451d9f7c18856").get -> 0.00))
  careers.find(f => f.id == "f7bc71513b1444c2842ce53d3e8c00ea").get.addJobs(Map(allJobs.find(s => s.id == "3a94bf2cb49647c88254138294d4202b").get -> 0.00))
  careers.find(f => f.id == "84fcf05567854c3a9f22b5890192cbab").get.addJobs(Map(allJobs.find(s => s.id == "f182262ba16e4682a3f451d9f7c18856").get -> 0.00))


  // add skills to courses
  courses.find(f => f.id == "6c27ae9873334ca995b2ff222d1f14ef").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  courses.find(f => f.id == "cc011c4807894e42a5ed4a551952ec41").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  courses.find(f => f.id == "918a11bbdf8a4551b1bfa83d2a276e8e").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 1.0))
  courses.find(f => f.id == "d94bf22d690a4df9a1fce5a3753609c8").get.addSkills(Map(allSkills.find(s => s.id == "77a8d50657cc4f91b4fa64db70348c99").get -> 1.0))
  courses.find(f => f.id == "f0e5128e4a26484d8eb7275175d197dd").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "6409d7b531174e7c90dc7a2055ee5c39").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  courses.find(f => f.id == "918a11bbdf8a4551b1bfa83d2a276e8e").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 1.0))
  courses.find(f => f.id == "01b5979d087e485da17de1c4f48255b9").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  courses.find(f => f.id == "d7b58dbad5754e6e9ea4e5806fca57c4").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 1.0))
  courses.find(f => f.id == "c32a750f6322486ea402500f2b68f0e8").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "770380fa9cba47f19c98909d7a4d9e66").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 1.0))
  courses.find(f => f.id == "6409d7b531174e7c90dc7a2055ee5c39").get.addSkills(Map(allSkills.find(s => s.id == "77a8d50657cc4f91b4fa64db70348c99").get -> 1.0))
  courses.find(f => f.id == "1a815c84c58c40d891d5db98086bfb49").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "74ef596c07a14890b2ad4dadc8ee22c1").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "6c27ae9873334ca995b2ff222d1f14ef").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  courses.find(f => f.id == "8b234f421f244b29ba6382ece77ee082").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  courses.find(f => f.id == "8b234f421f244b29ba6382ece77ee082").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 1.0))
  courses.find(f => f.id == "d0cf089fb65e4fc3baa6877123cf1e36").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 1.0))
  courses.find(f => f.id == "8b234f421f244b29ba6382ece77ee082").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  courses.find(f => f.id == "8dbf49befef540c4b9eb3d5940f0aeba").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 1.0))
  courses.find(f => f.id == "37fd37d05cb847098dac4be7cdcfae40").get.addSkills(Map(allSkills.find(s => s.id == "4c99ab2182314b7aab1c8c92c1fa2bbf").get -> 1.0))
  courses.find(f => f.id == "24495d3e5a3446eea1fef5e9d9b88053").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 1.0))
  courses.find(f => f.id == "9029d82f19d548ccbaf76b375ba7fc5f").get.addSkills(Map(allSkills.find(s => s.id == "32461f6423a641e19334963bb9cda38e").get -> 1.0))
  courses.find(f => f.id == "5acbc37475484697952fbaecac47ac01").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  courses.find(f => f.id == "d0cf089fb65e4fc3baa6877123cf1e36").get.addSkills(Map(allSkills.find(s => s.id == "bd8f16bf092944c8bb6cc28ab3c9f6ee").get -> 1.0))
  courses.find(f => f.id == "cfb71afac6084ed1b3a924e21dfeebf3").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "6c27ae9873334ca995b2ff222d1f14ef").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 1.0))
  courses.find(f => f.id == "8f2a6694459545bbb4405fc12fced331").get.addSkills(Map(allSkills.find(s => s.id == "68c215362c8948b2a8d6dfd25df925c7").get -> 1.0))
  courses.find(f => f.id == "24495d3e5a3446eea1fef5e9d9b88053").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  courses.find(f => f.id == "f0339f4a4b044604b9052151057f7f5a").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  courses.find(f => f.id == "b9af04f690914cfb8cb684d4daf8f68e").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  courses.find(f => f.id == "37fd37d05cb847098dac4be7cdcfae40").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  courses.find(f => f.id == "d7b58dbad5754e6e9ea4e5806fca57c4").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  courses.find(f => f.id == "17f0faa1786f4397a9e7af213390d099").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 1.0))
  courses.find(f => f.id == "c1184b01261e4fe393534ad86e25137c").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "78fe2391583a47cf9d35a1028f203432").get.addSkills(Map(allSkills.find(s => s.id == "0206a97c41754c849effeeea46876313").get -> 1.0))
  courses.find(f => f.id == "a3a268efcf1e4f1ea0cc0e1c9dfe7aaa").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "ad3f973a84d04aac8554cb8c638cf758").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  courses.find(f => f.id == "8dbf49befef540c4b9eb3d5940f0aeba").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  courses.find(f => f.id == "01b5979d087e485da17de1c4f48255b9").get.addSkills(Map(allSkills.find(s => s.id == "0206a97c41754c849effeeea46876313").get -> 1.0))
  courses.find(f => f.id == "78fe2391583a47cf9d35a1028f203432").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  courses.find(f => f.id == "3006db25574b497b9397a1616a815467").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 1.0))
  courses.find(f => f.id == "51ffbfe860ac4e70909946d1e34ba99b").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  courses.find(f => f.id == "b9af04f690914cfb8cb684d4daf8f68e").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 1.0))
  courses.find(f => f.id == "c32a750f6322486ea402500f2b68f0e8").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 1.0))
  courses.find(f => f.id == "a3a268efcf1e4f1ea0cc0e1c9dfe7aaa").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  courses.find(f => f.id == "ad3f973a84d04aac8554cb8c638cf758").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  courses.find(f => f.id == "ef334300e5844405b724f84a78f9bd11").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  courses.find(f => f.id == "f77ba840018441629e046de3a8dc8026").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  courses.find(f => f.id == "89eb65f3f595491a8627cfda451bc6f0").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  courses.find(f => f.id == "f77ba840018441629e046de3a8dc8026").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 1.0))
  courses.find(f => f.id == "cfb71afac6084ed1b3a924e21dfeebf3").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  courses.find(f => f.id == "17f0faa1786f4397a9e7af213390d099").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  courses.find(f => f.id == "918a11bbdf8a4551b1bfa83d2a276e8e").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "770380fa9cba47f19c98909d7a4d9e66").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  courses.find(f => f.id == "a3a268efcf1e4f1ea0cc0e1c9dfe7aaa").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 1.0))
  courses.find(f => f.id == "e08dd7f0b8d04a71a05e82823ba0c2ea").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "72c9af43678145c8ac621e79261a4241").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  courses.find(f => f.id == "17f0faa1786f4397a9e7af213390d099").get.addSkills(Map(allSkills.find(s => s.id == "4c99ab2182314b7aab1c8c92c1fa2bbf").get -> 1.0))
  courses.find(f => f.id == "770380fa9cba47f19c98909d7a4d9e66").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  courses.find(f => f.id == "1de452a7ba5040839165944a89bcdb27").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 1.0))
  courses.find(f => f.id == "c1184b01261e4fe393534ad86e25137c").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  courses.find(f => f.id == "98288503a38042cf820aa33557b296c7").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "99a1394cb91e41e9a66871850b208a13").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  courses.find(f => f.id == "d0cf089fb65e4fc3baa6877123cf1e36").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 1.0))
  courses.find(f => f.id == "2c7c4a4db36f4be69a4588b26820432f").get.addSkills(Map(allSkills.find(s => s.id == "333388b402264e288a2852a6e4d20272").get -> 1.0))
  courses.find(f => f.id == "8f2a6694459545bbb4405fc12fced331").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 1.0))
  courses.find(f => f.id == "c95255eb885a44cfa632274c3aab293c").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 1.0))
  courses.find(f => f.id == "72c9af43678145c8ac621e79261a4241").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "84d791d44eaf4df99c5bc38639ea21f0").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  courses.find(f => f.id == "d3555014272f40d49b7d6882585b58e8").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 1.0))
  courses.find(f => f.id == "1a815c84c58c40d891d5db98086bfb49").get.addSkills(Map(allSkills.find(s => s.id == "80daf82342504eb0a9bf8fe56e69d29f").get -> 1.0))
  courses.find(f => f.id == "6409d7b531174e7c90dc7a2055ee5c39").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  courses.find(f => f.id == "78fe2391583a47cf9d35a1028f203432").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "cc011c4807894e42a5ed4a551952ec41").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  courses.find(f => f.id == "cbfc2769a9174c1b8cd5aa12b3a447a0").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  courses.find(f => f.id == "74ef596c07a14890b2ad4dadc8ee22c1").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  courses.find(f => f.id == "ddbb79a937414b059a89df6b1771f761").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  courses.find(f => f.id == "1a815c84c58c40d891d5db98086bfb49").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 1.0))
  courses.find(f => f.id == "99a1394cb91e41e9a66871850b208a13").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  courses.find(f => f.id == "9029d82f19d548ccbaf76b375ba7fc5f").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "ddbb79a937414b059a89df6b1771f761").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  courses.find(f => f.id == "f0339f4a4b044604b9052151057f7f5a").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  courses.find(f => f.id == "e08dd7f0b8d04a71a05e82823ba0c2ea").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  courses.find(f => f.id == "84d791d44eaf4df99c5bc38639ea21f0").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "3e0fcd8980b547f49066be8b1a8d1d76").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 1.0))
  courses.find(f => f.id == "be5a7377c2434ee3b0418fc1e6bb075f").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  courses.find(f => f.id == "98288503a38042cf820aa33557b296c7").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  courses.find(f => f.id == "cbfc2769a9174c1b8cd5aa12b3a447a0").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  courses.find(f => f.id == "be5a7377c2434ee3b0418fc1e6bb075f").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  courses.find(f => f.id == "1de452a7ba5040839165944a89bcdb27").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 1.0))
  courses.find(f => f.id == "ef334300e5844405b724f84a78f9bd11").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  courses.find(f => f.id == "ef334300e5844405b724f84a78f9bd11").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  courses.find(f => f.id == "743a0eaac80a4b31bc8b3676a7366a75").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  courses.find(f => f.id == "99a1394cb91e41e9a66871850b208a13").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 1.0))
  courses.find(f => f.id == "c95255eb885a44cfa632274c3aab293c").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  courses.find(f => f.id == "c32a750f6322486ea402500f2b68f0e8").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 1.0))
  courses.find(f => f.id == "3006db25574b497b9397a1616a815467").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  courses.find(f => f.id == "8f2a6694459545bbb4405fc12fced331").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  courses.find(f => f.id == "cbfc2769a9174c1b8cd5aa12b3a447a0").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 1.0))
  courses.find(f => f.id == "e9e1c8adfd8d433b9c66a5aea5174c24").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 1.0))
  courses.find(f => f.id == "ad3f973a84d04aac8554cb8c638cf758").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 1.0))
  courses.find(f => f.id == "d3555014272f40d49b7d6882585b58e8").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  courses.find(f => f.id == "5acbc37475484697952fbaecac47ac01").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "9029d82f19d548ccbaf76b375ba7fc5f").get.addSkills(Map(allSkills.find(s => s.id == "0206a97c41754c849effeeea46876313").get -> 1.0))
  courses.find(f => f.id == "743a0eaac80a4b31bc8b3676a7366a75").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "ddbb79a937414b059a89df6b1771f761").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 1.0))
  courses.find(f => f.id == "d3555014272f40d49b7d6882585b58e8").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  courses.find(f => f.id == "cfb71afac6084ed1b3a924e21dfeebf3").get.addSkills(Map(allSkills.find(s => s.id == "333388b402264e288a2852a6e4d20272").get -> 1.0))
  courses.find(f => f.id == "e9e1c8adfd8d433b9c66a5aea5174c24").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "2c7c4a4db36f4be69a4588b26820432f").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  courses.find(f => f.id == "91bcceedd89842c88e2bc5a0d0aa0961").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  courses.find(f => f.id == "98288503a38042cf820aa33557b296c7").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  courses.find(f => f.id == "24495d3e5a3446eea1fef5e9d9b88053").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  courses.find(f => f.id == "743a0eaac80a4b31bc8b3676a7366a75").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 1.0))
  courses.find(f => f.id == "f48261bc8bfe40a8949d55d6c1c58188").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  courses.find(f => f.id == "5acbc37475484697952fbaecac47ac01").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  courses.find(f => f.id == "1de452a7ba5040839165944a89bcdb27").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  courses.find(f => f.id == "3e0fcd8980b547f49066be8b1a8d1d76").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 1.0))
  courses.find(f => f.id == "2c7c4a4db36f4be69a4588b26820432f").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "cc011c4807894e42a5ed4a551952ec41").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  courses.find(f => f.id == "72c9af43678145c8ac621e79261a4241").get.addSkills(Map(allSkills.find(s => s.id == "68c215362c8948b2a8d6dfd25df925c7").get -> 1.0))
  courses.find(f => f.id == "d3fb3ba66c9241b5a5862548032ab800").get.addSkills(Map(allSkills.find(s => s.id == "32461f6423a641e19334963bb9cda38e").get -> 1.0))
  courses.find(f => f.id == "123f2ce6dc2842478078e2d72ed6178a").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 1.0))
  courses.find(f => f.id == "d3fb3ba66c9241b5a5862548032ab800").get.addSkills(Map(allSkills.find(s => s.id == "0206a97c41754c849effeeea46876313").get -> 1.0))
  courses.find(f => f.id == "f0e5128e4a26484d8eb7275175d197dd").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  courses.find(f => f.id == "f48261bc8bfe40a8949d55d6c1c58188").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  courses.find(f => f.id == "51ffbfe860ac4e70909946d1e34ba99b").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "84d791d44eaf4df99c5bc38639ea21f0").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 1.0))
  courses.find(f => f.id == "b9af04f690914cfb8cb684d4daf8f68e").get.addSkills(Map(allSkills.find(s => s.id == "4c99ab2182314b7aab1c8c92c1fa2bbf").get -> 1.0))
  courses.find(f => f.id == "91bcceedd89842c88e2bc5a0d0aa0961").get.addSkills(Map(allSkills.find(s => s.id == "94aaa15fca5c4d0cbe2a3b3a93fd1705").get -> 1.0))
  courses.find(f => f.id == "74ef596c07a14890b2ad4dadc8ee22c1").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  courses.find(f => f.id == "f0339f4a4b044604b9052151057f7f5a").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  courses.find(f => f.id == "e08dd7f0b8d04a71a05e82823ba0c2ea").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  courses.find(f => f.id == "91bcceedd89842c88e2bc5a0d0aa0961").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 1.0))
  courses.find(f => f.id == "d3fb3ba66c9241b5a5862548032ab800").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "f0e5128e4a26484d8eb7275175d197dd").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  courses.find(f => f.id == "3e0fcd8980b547f49066be8b1a8d1d76").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  courses.find(f => f.id == "c1184b01261e4fe393534ad86e25137c").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  courses.find(f => f.id == "c95255eb885a44cfa632274c3aab293c").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  courses.find(f => f.id == "e9e1c8adfd8d433b9c66a5aea5174c24").get.addSkills(Map(allSkills.find(s => s.id == "333388b402264e288a2852a6e4d20272").get -> 1.0))
  courses.find(f => f.id == "51ffbfe860ac4e70909946d1e34ba99b").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  courses.find(f => f.id == "8dbf49befef540c4b9eb3d5940f0aeba").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  courses.find(f => f.id == "37fd37d05cb847098dac4be7cdcfae40").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  courses.find(f => f.id == "123f2ce6dc2842478078e2d72ed6178a").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "123f2ce6dc2842478078e2d72ed6178a").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 1.0))
  courses.find(f => f.id == "be5a7377c2434ee3b0418fc1e6bb075f").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "d94bf22d690a4df9a1fce5a3753609c8").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  courses.find(f => f.id == "d7b58dbad5754e6e9ea4e5806fca57c4").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  courses.find(f => f.id == "89eb65f3f595491a8627cfda451bc6f0").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  courses.find(f => f.id == "01b5979d087e485da17de1c4f48255b9").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  courses.find(f => f.id == "f48261bc8bfe40a8949d55d6c1c58188").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  courses.find(f => f.id == "f77ba840018441629e046de3a8dc8026").get.addSkills(Map(allSkills.find(s => s.id == "68c215362c8948b2a8d6dfd25df925c7").get -> 1.0))
  courses.find(f => f.id == "d94bf22d690a4df9a1fce5a3753609c8").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  courses.find(f => f.id == "89eb65f3f595491a8627cfda451bc6f0").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  courses.find(f => f.id == "3006db25574b497b9397a1616a815467").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))


  // add skills to jobs
  jobs.find(f => f.id == "2bbd50bd27204f55bb8e74c21e93f8b9").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  jobs.find(f => f.id == "4a8a1a53c6834a73871228f4a884d5fa").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 1.0))
  jobs.find(f => f.id == "000bc0bd9eaa46cb98594c571aa4f825").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 1.0))
  jobs.find(f => f.id == "0e5e0bc2005c4b8b92bd533f3762d39b").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  jobs.find(f => f.id == "7dd5d961d4d349c9a4018fdef4e973a9").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 1.0))
  jobs.find(f => f.id == "6ddbd1f76a784ad881c20462bbea20c9").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  jobs.find(f => f.id == "f665aab53c9848a188a354a5e4fe47b8").get.addSkills(Map(allSkills.find(s => s.id == "333388b402264e288a2852a6e4d20272").get -> 1.0))
  jobs.find(f => f.id == "f98b4426f5da400ba03c676d019ff263").get.addSkills(Map(allSkills.find(s => s.id == "0206a97c41754c849effeeea46876313").get -> 1.0))
  jobs.find(f => f.id == "8b292f887e9b44769c877e81176c4c2c").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 1.0))
  jobs.find(f => f.id == "2bbd50bd27204f55bb8e74c21e93f8b9").get.addSkills(Map(allSkills.find(s => s.id == "32461f6423a641e19334963bb9cda38e").get -> 1.0))
  jobs.find(f => f.id == "6dac563b27d249b3b0bc8692887fd292").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 1.0))
  jobs.find(f => f.id == "1111d548159341cb8681cbb5e409839b").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 1.0))
  jobs.find(f => f.id == "57dae5e6eddb45d3a04e50248b38fecb").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  jobs.find(f => f.id == "0e5e0bc2005c4b8b92bd533f3762d39b").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  jobs.find(f => f.id == "0e4ae5716dc648c29d3250c798bdafab").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  jobs.find(f => f.id == "fdbe705ade6e411084dacda919b78bcc").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  jobs.find(f => f.id == "bb1785abf02c4c04a1407ee604844f51").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  jobs.find(f => f.id == "6ddbd1f76a784ad881c20462bbea20c9").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  jobs.find(f => f.id == "f98b4426f5da400ba03c676d019ff263").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  jobs.find(f => f.id == "69fd8a45ceb342b3ab19fba2288c7a71").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  jobs.find(f => f.id == "8b292f887e9b44769c877e81176c4c2c").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  jobs.find(f => f.id == "f942c67e903e443fab4c571007d76c17").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  jobs.find(f => f.id == "bb1785abf02c4c04a1407ee604844f51").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  jobs.find(f => f.id == "4fc748dd4f234aa6974fe31f77402bcd").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  jobs.find(f => f.id == "69fd8a45ceb342b3ab19fba2288c7a71").get.addSkills(Map(allSkills.find(s => s.id == "fdf54ec8c34c4c89a3a8928f7c59d0ef").get -> 1.0))
  jobs.find(f => f.id == "3fcbfa21df7b452f9bae6be1db75fc3c").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  jobs.find(f => f.id == "108d216eba744547ae32a12ddd864dae").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 1.0))
  jobs.find(f => f.id == "1111d548159341cb8681cbb5e409839b").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  jobs.find(f => f.id == "f182262ba16e4682a3f451d9f7c18856").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  jobs.find(f => f.id == "9fa4772b261049a48f0cc9c3f54e432d").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  jobs.find(f => f.id == "4bdd33af85cf4273bd7a8d49f34b4783").get.addSkills(Map(allSkills.find(s => s.id == "94aaa15fca5c4d0cbe2a3b3a93fd1705").get -> 1.0))
  jobs.find(f => f.id == "bb1785abf02c4c04a1407ee604844f51").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  jobs.find(f => f.id == "6ddbd1f76a784ad881c20462bbea20c9").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  jobs.find(f => f.id == "3a94bf2cb49647c88254138294d4202b").get.addSkills(Map(allSkills.find(s => s.id == "68c215362c8948b2a8d6dfd25df925c7").get -> 1.0))
  jobs.find(f => f.id == "57dae5e6eddb45d3a04e50248b38fecb").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  jobs.find(f => f.id == "108d216eba744547ae32a12ddd864dae").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 1.0))
  jobs.find(f => f.id == "edb88116a2234fd282156354d001b044").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  jobs.find(f => f.id == "63e9be9229df4ddfae36039c1662363d").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 1.0))
  jobs.find(f => f.id == "000bc0bd9eaa46cb98594c571aa4f825").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  jobs.find(f => f.id == "3a94bf2cb49647c88254138294d4202b").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  jobs.find(f => f.id == "9fa4772b261049a48f0cc9c3f54e432d").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  jobs.find(f => f.id == "f98b4426f5da400ba03c676d019ff263").get.addSkills(Map(allSkills.find(s => s.id == "b5d0fa8f30fa436392dac0e256ed0222").get -> 1.0))
  jobs.find(f => f.id == "108d216eba744547ae32a12ddd864dae").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  jobs.find(f => f.id == "d0935fd33948483a8b86d0be850ef49d").get.addSkills(Map(allSkills.find(s => s.id == "32a0d1063e6045c787f921138ecb87bd").get -> 1.0))
  jobs.find(f => f.id == "fdbe705ade6e411084dacda919b78bcc").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  jobs.find(f => f.id == "d0935fd33948483a8b86d0be850ef49d").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  jobs.find(f => f.id == "306900c8a6364decbbcb576f7e0c33ec").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  jobs.find(f => f.id == "0e4ae5716dc648c29d3250c798bdafab").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  jobs.find(f => f.id == "63e9be9229df4ddfae36039c1662363d").get.addSkills(Map(allSkills.find(s => s.id == "333388b402264e288a2852a6e4d20272").get -> 1.0))
  jobs.find(f => f.id == "306900c8a6364decbbcb576f7e0c33ec").get.addSkills(Map(allSkills.find(s => s.id == "81f9f60dd7c5422993bf4284bee66731").get -> 1.0))
  jobs.find(f => f.id == "6dac563b27d249b3b0bc8692887fd292").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  jobs.find(f => f.id == "cf3a824b5d4d42279e616afdb3b62424").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  jobs.find(f => f.id == "d0935fd33948483a8b86d0be850ef49d").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  jobs.find(f => f.id == "f942c67e903e443fab4c571007d76c17").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  jobs.find(f => f.id == "9fa4772b261049a48f0cc9c3f54e432d").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 1.0))
  jobs.find(f => f.id == "63e9be9229df4ddfae36039c1662363d").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  jobs.find(f => f.id == "8e8e31278e944f5f971238b00d84430a").get.addSkills(Map(allSkills.find(s => s.id == "621fc6e153af4d7da743d16c6fa1a502").get -> 1.0))
  jobs.find(f => f.id == "3fcbfa21df7b452f9bae6be1db75fc3c").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  jobs.find(f => f.id == "7dd5d961d4d349c9a4018fdef4e973a9").get.addSkills(Map(allSkills.find(s => s.id == "05039698528d4f2e8e99231d28e732ec").get -> 1.0))
  jobs.find(f => f.id == "4a8a1a53c6834a73871228f4a884d5fa").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  jobs.find(f => f.id == "1a43bd699ac24733b6b36c6dfeae5ad0").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 1.0))
  jobs.find(f => f.id == "6dac563b27d249b3b0bc8692887fd292").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 1.0))
  jobs.find(f => f.id == "57dae5e6eddb45d3a04e50248b38fecb").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  jobs.find(f => f.id == "fdbe705ade6e411084dacda919b78bcc").get.addSkills(Map(allSkills.find(s => s.id == "402c00884d15442a9139da8c7308707a").get -> 1.0))
  jobs.find(f => f.id == "7dd5d961d4d349c9a4018fdef4e973a9").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 1.0))
  jobs.find(f => f.id == "4bdd33af85cf4273bd7a8d49f34b4783").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  jobs.find(f => f.id == "f182262ba16e4682a3f451d9f7c18856").get.addSkills(Map(allSkills.find(s => s.id == "80daf82342504eb0a9bf8fe56e69d29f").get -> 1.0))
  jobs.find(f => f.id == "0e5e0bc2005c4b8b92bd533f3762d39b").get.addSkills(Map(allSkills.find(s => s.id == "9929beb3a81641899cd7371a24b34e78").get -> 1.0))
  jobs.find(f => f.id == "87524cb7eee645529099d1764df4a4ab").get.addSkills(Map(allSkills.find(s => s.id == "bd8f16bf092944c8bb6cc28ab3c9f6ee").get -> 1.0))
  jobs.find(f => f.id == "1a43bd699ac24733b6b36c6dfeae5ad0").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  jobs.find(f => f.id == "69fd8a45ceb342b3ab19fba2288c7a71").get.addSkills(Map(allSkills.find(s => s.id == "486b2767880c41489dca0790ff5923e1").get -> 1.0))
  jobs.find(f => f.id == "3a94bf2cb49647c88254138294d4202b").get.addSkills(Map(allSkills.find(s => s.id == "3fcd04e32b0d4ae3ace10bff3ed65498").get -> 1.0))
  jobs.find(f => f.id == "4fc748dd4f234aa6974fe31f77402bcd").get.addSkills(Map(allSkills.find(s => s.id == "4c99ab2182314b7aab1c8c92c1fa2bbf").get -> 1.0))
  jobs.find(f => f.id == "02c86a3b3d8249d3b406ba74cc87eb35").get.addSkills(Map(allSkills.find(s => s.id == "8f83f425589349bfa039f0a45938ab1d").get -> 1.0))
  jobs.find(f => f.id == "87524cb7eee645529099d1764df4a4ab").get.addSkills(Map(allSkills.find(s => s.id == "52bd3bd4482245ae8db0cedfc6113b31").get -> 1.0))
  jobs.find(f => f.id == "0e4ae5716dc648c29d3250c798bdafab").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  jobs.find(f => f.id == "cf3a824b5d4d42279e616afdb3b62424").get.addSkills(Map(allSkills.find(s => s.id == "db56591413bd407dbd99238661167acf").get -> 1.0))
  jobs.find(f => f.id == "f665aab53c9848a188a354a5e4fe47b8").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  jobs.find(f => f.id == "edb88116a2234fd282156354d001b044").get.addSkills(Map(allSkills.find(s => s.id == "4ab013f80a1a42e7b4d28e25f04e594f").get -> 1.0))
  jobs.find(f => f.id == "8b292f887e9b44769c877e81176c4c2c").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 1.0))
  jobs.find(f => f.id == "8e8e31278e944f5f971238b00d84430a").get.addSkills(Map(allSkills.find(s => s.id == "93e6ba0417134b0d9459b4257c000c29").get -> 1.0))
  jobs.find(f => f.id == "f942c67e903e443fab4c571007d76c17").get.addSkills(Map(allSkills.find(s => s.id == "4c99ab2182314b7aab1c8c92c1fa2bbf").get -> 1.0))
  jobs.find(f => f.id == "87524cb7eee645529099d1764df4a4ab").get.addSkills(Map(allSkills.find(s => s.id == "0f6837aaf5f3464294c811013bb4ff1c").get -> 1.0))
  jobs.find(f => f.id == "02c86a3b3d8249d3b406ba74cc87eb35").get.addSkills(Map(allSkills.find(s => s.id == "68c215362c8948b2a8d6dfd25df925c7").get -> 1.0))
  jobs.find(f => f.id == "f665aab53c9848a188a354a5e4fe47b8").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  jobs.find(f => f.id == "1111d548159341cb8681cbb5e409839b").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  jobs.find(f => f.id == "3fcbfa21df7b452f9bae6be1db75fc3c").get.addSkills(Map(allSkills.find(s => s.id == "dfd02e90fa504e19b6428cc20d71d6ed").get -> 1.0))
  jobs.find(f => f.id == "2bbd50bd27204f55bb8e74c21e93f8b9").get.addSkills(Map(allSkills.find(s => s.id == "0206a97c41754c849effeeea46876313").get -> 1.0))
  jobs.find(f => f.id == "f182262ba16e4682a3f451d9f7c18856").get.addSkills(Map(allSkills.find(s => s.id == "7ae9cae404174e97b47d3f06d105b471").get -> 1.0))
  jobs.find(f => f.id == "8e8e31278e944f5f971238b00d84430a").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 1.0))
  jobs.find(f => f.id == "cf3a824b5d4d42279e616afdb3b62424").get.addSkills(Map(allSkills.find(s => s.id == "dfddb1e3796d4ffa8b014bda7fcda34b").get -> 1.0))
  jobs.find(f => f.id == "02c86a3b3d8249d3b406ba74cc87eb35").get.addSkills(Map(allSkills.find(s => s.id == "ddcb1273c6c04c4f847827146780631a").get -> 1.0))
  jobs.find(f => f.id == "edb88116a2234fd282156354d001b044").get.addSkills(Map(allSkills.find(s => s.id == "7c74c10042b548c9acc18c52831b358b").get -> 1.0))
  jobs.find(f => f.id == "306900c8a6364decbbcb576f7e0c33ec").get.addSkills(Map(allSkills.find(s => s.id == "77a8d50657cc4f91b4fa64db70348c99").get -> 1.0))
  jobs.find(f => f.id == "4fc748dd4f234aa6974fe31f77402bcd").get.addSkills(Map(allSkills.find(s => s.id == "5cee195716e34fd8a6071bdd1f7bb99c").get -> 1.0))
  jobs.find(f => f.id == "1a43bd699ac24733b6b36c6dfeae5ad0").get.addSkills(Map(allSkills.find(s => s.id == "f3afdbf6a45241c6953a73bf58cef8c5").get -> 1.0))
  jobs.find(f => f.id == "4a8a1a53c6834a73871228f4a884d5fa").get.addSkills(Map(allSkills.find(s => s.id == "55683d573c7943619fd722a15825b344").get -> 1.0))
  jobs.find(f => f.id == "000bc0bd9eaa46cb98594c571aa4f825").get.addSkills(Map(allSkills.find(s => s.id == "e516d22f4e064263a94de2f8686bf69c").get -> 1.0))
  jobs.find(f => f.id == "4bdd33af85cf4273bd7a8d49f34b4783").get.addSkills(Map(allSkills.find(s => s.id == "bad35a2240814a6e83ffb55513f34cf1").get -> 1.0))

  override def addMultiRelated(id: String, entity_type: String, algo: String, data: List[Map[String, Any]])(implicit request: RequestHeader): List[Map[String, Any]]  = ???

  override def addRelated(id1: String, entity_type1: String, id2: String, entity_type2: String, algo: String, data: Map[String, Any])(implicit request: RequestHeader):  Map[String,Any]= ???



  override def getSkillBySkillId(id: String,algo:String=defaultAlgo, filters: Map[String,Any],  page:Int, limit:Int)(implicit request: RequestHeader): List[(Skill, Double)] = ???

  override def getCareersByCategoryId(id: String, algo: String, filters: Map[String,Any],  page:Int, limit:Int)(implicit request: RequestHeader): List[(Career, Double)] = ???

  override def getSkillsByCategoryId(id: String, algo: String, filters: Map[String,Any],  page:Int, limit:Int)(implicit request: RequestHeader): List[(Skill, Double)] = ???

  override def getCoursesByCategoryId(id: String, algo: String, filters: Map[String,Any],  page:Int, limit:Int)(implicit request: RequestHeader): List[(Course, Double)] = ???

  override def index(entity: String, indexAll: Boolean = false, ids: List[String] = List[String]())(implicit request: RequestHeader) : Int = ???

  override def getJobsBySkillId(id: String, algo: String, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Job, Double)] = ???
}
