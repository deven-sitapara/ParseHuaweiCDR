# Parse Huawei CDR


Commands to execute

copy following files to destination location or /usr/bin

-   huawei_parser.jar
-   huawei_parser


Now here is how to convert Huawei .dat CDR to csv.


    huawei_parser ./FLHE2018040311464300252754.dat ./FLHE2018040311464300252754.csv


Command:

    huawei_parser [source] [destination]

    [options]

    [source] = source .dat file should be exists and with full path
    [destination] = destination .csv file should not be exists and with full path

Errors

    Source file not found:
        When .dat file not found
    Destination file already exists
        When .csv file alredy exists
