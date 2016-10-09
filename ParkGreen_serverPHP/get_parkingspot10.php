<?php
 
/*
 * Following code will get single product details
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// check for post data
if (true) {
    $spotID = 10;
 
    // get a product from products table
    $result = mysql_query("SELECT *FROM parkgreen WHERE spotID = $spotID");
 
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
 
            $result = mysql_fetch_array($result);
 
            $parkingspot = array();
            $parkingspot["spotID"] = $result["spotID"];
            $parkingspot["spotX"] = $result["spotX"];
            $parkingspot["spotY"] = $result["spotY"];
            $parkingspot["plateID"] = $result["plateID"];
            $parkingspot["timeIN"] = $result["timeIN"];
            $parkingspot["timeOUT"] = $result["timeOUT"];
            // success
            $response["success"] = 1;
 
            // user node
            $response["parkingspot"] = array();
 
            array_push($response["parkingspot"], $parkingspot);
 
            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No product found";
 
            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No product found";
 
        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>