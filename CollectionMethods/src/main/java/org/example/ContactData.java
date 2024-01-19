package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {

    private static final String phoneData = "Charlie Brown, 3334445555\nMaid Marion, 1234567890\nMickey Mouse, 9998887777\nMickey Mouse, 1247489758\nMinnie Mouse, 4567805666\nRobin Hood, 5647893000\nRobin Hood, 7899028222\nLucy Van Pelt, 5642086852\nMickey Mouse, 9998887777";

    private static final String emailData = "Mickey Mouse, mckmouse@gmail.com\nMickey Mouse, micky1@aws.com\nMinnie Mouse, minnie@verizon.net\nRobin Hood, rhood@gmail.com\nLinus Van Pelt, lvpelt2015@gmail.com\nDaffy Duck, daffy@google.com";

    public static List<Contact> getData(String type) {

        List<Contact> dataList = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split(",");
            Arrays.asList(data).replaceAll(String::trim);
            if (type.equals("phone")) {
                dataList.add(new Contact(data[0], Long.parseLong(data[1])));
            } else if (type.equals("email")) {
                dataList.add(new Contact(data[0], data[1]));
            }
        }
        return dataList;
    }
}

