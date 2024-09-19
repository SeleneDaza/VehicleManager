package co.edu.uptc.utilities;

import java.util.Comparator;
import java.util.List;

public class MySort<T>{
    
    public void sortData(SimpleList<SimpleList> data, Comparator<T> comparator){
        List<T> stringList = data.get(0);
        List<T> list = data.get(1);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(comparator.compare(list.get(i),list.get(j))>=1){
                    T aux = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, aux);
                    T stringAux = stringList.get(i);
                    stringList.set(j, stringList.get(i));
                    stringList.set(i, stringAux);
                }
            }
        }
    }

    public void sortCountyData(SimpleList<SimpleList> data, Comparator<T> comparator){
        List<T> state = data.get(0);
        List<T> stringList = data.get(1);
        List<T> list = data.get(2);
        for (int i = 0; i < state.size(); i++) {
            for (int j = 0; j < state.size(); j++) {
                if(comparator.compare(state.get(i),state.get(j))>=1){
                    T aux = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, aux);
                    T stringAux = stringList.get(i);
                    stringList.set(j, stringList.get(i));
                    stringList.set(i, stringAux);
                    T stateAux = state.get(i);
                    state.set(j, state.get(i));
                    state.set(i, stateAux);
                }
            }
        }
    }
}
