 maven java project:
 mvn clean -> clear "target" folder
 mvn compile -> compile java classes to .class code (byte code) in target
 mvn test -> (include compile), run all test cases
 mvn package -> (include compile + test), generate jar in target folder
 mvn install -> ( include compile + test + package), copy jar to .m2 folder
 (local repository)

 maven spring boot project:
 mvn spring-boot:run -> start up app server(web + app)
  step 1: @springbootApplication (java file should be located at root directory)
  step 2: @ComponentScan -> Find java class that annotated by @Component (@Controller, @Service, @Repository, @Configuartion), for example, Acontrolller.class, Bservice.class
  step 3: new objects of Acontroller.class & Bservice.class, put them into 
  SpringContext
  step 3.1: Acontroller.class depends on Bservice.class (Because you @Autowired 
  Bservice.class into Acontroller.class)
  step 3.2: So, it will new Bservice.class first.
  step 3.3: It will find the object of Bservice from SpringContext is order to
  create the new object of Acontroller (inject Bservice object)