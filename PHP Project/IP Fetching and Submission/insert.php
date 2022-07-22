<!DOCTYPE html>

<head>
    <title>IP Insertion</title>
</head>

<body>

    <?php
    include 'connection.php';
    if (isset($_POST['Submit'])) {
        $ip = $_POST['ip'];
        $date = date("Y-m-d h:i:s A");
        $db = new database();
        $db->insert('ips_table', ['ip' => $ip, 'date_time' => $date]);
        echo "<h1>IP Inserted Succesfully</h1>";
    }
    header('refresh:5;url="index.html"');
    ?>
    <footer>This page will be redirected in 5 seconds.....</footer>
</body>

</html>