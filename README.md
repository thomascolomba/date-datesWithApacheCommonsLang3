More handling of java.util.Date and java.util.GregorianCalendar with org.apache.commons.lang3.time<br/>
<br/>
How to compile and execute :<br/>
I executed it from within eclipse directly.<br/>
<br/>
I) Generalities<br/>
a)org.apache.commons.lang3.time package offers thread-safe code the Date and GregorianCalendar class do not provide, as well some nice Util methods.<br/>
Here I'm just showing how to use some of the DateUtils methods.<br/>
<br/>
<br/>
<a href="http://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/time/package-summary.html">Link to apache commons time javadoc</a><br/> 
<b>DateFormatUtils</b> : simple date formatting methods for 8601 format.<br/>
<b>DurationFormatUtils</b> : helps formatting durations and periods.<br/>
<b>FastDateFormat, FastDateParser, FastDatePrinter</b> : formats and parse Dates like SimpleDateFormat but is thread-safe. Also, it's only 99% compatible with SimpleDateFormat (time zones and some year patterns are not compatible)<br/>
<b>DateUtils</b> : some util methods<br/>
<b>StopWatch</b> : meant to measure elapsed time<br/> 
<br/>
<br/>
<br/>
II)The code<br/>
<b>ceiling()</b> ceils a Calendar/Date.<br/>
<b>isSameDay()</b> tells whether Calendar/Date represent the same day.<br/>
<b>isSameInstant()</b> tells whether Calendar/Date represent the same instant.<br/>
<b>round()</b> rounds a Calendar/Date's specific Field to the closest value.<br/>
<b>truncate()</b> truncates a Calendar/Date's specific Field to the closest value.<br/>
<b>truncatedCompareTo()</b> is a classic compare method to compare dates<br/>
<b>truncatedEquals()</b> tells whether Calendar/Date are equals or not.<br/>
<br/>

