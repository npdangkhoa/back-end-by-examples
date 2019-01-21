$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8585/greet/"
	}).then(function(data) {
	  var items = [];
	  $.each( data, function( key, val ) {
		items.push("message: "+val +"<br/>");
	  });
          $('.result').append(items);
	});
}); 