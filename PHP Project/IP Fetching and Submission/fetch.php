<?php
include "connection.php";
$ip = $_GET['ip'];
$db = new database();
$db->select("ips_table", "ip", "ip='$ip'");
if ($db->sql == true) {
    if (mysqli_fetch_array($db->sql)) {
        echo "IP Found";
    } else {
        echo "IP Not Found";
    }
} else {
    echo $db->error;
}
