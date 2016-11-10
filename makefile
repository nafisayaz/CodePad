

all: compile run clean 

compile:
	@echo "\033[01;32mCompile..."
	javac editorApp.java

run:
	@echo "\033[01;32mRun..."
	java editorApp

clean:
	rm -rf *.class
