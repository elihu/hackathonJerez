<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./favicon.ico">

    <title>Equipo Negro</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Equipo Negro</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="incidenciasSinValidar.php">Incidencias sin validar</a></li>
            <li><a href="incidenciasSinSolucionar.php">Incidencias sin solucionar</a></li>
            <li><a href="fotos.html">Moderar fotos</a></li>

	</ul>
            <ul class="nav navbar-nav navbar-right">
<li><a href="index.html">Salir</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <div class="template">
        <h1>Incidencias sin validar</h1>

      </div>

      <div class="bs-example" data-example-id="panel-without-body-with-table">
          <div class="panel panel-default">
            <table class="table">
              <thead>
                <tr>
                  <th>Fecha</th>
                  <th>Nombre</th>
                  <th>Descripción</th>
                  <th>Validar</th>
                </tr>
              </thead>
              <tbody>

                <?php
                  include 'php/functions.php';
					  $validar = $_GET['validar'];
					  if($validar!=0){
						validarIncidencia($validar);
					  }
					  $denegar = $_GET['denegar'];
					  if($denegar>0){
						denegarIncidencia($denegar);
					  }
                  listaIncidenciasNoValidadas();

                ?>
                <!--<tr>
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>
                    <button class="btn btn-success" type="button">Aceptar</button>
                    <button class="btn btn-danger" type="button">Denegar</button>
                  </td>
                </tr>
                <tr>
                  <th scope="row">2</th>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>
                    <button class="btn btn-success" type="button">Aceptar</button>
                    <button class="btn btn-danger" type="button">Denegar</button>
                  </td>
                </tr>
                <tr>
                  <th scope="row">3</th>
                  <td>Larry</td>
                  <td>the Bird</td>
                  <td>
                    <button class="btn btn-success" type="button">Aceptar</button>
                    <button class="btn btn-danger" type="button">Denegar</button>
                  </td>
                </tr>-->
              </tbody>
            </table>
          </div>
        </div>
    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
