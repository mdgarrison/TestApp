This is the README.md file for the TestApp project.  This project is the implementation of a JavaFX application which performs simple analysis of the git objects (the index, the refs, and the objects) in the .git directory relative to the current path.

TestApp is a simple project designed to demonstrate and exercise the following technologies:

      Java
      JavaFX
      SceneBuilder
      Gradle
      Git

Build and Execution Instructions:

      1. Ensure that controlsfx-8.40.10.jar is located at %JAVA_HOME%\jre\lib\ext
      2. From the root folder, type 'gradle assemble'
      3. From the root folder, type java -jar build/libs/TestApp.jar

Build Output:
      When the program starts, it displays the contents of the .git index file.  This output includes:
      1. Index length in bytes
      2. Index signature
      3. Index version
      4. Number of entries in the index
      5. For each entry in the index, the output includes:
         a) The SHA-1 value of the entry
         b) The flags value of the entry
         c) The path name of the entry

Note:  I eventually want to represent these entries as graphical objects in the GUI window.
