// https://voidsec.com/analysis-of-the-joomla-rce-cve-2015-8562/



// Check for clients browser
if (in_array('fix_browser', $this->security) && isset($_SERVER['HTTP_USER_AGENT'])){
    $browser = $this->get('session.client.browser');

    if ($browser === null){
        $this->set('session.client.browser', $_SERVER['HTTP_USER_AGENT']);
    }
    elseif ($_SERVER['HTTP_USER_AGENT'] !== $browser) {
        // @todo remove code:                    $this->_state   =       'error';
        // @todo remove code:                    return false;
    }
}

joomla_session` VALUES ('02di8ph9l9on7aa905khshtu57',0,1,'1505489800',
'__default|a:8:{
	s:15:"session.counter";		        i:1;
	s:19:"session.timer.start";		i:1505489800;
	s:18:"session.timer.last";		i:1505489800;
	s:17:"session.timer.now";		i:1505489800;
	s:22:"session.client.browser";	        s:11:"curl/7.55.1";
	s:8:"registry";					
		O:9:"JRegistry":1:{
						s:7:"\0\0\0data";
						O:8:"stdClass":0:{}
		}
	s:4:"user";O:5:"JUser":24:{
		s:9:"\0\0\0isRoot";	        b:0;
		s:2:"id";			i:0;
		s:4:"name";			N;
		s:8:"username";		        N;
		s:5:"email";			N;
		s:8:"password";		        N;
		s:14:"password_clear";	        s:0:"";
		s:5:"block";			N;
		s:9:"sendEmail";		i:0;
		s:12:"registerDate";		N;
		s:13:"lastvisitDate";		N;
		s:10:"activation";		N;
		s:6:"params";			N;
		s:6:"groups";					
			a:1:{
						i:0;
						s:2:"13";
			}
		s:5:"guest";			i:1;
		s:13:"lastResetTime";		N;
		s:10:"resetCount";		N;
		s:10:"\0\0\0_params";	
			O:9:"JRegistry":1:{
						s:7:"\0\0\0data";
						O:8:"stdClass":0:{}
			}
		s:14:"\0\0\0_authGroups";
			a:1:{
						i:0;
						s:1:"1";
			}
		s:14:"\0\0\0_authLevels";
			a:2:{
						i:0;
						i:1;
						i:1;
						i:1;
			}
		s:15:"\0\0\0_authActions";	N;
		s:12:"\0\0\0_errorMsg";	        N;
		s:10:"\0\0\0_errors";	        a:0:{}
		s:3:"aid";			i:0;
	}
	s:13:"session.token";			s:32:"ead9d16586b72de83eab1761e20436e4";
}'
,0,'');



public function write($id, $data)
{
    // Get the database connection object and verify its connected.
    $db = JFactory::getDbo();
    $data = str_replace(chr(0) . '*' . chr(0), '\0\0\0', $data);
    try    {
        $query = $db->getQuery(true)
            ->update($db->quoteName('#__session'))
            ->set($db->quoteName('data') . ' = ' . $db->quote($data))
            ->set($db->quoteName('time') . ' = ' . $db->quote((int) time()))
            ->where($db->quoteName('session_id') . ' = ' . $db->quote($id));

      // Try to update the session data in the database table.
      $db->setQuery($query);

      if (!$db->;execute())      {
            return false;
      }
      /* Since $db->execute did not throw an exception, so the query was successful.
         Either the data changed, or the data was identical.
         In either case we are done.
      */
      return true;
    }
    catch (Exception $e)    {
        return false;
    }
}
