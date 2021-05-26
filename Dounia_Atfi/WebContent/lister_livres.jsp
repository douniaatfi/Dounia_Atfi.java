<%@page import="services.serviceLivre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Livre"%>
<%@page import="models.Personne"%>
<% Personne p = (Personne)session.getAttribute("personne"); 
if(p==null){
	response.sendRedirect("http://localhost:8080/Dounia_Atfi/authentification");

}else{

%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Gestion de bibliotheque</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css">
  <link rel="stylesheet" type="text/css" href="lib/gritter/css/jquery.gritter.css" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  <script src="lib/chart-master/Chart.js"></script>

  

<body>
  <section id="container">
  
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>G-<span>biblio</span></b></a>
      <!--logo end-->
    
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="login.html">Logout</a></li>
        </ul>
      </div>
    </header>
   
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="profile.html"><img src="img/ui-sam.jpg" class="img-circle" width="80"></a></p>
          <h5 class="centered"><%=p.getNom()+" "+p.getPrenom() %></h5>
          <li class="sub-menu">
            <a  href="ajouter_etudiant.jsp">
              <i class="fa fa-cogs"></i>
              <span>Ajouter etudiant</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="ajouter_livre.jsp">
              <i class="fa fa-cogs"></i>
              <span>Ajouter livre</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="lister_livres.jsp">
              <i class="fa fa-cogs"></i>
              <span>Lister les livres</span>
              </a>
          </li>
         
      </div>
    </aside>
    
    <!--main content start-->
  <section id="main-content">
<section class="wrapper"> 
  <div class="card ">
                                            <div class="card-header">
                                                <h5>Liste des livres</h5>
                                               
                                            </div>
                                            <div class="card-block table-border-style">
                                                <div class="table-responsive">
                                                <% ArrayList<Livre> livres =serviceLivre.serviveLivres(); %>
                                                    <table class="table">
                                                        <thead>
                                                            <tr>
                                                                <th>#</th>
                                                                <th>ISBN</th>
                                                                <th>TITRE</th>
                                                                <th>GENRE</th>
                                                                <th>ANNEE EDITION</th>
                                                                <th>CATEGORIE</th>
                                                                <th>AUTEUR</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%for(Livre l :livres){
                                                            	%>
                                                            <tr>
                                                                <th scope="row"><%=l.getId()%></th>
                                                                <td><%=l.getIsbn() %></td>
                                                                <td><%=l.getTitre() %></td>
                                                                <td><%=l.getGenre() %></td>
                                                                <td><%=l.getAnnee_edition() %></td>
                                                                <td><%=l.getCategorie().getNom() %></td>
                                                                <td><%=l.getAuteur().getNom() %></td>
                                                            </tr>
                                                            <% } %>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
  </section>
  </section>
  
  
  
    <!--main content end-->
    <!--footer start-->
    <footer class="site-footer">
      <div class="text-center">
        <p>
          &copy; Copyrights . All Rights Reserved
        </p>
       
        <a href="index.html#" class="go-top">
          <i class="fa fa-angle-up"></i>
          </a>
      </div>
    </footer>
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>

  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <script src="lib/jquery.sparkline.js"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <script type="text/javascript" src="lib/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="lib/gritter-conf.js"></script>
  <!--script for this page-->
  <script src="lib/sparkline-chart.js"></script>
  <script src="lib/zabuto_calendar.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      var unique_id = $.gritter.add({
        // (string | mandatory) the heading of the notification
        title: 'Welcome to Dashio!',
        // (string | mandatory) the text inside the notification
        text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo.',
        // (string | optional) the image to display on the left
        image: 'img/ui-sam.jpg',
        // (bool | optional) if you want it to fade out on its own or just sit there
        sticky: false,
        // (int | optional) the time you want it to be alive for before fading out
        time: 8000,
        // (string | optional) the class name you want to apply to that specific message
        class_name: 'my-sticky-class'
      });

      return false;
    });
  </script>
  <script type="application/javascript">
    $(document).ready(function() {
      $("#date-popover").popover({
        html: true,
        trigger: "manual"
      });
      $("#date-popover").hide();
      $("#date-popover").click(function(e) {
        $(this).hide();
      });

      $("#my-calendar").zabuto_calendar({
        action: function() {
          return myDateFunction(this.id, false);
        },
        action_nav: function() {
          return myNavFunction(this.id);
        },
        ajax: {
          url: "show_data.php?action=1",
          modal: true
        },
        legend: [{
            type: "text",
            label: "Special event",
            badge: "00"
          },
          {
            type: "block",
            label: "Regular event",
          }
        ]
      });
    });

    function myNavFunction(id) {
      $("#date-popover").hide();
      var nav = $("#" + id).data("navigation");
      var to = $("#" + id).data("to");
      console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
  </script>
</body>

</html>
<%}%>