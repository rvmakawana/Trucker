<!doctype html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <h1>Hello, world!</h1>

   <table class="table table-striped table-bordered sortable table-responsive"  id="user2">
						<thead>
							<tr>
							
								<th>MAKE</th>
								<th>MODEL</th>	
							<th>YEAR</th>
								<th>REDLIMERPM</th>	
								<th>	maxFuelVolume	</th>
								<th>	lastServiceDate		</th>					
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vehicle" items="${vehicles }">
								<tr>
								
								    <td>${vehicle.make}</td>
							
									
									<td>${vehicle.model}</td>	
									<td>${vehicle.year}</td>
									
									<td>${vehicle.REDLIMERPM}</td>
									<td>${vehicle.maxFuelVolume}</td>
									<td>${vehicle.lastServiceDate}</td>
									
						
				
									</tr>
							</c:forEach>
						</tbody>
					</table>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>