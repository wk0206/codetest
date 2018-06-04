package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;


public class fileWriteTest {
	
	public static void test() throws IOException{
		File file = new File("/home/wk/Documents/source.txt");
		//File tempFile = new File("", file.getName() + i + CONSTANTS.SUFFIX);

		FileOutputStream os = new FileOutputStream(file);
		//ByteArrayOutputStream bs = new ByteArrayOutputStream();
	
		//long smallFileStart = i * sizeInByte;
		//long smallFileEnd = (i + 1) * sizeInByte;
		Random rnd = new Random();
	
		for(int i = 0; i <1024*1024;i++){
			Integer x = Integer.valueOf(rnd.nextInt());
			byte[] result = intToByteArray1(x);
			//System.out.println((byte)x;);
			//os.write(0);
			//bs.write(result);
			os.write(result);
//			os.write((Byte)byte[0]);
//			os.write(byte[1]);
//			os.write(byte[2]);
//			os.write(byte[3]);
		}
	
		os.close();

	}
	
	public static void test2() throws IOException{
		File file = new File("/home/wk/Documents/DiskCache.txt");
		//File tempFile = new File("", file.getName() + i + CONSTANTS.SUFFIX);

		FileInputStream is = new FileInputStream(file);
	
		//long smallFileStart = i * sizeInByte;
		//long smallFileEnd = (i + 1) * sizeInByte;
	
		for(int i = 0; i <104860; i++){
			byte[] result = new byte[4];
		
			is.read(result);
			int x = fromByteArray(result);
			//if(x!=0)System.out.println(i+"_"+x);
			if(i<10) {
				System.out.println(i+"_"+x);
			}
			
			if(4190<i && i <4200) {
				System.out.println(i+"_"+x);
			}
			
			if(i>104840) {
				System.out.println(i+"_"+x);
			}
			
		}
	
		is.close();

	}
	
	public static void test5() throws IOException{
		File file = new File("/home/wk/Documents/test4.txt");
	    long start = System.currentTimeMillis();  
	    RandomAccessFile raf = new RandomAccessFile(file, "rw");
	    
	    raf.writeBytes("hello world");
	    raf.writeBytes("Hello World!");  
        raf.writeBoolean(true);  
        raf.writeInt(30);  
        raf.writeDouble(3.56);  
        raf.close();
        
        
	    long end = System.currentTimeMillis();  
	    System.out.println("total times "+(end-start));  

	}
	
	public static void test6() throws IOException{
		File file = new File("/home/wk/Documents/test4.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
	    long start = System.currentTimeMillis();  
	    raf.seek(12);//设置指针的位置  
        boolean booleanValue = raf.readBoolean();  
        int intValue = raf.readInt();  
        double doubleValue = raf.readDouble();  
        raf.seek(0);//设置指针的位置为文件的开始部分  
        byte[] bytes = new byte[12];  
        for (int i=0; i<bytes.length; i++)  
            bytes[i] = raf.readByte();//每次读一个字节，并把它赋值给字节bytes[i]  
        String stringValue = new String(bytes);  
        raf.skipBytes(1);//指针跳过一个字节  
        int intValue2 = raf.readInt();  
        raf.close();  
        System.out.println(booleanValue);  
        System.out.println(intValue);  
        System.out.println(doubleValue);  
        System.out.println(stringValue);  
        System.out.println(intValue2);  

	}
	
	public static byte[] intToByteArray1(int i) {   
		  byte[] result = new byte[4];   
		  result[0] = (byte)((i >> 24) & 0xFF);
		  result[1] = (byte)((i >> 16) & 0xFF);
		  result[2] = (byte)((i >> 8) & 0xFF); 
		  result[3] = (byte)(i & 0xFF);
		  return result;
		}	
	
	static int fromByteArray(byte[] bytes) {
	     return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
	}
	
	public static void main(String[] args) throws IOException {
		//test();
		
		test2();
		Long size = (long) (4L*1024*1024*1024);
		//test3(size);
		
		//test4(size);
		//test5();
		//test6();
	}
	
	public static void test3(long length) throws IOException{
		File file = new File("/home/wk/Documents/test3.txt");
		long start = System.currentTimeMillis();  
	    FileOutputStream fos = null;  
	    FileChannel output = null;  
	    try {  
	       fos = new FileOutputStream(file);  
	       output = fos.getChannel();  
	       output.write(ByteBuffer.allocate(1), length-1);  
	    } finally {  
	        try {  
	           if (output != null) {  
	               output.close();  
	           }  
	           if (fos != null) {  
	               fos.close();  
	           }  
	        } catch (IOException e) {  
	           e.printStackTrace();  
	       }  
	    }  
	    long end = System.currentTimeMillis();  
	    System.out.println("total times "+(end-start)); 

	}
	
	public static void test4( long length) throws IOException{  
		File file = new File("/home/wk/Documents/test4.txt");
        long start = System.currentTimeMillis();  
        RandomAccessFile r = null;  
        try {  
            r = new RandomAccessFile(file, "rw");  
            r.setLength(length);  
        } finally{  
            if (r != null) {  
                try {  
                    r.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        long end = System.currentTimeMillis();  
        System.out.println(end-start);  
          
    } 	

}
