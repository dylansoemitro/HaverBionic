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

$biol = "SELECT * IF(gd_courses.department == BIOL) FROM gd_courses";

if ($result = mysqli_query($con, $biol)){
$biolArray = array();
$biolTempArray = array();
while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $biolTempArray = $row;
     array_push($biolArray, $biolTempArray);
}

echo json_encode($biolArray);
mysqli_close($con);

?>