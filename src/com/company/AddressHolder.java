package com.company;

import java.util.ArrayList;

public class AddressHolder {
    private static AddressHolder ourInstance = new AddressHolder();
    private ArrayList<String> addresses = new ArrayList<>();
    private int flag = 0;

    public static AddressHolder getInstance()
    {
        return ourInstance;
    }

    private AddressHolder() {
    }


    public String getAddress() {
        if (flag == 0)  this.initAddresses();

        if (!addresses.isEmpty()) {
            String str = addresses.get(0);
            addresses.remove(0);
            return str;
        }
        return "";
    }

    public void returnAddress(String string) {
        addresses.add(string);
    }

    public ArrayList<String> getAddresses() {
        if (flag == 0) this.initAddresses();
        return addresses;
    }

    private void initAddresses() {
        flag = 1;
        final int maxAddress = 7;
        for (int i = 1; i < maxAddress; i++) {
            addresses.add("/trigger/prophet" + i);
        }
    }
}
