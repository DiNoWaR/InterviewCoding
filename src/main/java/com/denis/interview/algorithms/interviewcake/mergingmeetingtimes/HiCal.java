package com.denis.interview.algorithms.interviewcake.mergingmeetingtimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Your company built an in-house calendar tool called HiCal.
 * You want to put a feature to see the times in a day when everyone is available.
 * To do this, you’ll need to know when any team is having a meeting.
 * In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
 * These integers represent the number of 30-minute blocks past 9:00am.
 * <p>
 * For example, given:
 * [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
 * your method would return:
 * [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
 */
public class HiCal {

    public static List<Meeting> mergeRanges(Meeting[] meetings) {

        // make a copy so we don't destroy the input
        // sort by start time
        var sortedMeetings = Arrays.stream(meetings)
                .sorted(Meeting::compareTo)
                .collect(Collectors.toList());

        // initialize mergedMeetings with the earliest meeting
        var mergedMeetings = new ArrayList<Meeting>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (var currentMeeting : sortedMeetings) {

            var lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // if the current meeting overlaps with the last merged meeting, use the
            // later end time of the two
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));

                // put the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

    public static void main(String[] args) {

        var meetings = new Meeting[]{new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};

        var mergedMeetings = mergeRanges(meetings);

        System.out.println(mergedMeetings);
    }

}
