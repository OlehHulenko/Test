package ua.hulenkoOleg;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class JavaIO {
    public static String read(String fileName) throws FileNotFoundException {
        //���� ����. ������ ��� ���������� ������
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        exists(fileName);

        try {
            //������ ��� ������ ����� � �����
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //� ����� ��������� ��������� ����
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //����� �� �������� ������� ����
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //���������� ���������� ����� � �����
        return sb.toString();
    }

    public static void exists(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if(!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
}
