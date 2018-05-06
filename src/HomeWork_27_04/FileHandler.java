package HomeWork_27_04;


import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class FileHandler {

    public void copyFileUsingStream(File source, File target) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(target))) {
            int len;
            while ((len = is.read()) > 0) {
                os.write(len);
            }
        }
    }

    public void copyFile(File source, File target) throws IOException {
        Files.copy(source.toPath(), target.toPath());
    }

    public void splitFileOnParts(File source, int sizeFile) throws IOException {
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream((source)))) {
            int numberFile = 1;
            byte[] buffer = new byte[sizeFile];
            String fileName = "part";
            int len = 0;
            while ((len = is.read(buffer)) > 0) {
                String filePartName = String.format("%s%d.txt", fileName, numberFile++);
                File newFile = new File(source.getParent(), filePartName);
                try (OutputStream os = new FileOutputStream(newFile)) {
                    os.write(buffer, 0, len);
                }
            }
        }
    }

    public void glueFiles(List<String> fileList, String fileName) throws IOException {
        List list = fileList;
        try (OutputStream os = new FileOutputStream(new File(fileName))) {
            for (String s : fileList) {
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(s)))) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = bis.read(buffer)) > 0) {
                        os.write(buffer, 0, len);
                    }
                }
            }
        }
    }
}
