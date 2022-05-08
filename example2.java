try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
String url = "jdbc:mysql://10.12.1.34/" + request.getParameter("selectedDB");
conn = DriverManager.getConnection(url, username, password);
doUnitWork();
}
catch(ClassNotFoundException cnfe)
{
//
}
catch(SQLException se)
{
  //
}
catch(InstantiationException ie)
{
  //
}
finally
{
 // manage conn
}
       
