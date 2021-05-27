# Searcher
Find worlds in text

##How To Run
* To run program install JDK
* To generate jar install GRADLE

###Instruction to setup environment, build and run app

* Install JDK and GRADLE
* Go to source app directory
* In console use gradle build
* Copy .jar to external directory
* In external directory create subfolder for example files
* In new folder create some text files with some words
* Execute app using command: java -jar Searcher-1.0.jar Searcher files

##Subject of the task
The exercise is to write a​ ​command-line​ driven text search engine, with usage being: 
* java -jar jarName mainClassFile directoryContainingTextFiles

This should read all the text files in the given directory, building an ​in-memory ​representation of the files and their contents, and then give a command prompt at which interactive searches can be performed.
The search should take the words given on the prompt and return a list of the top 10 (maximum) matching filenames in rank order, giving the rank score against each match.

###Ranking
* The rank score must be 100% if a file contains all the words
* It must be 0% if it contains none of the words
* It should be between 0 and 100 if it contains only some of the words but the exact ranking formula
is up to you to choose and implement


