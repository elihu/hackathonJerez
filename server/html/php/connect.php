<?php

	function connect(){

		/*
		$host = "mysql.hostinger.es";
		$bd = "u434166740_hacka";
		$user = "u434166740_root";
		$pass = "caminantenohaycamino";
		*/

		
		$host = "localhost";
		$bd = "hackathon";
		$user = "root";
		$pass = "root";
		

		$link = mysqli_connect("$host", "$user", "$pass");
		mysqli_select_db($link, $bd);
		$tildes = $link->query("SET NAMES 'utf8'"); //Para que se muestren las tildes correctamente

		return $link;
	}

?>
