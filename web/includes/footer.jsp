<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
GregorianCalendar currentDate = new GregorianCalendar();
int currentYear = currentDate.get(Calendar.YEAR);
int currentMonth = currentDate.get(Calendar.MONTH);
int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
%>
<footer>
<p>Copyright &copy; <%= currentMonth + "/" + currentDay + "/" + currentYear %> Titan Online Banking</p>
<a href="mailto:mperez40@live.spcollege.edu">mperez40@live.spcollege.edu</a>
</footer>
</div>
</body>
</html>