package pattern.decorator;

import java.io.*;

public class BufferedOutputStream extends OutputStream {

    byte[] buffer = new byte[1024]; // Puffer für 1024 Bytes
    int counter = 0;
    OutputStream out; // dekoriertes Objekt
    public BufferedOutputStream(OutputStream s) {
        out = s;
    }

    public void close() throws IOException {
        if (counter > 0) // falls Puffer nicht leer: leeren
        {
            out.write(buffer, 0, counter);
            counter = 0;
        }
        out.close(); //eigentliche Operation delegieren
    }

    public void flush() throws IOException {
        if (counter > 0) // falls Puffer nicht leer: leeren
        {
            out.write(buffer, 0, counter);
            counter = 0;
        }
        out.flush(); //eigentliche Operation delegieren
    }

    public void write(int i) throws IOException {
        buffer[counter] = (byte) i; // in Puffer legen
        counter++;
        if (counter == 1024) // falls Puffer voll
        {
            out.write(buffer); // Puffer in Stream schreiben
            counter = 0;
        }
    }

    public void write(byte[] b) throws IOException {
        int i;
        for (i = 0; i <= b.length; i++) {
            buffer[counter] = b[i]; // in Puffer legen
            counter++;
            if (counter == 1024) // falls Puffer voll
            {
                out.write(buffer); // Puffer in Stream schreiben
                counter = 0;
            }
        }
    }

    public void write(byte[] b, int off, int len) throws IOException {
        int i;
        for (i = off; i <= off + len; i++) {
            buffer[counter] = b[i]; // in Puffer legen
            counter++;
            if (counter == 1024) // falls Puffer voll
            {
                out.write(buffer); // Puffer in Stream schreiben
                counter = 0;
            }
        }
    }
}