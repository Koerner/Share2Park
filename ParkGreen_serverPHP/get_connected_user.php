<?php
 
/*
 * Following code will update a parking spot identified by spotID
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['connected'])) {
 
    $connected = $_POST['connected'];
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql update row with matched pid
    $result = mysql_query("SELECT COUNT(*) FROM users WHERE userID = $userID");
    array_push($response["numConnected"], $result);
 
    // check if row inserted or not
    if ($result) {
        // successfully updated
        $response["success"] > 0;
        $response["message"] = "send list, valid code";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
 
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "wrong code, no entry";
 
    // echoing JSON response
    echo json_encode($response);
}
?>