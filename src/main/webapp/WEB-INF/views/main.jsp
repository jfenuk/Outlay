<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

 <!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
    <title>Chart Application</title>
</head>
<body>
 <script type="text/javascript">
   
   
    // Load the Visualization API and the piechart package.
      google.load('visualization', '1', {'packages':['corechart']});
       
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);
      
    $(window).resize(drawChart);
    
    function drawChart() {
    	console.log("drawChart()");
    	$("#piechart").height($(document).height()/1.5);
    	
      var jsonData = $.ajax({
          url: "${pageContext.request.contextPath}/datatable.do",
          dataType:"json",
          async: false
          }).responseText;
      
      var jsonArrayData = $.ajax({
    	  
    	  url: "${pageContext.request.contextPath}/jsonArrayData.do",
          dataType:"json",
          async: false
      }).responseText;
          
      console.log("This is jsonArrayData: "+jsonArrayData);
      // Create our data table out of JSON data loaded from server.
     // var data = new google.visualization.DataTable(jsonData);
      
      var data = google.visualization.arrayToDataTable($.parseJSON(jsonArrayData), true);
      
     
      
      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(document.getElementById('piechart'));
      chart.draw(data, {});
    }
    </script>
<div class="container-fluid">

<div class="row">
  <div class="col-md-8"  id ="piechart"></div>
  <div class="col-md-4">
  
  <button type="button" class="btn btn-info btn-md">Add outlay</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">New outlay:</h4>
      </div>
      <div class="modal-body">
       <form role="form" id="add-outlay-form">
  <div class="form-group">
    <label for="amount">The amount:</label>
    <input class="form-control" id="amount" name="amount">
    </div>
    
    <div class="form-group">
    <label for="select_category">The type:</label>
    <select class="form-control" name="category" id="form-select-category">
    
      </select>
  </div>
    
          </div>
      <div class="modal-footer">
        <button id="submit" type="submit" class="btn btn-default">Submit</button>
        </form>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
  
  </div>
</div>

</div>
</body>

<script>
$(document).ready(function(){
    $(".btn").click(function(){
        $("#myModal").modal('show');
    });
});
$(document).ready(function(){
$('#myModal').on('shown.bs.modal', function (e) {
    e.preventDefault();
    $("#form-select-category" ).load( "${pageContext.request.contextPath}/outlayformselector.do");
});});
$(document).ready(function(){	$("#add-outlay-form").submit(function(event){
	 event.preventDefault();
	
	 $.ajax({
	    		   type: "POST",
	    		   url: "${pageContext.request.contextPath}/outlay.do",
	    		   data: $('#add-outlay-form').serialize(),
	    		   success: function(msg){
	    			   console.log("data submitted.");
	    			   $("#myModal").modal('hide'); 
	    			   },
	    			error: function(){
	    				console.log("data isn't submitted.");
	 	 				$("#myModal").hide(); 
	 					}
	    });
	 drawChart();
	 });
})
</script>
</html>