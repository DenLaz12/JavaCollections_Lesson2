package com.dlazarenko;

import java.util.*;

public class TopMostContactCalls {

    public static void main(String[] args) {

        Collection<Contact> contacts = new LinkedList<>();
        contacts.add(new Contact("Mother", "+38"));
        contacts.add(new Contact("Father", "+48"));
        contacts.add(new Contact("Grandmother", "+1"));
        contacts.add(new Contact("Grandfather", "+7"));
        contacts.add(new Contact("Father", "+48"));
        contacts.add(new Contact("Grandmother", "+1"));

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

    }
    private List<ContactWithCallsCount> getTop5ContactsByCallCount(
            Collection<CallLog> calls, Collection<Contact> contacts){
        Map<String, Integer> callsCountPerNumber = new HashMap<>();
        for (CallLog call : calls) {
            Integer callsCount = callsCountPerNumber.get(call.phoneNumber);
            if(callsCount == null){
                callsCount = 0;
            }
            callsCount += 1;
            callsCountPerNumber.put(call.phoneNumber, callsCount);
        }
        Map<String, Contact> contactsPerNumber =
                GroupItemsByUtils.groupContactsByNumber(contacts);

        List<ContactWithCallsCount> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : callsCountPerNumber.entrySet()) {
            String phoneNumber = entry.getKey();
            Integer callsCount = entry.getValue();

            result.add(new ContactWithCallsCount(
                    contactsPerNumber.get(phoneNumber), callsCount));
        }
        result.sort(new Comparator<ContactWithCallsCount>() {
            @Override
            public int compare(ContactWithCallsCount o1, ContactWithCallsCount o2) {
                return Integer.compare(o2.callsCount, o1.callsCount);
            }
        });
        List<ContactWithCallsCount> finalResult = new ArrayList<>();
        for (int i = 0; (i < 5 && i < result.size()); i++) {
            finalResult.add(result.get(i));
        }
        return finalResult;
    }

    private static class ContactWithCallsCount {
        public Contact contact;
        public int callsCount;

        public ContactWithCallsCount(Contact contact, int callsCount) {
            this.contact = contact;
            this.callsCount = callsCount;
        }
    }
}
