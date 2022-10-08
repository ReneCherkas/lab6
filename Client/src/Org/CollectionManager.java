package Org;

import manager.Message;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionManager implements Serializable {
    private static final long serialVersionUID = 1L;
    public static ArrayDeque<Person> pers = new ArrayDeque<>();

    public static long getFreeId(){
        ArrayDeque<Person> busyId = new ArrayDeque<>();
        Iterator<Person> it = pers.iterator();
        //while(it.hasNext()){
        //    busyId.add(it.next().getId());
        //}
        //busyId.add(pers);
        //Message.info(busyId);

        List<String> list = new ArrayList<>();
        for (Person var : pers){
            list.add(var.getId());
        }



        for (long id = 1; id <= list.size() + 1; id ++){
            if (!list.contains(id)){
                return id;
            }
        }
        return 0;
    }
}
