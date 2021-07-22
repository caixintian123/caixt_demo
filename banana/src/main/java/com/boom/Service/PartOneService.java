package com.boom.Service;

import com.boom.Domain.Interval;
import com.boom.Domain.PartOneResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class PartOneService {

    private static final Logger logger = LoggerFactory.getLogger(PartOneService.class);
@Test
    public List<PartOneResult> getAutoPart1(int p1Num){
        List<PartOneResult> p1List = new ArrayList<>();
        List<Interval> intervalList = new ArrayList<>();
        for (int cnt=0;cnt<p1Num;cnt++){
            PartOneResult partOneResult = new PartOneResult();
            int begin =999;
            int bigbegin =9999;

            int tempEnd = 1999;
            int tempBigEnd = 19999;

            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int i=0;i<10;i++){
                int aval = new Random().nextInt(tempEnd) % (tempEnd - begin+ 1) + begin;
                int bval = new Random().nextInt(tempBigEnd) % (tempBigEnd - bigbegin+ 1) + bigbegin;

                a.add(aval);
                b.add(bval);
                begin=begin+1000;
                tempEnd=tempEnd+1000;
                bigbegin=bigbegin+10000;
                tempBigEnd=tempBigEnd+10000;
            }
            System.out.println(a.toArray());
            for(int c=0;c<5;c++){
                Interval sInterval = new Interval(a.get(c*2),a.get((c*2)+1));
                intervalList.add(sInterval);
                Interval binterval = new Interval(b.get(c*2),b.get((c*2)+1));
                intervalList.add(binterval);
            }
            Interval[] arr = list2array(intervalList);
            partOneResult.setWordTrunk(arr);
            p1List.add(partOneResult);
        }
        return p1List;



    }
    public Interval[] list2array(List<Interval> list){
        if(list==null || list.size()==0){
            return null;
        }
        Interval[] array = new Interval[list.size()];
        for(int i=0;i<list.size();i++){
            array[i]= list.get(i);
        }
        return array;
    }
}
