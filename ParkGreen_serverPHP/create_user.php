<?php

/*
* Following code will create a new user row
* All product details are read from HTTP Post Request
*/

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['userID'])) {

  $userID = $_POST['userID'];

  // include db connect class
  require_once __DIR__ . '/db_connect.php';

  // connecting to db
  $db = new DB_CONNECT();

  // mysql inserting a new row
  $temp = mysql_query("SELECT EXISTS(SELECT 1 FROM users WHERE userID = $userID)"))
  if(0 == mysql_num_rows($temp))
  {
    $result = mysql_query("INSERT INTO users (userID) VALUES('$userID')");


    // check if row inserted or not
    if ($result) {
      // successfully inserted into database
      $response["success"] = 1;
      $response["message"] = "user successfully created.";

      // echoing JSON response
      echo json_encode($response);
    } else {
      // failed to insert row
      $response["success"] = 0;
      $response["message"] = "Oops! An error occurred.";

      // echoing JSON response
      echo json_encode($response);
    }
  }
  else
  {
    $response["success"] = 1;
    $response["message"] = "user already exists.";
  }
}
else {
  // required field is missing
  $response["success"] = 0;
  $response["message"] = "Required field(s) is missing";
}

// echoing JSON response
echo json_encode($response);

?>
