package ua.unit.tbujalo.fileWorker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class OutputWriter {
    private static OutputWriter writer = new OutputWriter();
    private String fileName;

    private OutputWriter() {
        fileName = "output.txt";
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))){
            pw.write("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static OutputWriter getInstance(){
        return writer;
    }

    public void writeMessage(String message){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true))){
            pw.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
