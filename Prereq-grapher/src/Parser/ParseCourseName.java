package Parser;

import courseclass.CourseClass;

import java.util.ArrayList;

/**
 * Created by thEnigma on 5/5/16.
 */
public class ParseCourseName {

    static public CourseClass nameSplit(String name){
        String dep = name.substring(0,name.length()-3);
        String id = name.substring(name.length()-3);
        return new CourseClass(dep,Integer.parseInt(id));
    }

    static public CourseClass parseParent(String name){
        String[] s_arr = name.split("\\s*->\\s*");
        return ParseCourseName.nameSplit(s_arr[0]);
    }

    static public ArrayList<CourseClass> parsePreReq(String name){
        String[] s_arr = name.split("\\s*->\\s*");
        if(s_arr.length <=1 )
            return null;
        String[] prArr = s_arr[1].split("\\s*,\\s*");
        ArrayList<CourseClass> prList = new ArrayList<>();

        for(String iter : prArr) prList.add(nameSplit(iter));

        return prList;
    }

}
