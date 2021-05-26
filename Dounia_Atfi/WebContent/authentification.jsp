<%@page import="models.Personne"%>
<% Personne p = (Personne)session.getAttribute("personne");  
if(p!=null){
	
    if(models.Role.ADMIN.equals(p.getRole())) {
		response.sendRedirect("http://localhost:8080/Dounia_Atfi/pageadmin.jsp");
	}else if(models.Role.ETUDIANT.equals(p.getRole())) {
		response.sendRedirect("http://localhost:8080/Dounia_Atfi/pageetudiant.jsp");}
		}
else{  %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>gestion de livre</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  
  
</head>

<body>
   <div id="login-page">
    <div class="container">
      <form class="form-login" action="authentification" method="post">
        <h2 class="form-login-heading">S'identifier</h2>
        <div class="login-wrap">
          <input type="text" class="form-control" name="email" placeholder="Email" autofocus>
          <br>
          <input type="text" class="form-control"name="mdp"  placeholder="Mot de passe">
            <br>
          <button class="btn btn-theme btn-block" href="index.html" type="submit"><i class="fa fa-lock"></i> Authentification</button>
        
       </div>
      </form>
    </div>
  </div>
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <!--BACKSTRETCH-->
  <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
  <script type="text/javascript" src="lib/jquery.backstretch.min.js"></script>
  <script>
    $.backstretch("img/login-bg.jpg", {
      speed: 500
    });
  </script>
</body>

</html>
<%}%>