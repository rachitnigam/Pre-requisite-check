package courseclass;

import graphs.Graph;
import java.io.Serializable;
import java.util.List;

/**
 * Created by thEnigma on 5/5/16.
 */
public class CourseList extends Graph<CourseClass> implements Serializable {

    public CourseList(int maxV) {
        super(maxV);
    }

    public CourseList() {
        this(100);
    }

    public void addClass(CourseClass c){
        if(!this.hasVertex(c))
            this.addVertex(c);
    }

    public void addPrerequisites(CourseClass c, List<CourseClass> clist) {
        if(clist == null)
            return;

        for (CourseClass iter : clist) {
            if(!this.hasVertex(iter))
                this.addClass(iter);
            addEdge(c, iter);
        }
    }
}
