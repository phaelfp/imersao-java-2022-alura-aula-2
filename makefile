all: compile run

run:
	java -classpath ./lib/gson-2.9.0.jar:./src App

compile:
	javac -classpath ./lib/gson-2.9.0.jar src/Filme.java src/ListOfFilmes.java src/JsonParser.java src/App.java
