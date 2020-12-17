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
$math = "SELECT * IF(gd_courses.department == MATH) FROM gd_courses";
$biol = "SELECT * IF(gd_courses.department == BIOL) FROM gd_courses";
$cmsc = "SELECT * IF(gd_courses.department == CMSC) FROM gd_courses";
$chem= "SELECT * IF(gd_courses.department == CHEM) FROM gd_courses";
$stat = "SELECT * IF(gd_courses.department == STAT) FROM gd_courses";
$phys = "SELECT * IF(gd_courses.department == PHYS) FROM gd_courses";

if ($result = mysqli_query($con, $econ)){
$econArray = array();
$econTempArray = array();
while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $econTempArray = $row;
     array_push($econArray, $econTempArray);
}

if ($result = mysqli_query($con, $math)){
$mathArray = array();
$mathTempArray = array();

while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $mathTempArray = $row;
     array_push($econArray, $mathTempArray);
}

if ($result = mysqli_query($con, $biol)){
$biolArray = array();
$biolTempArray = array();
while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $biolTempArray = $row;
     array_push($biolArray, $biolTempArray);
}

if ($result = mysqli_query($con, $cmsc)){
$cmscArray = array();
$cmscTempArray = array();

while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $cmscTempArray = $row;
     array_push($cmscArray, $cmscTempArray);

}
if ($result = mysqli_query($con, $chem)){
$chemArray = array();
$chemTempArray = array();

while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $chemTempArray = $row;
     array_push($chemArray, $chemTempArray);
}

if ($result = mysqli_query($con, $stat)){
$physArray = array();
$physTempArray = array();

while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $statTempArray = $row;
     array_push($statArray, $statTempArray);
}
if ($result = mysqli_query($con, $phys)){
$physArray = array();
$physTempArray = array();

while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $physTempArray = $row;
     array_push($physArray, $physTempArray);
}
$resultsArray = array($econArray, $mathArray, $biolArray, $cmscArray, $statArray, $chemArray, $physArray)
echo json_encode($resultArray);

?>