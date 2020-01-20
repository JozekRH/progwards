package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;


public class FindDuplicates {

    private List<String> added = new ArrayList<>();

    public List<List<String>> findDuplicates(String startPath){
        List<List<String>> result = new ArrayList<>();
        
        File dir = new File(startPath);
        
        Set<String> files = allFiles(dir);
        
        for (String s : files){
            if (added.contains(s)) continue;

            Set<String> ls = new HashSet<>();
            File f = new File(s);
            
            ls.add(f.getAbsolutePath());

            for (String s1 : files){
                if (s.equals(s1)) continue;
                File f1 = new File(s1);

                try {
                    if (f.getName().equals(f1.getName()) && f.lastModified() == f1.lastModified() && FileUtils.contentEquals(f, f1)){
                        ls.add(f1.getAbsolutePath());
                        added.add(f1.getAbsolutePath());
                    }
                } catch (IOException e) {}

            }
            
            if (ls.size() > 1){
                List<String> sl = new ArrayList<>();
                sl.addAll(ls);
                result.add(sl);
            }
        }
        
        return result;
    }
    
    private Set<String> allFiles(File dir){
        Set<String> result = new HashSet<>();
        for (String s : dir.list())
        {
            File f = new File(dir + "/" + s);
            if (f.isDirectory()) result.addAll(allFiles(f));
            else result.add(f.getAbsolutePath());
        }
        return result;
    }
}
