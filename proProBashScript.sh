#!/usr/bin/bash

# @author : Niall Martin Ryan
echo "compiling";
javac -cp ".;jna-platform-4.2.1.jar;jna-4.2.1.jar;mysql-connector-java-5.1.38-bin;jcommon-1.0.23.jar;jfreechart-1.0.19.jar;" *.java

echo "executing";
java -cp ".;jna-platform-4.2.1.jar;jna-4.2.1.jar;jcommon-1.0.23.jar;jfreechart-1.0.19.jar;" getActiveWindow

echo "complete"