package co.edu.uptc.utilities;

import java.util.Comparator;
import java.util.List;

public class MySort<T>{

    public void sortData(SimpleList<SimpleList> data, Comparator<T> comparator) {
        List<T> stringList = data.get(0);
        List<T> list = data.get(1);

        quickSort(list, stringList, comparator, 0, list.size() - 1);
    }

    private void quickSort(List<T> list, List<T> stringList, Comparator<T> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(list, stringList, comparator, low, high);

            quickSort(list, stringList, comparator, low, pi - 1);
            quickSort(list, stringList, comparator, pi + 1, high);
        }
    }

    private int partition(List<T> list, List<T> stringList, Comparator<T> comparator, int low, int high) {
        T pivot = list.get(high);
        T pivotString = stringList.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) >= 1) {
                i++;

                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);

                T tempString = stringList.get(i);
                stringList.set(i, stringList.get(j));
                stringList.set(j, tempString);
            }
        }

        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        T tempString = stringList.get(i + 1);
        stringList.set(i + 1, stringList.get(high));
        stringList.set(high, tempString);

        return i + 1;
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
