<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
GregorianCalendar currentDate = new GregorianCalendar();
int currentYear = currentDate.get(Calendar.YEAR);
%>
<footer>
<p>Copyright &copy; <%= currentYear %> Titan Online Banking</p>
<a href="mailto:mperez40@live.spcollege.edu">mperez40@live.spcollege.edu</a>
</footer>
</div>
</body>
</html>