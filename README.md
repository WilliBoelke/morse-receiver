# morse-receiver
A morse receiver and decoder implemented in Gnu Radio and Java

## Gnu Radio 
This includes a GNU radio application which is meant to receive signals using a SDR. 
It will put a thresshold on the received sigal and write it to a txt file. 

## Java 
The Java Program is meant to read the TXT file and decode the morese code written to it into readable Text.
This works fairly precise - though it may also decode single letters wrong.