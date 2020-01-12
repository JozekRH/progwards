package ru.progwards.java1.lessons.datetime;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Profiler {
    
    private static Map<String, StatisticInfo> statisticInfos = new TreeMap<>();
    private static Map<String, Long> openSectionsStartTimes = new TreeMap<>();
    private static Map<String, Set<String>> innerSections = new TreeMap<>();
    
    public static void enterSection(String name){
        
        for (String s: openSectionsStartTimes.keySet()){
            if (innerSections.get(s) != null) innerSections.get(s).add(name);
            else{
                Set<String> is = new HashSet<String>();
                is.add(name);
                innerSections.put(s, is);
            }
        }

        openSectionsStartTimes.put(name, new Date().getTime());
    }
    
    public static void exitSection(String name){
        StatisticInfo si = statisticInfos.get(name);
        if (si == null){
            si = new StatisticInfo();
            si.sectionName = name;
            si.fullTime = 0;
            si.selfTime = 0;
            si.count = 0;
        }
        si.fullTime += new Date().getTime() - openSectionsStartTimes.get(name);
        si.selfTime = si.fullTime - calcInnerTimes(name);
        si.count++;

        openSectionsStartTimes.remove(name);
        innerSections.remove(name);
        statisticInfos.put(name, si);
    }
    
    public static List<StatisticInfo> getStatisticInfo(){
        List<StatisticInfo> result = new ArrayList<>();
        result.addAll(statisticInfos.values());
        return result;
    }
    
    private static int calcInnerTimes(String name){
        int result = 0;
        if (innerSections.get(name) == null) return result;
        
        for (String s : innerSections.get(name)){
            result += statisticInfos.get(s).selfTime;
        }
        return result;
    }
    
    

}
