package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class FilesSelect {

    public void selectFiles(String inFolder, String outFolder, List<String> keys){
        
        File dir = new File(inFolder);
        Set<String> files  = allFiles(dir);        
        for (String s : files){
            File f = new File(s);
            String content;
            try {
                content = FileUtils.readFileToString(f);
            } catch (IOException e1) {
                continue;
            }
            
            for (String key : keys){
                if (!content.contains(key)) continue;
                File rd = new File(outFolder + "/" + key);
                rd.mkdirs();
                try {
                    FileUtils.copyFile(f, new File(outFolder + "/" + key + "/" + f.getName()));
                } catch (IOException e) {}
            }
        }
    }
    
    private Set<String> allFiles(File dir){
        Set<String> result = new HashSet<>();
        for (String s : dir.list())
        {
            File f = new File(dir + "/" + s);
            if (f.isDirectory()) result.addAll(allFiles(f));
            else if (f.getName().endsWith(".txt")) result.add(f.getAbsolutePath());
        }
        return result;
    }
    
    
}
