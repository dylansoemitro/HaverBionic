<?php
$servername = "localhost";
$username = "gtstudent";
$password = "";

// Create connection
$conn = new mysqli($servername, $username, $password, "test");

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

echo "Connected successfully";

$econ = "SELECT * IF(gd_courses.department == ECON) FROM gd_courses";


if ($result = mysqli_query($con, $econ)){
$array = array();
$tempArray = array();
while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $tempArray = $row;
     array_push($array, $tempArray);
}


echo json_encode($array);
mysqli_close($con);

?>