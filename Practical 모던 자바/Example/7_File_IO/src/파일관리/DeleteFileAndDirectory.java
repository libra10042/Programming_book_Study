package 파일관리;

import java.io.IOException;
import java.nio.file.*;

public class DeleteFileAndDirectory {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage : java DeleteFileAndDirectory <path>");
        }

        Path path = Paths.get(args[0]);

        try {
            Files.delete(path); // 삭제한다.
        } catch (NoSuchFileException e) {
            System.err.format("%s : 파일 혹은 디렉터리가 없습니다. %n", path);
            e.printStackTrace();
        } catch (DirectoryNotEmptyException e) {
            System.err.format("%s : 디렉터리가 비어 있지 않습니다. %\n", path);

            // 심볼릭 링크가 아닐 경우만 삭제
            if (!Files.isSymbolicLink(path)) {
                deleteNotEmptyDirectory(path);
            }
        } catch(IOException e){
            System.err.println(e);
        }


    }

    private static void deleteNotEmptyDirectory(Path path) throws IOException {
        // 디렉터리에 포함되어 있는 모든 파일을 삭제한다.
        // 하위에 디렉터리가 포함되어 있을 경우 재귀호출한다.
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
                for (Path entry : entries) {
                    deleteNotEmptyDirectory(entry);
                }
            }
            Files.delete(path);
        }
    }

}
