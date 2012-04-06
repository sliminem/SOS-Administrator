<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>SOS Administrator : dssos.config</title>
</head>

<body bgcolor="#3495AD">

<h2> This page parses the [dssos.config] file and strips the unnecessary data, leaving the variables that can be changed. </h2>

<form>

<?php
$pathToFile = "/home/iliyan/52north/52n-sos/conf/dssos.config";
$lines = file($pathToFile);
foreach ($lines as $line_num => $line) {
   //echo "Line #<b>{$line_num}</b> : " . htmlspecialchars($line) . "<br />\n";
	createForm($line, $line_num);  
}

function createForm($line, $num){
	if($num >= 31){
		$first = substr($line, 0,1);
		if($first == "#"){
			echo "<font size=4 color=\"8F0715\">".substr($line, 1)."</font>"."<br />";
		} elseif(ctype_alpha($first)) {
			$arr = explode("=", $line);
			echo $arr[0]." = <input type=\"text\" value=\" ".$arr[1]." \" /> <br /> <br /> ";
			//echo $arr[0];
			//echo $line."<br />"."<br />";
		}
	}
}

?>
</form>

</body>
</html>

