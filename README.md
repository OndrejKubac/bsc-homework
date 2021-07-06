# BSC Homework

##App definition
Simple console application which reads console inputs of defined format and persists them into memory.
Ongoing state is displayed every minute in console.

##Run application
1. Perform maven clean install
2. bsc-homework-1.0-SNAPSHOT.jar file will be created in target folder
3. Run application by command *java -jar bsc-homework-1.0-SNAPSHOT.jar*
##Input description
**weight**: positive number greater than 0 with maximal 3 decimal places

**postal code**: fixed 5 digits number

##Input options

1. Insert package information (format: [weight] [postal code]), e.g. *1.123 12345*
2. Quit application, e.g. *quit*
3. Process file with package information (format: [run - path]), e.g *run - src/main/resources/init_values.txt*

