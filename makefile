all: compile run

run:
	java -classpath src App

compile:
	javac src/JsonParser.java src/App.java
