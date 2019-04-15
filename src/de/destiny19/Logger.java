package de.destiny19;

import java.io.PrintStream;

public class Logger {
    @Injectable private static PrintStream stream;

    public static void setStream(PrintStream _stream){
        stream = _stream;
    }

    public static void trace(String s){
        stream.printf("[LOG]: %s\n", s);
    }
}
