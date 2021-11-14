Pre-Condition:
--------------

Java jdk 11 or greater should be Installed.

Latest version of Chrome and Mozilla browser should be Installed.

Latest version of Git should be Installed.

Latest version of Maven should be Installed.

User Guide to Execute Api Test:

1.Download the workspace and Keep in local directories.

2.Open the workspace in intellij.

3.To start execution

                 - In left panel open the api-test[commtest] project 
                 
                 - Go to src->main->resources->config.properties , 
	                    - mention the base url for api automation.
                        - mention the api_id and app_key for rest api automation.
	                     		
                 -  In api-test[commtest] project open the directory called Testsuite.
                 
                 -  In Testsuite open the Testng.xml file.
                 
                 -  In opened Testng file ,right click in the inside panel of file.
                 
                 -  And click Run(This will execute Api test).
                 
                 -  After execution go to reports - AutomationReport.html to see the results.

![api-test-report1](https://user-images.githubusercontent.com/56835649/141675415-ca450b5d-1e54-44db-ac07-b6fbfff30032.jpg)
![api-test-report](https://user-images.githubusercontent.com/56835649/141675425-19be3eca-e29d-4a67-a251-31f8c505493f.jpg)



