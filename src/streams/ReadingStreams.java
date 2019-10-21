package streams;

import java.io.*;

class ReadingStreams {
    public static void main(String[] args) throws IOException {
        streamToBytes();
        readArrayOfBytes();
        streamToChar();
        readArrayOfChars();
    }

    private static void streamToBytes() throws IOException {
        InputStream byteStream = new FileInputStream("src/streams/input.txt");
        int intVal;

//   note: read returns the byte (-1 when none left)
        System.out.println("byte values from file");
        while ((intVal = byteStream.read()) >= 0) {
            byte byteVal = (byte) intVal;
            System.out.println(byteVal);
        }
    }

    private static void readArrayOfBytes() throws IOException {
        InputStream byteStream = new ByteArrayInputStream("myString".getBytes());
        int length;
        byte[] byteBuff = new byte[10];

//  note: input.read returns length of buffer
        System.out.println("byte values from byte[]");
        while ((length = byteStream.read(byteBuff)) >= 0) {
//      we now need to iterate over the byte buffer to get the data
            for (int i = 0; i < length; i++) {
                byte byteVal = byteBuff[i];
                System.out.println(byteVal);
            }
        }

    }

    private static void streamToChar() throws IOException {
        Reader reader = new FileReader("src/streams/input.txt");
        int intVal;

        System.out.println("char values from file");
//  note: read returns the byte (-1 when none left)
        while ((intVal = reader.read()) >= 0) {
            char charVal = (char) intVal;
            System.out.println(charVal);
        }
    }

    private static void readArrayOfChars() throws IOException {
        Reader reader = new StringReader("myString");
        int length;
        char charBuff[] = new char[10];
//  note: input.read returns length of char buffer
        System.out.println("byte values from char[]");
        while ((length = reader.read(charBuff)) >= 0) {
        //   we now need to iterate over the byte buffer to get the data
            for (int i = 0; i < length; i++) {
                char byteVal = charBuff[i];
                System.out.println(byteVal);
            }
        }
    }
}