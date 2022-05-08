string userID = userModel.username;
string passwd = userModel.password;

// connect DB with the authenticated user provided credentials
// valid connection also implies succesfull authentication
SqlConnection DBconn = new SqlConnection("Data Source= tcp:10.10.2.1,1434;Initial Catalog=mydb;User ID=" + userID +";Password=" + passwd);
