
<?php
	header('Content-Type: text/html; charset=utf8');
	include 'connect.php';

	function buscar($municipio, $distancia, $dificultad, $valoracion)
	{
	
		$link = connect();
		$query = "SELECT IdSendero, Nombre, Municipio, Duracion, Permiso, Distancia, Valoracion, Latitud, Longitud, Dificultad"
	    . "	FROM Sendero "
	    . "	WHERE Municipio LIKE UCASE('%". $municipio . "%')"
	    . "	AND Distancia <= " . $distancia .""
	    . "	AND Dificultad = '" . $dificultad . "' "
	    . "	AND Valoracion >= ". $valoracion ."; ";

		$result = mysqli_query($link, $query);
		
		$string = "";
		while ($row = mysqli_fetch_array($result)){
			
			$string .= $row['IdSendero'] . "," . $row['Nombre'] . "," . $row['Municipio'] . "," . $row['Duracion'] . "," . $row['Permiso'] . "," . $row['Distancia']. "," . $row['Dificultad'] . "," . $row['Valoracion'] . "," . $row['Latitud'] . "," . $row['Longitud'] . "-";
		}
		@mysql_close($link);
		return $string; 
	}
	function puntuar($idsendero, $puntuacion){
		$link = connect();
		$query = "SELECT Valoracion FROM Sendero "
	    . " WHERE IdSendero = ". $idsendero .";";
		$result = mysqli_query($link, $query);
		$row = mysqli_fetch_array($result);
		
		$puntos = $row['Valoracion'];
		$puntos = ($puntos + $puntuacion)/2;

		$query = "UPDATE Sendero SET Valoracion = ". $puntos
		. "WHERE IdSendero =". $idsendero .";";
		$result = mysqli_query($link, $query);
		@mysql_close($link);
	}
	function reportarIncidencia($idsendero, $titulo, $descripcion, $imagen)
	{
		$link = connect();
		$query = "INSERT INTO Incidencia (Fecha, Foto, Revisado, Solucionado, Descripcion, Titulo, IdSendero)"
	    . " VALUES ("
	    . " '" . date("Y-t-d") ."',"
	    . " '" . $imagen . "',"
	    . "	FALSE,"
	    . "	FALSE,"
	    . " '". $descripcion ."', "
	    . " '". $titulo ."', "
	    . " ". $idsendero .");";

		$result = mysqli_query($link, $query);
		@mysql_close($link);
	}

	function listarIncidencias($idsendero)
	{
		$link = connect();
		$query = "SELECT Titulo, Descripcion, Imagen"
	    . "	FROM Incidencia "
	    . "	WHERE IdSendero = ". $idsendero . ";";

		$result = mysqli_query($link, $query);
		$string = "";
		while ($row = mysqli_fetch_array($result)){
			$string .= $row['Titulo'] . "," . $row['Descripcion'] . "," . $row['Imagen'] . "-";
		}
		@mysql_close($link);
		return $string; 
	}

	/* Funciones para la aplicación web */

	function listaIncidenciasNoValidadas(){
		$link = connect();
		$query = "SELECT Titulo, Descripcion, Fecha, IdIncidencia"
	    . "	FROM Incidencia "
	    . " WHERE Revisado = FALSE"
	    . " AND Solucionado = FALSE"
	    . "	ORDER BY Fecha DESC;";

		$result = mysqli_query($link, $query);
		while ($row = mysqli_fetch_array($result)){
			echo "<tr><th scope='row'>", $row['Fecha'], "</th>","<td>", $row['Titulo'], "</td>", "<td>", $row['Descripcion'], "<td><a href=../incidenciasSinValidar.php?validar=".$row['IdIncidencia'] ."><button class='btn btn-success' type='button'>Aceptar</button></a><a href=../incidenciasSinValidar.php?denegar=".$row['IdIncidencia'] ."><button class='btn btn-danger' type='button'>Denegar</button></a></td></tr>";
		}
		@mysql_close($link);
	}
	function validarIncidencia($validar){
		$link = connect();
		$query = "UPDATE Incidencia SET Revisado = 1 "
		. "WHERE IdIncidencia =". $validar .";";
		$result = mysqli_query($link, $query);
		@mysql_close($link);
	}	
	function denegarIncidencia($denegar){
		$link = connect();
		$query = "UPDATE Incidencia SET Revisado = 0 "
		. "WHERE IdIncidencia =". $denegar .";";
		$result = mysqli_query($link, $query);
		@mysql_close($link);
	}
	function validarSolucion($validar){
		$link = connect();
		$query = "UPDATE Incidencia SET Solucionado = 1 "
		. "WHERE IdIncidencia =". $validar .";";
		$result = mysqli_query($link, $query);
		@mysql_close($link);
	}
        function listaIncidenciasNoSolucionadas(){
		$link = connect();
		$query = "SELECT Titulo, Descripcion, Fecha, IdIncidencia"
	    . "	FROM Incidencia "
	    . " WHERE Solucionado = FALSE"
	    . " AND Revisado = TRUE"
	    . "	ORDER BY Fecha DESC;";

		$result = mysqli_query($link, $query);
		while ($row = mysqli_fetch_array($result)){
		echo "<tr><th scope='row'>", $row['Fecha'], "</th>","<td>", $row['Titulo'], "</td>", "<td>", $row['Descripcion'], "<td><a href=./incidenciasSinSolucionar.php?validar=".$row['IdIncidencia'] ."><button class='btn btn-primary' type='button'>Aceptar</button></a></td></tr>";
		}
		@mysql_close($link);
	}

?>
