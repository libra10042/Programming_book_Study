package FileTree;

import java.io.File;
import java.io.IOException;

/*
* File 클래스를 이용한 파일 목록 처리 예
* */
public class OldPrintAllFiles {

     public static void displayDirectoryContents(File dir){
         // 현재 디렉터리의 파일 목록을 가져온다.
         File[] files = dir.listFiles();

         for(File file :files){
             try {
                 if(file.isDirectory()){
                     if(file.isDirectory()) {
                         System.out.println("디렉터리 : " + file.getCanonicalPath());
                         // 재귀 호출되는 부분
                         displayDirectoryContents(file);
                     }else{
                         System.out.println("일반 파일 : " + file.getCanonicalPath());
                     }

                 }
             }catch(IOException e){
                 e.printStackTrace();
             }
         }
     }

     public static void main(String[] args){
         File currentDir = new File("C:/windows");
         displayDirectoryContents(currentDir);
     }

}
