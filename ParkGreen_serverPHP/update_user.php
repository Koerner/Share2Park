<?php
 
/*
 * Following code will update a parking spot identified by spotID
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['userID']) && isset($_POST['startX']) && isset($_POST['startY']) && isset($_POST['connected'])) {
 
    $userID = $_POST['userID'];
    $startX = $_POST['startX'];
    $startY = $_POST['startY'];
    $connected = $_POST['connected'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql update row with matched pid
    $result = mysql_query("UPDATE users SET startX = '$startX', startY = '$startY', connected = '$connected' WHERE userID = $userID");
 
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