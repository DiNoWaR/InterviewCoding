package com.denis.interview.algorithms.interviewcake.mergingmeetingtimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HiCal {

    public static List<Meeting> mergeRanges(Meeting[] meetings) {

        // make a copy so we don't destroy the input
        // sort by start time
        List<Meeting> sortedMeetings = Arrays.stream(meetings)
                .sorted(Meeting::compareTo)
                .collect(Collectors.toList());

        // initialize mergedMeetings with the earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (Meeting currentMeeting : sortedMeetings) {

            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // if the current meeting overlaps with the last merged meeting, use the
            // later end time of the two
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));

                // add the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

    public static void main(String[] args) {

        Meeting[] meetings = {new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};

        List<Meeting> mergedMeetings = mergeRanges(meetings);

        System.out.println(mergedMeetings);
    }

}
