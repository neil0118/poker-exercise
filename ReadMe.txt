building instructions:

bash build.sh

or 

javac *.java
jar -cvmf manifest.txt my-poker-solution.jar *.class
cat poker-hands.txt | java -jar my-poker-solution.jar