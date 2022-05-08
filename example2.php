<?php
$file = $_GET['file'];
$content = $_GET['content'];
file_put_contents("/some/path/$file",$content);
fclose($fh);
?>
