#!/bin/bash

mkdir src/main/java/Day$1
cp -r src/main/java/Day00/DayXX.java src/main/java/Day$1/Day$1.java
sed -i bak -e "s#Day00;#Day$1;#"  -e "s#DayXX#Day$1#" src/main/java/Day$1/Day$1.java
rm src/main/java/Day$1/*.javabak

mkdir src/test/java/Day$1
cp -r src/test/java/Day00/Day00Test.java src/test/java/Day$1/Day$1Test.java
sed -i bak -e "s#Day00;#Day$1;#"  -e "s#Day00Test#Day$1Test#" -e "s#Day day;#Day$1 day;#" -e "s#new Day#new Day$1#" src/test/java/Day$1/Day$1Test.java
rm src/test/java/Day$1/*.javabak