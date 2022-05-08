<?php
if​($_SERVER[​'REQUEST_METHOD'​] === ​"POST"​){ $fileContent[​'file'​] = ​false​; header(​'Content-Type: application/json'​); if​(​isset​($_POST[​'file'​])){
header(​'Content-Type: application/json'​);
$_POST[​'file'​] = str_replace( ​array​(​"../"​, ​"..""), "", $_POST['file']); if(strpos($_POST['file'], "​user.txt​") === false){
$file = fopen("​/​var​/www/html/​" . $_POST['file'], "​r​"); $fileContent['file'] = fread($file,filesize($_POST['file'])); fclose();
} }
       echo json_encode($fileContent);
}
