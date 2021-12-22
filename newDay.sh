#!/bin/bash

mkdir src/main/java/day$1
cp -r src/main/java/day00/DayXX.java src/main/java/day$1/Day$1.java
sed -i bak -e "s#day00;#day$1;#"  -e "s#DayXX#Day$1#" src/main/java/day$1/Day$1.java
rm src/main/java/day$1/*.javabak

mkdir src/test/java/day$1
cp -r src/test/java/day00/DayXXTest.java src/test/java/day$1/Day$1Test.java
sed -i bak -e "s#day00;#day$1;#"  -e "s#DayXX#Day$1#" src/test/java/day$1/Day$1Test.java
sed -i bak -e "s#\"0\",#\"$1\",#" src/test/java/day$1/Day$1Test.java
rm src/test/java/day$1/*.javabak