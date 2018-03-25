package com.denis.interview.algorithms.interviewcake.mergingmeetingtimes;

import java.util.Arrays;
import java.util.Comparator;

public class HiCal {

    public static Meeting[] mergeRanges(Meeting[] meetings) {

        int index = 0;

        Meeting[] sortedMeetings = Arrays.stream(meetings)
                .sorted(Comparator.comparing(Meeting::getStartTime))
                .toArray(Meeting[]::new);

        Meeting[] condensedMeetings = new Meeting[meetings.length];

        Meeting condensedMeeting = new Meeting(sortedMeetings[0].getStartTime(), sortedMeetings[0].getEndTime());

        for (int i = 0; i < meetings.length - 1; i++) {

            if (meetings[i + 1].getEndTime() < meetings[i].getStartTime()) {

            }

        }


        return sortedMeetings;
    }

    public static void main(String[] args) {


    }

}
