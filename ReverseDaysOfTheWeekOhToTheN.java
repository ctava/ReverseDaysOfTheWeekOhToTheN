import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseDaysOfTheWeekOhToTheN {

	public static void main(String[] args) {
		String daysOfTheWeek = "Sunday Monday Tuesday Wednesday Thursday Friday Saturday";
		System.out.println("before: "+daysOfTheWeek);
		
		//day of the week split by one or more space(s).
		String[] days = daysOfTheWeek.split("\\s+");
		//descending day name counter
		int descending = days.length-1;
		//ascending day name counter
		int ascending = 0;
		
		//iterate forward thru the days of the array of week day names
		//from left to right and right to left at the same time
		while (ascending < days.length) {
		    //first day of the week	
			String firstDayOfTheWeek = days[ascending];
			//System.out.println("firstDayOfTheWeek: "+firstDayOfTheWeek);

			Pattern firstDayOfTheWeekReplacePattern = Pattern.compile(firstDayOfTheWeek);
			Matcher firstDayOfTheWeekMatcher = firstDayOfTheWeekReplacePattern.matcher(daysOfTheWeek);
			daysOfTheWeek =  firstDayOfTheWeekMatcher.replaceFirst(lastDayOfTheWeek);
			//System.out.println("first day of the week swapped out: "+daysOfTheWeek);

			//last day of the week
			String lastDayOfTheWeek = days[descending];
			//System.out.println("lastDayOfTheWeek: "+lastDayOfTheWeek);			
			Pattern lastDayOfTheWeekReplacePattern = Pattern.compile(lastDayOfTheWeek);
			Matcher lastDayOfTheWeekMatcher = lastDayOfTheWeekReplacePattern.matcher(daysOfTheWeek);
			daysOfTheWeek =  lastDayOfTheWeekMatcher.replaceFirst(firstDayOfTheWeek);
			//System.out.println("last day of the week swapped out: "+daysOfTheWeek);
						
			ascending++;
			descending--;
		}
        System.out.println("after: "+daysOfTheWeek);
	}
}
