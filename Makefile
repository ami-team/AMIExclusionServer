all: package
	echo "done"

compile:
	mvn compile

package:
	mvn package

clean:
	mvn clean
