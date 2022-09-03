package Org;

import manager.Message;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class CollectionManager implements Serializable {
    private static final long serialVersionUID = 1L;
    public static ArrayDeque<Person> pers = new ArrayDeque<Person>();


    public static long getFreeId(){
        ArrayList<Long> busyId = new ArrayList<>();
        Iterator<Person> it = pers.iterator();
        while(it.hasNext()){
            busyId.add(it.next().getId());
        }
        for (long id = 1; id <= busyId.size() + 1; id ++){
            if (!busyId.contains(id)){
                return id;
            }
        }
        return 0;
    }
}
