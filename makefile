all: compile run

run:
	java -classpath ./lib/gson-2.9.0.jar:./bin App

compile:
	javac -classpath ./lib/gson-2.9.0.jar src/*.java -d bin

clear:
	rm -rf ./bin/* ./saida/*