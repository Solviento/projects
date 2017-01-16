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
 - In my directory structure, it is found in:

 First App
     \
      app
      	\
	 src
	  \
	   main
	    \
	     AndroidManifest.xml
	

MainActivity.java

- We can find our main activity java file in the main folder
 as seen in the above. Inside the main folder, mainactivity.java
 will be located in the java folder.


activity_main.xml

- Can be found in main->res->layout
- This xml file describes the user interface. You can either modify
 the code or use the UI designer that change the code accordingly

 More xml files
 - The values folder (found in main->res->values) contains even more
  xml files that we can modify.

  strings.xml
  - Rather than hardcoding string values straight into the code, we
  use reference IDs in strings.xml to allow any needed changes in strings

 Writing the App

 - First 
