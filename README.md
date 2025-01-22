File Reading:

The  process_selected_File is the method in which all the words are being read from the file and is inherited as Methods class to Word_From_File1 & Word_From_File2 for using the following Methods:-

1. The readWordsFromFile method reads each line from the file and stores the words in a HashSet. This allows us to quickly check if a prefix or suffix exists in the word list, which is crucial for identifying compounded words.
Compounded Word Detection:

2. The isCompoundedWord method checks if a word can be split into two smaller valid words. It does this by trying all possible split points and checking if both parts of the split word exist in the word set. If both parts exist, the word is considered compounded.
Time Measurement:

3. The program uses System.nanoTime() to measure the start and end time of processing each file. The difference is then converted to milliseconds using TimeUnit.NANOSECONDS.toMillis().
Results Output:

For each file, the program displays the longest and second longest compounded words along with the time taken to process the file.
