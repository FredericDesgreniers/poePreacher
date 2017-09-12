package preacher.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderToString {
    
    public static String getString(BufferedReader bufferedReader){
        try{
            return tryToGetString(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BufferedReaderToStringException("Could not get string from buffered reader");
        }
    }

    private static String tryToGetString(BufferedReader bufferedReader) throws IOException {
        StringBuilder stringFromUrlBuilder = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null){
            stringFromUrlBuilder.append(line);
        }
        return stringFromUrlBuilder.toString();
    }
    
}
