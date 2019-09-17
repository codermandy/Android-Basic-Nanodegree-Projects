# Android-Basics-Projects
These are collection of my display apps I learnt to build during Android Basics Course. I used xml to create the designs and they all are based on material design. Android Studio was used to create these projects.
# How to open projects in Android Studio?
1. Download and Unzip the github project to a folder.
2. Open Android Studio.
3. Go to File->Import Project. Then choose the specific project you want to import.
4. click Next->Finish. It will build the Gradle automatically and'll be ready for you to use.
# Additional Notes
 In some versions of Android Studio a certain error occurs- error:package android.support.v4.app does not exist. To fix it go to Gradle Scripts->build.gradle(Module:app) and the add the dependecies:

dependencies {      
  compile fileTree(dir: 'libs', include: ['*.jar'])  
  compile 'com.android.support:appcompat-v7:21.0.3'  
}

Then start an emulator and run your app
