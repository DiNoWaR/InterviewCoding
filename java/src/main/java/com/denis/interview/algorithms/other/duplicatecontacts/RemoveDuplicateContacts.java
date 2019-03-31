package com.denis.interview.algorithms.other.duplicatecontacts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a list of Contacts, where each contact consists of a contact ID and a list of email IDs.
 * Output a unique list of contacts by removing duplicates.
 * Two contacts are considered to be the same, if they share at least one email ID.
 */
public class RemoveDuplicateContacts {


    private static Set<String> uniqueContacts(Map<String, Set<String>> input) {

        Map<String, String> emailToContact = new HashMap<>();
        Set<String> duplicateSet = new HashSet<>();
        Set<String> uniqueSet = new HashSet<>();

        for (String contactId : input.keySet()) {
            uniqueSet.add(contactId);
            Set<String> emails = input.get(contactId);

            for (String email : emails) {
                if (emailToContact.containsKey(email)) {
                    duplicateSet.add(emailToContact.get(email));
                    duplicateSet.add(contactId);
                } else {
                    emailToContact.put(email, contactId);
                }
            }
        }
        uniqueSet.removeAll(duplicateSet);
        return uniqueSet;
    }

}
