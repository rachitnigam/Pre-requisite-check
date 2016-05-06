package Testing;

import Parser.ParseCourseName;
import courseclass.CourseClass;
import courseclass.CourseList;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by thEnigma on 5/5/16.
 */
public class Tester {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        CourseList lst = new CourseList();
        String[] nameLst = new String[]{
                "cs121",
                "cs187 -> cs121",
                "cs220 -> cs187",
                "cs230 -> cs187",
                "cs240 -> cs187",
                "cs250 -> cs187",
                "cs311 -> cs250",
                "cs383 -> cs230,cs240",
                "cs445 -> cs220,cs311",
                "cs320 -> cs220",
                "cs529 -> cs320",
                "cs497 -> cs230,cs326",
                "cs326 -> cs220",
                "cs348 -> cs240,cs250",
                "cs377 -> cs230"};


        for(String name : nameLst) {
            CourseClass parent = ParseCourseName.parseParent(name);
            ArrayList<CourseClass> prList = ParseCourseName.parsePreReq(name);

            lst.addClass(parent);
            lst.addPrerequisites(parent, prList);
        }

        System.out.println(lst.toString());
    }
}
