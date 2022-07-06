package com.dlazarenko;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){

        Collection<CallLog> callLogs = Arrays.asList(
                new CallLog("+38", 0,
                        10, CallLog.Status.Incoming),
                new CallLog("+38", 0,
                        35, CallLog.Status.Outgoing),
                new CallLog("+38", 0,
                        0, CallLog.Status.Missed),
                new CallLog("+48", 0,
                        35, CallLog.Status.Outgoing),
                new CallLog("+38", 0,
                        0, CallLog.Status.Missed),
                new CallLog("+1", 0,
                        240, CallLog.Status.Incoming),
                new CallLog("+1", 0,
                        600, CallLog.Status.Outgoing),
                new CallLog("+48", 0,
                        5, CallLog.Status.Outgoing),
                new CallLog("+7", 0,
                        500, CallLog.Status.Outgoing)
        );

        Collection<Contact> contacts = Arrays.asList(
                new Contact("Mother", "+38"),
                new Contact("Father", "+48"),
                new Contact("Grandmother", "+1"),
                new Contact("Grandfather", "+7")
        );

        Map<String, List<CallLog>> groupedCalls =
                GroupItemsByUtils.groupCallLogsByNumber(callLogs);

        Map<String, Contact> groupedContacts =
                GroupItemsByUtils.groupContactsByNumber(contacts);

        // Map<Contact, List<CallLog>> callsPerContact = new HashMap<>();

        for (Map.Entry<String, List<CallLog>> entry : groupedCalls.entrySet()) {
            String phoneNumber = entry.getKey();
            Contact contact = groupedContacts.get(phoneNumber);
            String contactName = contact != null ? contact.name : phoneNumber;
            System.out.println("Name : " + contactName);

            for (CallLog callLog : entry.getValue()) {
                System.out.println("Duration : " + callLog.duration);
                System.out.println("Is incoming : " + (callLog.status == CallLog.Status.Incoming));
            }
        }

        for (String candidateToCheck : Arrays.asList("+38", "+48", "+1", "+7")) {
            List<CallLog> calls = groupedCalls.get(candidateToCheck);
            int countOfCalls = calls == null ? 0 : calls.size();
            System.out.printf("How many calls are associated with the number '%s': '%d'",
                    candidateToCheck, countOfCalls);
            System.out.println();
        }
    }
}
