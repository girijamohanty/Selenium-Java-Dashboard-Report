
#Selenium/Serenity/JBehave/BDD Framework Project
A framework skeleton for testing using Selenium/Serenity/JBehave.

[Selenium](http://www.seleniumhq.org/docs/index.jsp)  
[Serenity](http://thucydides.info/docs/serenity-staging/)  
[JBehave](http://jbehave.org/)  

## Serenity Report
Target/site/serenity

## Customized Report
src/main/reports


## Captured Video for observation
Target/recording

## To Run
For most fun and functionality modify the pom.xml with your account stuff. Right now it is in Github.
The tests just send a simple "Hello" tweet and star this repo. There's also a Google test that doesn't require
any credentials.

__mvn verify__  is all that's required to run the tests via Firefox.  
__mvn -Psauce verify__ will run tests on Sauce Labs.  


* Will also generate an aggregated test report in target/serenity/index.html



