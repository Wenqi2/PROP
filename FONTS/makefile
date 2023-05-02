JUNIT_JARS = ./lib/junit-4.12.jar:./lib/hamcrest-core-1.3.jar
OUT =	../EXE/out/

INPUT =	./Domini/*.java \
				./Domini/Driver/*.java \

JAR_OUTPUT = ../EXE/

default:
	javac -d $(OUT) ./Presentacio/Presentacio.java
	jar cmvf ./Presentacio/Presentacio.mf $(JAR_OUTPUT)/GestorDocuments.jar -C $(OUT) .


Gestor:
	java -jar $(JAR_OUTPUT)/GestorDocuments.jar

clean:
	rm -r ../EXE/out/*

distclean:
	rm -r ../EXE/GestorDocuments.jar