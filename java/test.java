import java.io.*;
import java.nio.channels.FileChannel;

public class test {

    public static void main(String[] args) throws IOException
    {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel  toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel,position,count);

    }
}
class Person
{
    int id;
    String name;
    double height;
    public Person()
    {
    }
    public Person(int id, String name, double height)
    {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public void write(RandomAccessFile raf) throws IOException
    {
        raf.writeInt(id);
        raf.writeUTF(name);
        raf.writeDouble(height);
    }

    public void read(RandomAccessFile raf) throws IOException
    {
        this.id = raf.readInt();
        this.name = raf.readUTF();
        this.height = raf.readDouble();
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getHeight()
    {
        return height;
    }
    public void setHeight(double height)
    {
        this.height = height;
    }

}
