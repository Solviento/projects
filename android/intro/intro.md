Intro to Building your Own Android App
(taken from youtube)

- Download and Install Android Studio (google search)

- Open and download any additional files from Android Studio

- Create a new project from start menu

- Configure settings for new projects (pick defaults)

Android Manifest

- In the project tree structure, a file called
 AndroidManifest.xml is where we will perform modifications
 for our app if we need additional permissions from the system
- Note: the res folder stands for resources
- In my directory structure, it is found in:

 First App
     \
      app
	 	\
		manifests
			\
		 	AndroidManifest.xml

- Every android application must have an AndroidManifest file
- Typically you will add a list of permissions needed by your app
in this file

MainActivity.java

- We can find our main activity java file under the java folder and then
under the company_domain_name.welcome folder  as seen in the above. 

Res folder 
- This folder is where different resources for the project are kept, 
graphics, string values, menus and where the definition of the user
interface is stored
- Layout and Values are the more important res subfolders for building
early apps
- The values folder contains several different xml files
	- strings.xml is an important xml file in this folder

activity_main.xml

- Can be found in app->res->layout
- This xml file describes the user interface. You can either modify
the code or use the UI designer that changes the code accordingly
- Typically an android beginner will use the UI designer for editing
the main xml file

More xml files
- The values folder (found in main->res->values) contains even more
 xml files that we can modify.

strings.xml
- Rather than hardcoding string values straight into the code, we
use reference IDs in strings.xml to allow any needed changes in strings

Writing the App

- First 
