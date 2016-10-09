<?php
 
/*
 * Following code will update a parking spot identified by spotID
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['spotID']) && isset($_POST['plateID']) && isset($_POST['timeIN']) && isset($_POST['timeOUT'])) {
 
    $spotID = $_POST['spotID'];
    $plateID = $_POST['plateID'];
    $timeIN = $_POST['timeIN'];
    $timeOUT = $_POST['timeOUT'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql update row with matched pid
    $result = mysql_query("UPDATE parkgreen SET plateID = '$plateID', timeIN = '$timeIN', timeOUT = '$timeOUT' WHERE spotID = $spotID");
 
    // check if row inserted or not
    if ($result) {
        // successfully updated
        $response["success"] = 1;
        $response["message"] = "parkingspot successfully updated.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
 
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>