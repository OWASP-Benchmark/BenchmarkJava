#https://pentest.blog/advisory-cryptolog-unauthenticated-remote-code-execution/

$user=$_POST['user'];
$pass=$_POST['pass'];
if($_GET['act']=='logout'){
session_unset();
$contenttowrite = $contenttowrite.'<tr><td colspan="2">Çıkış yaptınız!</td></tr>';
}else if($_GET['act']=='login'){
  $link = mysql_connect(DB_HOST, DB_USER, DB_PASS);
  if (!$link) die ("Out of service");
  mysql_select_db(DB_DATABASE, $link) or die ("Out of service");
  $queryusercheck = mysql_query("SELECT count(id) FROM cc_users WHERE USERNAME='$user' AND `PASSWORD`='".computeHash($user, $pass)."'",$link);
  $usercheck_value = mysql_fetch_array ($queryusercheck);
