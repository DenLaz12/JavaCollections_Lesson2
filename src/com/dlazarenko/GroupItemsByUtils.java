package com.dlazarenko;

import java.util.*;

public class GroupItemsByUtils {

    public static Map<String, List<CallLog>> groupCallLogsByNumber(
            Collection<CallLog> callLogs){

        Map<String, List<CallLog>> output = new HashMap<>();

        for (CallLog callLog : callLogs) {

            List<CallLog> existingGroup = output.get(callLog.phoneNumber);

            if (existingGroup == null){
                List<CallLog> newGroup = new ArrayList<>();
                newGroup.add(callLog);
                output.put(callLog.phoneNumber, newGroup);
            } else {
                existingGroup.add(callLog);
            }

        }
        return output;
    }

    public static Map<String, Contact> groupContactsByNumber(
            Collection<Contact> contacts){
        Map<String, Contact> result = new HashMap<>();
        for (Contact contact : contacts) {
             result.put(contact.phoneNumber, contact);
        }
        return result;
    }
}
