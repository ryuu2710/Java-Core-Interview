package collections.treemap;

import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

public class MeetingScheduleDemo {
    private final TreeMap<LocalTime, String> schedules = new TreeMap<>();

    public void book(String time, String meetingName) {
        this.schedules.put(LocalTime.parse(time), meetingName);
    }

    public void findNextMeeting(String time) {
        LocalTime now = LocalTime.parse(time);
        Map.Entry<LocalTime, String> next = this.schedules.higherEntry(now);

        if(next != null) {
            System.out.println("Sau " + now + " là cuộc họp: "
                    + next.getValue() + " lúc " + next.getKey());
        } else {
            System.out.println("Sau " + now + " không còn cuộc họp nào.");
        }
    }

    public void printScheduleBetween(String startTime, String endTime) {
        LocalTime parsedStartTime = LocalTime.parse(startTime);
        LocalTime parsedEndTime = LocalTime.parse(endTime);

        System.out.println("--- Lịch từ " + parsedStartTime + " đến " + parsedEndTime + " ---");

        this.schedules.subMap(parsedStartTime, true, parsedEndTime, true)
                .forEach((time, title) -> System.out.println(time + ": " + title));
    }

    public static void main(String[] args) {
        MeetingScheduleDemo scheduler = new MeetingScheduleDemo();

        scheduler.book("14:00", "Review Code");
        scheduler.book("09:00", "Daily Scrum");
        scheduler.book("10:30", "Phỏng vấn ứng viên");
        scheduler.book("16:00", "Họp chiến lược");

        scheduler.findNextMeeting("10:00");
        scheduler.printScheduleBetween("13:00", "17:00");
    }
}
