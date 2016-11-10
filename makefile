

all: compile run clean 

compile:
	@echo "\033[01;32mCompile..."
	javac editor.java

run:
	@echo "\033[01;32mRun..."
	java editor

clean:
	rm -rf *.class
