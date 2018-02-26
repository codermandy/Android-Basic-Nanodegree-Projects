This is an Android project example with real-life tools and problems solved. It strives to demonstrate best practices over over-simplified examples 


Structure

    .idea 
    buildSrc 
        :class-gen
        :class-gen-tasks
    gradle
    :core
    :feature
        :f:about
        :f:about-contract
        :f:base
        :f:main
    :app



Glossary

    Android: a mobile platform building applications for smartphones
    Gradle: a build system that helps combining multiple projects (modules) into a single build flow.
    Android Gradle Plugin (AGP): a Gradle plugin that sets up project conventions for Android development and handles to heavy lifting of communicating with the Android SDK.
    Android Studio (AS): an IDE by Google based on IntelliJ IDEA Community, specifically tailored for Android development.
    IntellIJ IDEA: an IDE platform by JetBrains for polyglot software engineering. I'll refer to IDEA in most places instead of AS to demonstrate that it's true if someone is using raw IntelliJ IDEA Community/Ultimate as their IDE.
    module: a gradle subproject used to hold a bit of functionality in the project. Self-contained: built, packaged, tested individually.

