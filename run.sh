find . -name *.java > sources.txt
mkdir -p bin
javac -d bin -sourcepath src @sources.txt
java -cp bin:ua/unit/tbujalo/ ua.unit.tbujalo.Main
