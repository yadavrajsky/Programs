<?php
class database
{
    private $servername = 'localhost';
    private $username = 'root';
    private $password = '';
    private $dbname = 'ip_db';
    private $mysqli = '';
    public $sql;
    public function __construct()
    {
        $this->mysqli = new mysqli($this->servername, $this->username, $this->password, $this->dbname);
    }

    public function insert($table, $para = array())
    {
        $table_columns = implode(',', array_keys($para));
        $table_value = implode("','", $para);

        $sql = "INSERT INTO $table($table_columns) VALUES('$table_value')";

        $this->mysqli->query($sql);
    }

    public function select($table, $rows = "*", $where = null)
    {
        if ($where != null) {
            $sql = "SELECT $rows FROM $table WHERE $where";
        } else {
            $sql = "SELECT $rows FROM $table";
        }
        $this->sql = $this->mysqli->query($sql);
    }

    public function __destruct()
    {
        $this->mysqli->close();
    }
}
