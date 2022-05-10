package com.m3.c216.changes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static com.m3.c216.changes.Utils.*;

public class Java8DateTimeAPI {

	public static void main(String[] args) {
		printMethod("Features Introduced in Java 8: DateTime API");
		Java8DateTimeAPI j8 = new Java8DateTimeAPI();
		j8.localDate();
		j8.localTime();
		j8.localDateTime();
		j8.instantDurationPeriod();
		j8.utilities();
		j8.formatting();
		j8.parsing();
	}

	public void localDate() {
		printMethod("localDate");

		LocalDate today = LocalDate.now();
		print("today =", today);

		LocalDate independenceDay = LocalDate.of(1776, Month.JULY, 4);
		print("independenceDay =", independenceDay);

		// bad data causes a RuntimeException
		try {
			LocalDate badDate = LocalDate.of(2000, Month.FEBRUARY, 30);
		} catch (DateTimeException e) {
			Utils.printerr("No bad dates with Java 8:", e.getMessage());  // unless you date a software engineer
		}

		LocalDate todayInOz = LocalDate.now(ZoneId.of("Australia/Sydney"));
		print("today In Oz =", todayInOz);
		print("today In Tokyo =", LocalDate.now(ZoneId.of("Asia/Tokyo")));
		print("today In NY=", LocalDate.now(ZoneId.of("America/New_York")));
		print("today In Anchorage =", LocalDate.now(ZoneId.of("America/Anchorage")));

		// Misc
		LocalDate day0 = LocalDate.ofEpochDay(0);
		print("beginning of epoch =", day0);

		int day = 100;
		int year = today.getYear();
		LocalDate hundredDayOfThisYear = LocalDate.ofYearDay(year, day);
		print("day", day, "of", year, "is", hundredDayOfThisYear);

		print("today is", today.getDayOfWeek(), ": day", today.getDayOfYear(),
				"of the year", today.getYear(), "and day", today.getDayOfMonth(),
				"of the month of", today.getMonth());
		print("today is", today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CANADA_FRENCH));
	}

	public void localTime() {
		printMethod("localTime");

		LocalTime timeNow = LocalTime.now();
		print("timeNow =", timeNow);

		LocalTime specificTime = LocalTime.of(11, 59, 59, 987654321);
		print("Specific Time =", specificTime);
		LocalTime noon = LocalTime.of(12, 0);
		print("noon =", noon);

		// bad data causes a RuntimeException
		try {
			LocalTime badTime = LocalTime.of(24, 60);
		} catch (DateTimeException e) {
			printerr("No bad times with Java 8:", e.getMessage());  // except for Monday mornings
		}

		// Timezones
		LocalTime timeInOz = LocalTime.now(ZoneId.of("Australia/Sydney"));
		print("timeInOz =", timeInOz);
		print("timeInTokyo =", LocalTime.now(ZoneId.of("Asia/Tokyo")));
		print("timeInNYC =", LocalTime.now(ZoneId.of("America/New_York")));
		print("timeInLA =", LocalTime.now(ZoneId.of("America/Los_Angeles")));
		print("timeInLon =", LocalTime.now(ZoneId.of("Europe/London")));

		int second = 50_000;
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(second);
		print("second", second, "of the day =", specificSecondTime);
	}

	public void localDateTime() {
		printMethod("localDateTime");

		LocalDateTime now = LocalDateTime.now();
		print("now =", now);

		LocalDateTime localDT = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		print("localDT =", localDT);

		LocalDateTime specificDateTime = LocalDateTime.of(2017, Month.DECEMBER, 25, 11, 59, 30);
		print("specificDateTime =", specificDateTime);

		// bad data causes a RuntimeException
		try {
			LocalDateTime badDateTime = LocalDateTime.of(2017, Month.FEBRUARY, 29, 24, -1, 99);
		} catch (DateTimeException e) {
			printerr("Invalid LocalDateTime:", e.getMessage());
		}

		LocalDateTime dateTimeInOz = LocalDateTime.now(ZoneId.of("Australia/Sydney"));
		print("dateTime In Oz =", dateTimeInOz);
		print("dateTime In Tokyo =", LocalDateTime.now(ZoneId.of("Asia/Tokyo")));
		print("dateTime In NYC =", LocalDateTime.now(ZoneId.of("America/New_York")));
		print("dateTime In LA =", LocalDateTime.now(ZoneId.of("America/Los_Angeles")));

		// misc
		long second = 1_000_000_000_000L;
		LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.UTC);
		print("Second", second, "from start of epoch =", dateFromBase);

		print("now is", now.getMinute(), "past", now.getHour(), "on", now.getDayOfWeek(),
				", day", now.getDayOfYear(), "of the year", now.getYear(),
				"and day", now.getDayOfMonth(), "of the month of", now.getMonth(),
				"or", now.toLocalDate(), now.toLocalTime(), "or", now.toString());
	}

	public void instantDurationPeriod() {
		printMethod("instantDurationPeriod");

		Instant now = Instant.now();
		print("now =", now);

		long secondsLater = 10_000_000L;
		long totalSinceEpoch = now.toEpochMilli() / 1000 + secondsLater;
		Instant laterInstant = Instant.ofEpochSecond(totalSinceEpoch);
		print("laterInstant =", laterInstant);
		print("laterInstant =", now.plusSeconds(secondsLater));


		Duration duration = Duration.ofDays(7);
		print("7 day duration =", duration);
		print("14 day duration =", duration.plus(duration));
		print("1.5 day duration =", duration.minusDays(6).plusHours(12));
		print("6 hour duration =", duration.minusDays(6).minusHours(18));
		print("5 mins 30 secs duration =", Duration.ofMinutes(5).plusSeconds(30));


		LocalDate today = LocalDate.now();
		LocalDate yesteryear = today.with(ChronoField.YEAR, 2000);
		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());


		Period period = today.until(lastDayOfYear);
		print("period =", period);
		print("Remaining in this year:", period.getMonths(), "month(s) and", period.getDays(), "days");

		Period randomPeriod = period
				.minusMonths(Utils.getRandomInt(2, 5))
				.minusDays(Utils.getRandomInt(7, 28))
				.plusYears(Utils.getRandomInt(0, 12));
		print("random period =", randomPeriod, ": remaining months =", randomPeriod.toTotalMonths());
	}

	public void utilities() {
		printMethod("utilities");

		LocalDate today = LocalDate.now();

		print("Year", today.getYear(), "is a leap year:", today.isLeapYear());

		LocalDate java9ReleaseDay = LocalDate.of(2017, 9, 21);
		LocalDate java11ReleaseDay = LocalDate.of(2018, 9, 25);
		print("java9ReleaseDay is", java9ReleaseDay.isBefore(java11ReleaseDay) ? "before" : "after", "java11ReleaseDay");
		print("Today is", today.isBefore(java11ReleaseDay) ? "before" : "after",
				"and not", today.isAfter(java11ReleaseDay) ? "before" : "after", java11ReleaseDay);

		LocalDateTime noonToday = today.atTime(12, 0);
		print("noonToday =", noonToday);

		print("21 days after today:", today.plusDays(21));
		print("13 weeks after today:", today.plusWeeks(13));
		print("18 months after today:", today.plusMonths(18));
		print("21 days before today:", today.minusDays(21));
		print("13 weeks before today:", today.minusWeeks(13));
		print("21 months before today:", today.minusMonths(21));

		print("t1 = ", today.plus(3, ChronoUnit.CENTURIES));
		print("t2 = ", today.plus(Period.ofDays(3)));
		// print("t3 = ", today.minus(Duration.ofHours(24)));

		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
		print("Last day of this year =", lastDayOfYear);
		print("First day of this month =", today.with(TemporalAdjusters.firstDayOfMonth()));
		print("First Friday of this month =", today.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)));
		print("Next Friday =", today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		print("Previous/Same Friday =", today.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY)));
	}

	public void formatting() {
		printMethod("formatting");

		LocalTime time = LocalTime.now();
		print("LocalTime format 0:", time); // default format
		print("LocalTime format 1a:", time.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
		print("LocalTime format 1b:", time.format(DateTimeFormatter.ofPattern("HH,mm,ss.SSS")));
		print("LocalTime format 2:", time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		print();

		LocalDate date = LocalDate.now();
		print("LocalDate format 0:", date); // default format
		print("LocalDate format 1:", date.format(DateTimeFormatter.ofPattern("d / MMM / uuuu")));
		print("LocalDate format 2:", date.format(DateTimeFormatter.BASIC_ISO_DATE));
		print("LocalDate format 3:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		print("LocalDate format 4:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		print("LocalDate format 5:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		print("LocalDate format 6:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		print();

		LocalDateTime dateTime = LocalDateTime.now();
		print("LocalDateTime format 0:", dateTime); // default format
		print("LocalDateTime format 1:", dateTime.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy HH::mm::ss")));
		print("LocalDateTime format 2:", dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		print("LocalDateTime format 3:", dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		print("LocalDateTime format 4:", dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		print("LocalDateTime format 5:", dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
	}

	public void parsing() {
		printMethod("parsing");

		String timeStr = "11/59/30";
		String dateStr = "29:Feb:2000";
		String dateTimeStr = dateStr + "-" + timeStr;

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH/mm/ss");
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd:MMM:yyyy");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd:MMM:yyyy-HH/mm/ss");

		print("parsed time:", LocalTime.parse(timeStr, timeFormatter));
		print("parsed date:", LocalDate.parse(dateStr, dateFormatter));
		print("parsed dateTime:", LocalDateTime.parse(dateTimeStr, dateTimeFormatter));
	}
}
