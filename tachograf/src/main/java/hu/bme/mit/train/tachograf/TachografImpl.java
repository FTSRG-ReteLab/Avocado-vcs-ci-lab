package hu.bme.mit.train.tachograf;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TachografImpl {
    private Table<Integer,Integer,Integer> table = HashBasedTable.create();

    public Boolean hasElements(){
        return !table.isEmpty();
    }
}
