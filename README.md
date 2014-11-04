ExcelRecordReaderMapReduce
==========================

<h3><b>MapReduce Input format for hadoop mapreduce to read Microsoft Excel spreadsheet</b></h3>
 
License
 
Apache licensed.
 
<h2><b>Usage</h2></b>
1. Download and run ant. <br>
2. Include ExcelRecordReaderMapReduce-0.0.1-SNAPSHOT.jar in your environment <br>
3. Use ExcelInputFormat class as Mapper's input format. <br>
 
<br>
Check src/test/resource/test.xls to see demofile.
The key returned is the file offset which starts with zero and value is the all columns value for single row.
Zip files are not supported
 
Execute the job as
hadoop jar ExcelRecordReaderMapReduce-0.0.1-SNAPSHOT-jar-with-dependencies.jar in out
 
 
hadoop fs -cat out/part*
0       Buffet  Jimmy   Somewhere on the Beach  Key West        FL
1       Bush    George  1600 Pennsylvania Ave   Washington      DC
2       Cartman Eric    84 Bigboned Way South Park      CO
3       Crockett        Davey   The Alamo       San Antonio     TX
4       Doe     Jane    821 Zimbabwe Ave        DC
5       Gates   Bill    1 Microsoft Way Redmond WA
