find src/ -name "*.java" > sources.txt
mkdir -p bin
javac -d bin -sourcepath src @sources.txt
if [ $? -eq 0 ]
then
	java -cp bin:ua/unit/tbujalo/ ua.unit.tbujalo.Main
fi
