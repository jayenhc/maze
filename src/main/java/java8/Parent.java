package java8;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Parent {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("h:mm a");
    private static final ZoneId zid = ZoneId.of("Europe/London");
    int id;
    String name;
    LocalDate dob;
    List<Child> children;

    public Parent(final int id, final String name, final LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public static String getCourtTime(final ZonedDateTime hearingDateTime) {
        String courtTime = "";
        try {
            courtTime = TIME_FORMATTER.format(hearingDateTime.plusSeconds(
                    hearingDateTime.withZoneSameInstant(zid).getOffset().getTotalSeconds()));
        } catch (DateTimeException dte) {


        }
        return courtTime;
    }

    private static boolean isBetween(final LocalDateTime sittingDay, final LocalDateTime from, final LocalDateTime to) {
        return (sittingDay.isAfter(from)) && sittingDay.isBefore(to);
    }

    public static void main(String arg[]) {
        String str = "2019-04-08 10:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.parse(str, formatter);
        str = "2019-04-08 11:00";
        LocalDateTime dateTime2 = LocalDateTime.parse(str, formatter);
        // HearingService h = new HearingService();
        System.out.println("------------------" + isBetween(dateTime1, dateTime1, dateTime2));
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(final LocalDate dob) {
        this.dob = dob;
    }
   /* public static void main(String str[]){

        System.out.print(getCourtTime(ZonedDateTime.now()));
    }*/

    public List<Child> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void setChildren(final List<Child> children) {
        this.children = children;
    }

   /* private ZonedDateTime convertDateTime(String date, String time) {
        time = time.trim().replaceAll(" ", "");
        date = date.trim().replaceAll(" ", "");

        if (!StringUtils.isEmpty(date)) {
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern(TIME_FORMAT));
            LocalDate localDate = null;
            try {
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
            } catch (DateTimeParseException dtp) {
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(ALTERNATE_DATE_FORMAT));
            }
            return ZonedDateTime.of(localDate, localTime, ZoneId.systemDefault());
        }

        return null;
    }*/

}
