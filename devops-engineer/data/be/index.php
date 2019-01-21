<?php

// Include database configuration file
require 'conf.php';


$data = array();
$data['hostname'] = gethostname();

header('Content-Type: application/json');

if (!$link = @mysqli_connect($mysql_host, $mysql_user, $mysql_pass, $mysql_db)) {
	$data['error'] = mysqli_connect_error();
	echo json_encode($data);
	exit();
}

// Check connection
if (mysqli_connect_error()) {
	$data['error'] = mysqli_connect_error();
	echo json_encode($data);
	exit();
}

// Query users
$query = 'SELECT * FROM ' . $mysql_db . '.users';
if ( ($result = mysqli_query($link, $query)) === FALSE ) {
	$data['error'] = mysqli_error();
	echo json_encode($data);
	mysqli_free_result($result);
	exit();
}

// Gather data
while ($row = mysqli_fetch_array($result)) {
	$data['data'][] = $row;
}

// Free result set
mysqli_free_result($result);

// Close connection
mysqli_close($link);

// Output
echo json_encode($data);
